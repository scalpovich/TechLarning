package com.mastercard.pts.integrated.issuing.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.optional.ssh.Scp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public abstract class LinuxUtils {
	final static Logger logger = LoggerFactory.getLogger(LinuxUtils.class);

	public interface RemoteConnectionDetails {
		String getUserName();

		String getPassword();

		String getHostName();

		int getPort();
	}

	// Copying Embossed file from linux server to windows machine through winscp

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

	public static Session connectSession(String user, String host, String pwd,
			int port) throws JSchException, IOException {
		JSch jsch = new JSch();
		Session session = jsch.getSession(user, host, port);
		session.setPassword(pwd);
		java.util.Properties config = new java.util.Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();
		System.out.println("connected");
		return session;
	}

	public static String listFilesInDirectory(Session session, String filepath,
			String fileName) throws JSchException, IOException {
		ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
		channelExec
				.setCommand("ls -t" + " " + filepath + " > " + "" + fileName);
		channelExec.getOutputStream();
		channelExec.getInputStream();
		channelExec.connect();
		return fileName;
	}

	public static void movingToDir(Session session) throws JSchException,
			IOException {
		ChannelExec channelExec1 = (ChannelExec) session.openChannel("exec");
		channelExec1.setCommand("pwd > 576456.txt");
		// channelExec.setCommand("pwd > 11121.txt");
		OutputStream out1 = channelExec1.getOutputStream();
		InputStream in1 = channelExec1.getInputStream();
		System.out.println("connecting");
		channelExec1.connect();
	}

	public static void navigateAndGetGPGFile(Session session, String command,
			String FileName) throws JSchException, IOException {
		ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
		if (!channelExec.isClosed()) {
			channelExec.setCommand(command + FileName);
			channelExec.connect();
			int exitStatus = channelExec.getExitStatus();
			channelExec.disconnect();
			if (exitStatus < 0) {
				logger.warn("Done with no error status");
			} else if (exitStatus > 0) {
				logger.warn("Done with error");
			} else {
				logger.warn("Successfully done");
			}
			channelExec.disconnect();
		}
	}

	public static void copyFilesfromServer(Session session, String command,
			String fileName, String localDest) throws JSchException,
			IOException {
		FileOutputStream fileOutputStream = null;

		String Copycommand = command + "/" + fileName;
		Channel channel1 = session.openChannel("exec");
		System.out.println(Copycommand);
		((ChannelExec) channel1).setCommand(Copycommand);
		OutputStream out = channel1.getOutputStream();
		InputStream in = channel1.getInputStream();
		System.out.println("connecting");
		channel1.connect();
		byte[] buf = new byte[1024];
		buf[0] = 0;
		out.write(buf, 0, 1);
		out.flush();
		if (checkAck(in) != 0) {
			System.out.println("ok");
		}
		in.read(buf, 0, 5);
		long fileSize = 0L;
		while (true) {
			if (in.read(buf, 0, 1) < 0 || buf[0] == ' ') {
				break;
			}
			fileSize = fileSize * 10L + buf[0] - '0';
		}
		// for (int i = 0;; i++) {
		// if(buf.length <i){
		// System.out.println(i);
		for (int i = 1; i < buf.length; i++) {
			in.read(buf, i, 1);

			if (buf[i] == (byte) 0x0a) {
				break;
			}
			// }
		}
		buf[0] = 0;
		out.write(buf, 0, 1);
		out.flush();
		// String localDest = System.getProperty("user.dir") +
		// "/src/main/resources/downloads";
		fileOutputStream = new FileOutputStream(localDest);
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
		out.write(buf, 0, 1);
		out.flush();
		fileOutputStream.close();
		// channel1.close();

	}

	public static void upload(RemoteConnectionDetails connectiondetails,
			String localsource, String remoteDir) throws JSchException {

		Scp scp = new Scp();
		int portSSH = connectiondetails.getPort();
		String serverSSH = connectiondetails.getHostName();
		String userSSH = connectiondetails.getUserName();
		String pswdSSH = connectiondetails.getPassword();

		scp.setPort(portSSH);
		scp.setLocalFile(localsource);
		scp.setTodir(userSSH + ":" + pswdSSH + "@" + serverSSH + ":"
				+ remoteDir);
		scp.setProject(new Project());
		scp.setTrust(true);
		scp.execute();

	}

}