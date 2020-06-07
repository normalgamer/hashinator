package hashinator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;
import java.util.zip.Checksum;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.xml.bind.DatatypeConverter;

public class Main_old {
	public static void main(String args[]) throws NoSuchAlgorithmException, IOException {
		//generateMD5("admin");
		//generateSHA1("admin");
		//crc32("admin");
		
		
		JFrame frame = new JFrame("Hashinator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,200);
		
		JLabel text = new JLabel("Hashinator v1.0", JLabel.CENTER);
		
		JButton selectFile = new JButton("Select file...");
	    selectFile.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	                   
	        }  
	        });  
		JButton calcHashes = new JButton("Calculate hashes");
		
		
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		frame.add(text);
		frame.add(selectFile);
		frame.add(calcHashes);
		
		
		
		
		frame.setVisible(true);
		
		
	    
		
		
		/*
		FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
	    dialog.setMode(FileDialog.LOAD);
	    dialog.setVisible(true);
	    String file = dialog.getFile();
	    System.out.println(file + " chosen.");
		*/
		
		
		
		
		genMD5("C:\\Jon Izaguirre\\ROMs\\Gamecube\\Super Smash Bros. Melee (USA) (En,Ja) (v1.02).iso");
		genSHA1("C:\\Jon Izaguirre\\ROMs\\Gamecube\\Super Smash Bros. Melee (USA) (En,Ja) (v1.02).iso");
		//genCRC32("C:\\Jon Izaguirre\\ROMs\\Gamecube\\Mario Kart - Double Dash!! (USA)\\Mario Kart - Double Dash!! (USA).iso");
		//File file = new File("C:\\Jon Izaguirre\\ROMs\\Gamecube\\Super Smash Bros. Melee (USA) (En,Ja) (v1.02).iso");
		//getFileCRC(file);
		//genCRC("C:\\Jon Izaguirre\\ROMs\\Gamecube\\Super Smash Bros. Melee (USA) (En,Ja) (v1.02).iso");
		
		
	}
	
	public void fileSelect(ActionEvent a) {
		
	}
	
	
	
	/*public static void genCRC(String path) throws NoSuchAlgorithmException, IOException{
		File f = new File(path);
		 try (FileInputStream inputStream = new FileInputStream(f)) {
		        CRC32 crc = new CRC32();
		 
		        byte[] bytesBuffer = new byte[1024];
		        int bytesRead = -1;
		 
		        while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
		            digest.update(bytesBuffer, 0, bytesRead);
		        }
		 
		        byte[] hashedBytes = digest.digest();
		 
		        String hash = DatatypeConverter.printHexBinary(hashedBytes);
		        System.out.println("crc32 : " + hash);
		    }
	}*/
	
	
	
	
	
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
		 
		        String hash = DatatypeConverter.printHexBinary(hashedBytes);
		        System.out.println("File MD5 : " + hash);
		    }
        
		//byte[] d = md.digest();
		//String hashedOutput = DatatypeConverter.printHexBinary(d);
		//System.out.println("File MD5 = "+ hashedOutput);
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
		 
		        String hash = DatatypeConverter.printHexBinary(hashedBytes);
		        System.out.println("File SHA1 : " + hash);
		    }
	}
	
	
	public static long getFileCRC(File file) throws IOException {
	    BufferedInputStream bsrc = null;
	    CRC32 crc = new CRC32();
	    try {
	        bsrc = new BufferedInputStream( new FileInputStream( file ) );
	        byte[] bytes = new byte[1024];
	        int i;
	        while( (i = bsrc.read(bytes)) != -1 ) {
	            crc.update(bytes, 0, i );
	        }
	    }
	    finally {
	        if ( bsrc != null ) {
	            bsrc.close();
	        }
	    }
	    System.out.println("File CRC32 = " + crc.getValue());
	    return crc.getValue();
	}
	 
	
	
	
	
	
	
	
	/*public static void genCRC32(String path) throws NoSuchAlgorithmException, IOException{
		File f = new File(path);
		 try (FileInputStream inputStream = new FileInputStream(f)) {
			
		     Checksum checksum = new CRC32();
		     byte[] bytesBuffer = new byte[1024];
		     byte bytesRead = -1;
		 
		     while ((bytesRead = inputStream.read(bytesBuffer)) != -1) {
		         checksum.update(bytesRead, 0, bytesRead.length);
		     }
		     
		     
		     
		     
		     
		     System.out.print("File CRC32 = ");
		     System.out.println(checksum.getValue());
		    }
	}*/
	
	
	public static long crc32(String input) {
        byte[] bytes = input.getBytes();
        Checksum checksum = new CRC32(); // java.util.zip.CRC32
        checksum.update(bytes, 0, bytes.length);

        System.out.println(checksum.getValue());
        
        return checksum.getValue();
    }
	
	
	
	public static void generateMD5(String s) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(s.getBytes());
		byte[] digiest = messageDigest.digest();
		String hashedOutput = DatatypeConverter.printHexBinary(digiest);
		System.out.println(hashedOutput);
	}
	public static void generateSHA1(String s) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
		messageDigest.update(s.getBytes());
		byte[] digiest = messageDigest.digest();
		String hashedOutput = DatatypeConverter.printHexBinary(digiest);
		System.out.println(hashedOutput);
	}
	public static void generateCRC32(String s) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("CRC");
		messageDigest.update(s.getBytes());
		byte[] digiest = messageDigest.digest();
		String hashedOutput = DatatypeConverter.printHexBinary(digiest);
		System.out.println(hashedOutput);
	}
}
