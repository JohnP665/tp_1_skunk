import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SkunkApp {

	 public static void SkunkRule () {
		String Answer;
        char response;
        Messages.println("SEIS635 - Spring 2020");
        Messages.println("Team Project ver. 2.3 - John Pham & Rose Xiong");
        Messages.print("\n\nDo you want to read the rules? ");
 		Answer = Messages.UI("(Enter 'y' to display rules or any other letter to skip) ");
		Answer.toLowerCase();
		response = Answer.charAt(0);
		if(response == 'y'){		

		  try {
			  Messages.print("\n\n\n");
			  File myObj = new File("src/SkunkRules.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Messages.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		    	Messages.println("An error in file reading occurred.");
		    	e.printStackTrace();
		    }		  
		}
	 } 
	 
	 public static void main(String[] args) {
		SkunkRule ();
		new Tournament();
	 }
}//End public class SkunkApp 	