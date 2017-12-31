package konkurs;

import java.io.IOException;
import java.time.LocalDateTime;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import konkurs.fx_contollers.PlanController;
import konkurs.taskmodules.impl.TaskManager;
import konkurs.taskmodules.impl.TestTask;

public class Main extends Application {

	// --------------------------------------------------------------------------------------------------------------------
	
	private Stage mainStage;
	
	private UpdateScene updateScene;
	
	private Scene sceneMain;
	
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
					Thread.sleep(1500);
					
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
		
		sceneMain = new Scene(pane);
		
		mainStage.hide();
		
		mainStage.setTitle("[My Organizer] by 3TI Wolbrom");
		mainStage.setResizable(true);
		
		mainStage.setWidth(800);
		mainStage.setHeight(600);
		mainStage.setScene(sceneMain);
			
		mainStage.show();
		
		mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				AppManager.closeApp();
			}
		});
		
		// Uruchamiamy TaskManagera
		TaskManager.initialize();
		
		//LocalDateTime ldtNow = LocalDateTime.now();
		//TaskManager.createTask(new TestTask(LocalDateTime.of(ldtNow.getYear(), ldtNow.getMonth(), ldtNow.getDayOfMonth(), ldtNow.getHour(), ldtNow.getMinute(), ldtNow.getSecond())));
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda sluzy do stworzenia sceny o autorach
	// -----------------------------------------------------------------------------------------------------------------------------
	public void buildAbout() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/resources/fxml/About.fxml"));
		
		StackPane pane = loader.load();
		
		mainStage.setScene(new Scene(pane));
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda sluzy do stworzenia sceny o wydarzeniach
	// TODO: Znalezc lepszy sposob na ladowanie plikow fxml za pomoca jakiegos "factory" albo cos w tym stylu.
	// -----------------------------------------------------------------------------------------------------------------------------
	public void buildEventsEditor() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/resources/fxml/Events.fxml"));
		
		GridPane pane = loader.load();
		
		mainStage.setScene(new Scene(pane));
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda sluzy do stworzenia sceny planu lekcji
	// -----------------------------------------------------------------------------------------------------------------------------
	public void buildPlanEditor() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/resources/fxml/Plan.fxml"));
		GridPane pane = loader.load();
		mainStage.setScene(new Scene(pane));
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------
	// Ta metoda sluzy do przelaczenia na scene glowna
	// -----------------------------------------------------------------------------------------------------------------------------
	public void switchToMain() {
		mainStage.setScene(sceneMain);
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
			
			// Jezeli chcemy aby nasz program uruchamial sie szybciej
			// polecam ustawic ta opcje na false
			UpdateManager.allowUpdate(false);
			UpdateManager.initialize();
			
			launch(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
