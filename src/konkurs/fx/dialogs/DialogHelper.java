package konkurs.fx.dialogs;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import konkurs.Main;
import konkurs.fx_contollers.ExceptionDialogController;
import konkurs.fx_contollers.NormalDialogController;

public class DialogHelper {

	// --------------------------------------------------------------------------------------------------------------------
	
	// Powinno byc uzywane na tym samym watku co Java-fx thread.
	public static void showDefaultDialog(String caption, String text) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/resources/fxml/Dialog_Normal.fxml"));

		try {
			GridPane gp = loader.load();
			NormalDialogController ndc = (NormalDialogController) loader.getController();
			ndc.detailsLabel.setText(text);

			Stage stage = new Stage();
			stage.setScene(new Scene(gp));

			stage.setTitle(caption);
			stage.setResizable(false);

			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	// Powinno byc uzywane na tym samym watku co Java-fx thread.
	public static void showExceptionDialog(Exception e) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/resources/fxml/Dialog_Exception.fxml"));

		try {
			GridPane gp = loader.load();
			ExceptionDialogController edc = (ExceptionDialogController) loader.getController();
			edc.messageLabel.setText("Exception:");

			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);

			e.printStackTrace(pw);

			edc.exceptionTextArea.setText(sw.toString());

			Stage stage = new Stage();
			stage.setScene(new Scene(gp));

			stage.setTitle("Exception!");
			stage.setResizable(false);

			stage.show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	// Powinno byc uzywane wtedy, gdy znajdujemy sie na innym watku
	// czyli np. UpdateScene/UpdateManager
	public static void showDefaultDialogLater(String caption, String text) {
		Platform.runLater(new Runnable() {
			public void run() { showDefaultDialog(caption, text); }
		});
	}

	// --------------------------------------------------------------------------------------------------------------------
	
	// Powinno byc uzywane wtedy, gdy znajdujemy sie na innym watku
	// czyli np. UpdateScene/UpdateManager
	public static void showExceptionDialogLater(Exception e) {
		Platform.runLater(new Runnable() {
			public void run() { showExceptionDialog(e); }
		});
	}
}
