package com.mastercard.pts.integrated.issuing.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

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

	private static final Logger logger = LoggerFactory.getLogger(LinuxUtils.class);
	private static String[] cardData;

	public interface RemoteConnectionDetails{
		String getUserName(); 
		String getPassword(); 
		String getHostName(); 
		int getPort();
	}

	public static void download(RemoteConnectionDetails connectiondetails, String remoteSource, String localDestination ) throws JSchException  {
		logger.info("Conection Details: {}", connectiondetails);
		JSch jsch = new JSch();
		Session session = jsch.getSession(connectiondetails.getUserName(), 	connectiondetails.getHostName(), connectiondetails.getPort());
		session.setPassword(connectiondetails.getPassword());
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		if(!session.isConnected()) {
			session.connect();
		}
		//specify the location where the DAT file gets generated
		if (!remoteSource.startsWith("/")) {
			remoteSource = "/" + remoteSource;
			MiscUtils.reportToConsole("@remoteSource "+  remoteSource);
		}
		String command = "scp -f " + remoteSource;
		logger.info("Linux Command  {} -> {} ", command);
		Channel channel = session.openChannel("exec");
		((ChannelExec)channel).setCommand(command);
		channel.connect();

		try {
			transferFile(remoteSource, localDestination, channel);
		} catch (IOException e) {
			MiscUtils.reportToConsole("download Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} ",  e.getMessage());
			throw MiscUtils.propagate(e);
		}
	}

	public static String getFileAbsolutePath(RemoteConnectionDetails connectiondetails, String lookUpFor) throws Exception
	{
		return getFileFromLinuxBox(connectiondetails, lookUpFor);
	}
	
	public static boolean getPhotoReferenceNumberinDumpFile(File filePath,
			String applicationNumber) {
		MiscUtils
				.reportToConsole("*********   starting getPhotoReferenceNumber in Dump File *******  ");
		boolean flg = false;
		String strLine;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

			while ((strLine = br.readLine()) != null) {
				strLine = strLine.trim().replaceAll("\\s+", " ");
				MiscUtils.reportToConsole("*********   File Data *******  "
						+ strLine);
				String[] data = strLine.trim().split(",");
				// MiscUtils.reportToConsole("********* Data *******  " + data);
				int i = 0;
				for (i = 0; i < data.length; i++) {
					MiscUtils.reportToConsole(data[i]);
					if (data[i].equals(applicationNumber))

					{
						flg = true;
						break;
					}

				}
				if (flg)
					break;
			}
		} catch (Exception e) {
			MiscUtils.reportToConsole("getphotoReferenceNumber Exception :  "
					+ e.toString());
			logger.info(ConstantData.EXCEPTION + " {} " + e.getMessage());
			throw MiscUtils.propagate(e);
		}
		return flg;
	}

	private static String getFileFromLinuxBox (RemoteConnectionDetails connectiondetails, String lookUpFor) throws Exception
	{
		try {
			String result = null;
			Session session = new JSch().getSession(connectiondetails.getUserName(), connectiondetails.getHostName(), connectiondetails.getPort());    
			session.setPassword(connectiondetails.getPassword());
			java.util.Properties config = new java.util.Properties(); 
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			if(!session.isConnected())
				session.connect();
			String cmd = "find /home/dc-user/integrated/elt_bo/data -name \"*" + lookUpFor + "*\"";
			logger.info("command for getFileFromLinuxBox {} --> ", cmd);
			Channel channel=session.openChannel("exec");
			((ChannelExec)channel).setCommand(cmd);
			channel.setInputStream(null);
			((ChannelExec)channel).setErrStream(System.err);
			InputStream in=channel.getInputStream();
			channel.connect();
			byte[] tmp=new byte[1024];
			while(true){
				int i=in.read(tmp, 0, 1024);
				result = new String(tmp, 0, i).trim();
				//		   channel.disconnect();
				//			session.disconnect();
				return result;
			}
		}
		catch(Exception e) {
			MiscUtils.propagate(e);
			return null;
		}
	}

	private static void transferFile(String remoteSource, String localDestination, Channel channel) throws IOException {
		MiscUtils.reportToConsole("********* start transferFile ******** ");
		// get I/O streams for remote scp
		OutputStream out = channel.getOutputStream();
		InputStream in = channel.getInputStream();
		byte[] buf = new byte[1024];
		buf[0] = 0;
		out.write(buf, 0, 1);
		out.flush();
		checkAck(in);

		in.read(buf, 0, 5);
		long fileSize = 0L;
		while (true) {
			if (in.read(buf, 0, 1) < 0 || buf[0] == ' ') {
				break;
			}
			fileSize = fileSize * 10L + (long) (buf[0] - '0');
		}
		for (int i = 1; i < buf.length; i++) {
			in.read(buf, i - 1, 1);
			if (buf[i-1] == (byte) 0x0a ) {
				break;
			}
		}
		buf[0] = 0;
		out.write(buf, 0, 1);
		out.flush();
		String fileName = getFileName(remoteSource.replace("/", "\\"));
		logger.info("File Name of the file being downloaded: {}", fileName);
		createFolderIfNotAlreadyExists(localDestination);

		String finalDestination = localDestination + "\\" + fileName;
		try (FileOutputStream fileOutputStream = new FileOutputStream(finalDestination)) {
			logger.info("File downloaded to @: {}", finalDestination);

			int i;
			while (fileSize != 0L) {
				i = buf.length < fileSize ? buf.length : (int) fileSize;
				i = in.read(buf, 0, i);
				if (i < 0) {
					break;
				}
				fileOutputStream.write(buf, 0, i);
				fileSize -= i;
			}
			buf[0] = 0;
			out.write(buf, 0, 1);
			out.flush();
		}
	}

	private static String getFileName(String fullPath) {
		File f = new File(fullPath);
		return f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf('\\') + 1);
	}

	private static void createFolderIfNotAlreadyExists(String destDir) {
		File file = new File(destDir);
		if (!file.exists()) {
			file.mkdir();
			logger.info("Directory is created!");
		}
	}

	private static int checkAck(InputStream in) throws IOException {
		int b = in.read();
		if (b < 0) 
			return b;

		if (b == 1 || b == 2) {
			StringBuilder stringBuilder = new StringBuilder();
			int c;
			do {
				c = in.read();
				stringBuilder.append((char) c);
			}
			while (c != '\n');
		}
		return b;
	}

	public static void upload(RemoteConnectionDetails connectiondetails, String localsource,
			String remoteDir) throws InterruptedException  {

		Scp scp = new Scp();
		int portSSH = connectiondetails.getPort();
		String serverSSH = connectiondetails.getHostName();
		String userSSH = connectiondetails.getUserName(); 
		String pswdSSH = connectiondetails.getPassword();
		scp.setPort( portSSH );
		scp.setLocalFile(localsource);
		scp.setTodir( userSSH + ":" + pswdSSH + "@" + serverSSH + ":" + remoteDir );
		scp.setProject( new Project() );
		scp.setTrust( true );
		scp.execute();
		Thread.sleep(60000); // long sleep as file permission cron job runs every minute
	}

	
	public static void downloadFileViaScp(RemoteConnectionDetails connectiondetails, String remoteDir,
			String localsource) throws InterruptedException  {
		
		Scp scp = new Scp();
		String serverSSH = connectiondetails.getHostName();
		String userSSH = connectiondetails.getUserName(); 
		String pswdSSH = connectiondetails.getPassword();
		Thread.sleep(60000);
		logger.info("localsource "+localsource+" remoteDir: "+remoteDir+" ");
		scp.setPort( connectiondetails.getPort() );			
		scp.setRemoteFile(userSSH + ":" + pswdSSH + "@" + serverSSH + ":" + remoteDir);
		scp.setLocalTodir(localsource);
		//scp.setTodir( userSSH + ":" + pswdSSH + "@" + serverSSH + ":" + remoteDir );
		scp.setProject( new Project() );
		scp.setTrust( true );
		scp.execute();	
		Thread.sleep(35000); // long sleep as file permission cron job runs every minute
	}
	
	public static String[] getCardNumberAndExpiryDate(File filePath) {
		MiscUtils.reportToConsole("*********   starting getCardNumberAndExpiryDate *******  ");
		int lnNumber = 1;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			String strLine;
			while ((strLine = br.readLine()) != null)
			{
				if (lnNumber == 2)
				{
					strLine = strLine.trim().replaceAll("\\s+"," ");
					MiscUtils.reportToConsole("*********   File Data *******  " + strLine);
					String[] data = strLine.trim().split(" ");
					cardData = data[0].trim().split(":");
					break;
				}
				lnNumber++;
			}
		} catch (Exception e) {
			MiscUtils.reportToConsole("getCardNumberAndExpiryDate Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
		return cardData;
	}
	
	public static String getPhotoReferenceNumber(File filePath) {
		MiscUtils.reportToConsole("*********   starting getPhotoReferenceNumber *******  ");
		int lnNumber = 1;
		String photoReferenceNumber = "";
		try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			String strLine;
			while ((strLine = br.readLine()) != null)
			{
				if (lnNumber == 2)
				{
					strLine = strLine.trim().replaceAll("\\s+"," ");
					MiscUtils.reportToConsole("*********   File Data *******  " + strLine);
					String[] data = strLine.trim().split(" ");
					photoReferenceNumber = data[data.length-1];
					break;
				}
				lnNumber++;
			}
		} catch (Exception e) {
			MiscUtils.reportToConsole("getphotoReferenceNumber Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
		return photoReferenceNumber;
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
	
	

	public static boolean isPhotoReferenceNumberPresentFlatFile(File filePath,
			String applicationNumber) {
		MiscUtils.reportToConsole("*********   starting Flat file check*******  ");
		boolean isPhotoReferenceNumberFound = false;
		try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
		{
			String strLine;
			while ((strLine = br.readLine()) != null)
			{
				MiscUtils.reportToConsole("*********   File Data *******  " + strLine);
				isPhotoReferenceNumberFound = strLine.contains(applicationNumber);
			}
		} catch (Exception e) {
			MiscUtils.reportToConsole("getphotoReferenceNumber Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
		MiscUtils.reportToConsole("*********   ending Flat file check*******  ");		
		return isPhotoReferenceNumberFound;
	}

	public static String getJPEGPhotoFileName(File batchFile) {
		String photoFileName = "";
		MiscUtils.reportToConsole("*********   getting  image file name*******  ");
		try (BufferedReader br = new BufferedReader(new FileReader(batchFile)))
		{
			String strLine;
			if ((strLine = br.readLine()) != null){
				String[] fileData = strLine.split(",");
				photoFileName = fileData[0]+".jpeg";
			}
			
		} catch (Exception e) {
			MiscUtils.reportToConsole("getphotoReferenceNumber Exception :  " + e.toString());
			logger.info(ConstantData.EXCEPTION +" {} " +  e.getMessage());
			throw MiscUtils.propagate(e);
		}
		return photoFileName;
	}
}
