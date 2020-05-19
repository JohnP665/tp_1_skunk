//////////////////////////////////////////////////////////////
/*
* Turn Class
*  Players take turn to play (roll), ask if user want to continue their turn to roll
*/

import java.util.Arrays;
import edu.princeton.cs.introcs.StdOut;

public class Turn extends Player{
	
	int[] rollTurn = new int[TURNLIMIT];
	private String continueToRoll = null;	
	
	public Turn() {

	}
	
	public void playerTurn(int PlayerNum, String playerName, int rolNum) {
		
		Roll roll = new Roll();						
		boolean plyFlag = false;

		while (true) {	
			do {  
				try {
					setChoice(Messages.UI("").toLowerCase());
					if(getChoice().equals("y") || getChoice().equals("n"))
						break;
					else Messages.println(Re_Enter);
			    }
				catch (Exception e) {
					Messages.println(InputMismatch);			 
	            }	
			}while(!getChoice().equals("y") || !getChoice().equals("n"));	
			
			if (getChoice().equals("y")) {
                
                if(plyFlag == false) {
                	Messages.print("\n" + Player.getPlayer(playerName) + FinalRollMesg2);
                	Messages.println("..................");
					plyFlag = true;
                }
				roll.throwDice(PlayerNum);

				StdOut.println("\nDie1: " + roll.getDie1Score() + "   Die2: " + roll.getDie2Score());
				if (roll.playerLosesTurn() == true) {
					int rollScore = roll.getDie1Score() + roll.getDie2Score();
					if (rollScore == 2) {
						doubleSkunkMsg();
						roll.resetGameScore(PlayerNum);
						rolNum = 0;
						PrintReport(Player.tempTotalGamescore, PlayerNum, playerName, roll);

					} 
					else if (rollScore == 3) {
						deuceMsg();
						rolNum = 0;
						PrintReport(Player.tempTotalGamescore, PlayerNum, playerName, roll);
					} 
					else if ((roll.getDie1Score() == 1 || roll.getDie2Score() == 1)) {
						SkunkMsg();
						rolNum = 0;
						PrintReport(Player.tempTotalGamescore, PlayerNum, playerName, roll);
					}
					break;
				} 
				else {
					PrintReport(Player.tempTotalGamescore, PlayerNum, playerName, roll);
					rollTurn[rolNum] = roll.getRollScore();
					rolNum++;
					Player.tempTotalGamescore = roll.getGameScore(PlayerNum);
					if (Player.tempTotalGamescore >= MAXROUNDSCORE) {
						break;
					} 
					else if (rolNum >= (TURNLIMIT)){
						Messages.println(FinalRollMesg9);
						rolNum = 0;
						break;
					}
					else
						Messages.print(Ask_User);
				}
			} 
			else if (getChoice().equals("n")) {
				rolNum = 0;
				break;
			}

		} // End while (true)

 /* print turn scores */
		if (Player.tempTotalGamescore >= MAXROUNDSCORE) {
			Messages.print(RoundMessage3);
		}
	}//End public void playerTurn(int PlayerNum, String playerName, int rolNum)
			
	public void PrintReport(int tempTotScore, int playerNum, String playerName, Roll thisroll) {	
		int TurnScore = thisroll.getTurnScore();
				
		if ((thisroll.getDie1Score() == 1 || thisroll.getDie2Score() == 1)) {
			Messages.println("\n" + playerName + TurnReport2 + TurnScore);
		}
		else {	
			Messages.println("\n" + playerName + TurnReport1 + thisroll.getRollScore());
			Messages.print(TurnReport4 + TurnScore + " ==> ");
			Messages.print(Arrays.toString(thisroll.thisTurnScore) + "\n");
		}
		tempTotScore = thisroll.getGameScore(playerNum);	
	}
	
	public void doubleSkunkMsg() {
		Messages.println(doubleSkunk1);
		Messages.println(doubleSkunk2);
		Messages.println(doubleSkunk3);
	}
	
	public void deuceMsg() {
		Messages.println(deuceSkunk1);
		Messages.println(deuceSkunk2);
		Messages.println(deuceSkunk3);
	}
	
	public void SkunkMsg() {
		Messages.println(singleSkunk1);
		Messages.println(singleSkunk2);
		Messages.println(singleSkunk3);
	}
		
	public void setChoice(String choice) {
		continueToRoll = choice;
	}
	
	public String getChoice() {
		return continueToRoll;
	}
}
