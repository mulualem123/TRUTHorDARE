package org;

/**
 * Mulualem Hailom
 * 6-10-2022
 * 
 */

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXGui extends Application {
	protected static ArrayList<String> players = new ArrayList<String>();
	private static String listOfPlayers = "";
	protected static int track = 0;
	protected static TruthDareMethods truthDareMethods = new TruthDareMethods();

	protected Scene insertPlayers;
	protected Scene giveChoices;
	protected Scene displayQuestions;
	protected Scene outOfQuestions;
	protected Scene playerList;
	
	protected static Stage stage ;

	public static void main(String args[]) {
		System.out.println("Call lounch methode");
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage ;
		//new
		//Parent playerListFxml= FXMLLoader.load(getClass().getResource("/playerList.fxml"));
		//Parent optionsFxml = FXMLLoader.load(getClass().getResource("/options.fxml"));
		//Parent displayFxml = FXMLLoader.load(getClass().getResource("/displayStatement.fxml"));
		Parent outOfQuestionFxml = FXMLLoader.load(getClass().getResource("/outOfQuestions.fxml"));
		String css = this.getClass().getResource("style.css").toExternalForm();

		//classic 
		StackPane inserPlayerLayout = new StackPane(); 
		StackPane giveOptionLayout = new StackPane(); 
		StackPane displayQuestionsLayout = new StackPane(); 
		StackPane outOfQuestionLayout = new StackPane(); 

		//flexable between new and classic
		//Scene insertPlayers = new Scene(inserFxml);
		//insertPlayers.getStylesheets().add(css);
		//Scene giveChoices = new Scene(optionFxml);
		//Scene displayQuestions = new Scene(displayFxml);
		//Scene outOfQuestions = new Scene(outOfQuestionFxml);

		//playerList = new Scene(playerListFxml);
		//giveChoices = new Scene(optionsFxml);
		//displayQuestions = new Scene(displayFxml);
		outOfQuestions = new Scene(outOfQuestionFxml);

		////scene.getStylesheets().add(directory);

		//inserPlayerNames
		Label welcomeLabel = new Label("Welcome to Truth or Dare");
		Label addPlayerLabel = new Label("Insert Player name");
		TextField text = new TextField();
		Button addPlayer = new Button("Add"); // adds the name to players arrayList and reset the TextField.
		Button startGame = new Button("Start game");// calls "giveOptions"
		HBox buttonsHBox = new HBox(text, addPlayer);
		buttonsHBox.autosize(); //may be delete it
		VBox buttonsVBox = new VBox(addPlayerLabel, buttonsHBox, startGame); 
		inserPlayerLayout.getChildren().addAll(welcomeLabel);
		inserPlayerLayout.getChildren().addAll(buttonsVBox);

		//giveOptions
		Label truthOrDareLabel = new Label(" What do you want to play?");
		Button dareOption = new Button("Dare");// calls "displayQuesions"  and track++
		Button truthOption = new Button("Truth");// calls " displayDare"
		HBox optionButtHBox = new HBox(dareOption, truthOption);
		giveOptionLayout.getChildren().addAll(truthOrDareLabel, optionButtHBox);

		//displayQuestions or displayDare
		Label aQuestDareLabel = new Label("Truth or Dare will be displayed here!");
		Button next = new Button("Next Play"); // calls "giveOptions"
		Button quit = new Button("Quit");// reset truthDareMethods object and empty player arrayList
		HBox displayButtHBox = new HBox(next, quit);
		displayQuestionsLayout.getChildren().addAll(aQuestDareLabel, displayButtHBox);
		// in dare button event aQuestDareLabel.setText(truthDareMethods.getDare());

		//outOfQuestions
		Label outChoices = new Label("You went through all the Truth and Dares");
		Button restart = new Button("restart"); // calls truthDareMethods.reset();
		//Quit Button
		HBox outOfQuestionHBox = new HBox(restart,quit);
		outOfQuestionLayout.getChildren().addAll(outChoices, outOfQuestionHBox);


		// button events
		addPlayer.setOnAction(e->{
			try {
				if(text.getText()!=null) {
					String str = text.getText();
					System.out.println(str);
					text.clear();
					listOfPlayers = listOfPlayers + " " + str;
					addPlayerLabel.setText("Insert next player name.");
					welcomeLabel.setText("The palyers are " + listOfPlayers );
					players.add(str);
				}
			}catch(NullPointerException e1) {

			}
		});

		startGame.setOnAction(e->{
			track = 0;
			System.out.println(players.toString());
			truthOrDareLabel.setText(players.get(track) + " what do you want to play?");
			stage.setScene(giveChoices);
		}); //may be combine next button with restart button

		dareOption.setOnAction(e->{
			aQuestDareLabel.setText(TruthDareMethods.getDare());
			stage.setScene(displayQuestions);

		});

		truthOption.setOnAction(e->{
			aQuestDareLabel.setText(TruthDareMethods.getTruth());
			stage.setScene(displayQuestions);
		});

		next.setOnAction(e->{
			if(track >= players.size()-1) {
				track = 0;
			}else {				
				track++;		
			}

			try {
				if(truthDareMethods.getDareLength() == 0 || truthDareMethods.getTruthLength()==0) {
					stage.setScene(outOfQuestions);
				}else {
					truthOrDareLabel.setText(players.get(track) + " what do you want to play?");
					stage.setScene(giveChoices);
				}
			}catch(NullPointerException e2) {
				System.out.println("Something is wrong");
			}
		});

		quit.setOnAction(e->{
			text.clear();
			players.clear();
			truthDareMethods.reset();
			stage.setScene(insertPlayers);

		});
		restart.setOnAction(e->{
			track = 0;
			truthDareMethods.reset();
			stage.setScene(giveChoices);
		});

		//give option
		stage.setTitle("Truth or Dare");
		stage.setScene(outOfQuestions);
		stage.show();
	}

}

