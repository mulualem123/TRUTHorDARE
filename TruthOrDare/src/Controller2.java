import java.awt.Label;
import java.awt.TextField;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Controller2 extends StageLoader{
	
	@FXML
	private Button addMe;
	@FXML
	private TextField text;
	@FXML
	private ListView listView;
	@FXML 
	private Label announcePlayers;
	
	private static ArrayList<String> players = new ArrayList<String>();
	private Stage stage;
	private Scene scene; 
	private Parent root;

	public void add(ActionEvent e) {

		try {
			if(text.getText()!=null) {
				String str = text.getText();
					System.out.println(str);
				text.setText("");
				//listOfPlayers = listOfPlayers + " " + str;
				listView.getItems().add(str);
				announcePlayers.setText("Insert next player name.");
				//welcomeLabel.setText("The palyers are " + listOfPlayers );
				players.add(str);
			}
		}catch(NullPointerException e1) {

		}

	}

}
