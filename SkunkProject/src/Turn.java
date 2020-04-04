
import java.util.Arrays;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

public class Turn {
	final int TURNLIMIT = 10;
	final public int MAXSCORE = 100;
	int[] rollTurn = new int[TURNLIMIT];
	int lastTurnScore = 0;
	private String continueToRoll = null;
	Messages MSG = new Messages();
	Roll roll = new Roll();
	Player player = new Player();	

	public Turn() {
				
	}

	public Turn(Player plyr) {
		plyr = new Player();
		plyr.player();	
		startGame (plyr);		
	}
	
	public void startGame (Player plyr) {
		int j = 0;
		int rollNumber = 0;
		int tempTotalGamescore = 0;		
				
		if(plyr.getPlayernumber() > 1)
			StdOut.println("\n" + plyr.namePlayers[j] + MSG.PlayFirst);
		StdOut.println(MSG.TurnStart + plyr.namePlayers[j]);
		StdOut.print(plyr.namePlayers[j] + MSG.AskUserStartRoll);

		while (tempTotalGamescore < MAXSCORE) {

			playerTurn(j, plyr.namePlayers[j], rollNumber);
			rollNumber = 0;
			/*
			 * print score
			 */
			StdOut.println("\n\t<<<<< Turn Summary for " + plyr.namePlayers[j] + " >>>>>");
			StdOut.println("\n" + plyr.namePlayers[j] + MSG.LastTurnScore + lastTurnScore);
			StdOut.println(plyr.namePlayers[j] + MSG.GameReport1 + roll.getGameScore(j));
			StdOut.println(plyr.namePlayers[j] + MSG.FinalRollMesg5 + roll.updateChipCount(j));
			StdOut.println(MSG.CurrentKitty + roll.getKittyChipCounts());
			StdOut.println("\n\n\t<<<<< UptoDate Game Score for all Players >>>>>\n");
			for (int i = 0; i<plyr.getPlayernumber(); i++ ) {
				StdOut.println(plyr.namePlayers[i] + MSG.GameReport2 + roll.getGameScore(i));
			}

			roll.resetTurnScore();
			rollNumber = 0;

			tempTotalGamescore = roll.getGameScore(j);
			if (tempTotalGamescore >= MAXSCORE) {
				break;
			}

			j++;
			if (j == plyr.getPlayernumber())
				j = 0;
			StdOut.println("\n\n\t========>> New turn for " + plyr.namePlayers[j] + " <<========");
			for (int i = 0; i < 10; i++)
				rollTurn[i] = 0;

			StdOut.print(plyr.namePlayers[j] + MSG.AskUserStartRoll);

		} // while (tempTotalGamescore)

		if (tempTotalGamescore >= MAXSCORE) {
			for (int i = 0; i < plyr.getPlayernumber(); i++) {
				if (roll.getGameScore(i) >= MAXSCORE)
					continue;
				StdOut.println("\n" + MSG.Tab3Mesg + " ========>> WE HAVE WINNER!!! THE FINAL TURN FOR " + plyr.namePlayers[i] + " <<========");
				StdOut.print(plyr.namePlayers[i] + MSG.AskUserLastRoll);
				if (getChoice().equals("y")) {
					 playerTurn(i, plyr.namePlayers[i], rollNumber);
					 rollNumber = 0;
				}
				else continue;
				StdOut.println(MSG.FinalRollMesg7 + roll.updateChipCount(i));
				StdOut.println(MSG.FinalRollMesg8 + roll.getKittyChipCounts());
			}//for (int i = 0; i < plyr.getPlayernumber(); i++) 
		}//if (tempTotalGamescore >= MAXSCORE)  

		WinnerDeclaration(plyr);
	}//End public void startGame () 	

	public void WinnerDeclaration(Player plyer) {
		Roll roll = new Roll();
		
		int TotalBonus = roll.getKittyChipCounts();
		int Bonus = 0;
		int remainder = 0;
		int ChipRemain = 0;
		int gWin = 0;
		int numWinner = 0;
		StdOut.println("\n\n\t\t\t======== End of Game Summary ========");           

		for (int i = 0; i < plyer.getPlayernumber(); i++) {
			if (roll.getGameScore(i) >= MAXSCORE) {
				PrintWinner(roll, i, plyer.namePlayers[i], MSG.Message1, MSG.Message2);
				numWinner++;
			} 
			else if (roll.getGameScore(i) > 0) {
				PrintLooserWithScore(roll, i, plyer.namePlayers[i], MSG.Message4, MSG.Message5);	
				if(roll.updateChipCount(i) >= 5) {
					ChipRemain = roll.updateChipCount(i)  - 5;
					TotalBonus += 5;
				}
				else {
					ChipRemain = 0;
					TotalBonus += roll.updateChipCount(i);
				}    
				StdOut.println(MSG.Tab3Mesg + plyer.namePlayers[i] + MSG.Message_has + ChipRemain  + MSG.Message4);
			}
			else if (roll.getGameScore(i) == 0) {
				PrintZeroScoreLooser(roll, i, plyer.namePlayers[i], MSG.Message4, MSG.Message6);
				if(roll.updateChipCount(i) >= 10) {
					ChipRemain = roll.updateChipCount(i)  - 10;
					TotalBonus += 10;
				}
				else {
					ChipRemain = 0;
					TotalBonus += roll.updateChipCount(i);
				}    
				StdOut.println(MSG.Tab3Mesg + plyer.namePlayers[i] + MSG.Message_has + ChipRemain  + MSG.Message4);
			}
		}	   
		
		StdOut.println(MSG.FinalKitty + TotalBonus);
 		if( numWinner > 1) {
 			Bonus = TotalBonus / numWinner; 		
 		    StdOut.println(MSG.Message8 + Bonus + MSG.Message13);
			remainder = TotalBonus % numWinner;
			if (remainder > 0) {
				StdOut.println("The " + remainder + MSG.Message14 + numWinner + MSG.Message15);
			}

 		}
 		else {
 			Bonus = TotalBonus;
 			StdOut.println(MSG.Message9 + Bonus + MSG.Message13);
 		}
 		
		for (int i = 0; i < plyer.getPlayernumber(); i++) {
			if(numWinner > 1) {
				if (roll.getGameScore(i) >= MAXSCORE) {
					ChipRemain = roll.updateChipCount(i) + Bonus;
					gWin++;
					StdOut.println(MSG.Message10 + gWin + ": " + plyer.namePlayers[i] + MSG.Message12 + ChipRemain + MSG.Message13);
				}  
			}
			else {
				if (roll.getGameScore(i) >= MAXSCORE) {
					ChipRemain = roll.updateChipCount(i) + Bonus;
					StdOut.println(MSG.Message16 + plyer.namePlayers[i] + MSG.Message11 + MSG.Message12 + ChipRemain + MSG.Message13);
				}  			
			}
		}
		
		StdOut.println("\n\t\t\tGAME IS OVER\n");
	}// End WinnerDeclaration
		
	public void playerTurn(int PlayerNum, String playerName, int rolNum) {
				
		Roll roll = new Roll();
		int tempTotalGamescore = 0;

		while (true) {
			do { 
				try {
					setChoice(StdIn.readString().toLowerCase());
					if(getChoice().equals("y") || getChoice().equals("n"))
						break;
					else StdOut.print(MSG.Re_Enter);
			    }
				catch (Exception e) {
	                System.out.println(MSG.InputMismatch);			 
	            }	
			}while(!getChoice().equals("y") || !getChoice().equals("n"));	

			if (getChoice().equals("y")) {

				StdOut.println("\n" + Player.getPlayer(playerName) + " is rolling ...");
				StdOut.println("\n");
				roll.throwDice(PlayerNum);

				StdOut.println("\nDie1: " + roll.getDie1Score() + "   Die2: " + roll.getDie2Score());
				if (roll.playerLosesTurn() == true) {

					if (roll.getRollScore() == 2) {
						roll.resetGameScore(PlayerNum);
						rolNum = 0;
						PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
					} else if (roll.getRollScore() == 3) {
						rolNum = 0;
						PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
					} else if ((roll.getRollScore() > 3) && (roll.getDie1Score() == 1 || roll.getDie2Score() == 1)) {
						rolNum = 0;
						PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
					}
					break;
				} else {
					StdOut.println(MSG.ThrowDisp + rolNum);
					PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
					rollTurn[rolNum] = roll.getRollScore();
					rolNum++;
					if (rolNum > 9) // preventing out of bound
						rolNum = 0;
					tempTotalGamescore = roll.getGameScore(PlayerNum);
					if (tempTotalGamescore >= MAXSCORE) {
						break;
					} else
						StdOut.print(MSG.Ask_User);
				}
			} 
			else if (getChoice().equals("n")) {
				rolNum = 0;
				break;
			}

		} // End while (true)
		/*
		 * print score
		 */
		lastTurnScore = roll.getTurnScore();
		StdOut.print(Arrays.toString(roll.thisTurnScore) + " ");
		StdOut.println(MSG.TurnReport4 + lastTurnScore);
		StdOut.println(playerName + MSG.TurnReport5 + roll.getPlayerPenaltyChipCounts(PlayerNum));

	}//End public void playerTurn(int PlayerNum, String playerName, int rolNum)
		    
	public void PrintWinner( Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
		StdOut.println("\n\t\t******* " + playerName + Mess1);
		StdOut.println(MSG.Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
		StdOut.println(MSG.Tab3Mesg + playerName + MSG.Message_has + Wroll.updateChipCount(playerNum) + Mess2);
	}
	
	public void PrintLooserWithScore( Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
		StdOut.println("\n" + MSG.Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
		StdOut.println(MSG.Tab3Mesg + playerName + MSG.Message_has + Wroll.updateChipCount(playerNum) + Mess1);
		StdOut.println(MSG.Tab3Mesg + playerName + Mess2);
	}
	
	public void PrintZeroScoreLooser( Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
		StdOut.println("\n" + MSG.Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
		StdOut.println(MSG.Tab3Mesg + playerName + MSG.Message_has + Wroll.updateChipCount(playerNum) + Mess1);
		StdOut.println(MSG.Tab3Mesg + playerName +Mess2);
	}		
	
	public void PrintReport(int tempTotalScore, int playerNum, String playerName, Roll thisroll) {	
		StdOut.println("\n" + playerName + MSG.TurnReport1 + thisroll.getRollScore());
		StdOut.println(playerName + MSG.TurnReport2 + thisroll.getTurnScore());
		StdOut.println(playerName + MSG.TurnReport3 + thisroll.getGameScore(playerNum));
		tempTotalScore = thisroll.getGameScore(playerNum);	
	}
	
	public void setChoice(String choice) {
		continueToRoll = choice;
	}
	
	public String getChoice() {
		return continueToRoll;
	}
}



//import java.util.Arrays;
//import edu.princeton.cs.introcs.StdOut;
//import edu.princeton.cs.introcs.StdIn;
//
//public class Turn {
//	final int TURNLIMIT = 10;
//	final public int MAXSCORE = 100;
//	int[] rollTurn = new int[TURNLIMIT];
//	int lastTurnScore = 0;
//	private String continueToRoll = null;
//	Messages MSG = new Messages();
//	
//	public Turn() {
//		
//	}
//	
//	public void playerTurn(int PlayerNum, String playerName, int rolNum) {
//				
//		Roll roll = new Roll();
//		int tempTotalGamescore = 0;
//
//		while (true) {
//			do { 
//				try {
//					setChoice(StdIn.readString().toLowerCase());
//					if(getChoice().equals("y") || getChoice().equals("n"))
//						break;
//					else StdOut.println(MSG.Re_Enter);
//			    }
//				catch (Exception e) {
//	                System.out.println(MSG.InputMismatch);			 
//	            }	
//			}while(!getChoice().equals("y") || !getChoice().equals("n"));	
//
//			if (getChoice().equals("y")) {
//
//				StdOut.println("\n" + Player.getPlayer(playerName) + " is rolling ...");
//				StdOut.println("\n");
//				roll.throwDice(PlayerNum);
//
//				StdOut.println("\nDie1: " + roll.getDie1Score() + "   Die2: " + roll.getDie2Score());
//				if (roll.playerLosesTurn() == true) {
//
//					if (roll.getRollScore() == 2) {
//						roll.resetGameScore(PlayerNum);
//						rolNum = 0;
//						PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
//					} else if (roll.getRollScore() == 3) {
//						rolNum = 0;
//						PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
//					} else if ((roll.getRollScore() > 3) && (roll.getDie1Score() == 1 || roll.getDie2Score() == 1)) {
//						rolNum = 0;
//						PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
//					}
//					break;
//				} else {
//					StdOut.println(MSG.ThrowDisp + rolNum);
//					PrintReport(tempTotalGamescore, PlayerNum, playerName, roll);
//					rollTurn[rolNum] = roll.getRollScore();
//					rolNum++;
//					if (rolNum > 9) // preventing out of bound
//						rolNum = 0;
//					tempTotalGamescore = roll.getGameScore(PlayerNum);
//					if (tempTotalGamescore >= MAXSCORE) {
//						break;
//					} else
//						StdOut.print(MSG.Ask_User);
//				}
//			} 
//			else if (getChoice().equals("n")) {
//				rolNum = 0;
//				break;
//			}
//
//		} // End while (true)
//		/*
//		 * print score
//		 */
//		lastTurnScore = roll.getTurnScore();
//		StdOut.print(Arrays.toString(roll.thisTurnScore) + " ");
//		StdOut.println(MSG.TurnReport4 + lastTurnScore);
//		StdOut.println(playerName + MSG.TurnReport5 + roll.getPlayerPenaltyChipCounts(PlayerNum));
//
//	}
//		    
//	public void PrintReport(int tempTotalScore, int playerNum, String playerName, Roll thisroll) {	
//		StdOut.println("\n" + playerName + MSG.TurnReport1 + thisroll.getRollScore());
//		StdOut.println(playerName + MSG.TurnReport2 + thisroll.getTurnScore());
//		StdOut.println(playerName + MSG.TurnReport3 + thisroll.getGameScore(playerNum));
//		tempTotalScore = thisroll.getGameScore(playerNum);	
//	}
//	
//	public void setChoice(String choice) {
//		continueToRoll = choice;
//	}
//	
//	public String getChoice() {
//		return continueToRoll;
//	}
//}
