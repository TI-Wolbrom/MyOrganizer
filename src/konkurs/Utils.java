package konkurs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class Utils {
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static FileOutputStream lockFileOs;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static String getFileChecksum(MessageDigest digest, File file) throws IOException {
	    // Get file input stream for reading the file content
		FileInputStream fis = new FileInputStream(file);
	     
	    // Create byte array to read data in chunks
	    byte[] byteArray = new byte[1024];
	    int bytesCount = 0;
	      
	    // Read file data and update in message digest
	    while ((bytesCount = fis.read(byteArray)) != -1)
	        digest.update(byteArray, 0, bytesCount);
	     
	    // close the stream; We don't need it now.
	    fis.close();
	     
	    // Get the hash's bytes
	    byte[] bytes = digest.digest();
	     
	    // This bytes[] has bytes in decimal format;
	    // Convert it to hexadecimal format
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i< bytes.length ;i++)
	    	sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	     
	   // return complete hash
	   return sb.toString();
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	public static String getHTML(String urlStr) throws Exception {
		StringBuilder result = new StringBuilder();
		URL url = new URL(urlStr);
		
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			
			while((line = br.readLine()) != null)
				result.append(line);
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
		return result.toString();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void lockInstance() throws Exception {
		Path path = Paths.get(System.getProperty("user.home") + "/" + ".myorganizer");
		
		if(Files.exists(path))
			throw new Exception("Only one instance of the MyOrganizer can be running!");
		else {
			lockFileOs = new FileOutputStream(path.toString());
			System.out.println("[AppLock] Locking instance...");
		}
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void unlockInstance() throws IOException{
		Path path = Paths.get(System.getProperty("user.home") + "/" + ".myorganizer");

		lockFileOs.close();
		
		if(Files.deleteIfExists(path))
			System.out.println("[AppLock] Unlocking instance...");
	}
}
