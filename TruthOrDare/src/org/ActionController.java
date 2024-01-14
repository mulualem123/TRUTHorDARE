package org;
import java.awt.TextField;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class ActionController{
	private static ArrayList<String> players = new ArrayList<String>();
	//private static String listOfPlayers = "";
	private static int track = 0;
	private static TruthDareMethods truthDareMethods = new TruthDareMethods();

	private  Stage stage;
	private  Scene scene;
	private  Parent root;

	//inserFxml
	@FXML
	public TextField textField;
	@FXML
	public Button startGame;
	@FXML 
	public Labeled announcePlayers, askTDLabel, displayTDLabel;
	@FXML
	protected ListView listView;

	//Button Actions
	public void add(ActionEvent e) {
		try {
			if(textField.getText()!=null) {
				String str = textField.getText();
				System.out.println(str);
				textField.setText("");
				//listOfPlayers = listOfPlayers + " " + str;
				listView.getItems().add(str);
				//announcePlayers.setText("Insert next player name.");
				//welcomeLabel.setText("The palyers are " + listOfPlayers );
				players.add(str);
			}
		}catch(NullPointerException e1) {

		}

	}
	public void start(ActionEvent e) throws IOException {
		track = 0;
		System.out.println(players.toString());
		askTDLabel.setText(players.get(track) + " what do you want to play?");
		optionsScene(e);
	}
	public void dare(ActionEvent e) throws IOException {

		//displayTDLabel.setText(TruthDareMethods.getDare());
		displayStatement(e);
	}
	public void truth(ActionEvent e) throws IOException {
		//displayTDLabel.setText(TruthDareMethods.getTruth());
		displayStatement(e);	
	}
	public void next(ActionEvent e) throws IOException {

		if(track >= players.size()-1) {
			track = 0;
		}else {				
			track++;		
		}

		try {
			if(truthDareMethods.getDareLength() == 0 || truthDareMethods.getTruthLength()==0) {
				outOfQuestions(e);
			}else {
				askTDLabel.setText(players.get(track) + " what do you want to play?");
				optionsScene(e);
			}
		}catch(NullPointerException e2) {
			System.out.println("Something is wrong");
		}

	}
	public void quit(ActionEvent e) throws IOException {

		//textField.setText("");;
		players.clear();
		truthDareMethods.reset();
		playerList(e);

	}
	public void restart(ActionEvent e) throws IOException {

		track = 0;
		truthDareMethods.reset();
		playerList(e);
	}
	
	//Navigations
	public void optionsScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/options.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void playerList(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/playerList.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void outOfQuestions(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/outOfQuestions.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	public void displayStatement(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("/displayStatement.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}


