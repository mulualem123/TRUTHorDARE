
/**
 * Mulualem Hailom
 * 6-10-2022
 * 
 */
import java.util.ArrayList;
import java.util.Random;


public class TruthDareMethods {

	
	private static ArrayList<String> dare = new Statement().getDare();
	private static ArrayList<String> truth = new Statement().getTruth();

	public TruthDareMethods() {

	}
	//public static void addPlayers(String playerName) {
	//	players.add(playerName);
	//}

	public static String getDare() {
		
		int random = new Random().nextInt(getDareLength());
		System.out.println(dare.size());
		String str = dare.get(random);
		dare.remove(random);
		return str;
		
	}

	public static int getDareLength() {
		// TODO Auto-generated method stub

		return dare.size();
	}

	public static String getTruth() {
		int random = new Random().nextInt(getTruthLength());
		System.out.println(truth.size());
		String str = truth.get(random);
		truth.remove(random);
		return str;
	}

	public static int getTruthLength() {
		// TODO Auto-generated method stub
		return truth.size();
	}

	public static void reset() {
		dare = new Statement().getDare();
		truth = new Statement().getTruth();

	}


}