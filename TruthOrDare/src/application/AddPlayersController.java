package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AddPlayersController extends Controller{

	private Stage stage;
	private Scene scene;
	private Parent parent;

	@FXML 
	Label displayChoiceLabel;

	//called by Controller class
	public void changeTextLabel(String str) {
		displayChoiceLabel.setText(str);
	}

	//Giving option Button Methods
	@FXML
	private void dare(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StatementDisplayPage.fxml"));
		parent = loader.load();	
		Controller controller = loader.getController();
		controller.displayDareStatement();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}

	@FXML
	private void truth(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("StatementDisplayPage.fxml"));
		parent = loader.load();	
		Controller controller = loader.getController();
		controller.displayTruthStatement();
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}

}
