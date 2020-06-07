package hashinator;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main {
	
	public static String md5Hashh;
	public static String sha1Hashh;
	public static String f;

	public static void main(String args[]) throws NoSuchAlgorithmException, IOException {
		
		JFrame frame = new JFrame("Hashinator v1.0");
	    JLabel md5Hash = new JLabel("(MD5 hash)");
	    //JLabel sha1Hash = new JLabel("SHA-1 hash");
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
					genMD5(f);
					md5Hash.setText(md5Hashh);
					//genSHA1(file);
					//sha1Hash.setText(sha1Hashh);
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
		//frame.add(sha1Hash);
		
		frame.setVisible(true);
		
		
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
	}
}