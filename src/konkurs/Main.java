package konkurs;

import java.io.IOException;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

	// --------------------------------------------------------------------------------------------------------------------
	
	private Stage mainStage;
	
	private UpdateScene updateScene;
	private Scene scene;
	
	private Thread loadingThread;
	
	// --------------------------------------------------------------------------------------------------------------------
	
	
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda jest wywolywana, gdy nasza aplikacja sie wlacza.
	// -----------------------------------------------------------------------------------------------------------------------------
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		
		updateScene = new UpdateScene(new Parent() {}, this.mainStage);
		updateScene.build();
		
		mainStage.setScene(updateScene);
		
		AppManager.applyMain(this);
		UpdateManager.applyBehaviour(updateScene);
		
		Task<Void> updateTask = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				System.out.println("[UPDATE_TASK] Thread ID: " + Thread.currentThread().getId() + " Name=" + Thread.currentThread().getName());
				
				if(UpdateManager.allowsUpdate()) {
					// Tutaj na razie nic sie nie dzieje
					// wiec poprostu czekamy 5 sekund (5000ms) i konczymy zadanie
					Thread.sleep(5000);
					
					UpdateManager.doUpdate();
				}
				
				updateScene.loadResources();
				
				// Dajemy jakis czas zeby zasymulowac
				// wczytywanie plikow itp.
				Thread.sleep(2000);
				
				return null;
			}
		};
		
		updateTask.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			@Override
			public void handle(WorkerStateEvent event) {
				try {
					buildMain();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		loadingThread = new Thread(updateTask);
		loadingThread.start();

		mainStage.show();
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda jest wywolywana, gdy nasza aplikacja sie wylacza.
	// -----------------------------------------------------------------------------------------------------------------------------
	@Override
	public void stop() throws Exception {
		if(loadingThread != null) {
			// Zakonczenie watku w taki sposob, nie jest najlepszym pomyslem
			// ale na razie to nam wystarcza
			loadingThread.stop();
		}
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda sluzy do stworzenia glownej sceny
	// -----------------------------------------------------------------------------------------------------------------------------
	private void buildMain() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/resources/fxml/Base.fxml"));
		
		BorderPane pane = loader.load();
	
		scene = new Scene(pane);
	
		mainStage.hide();
		
		mainStage.setTitle("[My Organizer] by 3TI Wolbrom");
		mainStage.setResizable(true);
		
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		mainStage.setScene(scene);
			
		mainStage.show();
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Metoda main
	// -----------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		try {
			if(args.length > 0 && args[0].equalsIgnoreCase("-export")) {
				UpdateManager.exportTargetMD5ToFile("sync.txt");
				System.exit(0);
			}
			
			// Wylaczamy aktualizacje
			// oczywiscie mozemy je wlaczyc ale aktualnie nie musimy sprawdzac aktualizacji chyba nie musze mowic dlaczego :)
			UpdateManager.allowUpdate(false);
			UpdateManager.initialize();

			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
