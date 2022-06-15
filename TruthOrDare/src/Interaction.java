
/**
 * Mulualem Hailom
 * 6-10-2022
 * 
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.sun.source.tree.WhileLoopTree;

public class Interaction {

	
	
	//public static void  main(String[] arg) {
		public Interaction() {

		// TODO Auto-generated constructor stub
		ArrayList<String> players = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int i = 0;
		
		System.out.println("Enter first player's name.");
		
		while(scan.hasNext()&& !scan.hasNextDouble()){ 
			System.out.println("Enter next player name.");
			players.add(scan.next());
			System.out.println(players.get(i));
			i++;
		}
		System.out.println(players);

		Statement queStatement = new Statement();
		ArrayList<String> dare= queStatement.getDare();
		System.out.println("Size of dare statement array list" + dare.size());
		ArrayList<String> truth= queStatement.getTruth();
		System.out.println("Size of truth question array list" + truth.size());

		Scanner choiceScanner = new Scanner(System.in);

		int dareTruthSizeTracker = dare.size();

		for (int j = dareTruthSizeTracker; j >= 0; j--) {


			if (j>0) { // helps to continue the game after each got their turn.

				for(String str: players) {

					if(dareTruthSizeTracker>0) {

						System.out.println( str + " dare or truth?");// Text input and button 

						Random random = new Random();
						int ran;

						try {
							ran = random.nextInt(dareTruthSizeTracker);
						} catch (Exception e) {
							ran = 0;
						}


						if(choiceScanner.next().contains("dare")) {

							System.out.println(" "+ran + " " + dare.get(ran) ); // tracking the random number is not 
							dare.remove(ran);
							System.out.println("Size "+dare.size());// tracking the size of dare array

						}else {

							System.out.println(ran + " " + truth.get(ran) );
							dare.remove(ran);
							System.out.println("Size "+truth.size());
						}

					}

					if(dare.size()<=truth.size()) { //restricting the most outer loop

						dareTruthSizeTracker = dare.size();

					}else {

						dareTruthSizeTracker=truth.size();
					}
				}
			}else {

				System.out.println("Restart or Done?");
				if (choiceScanner.next().contains("restart")) {

					//reset
					dare= queStatement.getDare();
					truth= queStatement.getTruth();	
				}else {

					//or this game is over
					System.out.println("This game is over!");

				}
			}

			System.out.println("j = " + j);
			System.out.println("dareTruthSizeTracker "+dareTruthSizeTracker);

		}// The most out For loop
	}


}
