package com.mastercard.pts.integrated.issuing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

//import com.mastercard.mdes.utility.common.exception.Exception;

public class SshUtil {

	private SshUtil() {
	}

	public static Session createSession(String host, int port, String user,
			String password) throws Exception {
		try {
			Session session = new JSch().getSession(user, host, port);
			session.setPassword(password);
			session.setConfig("StrictHostKeyChecking", "no");
			session.connect();
			return session;
		} catch (JSchException e) {
			throw new Exception("Error attempting to create SSH session", e);
		}
	}

	public static void closeSession(Session session) {
		session.disconnect();
	}

	public static List<String> executeCommand(Session session, String command)
			throws Exception {
		List<String> result = new ArrayList<>();
		InputStream commandOutput = null;
		Channel channel = null;
		try {
			channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.connect();
			commandOutput = channel.getInputStream();
			int readByte = commandOutput.read();
			StringBuilder outputBuffer = new StringBuilder();
			while (readByte != 0xffffffff) {
				char c = (char) readByte;
				if (c == '\n') {
					result.add(outputBuffer.toString());
					outputBuffer.delete(0, outputBuffer.length());
				} else {
					outputBuffer.append((char) readByte);
				}
				readByte = commandOutput.read();
			}
		} catch (Exception e) {
			throw new Exception("Error attempting to execute SSH command", e);
		} finally {
			if (commandOutput != null) {
				try {
					commandOutput.close();
				} catch (IOException ignored) {
				}
			}
			if (channel != null && channel.isConnected()) {
				channel.disconnect();
			}
		}
		return result;
	}

	public static void uploadFile(Session session, String localFileLocation,
			String remoteDestination) throws Exception {
		localFileLocation = localFileLocation.replaceAll("\\\\", "/");
		remoteDestination = remoteDestination.replaceAll("\\\\", "/");
		Channel channel = null;
		FileInputStream fileInputStream = null;
		OutputStream outputStream = null;
		try {
			String command = "scp " + ("-p") + " -t " + remoteDestination;
			channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			outputStream = channel.getOutputStream();
			InputStream in = channel.getInputStream();
			channel.connect();
			if (checkAck(in) != 0) {
				throw new Exception(
						"Error attempting to upload file to remote host");
			}
			File _lfile = new File(localFileLocation);
			command = "T " + (_lfile.lastModified() / 1000) + " 0";
			command += (" " + (_lfile.lastModified() / 1000) + " 0\n");
			outputStream.write(command.getBytes());
			outputStream.flush();
			if (checkAck(in) != 0) {
				throw new Exception(
						"Error attempting to upload file to remote host");
			}
			long filesize = _lfile.length();
			command = "C0644 " + filesize + " ";
			if (localFileLocation.lastIndexOf('/') > 0) {
				command += localFileLocation.substring(localFileLocation
						.lastIndexOf('/') + 1);
			} else {
				command += localFileLocation;
			}
			command += "\n";
			outputStream.write(command.getBytes());
			outputStream.flush();
			if (checkAck(in) != 0) {
				throw new Exception(
						"Error attempting to upload file to remote host");
			}
			fileInputStream = new FileInputStream(localFileLocation);
			byte[] buf = new byte[1024];
			while (true) {
				int len = fileInputStream.read(buf, 0, buf.length);
				if (len <= 0)
					break;
				outputStream.write(buf, 0, len);
			}
			buf[0] = 0;
			outputStream.write(buf, 0, 1);
			outputStream.flush();
			if (checkAck(in) != 0) {
				throw new Exception(
						"Error attempting to upload file to remote host");
			}
		} catch (Exception e) {
			throw new Exception(
					"Error attempting to upload file to remote host", e);
		} finally {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException ignored) {
				}
			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException ignored) {
				}
			}
			if (channel != null && channel.isConnected()) {
				channel.disconnect();
			}
		}
	}

	public static void downloadFile(Session session, String remoteFileLocation,
			String localDestination) throws Exception {
		localDestination = localDestination.replaceAll("\\\\", "/");
		remoteFileLocation = remoteFileLocation.replaceAll("\\\\", "/");
		String[] localLocationParts = localDestination.split("/");
		String[] remoteLocationParts = remoteFileLocation.split("/");
		File localFile = new File(localDestination);
		if (localLocationParts[localLocationParts.length - 1].contains(".")) {
			throw new IllegalArgumentException(
					"Input \"localDestination\" must be a local directory, not a file.");
		} else if (!localFile.exists() && !localFile.mkdirs()) {
			throw new Exception("Unable to create directory: "
					+ localDestination);
		}
		localDestination = localDestination + "/"
				+ remoteLocationParts[remoteLocationParts.length - 1];
		FileOutputStream fileOutputStream = null;
		Channel channel = null;
		OutputStream outputStream = null;
		try {
			String command = "scp -f " + remoteFileLocation;
			channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			outputStream = channel.getOutputStream();
			InputStream in = channel.getInputStream();
			channel.connect();
			byte[] buf = new byte[1024];
			buf[0] = 0;
			outputStream.write(buf, 0, 1);
			outputStream.flush();
			while (true) {
				if ('C' != checkAck(in)) {
					break;
				}
				in.read(buf, 0, 5);
				long fileSize = 0L;
				while (true) {
					if (in.read(buf, 0, 1) < 0 || buf[0] == ' ') {
						break;
					}
					fileSize = fileSize * 10L + buf[0] - '0';
				}
				for (int i = 0;; i++) {
					in.read(buf, i, 1);
					if (buf[i] == (byte) 0x0a) {
						break;
					}
				}
				buf[0] = 0;
				outputStream.write(buf, 0, 1);
				outputStream.flush();
				fileOutputStream = new FileOutputStream(localDestination);
				int i;
				while (true) {
					i = buf.length < fileSize ? buf.length : (int) fileSize;
					i = in.read(buf, 0, i);
					if (i < 0) {
						break;
					}
					fileOutputStream.write(buf, 0, i);
					fileSize -= i;
					if (fileSize == 0L) {
						break;
					}
				}
				buf[0] = 0;
				outputStream.write(buf, 0, 1);
				outputStream.flush();
			}
		} catch (Exception e) {
			throw new Exception(
					"Error attempting to download file from remote host", e);
		} finally {
			if (channel != null && channel.isConnected()) {
				channel.disconnect();
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException ignored) {
				}
			}
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException ignored) {
				}
			}
		}
	}

	private static int checkAck(InputStream in) throws IOException {
		int b = in.read();
		if (b == 0)
			return b;
		if (b == -1)
			return b;

		if (b == 1 || b == 2) {
			StringBuffer stringBuffer = new StringBuffer();
			int c;
			do {
				c = in.read();
				stringBuffer.append((char) c);
			} while (c != '\n');
		}
		return b;
	}
}
