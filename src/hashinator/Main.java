package hashinator;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.zip.CRC32;

public class Main {
	
	public static String md5Hashh;
	public static String sha1Hashh;
	public static String crc32Hashh;
	public static String f;
	public static String s = "";

	public static void main(String args[]) throws NoSuchAlgorithmException, IOException {
		
		JFrame frame = new JFrame("Hashinator v1.3");
	    JLabel md5Hash = new JLabel("(MD5 hash)");
	    JLabel sha1Hash = new JLabel("(SHA-1 hash)");
	    JLabel crc32Hash = new JLabel("(CRC32 hash)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,100);
		
		JButton selectFile = new JButton("Select file...");
	    selectFile.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){
	    		FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
	    	    dialog.setMode(FileDialog.LOAD);
	    	    dialog.setVisible(true);
	    	    f = dialog.getDirectory() + dialog.getFile();
	    	    System.out.println(f + " chosen.");
	        }  
	    });
		
	    
	    JButton calcHashes = new JButton("Calculate hashes");
	    calcHashes.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){
	    		try {
	    			getHashes(f);
					//genMD5(f);
					md5Hash.setText("MD5: " + md5Hashh);
					//genSHA1(f);
					sha1Hash.setText("SHA-1: " + sha1Hashh);
					//gencrc32(f);
					
					
					
					for(int i = 8; i<=15; i++) {
						s = s + String.valueOf(crc32Hashh.charAt(i));
					}
					
					crc32Hash.setText("CRC32: " + s);
					
					//crc32Hash.setText("CRC32: "+ crc32Hashh);
					frame.setSize(360,150);
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }  
	    });
	    
	    
	    
		
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		//frame.add(text);
		frame.add(selectFile);
		frame.add(calcHashes);
		frame.add(md5Hash);
		frame.add(sha1Hash);
		frame.add(crc32Hash);
		
		frame.setVisible(true);
		
		
	}
	
	public static void getHashes(String path) throws NoSuchAlgorithmException, IOException{
		CRC32 crc = new CRC32();
		MessageDigest md5Digest = MessageDigest.getInstance("MD5");
		MessageDigest sha1Digest = MessageDigest.getInstance("SHA-1");
		File f = new File(path);
		try (FileInputStream inputStream = new FileInputStream(f)) {
			 
	        byte[] bytesBuffer = new byte[1024];
	        int bytesRead = -1;
	 
	        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
	            crc.update(bytesBuffer, 0, bytesRead);
	            md5Digest.update(bytesBuffer, 0, bytesRead);
	            sha1Digest.update(bytesBuffer, 0, bytesRead);
	        }
	        
	        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);	//Convert from long to byte array
	        buffer.putLong(crc.getValue());
	        
	        byte[] crc32HashedBytes = buffer.array();
			crc32Hashh = DatatypeConverter.printHexBinary(crc32HashedBytes);
	        System.out.println("File CRC32 = " + crc32Hashh);
	        
			byte[] md5HashedBytes = md5Digest.digest();
			md5Hashh = DatatypeConverter.printHexBinary(md5HashedBytes);
	        System.out.println("File MD5 = " + md5Hashh);
	        
			byte[] sha1HashedBytes = sha1Digest.digest();
			sha1Hashh = DatatypeConverter.printHexBinary(sha1HashedBytes);
	        System.out.println("File SHA-1 = " + sha1Hashh);
		}
	}
	/*
	public static void gencrc32(String path) throws NoSuchAlgorithmException, IOException{
		CRC32 crc = new CRC32();
		File f = new File(path);
		try (FileInputStream inputStream = new FileInputStream(f)) {
	 
	        byte[] bytesBuffer = new byte[1024];
	        int bytesRead = -1;
	 
	        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
	            crc.update(bytesBuffer, 0, bytesRead);
	        }
	        
	        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);	//Convert from long to byte array
	        buffer.putLong(crc.getValue());
	        
	        byte[] hashedBytes = buffer.array();
			crc32Hashh = DatatypeConverter.printHexBinary(hashedBytes);
	        System.out.println("File CRC32 = " + crc32Hashh);
		}
		
	}
	
	public static void genMD5(String path) throws NoSuchAlgorithmException, IOException{
		File f = new File(path);
		 try (FileInputStream inputStream = new FileInputStream(f)) {
		        MessageDigest digest = MessageDigest.getInstance("MD5");
		 
		        byte[] bytesBuffer = new byte[1024];
		        int bytesRead = -1;
		 
		        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
		            digest.update(bytesBuffer, 0, bytesRead);
		        }
		 
		        byte[] hashedBytes = digest.digest();
		        
		        
		        md5Hashh = DatatypeConverter.printHexBinary(hashedBytes);
		        String hash = DatatypeConverter.printHexBinary(hashedBytes);
		        System.out.println("File MD5 : " + hash);
		    }
        
	}
	
	public static void genSHA1(String path) throws NoSuchAlgorithmException, IOException{
		File f = new File(path);
		 try (FileInputStream inputStream = new FileInputStream(f)) {
		        MessageDigest digest = MessageDigest.getInstance("SHA-1");
		 
		        byte[] bytesBuffer = new byte[1024];
		        int bytesRead = -1;
		 
		        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
		            digest.update(bytesBuffer, 0, bytesRead);
		        }
		 
		        byte[] hashedBytes = digest.digest();
		        
		        sha1Hashh = DatatypeConverter.printHexBinary(hashedBytes);
		        String hash = DatatypeConverter.printHexBinary(hashedBytes);
		        System.out.println("File SHA1 : " + hash);
		    }
	}*/
}