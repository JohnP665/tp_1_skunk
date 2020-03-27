
import java.util.Arrays;
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

public class Turn {
	final int TURNLIMIT = 10;
	final public int MAXSCORE = 100;
	int[] rollTurn = new int[TURNLIMIT];
	int lastTurnScore = 0;
	
	public void playerTurn(int PlayerNum, String playerName, int rolNum) {
		String continueToRoll = null;
		// int rolNum=0;
		Roll roll = new Roll();
		int tempTotalGamescore = 0;

		while (true) {

			continueToRoll = StdIn.readString().toLowerCase();
			if (continueToRoll.equals("y")) {

				StdOut.println("\n" + Player.getPlayer(playerName) + " is rolling ...");
				StdOut.println("\n");
				roll.throwDice(PlayerNum);

				StdOut.println("\nDie1: " + roll.getDie1Score() + "   Die2: " + roll.getDie2Score());
//				 StdOut.println("Total score for this roll is " + roll.getRollScore());

				if (roll.playerLosesTurn() == true) {

					if (roll.getRollScore() == 2) {
						roll.resetGameScore(PlayerNum);
						rolNum = 0;
						StdOut.println("\n" + playerName + "'s score for this Roll: " + roll.getRollScore());
						StdOut.println(playerName + "'s score for this Turn: " + roll.getTurnScore());
						StdOut.println(playerName + "'s score for this Game: " + roll.getGameScore(PlayerNum));
//						StdOut.println(playerName + "'s chip count: " + roll.updateChipCount(PlayerNum));
						tempTotalGamescore = roll.getGameScore(PlayerNum);

					} else if (roll.getRollScore() == 3) {
						rolNum = 0;
						StdOut.println("\n" + playerName + "'s score for this roll: " + roll.getRollScore());
						StdOut.println(playerName + "'s score for this Turn: " + roll.getTurnScore());
						StdOut.println(playerName + "'s score for this Games: " + roll.getGameScore(PlayerNum));
//						StdOut.println(playerName + "'s chip count: " + roll.updateChipCount(PlayerNum));
						tempTotalGamescore = roll.getGameScore(PlayerNum);
					} else if ((roll.getRollScore() > 3) && (roll.getDie1Score() == 1 || roll.getDie2Score() == 1)) {
						rolNum = 0;
						StdOut.println("\n" + playerName + "'s score for this roll: " + roll.getRollScore());
						StdOut.println(playerName + "'s score for this Turn: " + roll.getTurnScore());
						StdOut.println(playerName + "'s score for this Games: " + roll.getGameScore(PlayerNum));
//						StdOut.println(playerName + "'s chip count: " + roll.updateChipCount(PlayerNum));
						tempTotalGamescore = roll.getGameScore(PlayerNum);
					}
					break;
				} else {
					StdOut.println("\n======== Throw " + rolNum);
					StdOut.println("\n" + playerName + "'s score for this roll: " + roll.getRollScore());
					StdOut.println(playerName + "'s score for this Turn: " + roll.getTurnScore());
					StdOut.println(playerName + "'s score for this Game: " + roll.getGameScore(PlayerNum));
//					StdOut.println(playerName + "'s chip count: " + roll.updateChipCount(PlayerNum));
					tempTotalGamescore = roll.getGameScore(PlayerNum);
					rollTurn[rolNum] = roll.getRollScore();
//					StdOut.println("\n===============>Debug: score for Turn[" + rolNum + "] is: " + roll.getRollScore());
					rolNum++;
					if (rolNum > 9) // preventing out of bound
						rolNum = 0;
					tempTotalGamescore = roll.getGameScore(PlayerNum);
					
////				if(tempTotalGamescore >= 100) {	
////				winFlag = true;  //if winFlag is true, let other players to paly one more time before closing the game
////				winPlayer = j;
////				break;
////			}	
					if (tempTotalGamescore >= MAXSCORE) {
						break;
					} else
						StdOut.println("\nroll again? [y or n]");
				}
			} else if (continueToRoll.equals("n")) { // || newGame.gamesScores[j] > 100) {
				rolNum = 0;
				break;
			}

		} // End while (true)
		/*
		 * print score
		 */
		// StdOut.println("\n");
		lastTurnScore = roll.getTurnScore();
		StdOut.print(Arrays.toString(roll.thisTurnScore) + " ");
		StdOut.println("==>> Total turn score is: " + lastTurnScore);
		// StdOut.println(playerName + "'s turn score upto this roll is: " + roll.getTurnScore());
		// StdOut.println(playerName +"'s Total Game Score is: " +
		// roll.getGameScore(PlayerNum));
		// StdOut.println(playerName +"'s chip count: " +
		// roll.updateChipCount(PlayerNum));
		StdOut.println(playerName + "'s Total Penalty Chips: " + roll.getPlayerPenaltyChipCounts(PlayerNum));

	}
}

//
//public class Turn {
//
//	public void playerTurn(int PlayerNum, String playerName ) {
//		final int TURNLIMIT = 10;
//		String continueToRoll = null;
//		int rollNumber=0;
//		Roll roll = new Roll();
//		int tempTotalGamescore = 0;
//		int[] rollTurn = new int[TURNLIMIT];
//
//		while (true) {
//			
//			continueToRoll = StdIn.readString().toLowerCase();
//			if (continueToRoll.equals("y")) {
//				
//				StdOut.println(Player.getPlayer(playerName) + " is rolling");
//				roll.throwDice(PlayerNum);
//				
//				StdOut.println("Die1: " + roll.getDie1Score() + "   Die2: " + roll.getDie2Score());
//				StdOut.println("Total score for this roll is " + roll.getRollScore());
//					
//				if(roll.playerLosesTurn() == true ) {
//					
//				   StdOut.println("\n************ Throw " + rollNumber + " and Loose turn is " + roll.playerLosesTurn());
//
//				   if(roll.getRollScore() == 2) {
//						for(int i = 0; i<10; i++)
//							rollTurn[i] = 0;
//						roll.resetGameScore(PlayerNum);
//						rollNumber = 0;
//						StdOut.println("\n" + playerName +"'s chip count: " + roll.updateChipCount(PlayerNum));
//						StdOut.println("score for this Turn: " + roll.getTurnScore());
//						StdOut.println("Roll score for game: " + roll.getGameScore(PlayerNum));
//						tempTotalGamescore = roll.getGameScore(PlayerNum);
//
//				   }
//				   else if(roll.getRollScore() == 3) {
//						for(int i = 0; i<10; i++)
//							rollTurn[i] = 0;
//						roll.resetTurnScore();
//						rollNumber = 0;
//						StdOut.println("\n" + playerName +"'s chip count: " + roll.updateChipCount(PlayerNum));
//						StdOut.println("score for this Turn: " + roll.getTurnScore());
//						StdOut.println("Roll score for game: " + roll.getGameScore(PlayerNum));
//						tempTotalGamescore = roll.getGameScore(PlayerNum);
//				   }	
//				   else if((roll.getDie1Score() == 1) || (roll.getDie2Score() == 1)) {
//						for(int i = 0; i<10; i++)
//							rollTurn[i] = 0;
//						roll.resetTurnScore();
//						rollNumber = 0;
//						StdOut.println("\n" + playerName +"'s chip count: " + roll.updateChipCount(PlayerNum));
//						StdOut.println("score for this Turn: " + roll.getTurnScore());
//						StdOut.println("Roll score for game: " + roll.getGameScore(PlayerNum));
//						tempTotalGamescore = roll.getGameScore(PlayerNum);
//				   }
//				   break;
//				}
//				else {
//					
//					StdOut.println("\n************ Throw " + rollNumber);
//					StdOut.println("\nscore for this Turn: " + roll.getTurnScore());
//					StdOut.println("Roll score for game: " + roll.getGameScore(PlayerNum));
//					tempTotalGamescore = roll.getGameScore(PlayerNum);					
//					rollTurn[rollNumber] = roll.getRollScore();
//					rollNumber++;
//					tempTotalGamescore = roll.getGameScore(PlayerNum);
//					if(tempTotalGamescore >= 100)  
//					{			
//						break;	
//					}	
//					else
//						StdOut.println("\nroll again? [y or n]");
//				}	
//			}
//			else if (continueToRoll.equals("n")) { //|| newGame.gamesScores[j] > 100) {
//				rollNumber = 0;
//				break;
//			}
//
//		} //End while (true)				
//		
//	}
//}
//

