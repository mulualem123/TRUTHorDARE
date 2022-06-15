
/**
 * Mulualem Hailom
 * 6-10-2022
 * 
 */
import java.util.ArrayList;



public class Statement {

	public Statement() {
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<String> dare(){
		ArrayList<String> dare = new ArrayList<String>();
		dare.add("Ask him a question");
		dare.add("give him a good reason");
		dare.add("take him a where you want");
		dare.add("what him a question");
		dare.add("make him ");
		dare.add("convince him");
		dare.add("resist");
		dare.add("sit under");
		dare.add("lay over");
		dare.add("Eye contact");
		dare.add("Tell him");
		return dare;
	}

	public static ArrayList<String> truth(){
		ArrayList<String> truth = new ArrayList<String>();
		truth.add("Who is your favorite?");
		truth.add("which one do you like?");
		truth.add("when did you do it?");
		truth.add("How did you like it?");
		truth.add("What is it nice?");
		truth.add("Do you think is big");
		truth.add("Are you curios?");
		truth.add("First time?");
		truth.add("How are you now?");
		truth.add("You want to do it?");
		truth.add("What it the weirdest thing?");
		return truth;
	}
	
	public static ArrayList<String> getTruth(){
		ArrayList<String> truthCopy = truth();
		return truthCopy;
	}
	
	public static ArrayList<String> getDare(){
		ArrayList<String> truthDare = dare();
		return truthDare;

	}

}
