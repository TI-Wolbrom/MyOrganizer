package konkurs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javafx.application.Platform;
import konkurs.fx.dialogs.DialogHelper;

public class UpdateManager {

	// --------------------------------------------------------------------------------------------------------------------
	
	// Mozemy zmienic ta wartosc na false
	// jezeli np. nie chcemy aby nasz program sprawdzal i instalowal aktualizacje.
	private static boolean DO_UPDATE = false;
	
	// Sciezka do katalogu na serwerze w ktorym znajduja sie wszystkie
	// pliki binarne programu (czyli jar itp.)
	public static final String UPDATE_URL = "http://xerp.cba.pl/MyOrganizer/updates/";
	
	// Plik, ktory bedziemy aktualizowac (ten co znajduje sie na serwerze)
	public static final String UPDATE_URL_TARGET = "MyOrganizer.jar";
	
	// Plik z suma kontrolna pliku (MD5) ktorego bedziemy aktualizowac
	public static final String UPDATE_URL_TARGET_SYNC = "sync.txt";
	
	// Plik, ktory bedziemy aktualizowac (znajdujacy sie na dysku)
	public static final String UPDATE_TARGET = "MyOrganizer.jar";

	// MD5 pliku
	public static String updateTargetMd5;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static UpdateBehaviour updateControl;

	// --------------------------------------------------------------------------------------------------------------------
	
	public static void applyBehaviour(UpdateBehaviour ub) {
		updateControl = ub;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void allowUpdate(boolean arg) {
		DO_UPDATE = arg;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static boolean allowsUpdate() {
		return DO_UPDATE;
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void initialize() throws NoSuchAlgorithmException {
		try {
			// Pobieramy MD5 pliku
			updateTargetMd5 = Utils.getFileChecksum(MessageDigest.getInstance("MD5"), new File(UPDATE_TARGET));
		} catch (IOException e) {
			System.err.println("[UPDATE_PROCESS] Could not find MD5 for File (Possible not exist) [DeveloperMode?]");
		}
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	public static void doUpdate() throws Exception {
		String result = Utils.getHTML(UPDATE_URL + UPDATE_URL_TARGET_SYNC);
		
		if(!result.isEmpty()) {
			System.out.println("[UPDATE_PROCESS] MD5 from Server: (" + result + ") our (" + updateTargetMd5 + ")");
			
			if(updateTargetMd5 == null) {
				updateControl.onUpdateStarted();
				
				downloadAppAndUpdate();
			} else if(updateTargetMd5.equals(result)) {
				updateControl.onUpdateNothingToUpdate();
			} else {
				updateControl.onUpdateStarted();
				
				downloadAppAndUpdate();
			}
			
		} else {
			updateControl.onUpdateError();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------

	public static int updateRequired() throws Exception {
		try {
			String result = Utils.getHTML(UPDATE_URL + UPDATE_URL_TARGET_SYNC);
			
			if(updateTargetMd5 != null) {
				System.out.println(result + " <==> " + updateTargetMd5);
				
				if(!result.isEmpty()) 
				{
					
					if(updateTargetMd5.equals(result)) return 3;
					else return 1;
					
				} else return 2;
			}
		} catch (IOException e) { return -1; }
		
		return 0;
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	public static void exportTargetMD5ToFile(String fileName) throws NoSuchAlgorithmException, IOException {
		String md5 = Utils.getFileChecksum(MessageDigest.getInstance("MD5"), new File(UPDATE_TARGET));
		
		FileOutputStream fos = new FileOutputStream(fileName);
		fos.write(md5.getBytes(), 0, md5.length());
		fos.close();
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
	private static void downloadAppAndUpdate() throws Exception {
		System.out.println("[UPDATE_PROCESS] Downloading update...");
		String appSource = Utils.getHTML(UPDATE_URL + UPDATE_URL_TARGET);
		
		if(!appSource.isEmpty()) {
			URL web = new URL(UPDATE_URL + UPDATE_URL_TARGET);
			ReadableByteChannel rbc = Channels.newChannel(web.openStream());
			
			FileOutputStream fos = new FileOutputStream("MyOrganizer-Update.jar");
			fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
			
			fos.close();
			
			System.out.println("[UPDATE_PROCESS] Download done.");
			
			System.out.println("[UPDATE_PROCESS] Applying update...");
			
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					Path oldVersionsPath = Paths.get("old");
					
					try {
						Files.createDirectory(oldVersionsPath);
					} catch(FileAlreadyExistsException ex) {
						System.out.println("[UPDATE_PROCESS] Old Dir exist :D");
					} catch (IOException ex) {
						DialogHelper.showExceptionDialog((Exception)ex);
						ex.printStackTrace();
						AppManager.closeApp();
					}
					
					try {
						if(AppManager.OS_NAME.indexOf("win") >= 0) {
							Runtime.getRuntime().exec("cmd.exe /c " + "start update.bat"); // Dla Windows
						} else if(AppManager.OS_NAME.indexOf("nix") >= 0 || AppManager.OS_NAME.indexOf("nux") >= 0 || AppManager.OS_NAME.indexOf("aix") > 0 ) {
							Runtime.getRuntime().exec("/bin/bash -c " + "sh update.sh"); // Dla Linux
						} else {
							// Brak wsparcia
							System.err.println("[UPDATE_PROCESS] OS not supported at all!");
						}
						
						AppManager.closeApp();
					} catch (Exception e) {
						DialogHelper.showExceptionDialog(e);
						e.printStackTrace();
						AppManager.closeApp();
					}
				}
			});
			
			System.out.println("[UPDATE_PROCESS] All done!");
		}
	}
	
	// --------------------------------------------------------------------------------------------------------------------
	
}
