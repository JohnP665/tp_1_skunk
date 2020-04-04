
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
				if((getPlayernumber() > 5) || (getPlayernumber() < 1))
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




//import edu.princeton.cs.introcs.StdOut;
//import edu.princeton.cs.introcs.StdIn;
//
//public class Player {
//	final public int MAXPLAYER = 5;
//	final public int MAXGAME = 5;
//	final public int MAXSCORE = 100;
//	private int numPlayers = 0;
//	private String[] namePlayers = new String[MAXPLAYER];
//	Messages MSG = new Messages();
//	
//	public Player () {
//		
//	}
//		
//	public void player () {	
//		
//		String PaddingName = "Player_";
//		
//		StdOut.println("\n");		
//		//Set number of Players
//		while (true) {
//			try {
//				StdOut.print(MSG.AskUserInput);				
//				setPlayernumber(StdIn.readInt());
//				if((getPlayernumber() > 5) || (getPlayernumber() < 1))
//					StdOut.print(MSG.InputBound);
//				else
//					break;
//		    }
//			catch (Exception e) {
//				StdOut.println(MSG.InputMismatch);			 
//            }		
//		}//End While(true)
//		// Create a String & int array to save Players names & Total scores
//		// Loop over array to save user input
//		for (int i = 0; i < getPlayernumber(); i++) {
//			if(getPlayernumber() > 1)
//			  StdOut.print("Enter player " + (i+1) + " 's name: ");
//			else
//			  StdOut.print("Enter player's name: ");
//			setPlayer(i, StdIn.readString());			
//			//Padding player name is it's a single char
//			if(namePlayers[i].length() == 1){
//				namePlayers[i] = PaddingName + namePlayers[i];
//			}						
//		}	
//		startGame();
//		StdOut.println("\n");
//	}//End public void player ()
//	
//	public void startGame () {
//		int j = 0;
//		int rollNumber = 0;
//		int tempTotalGamescore = 0;
//		Roll roll = new Roll();
//		Turn turn = new Turn();	
//				
//		if(getPlayernumber() > 1)
//			StdOut.println("\n" + namePlayers[j] + MSG.PlayFirst);
//		StdOut.println(MSG.TurnStart + namePlayers[j]);
//		StdOut.print(namePlayers[j] + MSG.AskUserStartRoll);
//
//		while (tempTotalGamescore < MAXSCORE) {
//
//			turn.playerTurn(j, namePlayers[j], rollNumber);
//			rollNumber = 0;
//			/*
//			 * print score
//			 */
//			StdOut.println("\n\t<<<<< Turn Summary for " + namePlayers[j] + " >>>>>");
//			StdOut.println("\n" + namePlayers[j] + MSG.LastTurnScore + turn.lastTurnScore);
//			StdOut.println(namePlayers[j] + MSG.GameReport2 + roll.getGameScore(j));
//			StdOut.println(namePlayers[j] + MSG.FinalRollMesg5 + roll.updateChipCount(j));
//			StdOut.println(MSG.CurrentKitty + roll.getKittyChipCounts());
//			StdOut.println("\n\n\t<<<<< UptoDate Game Score for all Players >>>>>\n");
//			for (int i = 0; i<getPlayernumber(); i++ ) {
//				StdOut.println(namePlayers[i] + MSG.GameReport2 + roll.getGameScore(i));
//			}
//
//			roll.resetTurnScore();
//			rollNumber = 0;
//
//			tempTotalGamescore = roll.getGameScore(j);
//			if (tempTotalGamescore >= MAXSCORE) {
//				break;
//			}
//
//			j++;
//			if (j == getPlayernumber())
//				j = 0;
//			StdOut.println("\n\n\t========>> New turn for " + namePlayers[j] + " <<========");
//			for (int i = 0; i < 10; i++)
//				turn.rollTurn[i] = 0;
//
//			StdOut.print(namePlayers[j] + MSG.AskUserStartRoll);
//
//		} // while (tempTotalGamescore)
//
//		if (tempTotalGamescore >= MAXSCORE) {
//			for (int i = 0; i < getPlayernumber(); i++) {
//				if (roll.getGameScore(i) >= MAXSCORE)
//					continue;
//				StdOut.println("\n" + MSG.Tab3Mesg + " ========>> WE HAVE WINNER!!! THE FINAL TURN FOR " + namePlayers[i] + " <<========");
//				StdOut.print(namePlayers[i] + MSG.AskUserLastRoll);
//				if (turn.getChoice().equals("y")) {
//					 turn.playerTurn(i, namePlayers[i], rollNumber);
//					 rollNumber = 0;
//				}
//				else continue;
//				StdOut.println("Player chip count: " + roll.updateChipCount(i));
//				StdOut.println("Kitty chip count: " + roll.getKittyChipCounts());
//			}//for (int i = 0; i < getPlayernumber(); i++) 
//		}//if (tempTotalGamescore >= MAXSCORE)  
//
//		WinnerDeclaration();
//	}//End public void startGame () 	
//
//	public void WinnerDeclaration() {
//		
//		Roll roll = new Roll();
//		int TotalBonus = roll.getKittyChipCounts();
//		int Bonus = 0;
//		int remainder = 0;
//		int ChipRemain = 0;
//		int gWin = 0;
//		int numWinner = 0;
//		StdOut.println("\n\n\t\t\t======== End of Game Summary ========");           
//
//		for (int i = 0; i < getPlayernumber(); i++) {
//			if (roll.getGameScore(i) >= MAXSCORE) { 
//				PrintWinner(roll, i, namePlayers[i], MSG.Message1, MSG.Message4);
//				numWinner++;
//			} 
//			else if (roll.getGameScore(i) > 0) {
//				PrintLooserWithScore(roll, i, namePlayers[i], MSG.Message4, MSG.Message5);	
//				if(roll.updateChipCount(i) >= 5) {
//					ChipRemain = roll.updateChipCount(i)  - 5;
//					TotalBonus += 5;
//				}
//				else {
//					ChipRemain = 0;
//					TotalBonus += roll.updateChipCount(i);
//				}    
//				StdOut.println(MSG.Tab3Mesg + namePlayers[i] + MSG.Message_has + ChipRemain  + MSG.Message4);
//			}
//			else if (roll.getGameScore(i) == 0) {
//				PrintZeroScoreLooser(roll, i, namePlayers[i], MSG.Message4, MSG.Message6);
//				if(roll.updateChipCount(i) >= 10) {
//					ChipRemain = roll.updateChipCount(i)  - 10;
//					TotalBonus += 10;
//				}
//				else {
//					ChipRemain = 0;
//					TotalBonus += roll.updateChipCount(i);
//				}    
//				StdOut.println(MSG.Tab3Mesg + namePlayers[i] + MSG.Message_has + ChipRemain  + MSG.Message4);
//			}
//		}	   
//		
//		StdOut.println(MSG.FinalKitty + TotalBonus);
// 		if( numWinner > 1) {
// 			Bonus = TotalBonus / numWinner; 		
// 		    StdOut.println(MSG.Message8 + Bonus + MSG.Message13);
//			remainder = TotalBonus % numWinner;
//			if (remainder > 0) {
//				StdOut.println("The " + remainder + MSG.Message14 + numWinner + MSG.Message15);
//			}
//
// 		}
// 		else {
// 			Bonus = TotalBonus;
// 			StdOut.println(MSG.Message9 + Bonus + MSG.Message13);
// 		}
// 		
//		for (int i = 0; i < getPlayernumber(); i++) {
//			if(numWinner > 1) {
//				if (roll.getGameScore(i) >= MAXSCORE) {
//					ChipRemain = roll.updateChipCount(i) + Bonus;
//					gWin++;
//					StdOut.println(MSG.Message10 + gWin + ": " + namePlayers[i] + MSG.Message12 + ChipRemain + MSG.Message13);
//				}  
//			}
//			else {
//				if (roll.getGameScore(i) >= MAXSCORE) {
//					ChipRemain = roll.updateChipCount(i) + Bonus;
//					StdOut.println(MSG.Message16 + namePlayers[i] + MSG.Message11 + MSG.Message12 + ChipRemain + MSG.Message13);
//				}  			
//			}
//		}
//
//		StdOut.println("\n\t\t\tGAME IS OVER\n");
//	}// End WinnerDeclaration
//	
//	public void PrintWinner( Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
//		StdOut.println("\n\t\t******* " + playerName + Mess1);
//		StdOut.println(MSG.Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
//		StdOut.println(MSG.Tab3Mesg + playerName + MSG.Message_has + Wroll.updateChipCount(playerNum) + Mess2);
//	}
//	
//	public void PrintLooserWithScore( Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
//		StdOut.println("\n" + MSG.Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
//		StdOut.println(MSG.Tab3Mesg + playerName + MSG.Message_has + Wroll.updateChipCount(playerNum) + Mess1);
//		StdOut.println(MSG.Tab3Mesg + playerName + Mess2);
//	}
//	
//	public void PrintZeroScoreLooser( Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
//		StdOut.println("\n" + MSG.Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
//		StdOut.println(MSG.Tab3Mesg + playerName + MSG.Message_has + Wroll.updateChipCount(playerNum) + Mess1);
//		StdOut.println(MSG.Tab3Mesg + playerName +Mess2);
//	}		
//	
//	public void setPlayer(int index, String namePlayer) {
//		
//		namePlayers[index] =  namePlayer;	
//	}
//
//	public static String getPlayer(String Player) {
//		
//		return Player;	
//	}
//	
//	public void setPlayernumber(int numPlayer) {
//
//		numPlayers = numPlayer;
//	}
//
//	public int getPlayernumber() {
//
//		return numPlayers;
//	}
//}//End Player class
