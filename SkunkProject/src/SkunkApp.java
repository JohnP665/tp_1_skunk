
//implement SkunkApp with starting main() and other classes so that this app 
//plays a complete interactive Turn of Skunk with multiple human Players.

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import edu.princeton.cs.introcs.StdOut;

public class SkunkApp {

	static int numPlayers = 0;

	public static void main(String[] args) {
		
	  try {
	      File myObj = new File("src/SkunkRules.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        System.out.println(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	    	StdOut.println("An error in file reading occurred.");
	    	e.printStackTrace();
	    }
	
		Player SkunkGame = new Player();
		new Turn(SkunkGame);
	}
}


//import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
//import java.util.Scanner; // Import the Scanner class to read text files
//import edu.princeton.cs.introcs.StdOut;
//
//public class SkunkApp {
//
//	static int numPlayers = 0;
//
//	public static void main(String[] args) {
//		
//		  try {
//		      File myObj = new File("src/SkunkRules.txt");
//		      Scanner myReader = new Scanner(myObj);
//		      while (myReader.hasNextLine()) {
//		        String data = myReader.nextLine();
//		        System.out.println(data);
//		      }
//		      myReader.close();
//		    } catch (FileNotFoundException e) {
//		    	StdOut.println("An error in file reading occurred.");
//		    	e.printStackTrace();
//		    }
//		
//		Player SkunkGame = new Player();
//		SkunkGame.player();
//	}
//}
