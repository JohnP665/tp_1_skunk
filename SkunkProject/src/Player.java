

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

public class Player {
	final public int MAXPLAYER = 5;
	final public int MAXGAME = 5;
	final public int MAXSCORE = 100;
	private int numPlayers = 0;
	String[] namePlayers = new String[MAXPLAYER];
	Messages MSG = new Messages();
	
	public Player () {
		
	}
		
	public void player () {	
		
		String PaddingName = "Player_";
		
		StdOut.println("\n");		
		//Set number of Players
		while (true) {
			try {
				StdOut.print(MSG.AskUserInput);				
				setPlayernumber(StdIn.readInt());
				if((getPlayernumber() > 5) || (getPlayernumber() < 2))
					StdOut.print(MSG.InputBound);
				else
					break;
		    }
			catch (Exception e) {
				StdOut.println(MSG.InputMismatch);			 
            }		
		}//End While(true)
		// Create a String & int array to save Players names & Total scores
		// Loop over array to save user input
		for (int i = 0; i < getPlayernumber(); i++) {
			if(getPlayernumber() > 1)
			  StdOut.print("Enter player " + (i+1) + " 's name: ");
			else
			  StdOut.print("Enter player's name: ");
			setPlayer(i, StdIn.readString());			
			//Padding player name is it's a single char
			if(namePlayers[i].length() == 1){
				namePlayers[i] = PaddingName + namePlayers[i];
			}						
		}			
		StdOut.println("\n");
	}//End public void player ()
	

	public void setPlayer(int index, String namePlayer) {
		
		namePlayers[index] =  namePlayer;	
	}

	public static String getPlayer(String Player) {
		
		return Player;	
	}
	
	public void setPlayernumber(int numPlayer) {

		numPlayers = numPlayer;
	}

	public int getPlayernumber() {

		return numPlayers;
	}
}//End Player class
