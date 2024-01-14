package application;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	private static ArrayList<String> players = new ArrayList<String>();
	private static TruthDareMethods truthDareMethods;

	private static int track = 0;

	private Stage stage;
	private Scene scene;
	private Parent parent;
	//Welcome page
	@FXML private Labeled welocomeLabel;

	//AddPage
	@FXML private Label addPlayerName;
	@FXML private TextField textField;
	@FXML private ListView listView;

	//OptionPage
	@FXML private Button chooseDare;
	@FXML private Button chooseTruth;
	@FXML private static Label displayOrderLabel;
	//public static Label staGiveOptionLabel= displayOrderLabel;

	//presetTheTruthDare
	@FXML private Labeled presetTruthDare;


	//Adding player page button methods
	@FXML
	private void add(ActionEvent e) {

		try {
			if(textField.getText()!=null) {
				String str = textField.getText();
				System.out.println(str);
				textField.setText("");
				//listOfPlayers = listOfPlayers + " " + str;
				
				//announcePlayers.setText("Insert next player name.");
				//welcomeLabel.setText("The palyers are " + listOfPlayers );
				players.add(str);
				listView.getItems().clear();
				for (String strg : players) {
					
					listView.getItems().add(strg);
				}
			}
		}catch(NullPointerException e1) {

		}

	}
	@FXML
	private void clear(ActionEvent e) {
		listView.getItems().clear();
		players.clear();
	}
	@FXML
	private void Start(ActionEvent e) throws IOException {
		track = 0;
		System.out.println(players.toString());
		truthDareMethods.reset();
		navigateOptionFxml(e);

	}	

	//Displaying statement Button Methods
	public void next(ActionEvent e) throws IOException {

		if(track >= players.size()-1) {
			track = 0;
		}else {				
			track++;		
		}

		try {
			if(truthDareMethods.getDareLength() == 0 || truthDareMethods.getTruthLength()==0) {
				navigateOutOfDaresAndQuestions(e);
			}else {
				navigateOptionFxml(e);
			}
		}catch(NullPointerException e2) {
			System.out.println("Something is wrong");
		}

	}
	//Game over methods

	//Navigation methods
	public void navigateAddPlayersFxml(ActionEvent e) throws IOException {
		parent = FXMLLoader.load(getClass().getResource("AddPlayersPage.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	public void navigateOptionFxml(ActionEvent e) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("OptionPage.fxml"));
		parent=loader.load();	
		AddPlayersController controllerCopy=loader.getController();
		controllerCopy.changeTextLabel(players.get(track) + " what do you want to play?");
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	public void navigateWelcominFxml(ActionEvent e) throws IOException {
		parent = FXMLLoader.load(getClass().getResource("WelcomingPage.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
	public void navigateOutOfDaresAndQuestions(ActionEvent e) throws IOException {
		parent = FXMLLoader.load(getClass().getResource("outOfDaresAndQuestions.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(parent);
		stage.setScene(scene);
		stage.show();
	}
	
	//Restart != Start
	@FXML
	private void Restart(ActionEvent e) throws IOException {
		track = 0;
		System.out.println(players.toString());
		truthDareMethods = new TruthDareMethods();
		navigateOptionFxml(e);

	}	
	
	//Quit
	public void quit(ActionEvent e) {
		players.clear();
		track = 0;
		try {
			navigateWelcominFxml(e);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	//Called from AddPlayersController.java
	public void displayDareStatement() throws IOException {
		presetTruthDare.setText(TruthDareMethods.getDare());
	}
	public void displayTruthStatement() throws IOException {
		presetTruthDare.setText(TruthDareMethods.getDare());
	}
	
}
