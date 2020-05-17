
//////////////////////////////////////////////////////////////				
/*
 * Tournament  Class
 * 	Players start Tournament, store information (score, penalty, chips remained, and sumarize report
 */

public class Tournament extends Player{
	static int round = 0;
	public int plyNum;
		
	public Tournament() {
		player();
		Tournement();	
	}
	
	public void Tournement () {
		
		int[][] Game = new int[MAXGAME][MAXPLAYER]; // OK 

/* Initialize RoundScore and Round Chips, These will be accumulated after each rounds */	
		for (int i = 0; i < MAXGAME; i++) {
			for (int j = 0; j < getPlayernumber(); j++) {
				Game[i][j] = 0;
				RoundScore[i][j] = 0;
				RoundChips[i][j] = 0;
			}				
		}

		Messages.println("\n");
		
/* Initialize Winning round */		
		for (int i = 0; i < MAXGAME; i++) {
			setTotal(i, DsplWRnd, 0);
		}

/* Start Rounds */	
		for(round=0; round<MAXGAME; round++) {
			Messages.println("\n\t\t===========>> Start Round \"" + rounds[round] + "\" <<============");
			
/* Initialize before starting next round  */
			for(int i = 0; i<MAXPLAYER; i++ ) {
				setTotal(i, Roll.TotalCHIP, 50);
				setTotal(i, Roll.penaltyCHIP, 0);
				setTotal(i, Roll.Gamescore, 0);
		    }
			
			Roll.KittyChipCount = 0;
			
/* Reset last scores && Flag for next round */			
			for(int i = 0; i<MAXPLAYER; i++ ) {
				setTotal(i, lastGameScore, 0);
			}

/* Calling startGame */			
			startGame();
			
/* Select the Winner(s) with highest score */	
			int Round_maxScore =  getMaxScore(lastGameScore);
			
/* Print Player Status */			
			for (int i = 0; i < getPlayernumber(); i++) {
				if(getTotal(i, lastGameScore) >= Round_maxScore){
					
/* Add 1 each time player win the game */
					Game[round][i] += 1;   
				}
			}
					   			
			//Display Report	
			DisplayEndOfRoundWinner(DsplWRnd);
			
	        if(round == MAXGAME -1)
	        	 Messages.println("\n\n================>> E N D   O F   T O U R N A M E N T   R E P O R T <<================");
			
/* Set staring player for next round. Players take turn to play first in each round */			
			player_Num += 1;
			if (player_Num == getPlayernumber())
				player_Num = 0;
			
		} //End for(round=0; round<MAXGAME; round++)
				
/* Print all players' round score and Chips */
		for(int k=0; k<MAXGAME; k++) {	
			Messages.println("\n\t\t\t\tRound " + rounds[k]);		//(k+1));
			Messages.println("\t\t\t\t-------");		
			for(int j =0; j<getPlayernumber(); j++) {
				Messages.println("\t\t\t=> " + namePlayers[j] + "'s score:    " + RoundScore[k][j] );
				Messages.println("\t\t\t=> " + namePlayers[j] + "'s chips:    " + RoundChips[k][j] );
			}
		}
	
/* Print Table summary */
		Messages.print("\n\t\t\t");
		for(int i=0; i< getPlayernumber(); i++)
			Messages.print(namePlayers[i] + "   ");
		Messages.println("\n\t\t\t------------------------------------------");
		
		for(int k=0; k<MAXGAME; k++) {
			Messages.print("\n\t\t" + rounds[k]+" :   \t");
			for(int j =0; j<getPlayernumber(); j++) {
				Messages.print(Game[k][j]+ "          ");  //k = round, J = player number
			}
		}		

/* Print TotalRoundwin summary */
		Messages.println("\n\t\t\t------------------------------------------");
		Messages.print("Each Player TotalWins:\t");
		for(int j =0; j<getPlayernumber(); j++) {
			Messages.print(winRound[j] + "          ");
		}
					 
/* Select the Winner(s) with highest Tournament score */
		int Tournament_maxScore = getMaxScore(TotalScore);
		
/* Print each player total score, Total chips and number of winning rounds */		
		Messages.println("\n");
		for (int i = 0; i < getPlayernumber(); i++) {
			Messages.println("\n" + namePlayers[i] + "'s Total Chips is " + TotalChipCount[i]);
			Messages.println(namePlayers[i] + " wins " + winRound[i] + " rounds");
			Messages.println(namePlayers[i] + "'s Total Tournament Score is " + TotalScore[i]);
			if(getTotal(i,TotalScore) >= Tournament_maxScore)
				Messages.println("\t\t\t\t***** CONGRATULATIONS! " + namePlayers[i] + " is the FINAL WINNER *****");
		}
		
		Messages.println("\n\t\t\t\t<<<<<  T O U R N A M E N T   I S   O V E R  >>>>>");
	}//End public void Tournament () 
	
////////////////////////////////////////////////////////////////
/*
* public void startGame  method
* 	Players start the game
*/

	public void startGame() {
		int plyNum = 0;
		int rollNumber = 0;
		int game;
		Roll roll = new Roll();
		Turn turn = new Turn();

		game = Tournament.round;
		/* Out of Chip Implementation */
		int sitPlayer = 0;

		plyNum = player_Num;
		if (getPlayernumber() > 1)  //handling when only one player
			Messages.println("\n" + namePlayers[plyNum] + PlayFirst);
		Messages.println(TurnStart + namePlayers[plyNum]);
		Messages.print(namePlayers[plyNum] + AskUserStartRoll);

		while (tempTotalGamescore < MAXROUNDSCORE) {
			turn.playerTurn(plyNum, namePlayers[plyNum], rollNumber);
			rollNumber = 0;

			/* print updated Chips and score after each turn */
			Messages.println("\n\n\t<<<<< UptoDate for all Players >>>>>\n");
			for (int i = 0; i < getPlayernumber(); i++) {
				Messages.println(
						namePlayers[i] + GameReport5 + roll.updateChipCount(i) + GameReport4 + roll.getGameScore(i));
			}
			Messages.println(CurrentKitty + roll.getKittyChipCounts());
			roll.resetTurnScore();
			rollNumber = 0;
			if (roll.updateChipCount(plyNum) <= 0)
				sitPlayer++;
			/* break if only 1 player remained */
			if (sitPlayer == (getPlayernumber() - 1)) {
				break;
			}

			/* Skip any previous player that already been sit */
			while (true) {
				plyNum++;
				
				//Validate out of bound after increment
				if (plyNum == getPlayernumber())
					plyNum = 0;
				if (roll.updateChipCount(plyNum) <= 0)
					plyNum++;
				//Validate out of bound after increment
				if (plyNum == getPlayernumber())
					plyNum = 0;
				if (roll.updateChipCount(plyNum) > 0) {
					break;
				}
			}

			if (tempTotalGamescore >= MAXROUNDSCORE) {
				break;
			} else {

				Messages.println(
						"\n\n\t================>> New turn for " + namePlayers[plyNum] + " <<================");
				for (int i = 0; i < TURNLIMIT; i++)
					turn.rollTurn[i] = 0;
				Messages.print(namePlayers[plyNum] + AskUserStartRoll);
			}
		} // while (tempTotalGamescore)

		/* Check if any player exceeds the game maximum score and ending the round */
		if ((tempTotalGamescore >= MAXROUNDSCORE) || (sitPlayer == (getPlayernumber() - 1))) {
			if (sitPlayer >= (getPlayernumber() - 1)) { // The last player survived is a winner
				for (int i = 0; i < getPlayernumber(); i++) {
					if (roll.getGameScore(i) > 0) {
						Messages.println("Kitty chip count: " + roll.getKittyChipCounts());
						Messages.println(RoundMessage5);
						break;
					}
				}
			} else if (sitPlayer < (getPlayernumber() - 1)) { // more than one player still stand that qualify for last
				// turn
				for (int i = 0; i < getPlayernumber(); i++) {
					if (roll.getGameScore(i) >= MAXROUNDSCORE) {
						continue;
					}
					/* Skip Out of Chip player */
					if (roll.updateChipCount(i) <= 0)
						continue;
					Messages.println("\n" + Tab3Mesg + " ========>> WE HAVE WINNER!!! THE FINAL TURN FOR "
							+ namePlayers[i] + " <<========");
					Messages.print(namePlayers[i] + AskUserLastRoll);
					if (turn.getChoice().equals("y")) {
						turn.playerTurn(i, namePlayers[i], rollNumber);
						rollNumber = 0;
					} else
						continue;
					Messages.println("Kitty chip count: " + roll.getKittyChipCounts());

				} // for (int i = 0; i < getPlayernumber(); i++)
			}
		} // if (tempTotalGamescore >= MAXROUNDSCORE)

		for (int i = 0; i < getPlayernumber(); i++) {
			lastGameScore[i] = roll.getGameScore(i);
			RoundScore[game][i] = roll.getGameScore(i);
			RoundChips[game][i] = roll.updateChipCount(i);
		}
		WinnerDeclaration();

		/* Reset Game score for next round */
		for (int i = 0; i < MAXPLAYER; i++) {
			roll.resetGameScore(i);
		}

		tempTotalGamescore = 0;
	}// End public void startGame ()
	
////////////////////////////////////////////////////////////////////////////////////////
	
/*
 * Utilities Functions & Methods
 */

	public void DisplayEndOfRoundWinner(int[] Displ) {
		

		if(round == 0) {
			Messages.println("\n\n\t\t\tRounds  ********** " + rounds[0] + " **********");
			Messages.println("\t\t\tWinning Player ==> "+ Displ[0] + " <==");
		}
		else if(round == 1) {
			Messages.println("\n\n\t\t\tRounds  *********** " + rounds[0] + "  " +  rounds[1] + " ***********");
			Messages.println("\t\t\tWinning Players ==> "+ Displ[0] + "  "  + Displ[1] + " <==");
		}
		else if(round == 2) {
			Messages.println("\n\n\t\t\tRounds  *********** " + rounds[0] + "  "  + rounds[1] + "  "  + rounds[2] + " ***********");
			Messages.println("\t\t\tWinning Players ==> "+ Displ[0] + "  "  + Displ[1]+ "  "  + Displ[2] + " <==");
		}
		else if(round == 3) {
			Messages.println("\n\n\t\t\tRounds  *********** " + rounds[0] + "  "  + rounds[1] + "  "  + rounds[2] + "  "  + rounds[3] + " ***********");
			Messages.println("\t\t\tWinning Players ==> "+ Displ[0] + "  "  + Displ[1]+ "  "  + Displ[2]+ "  "  + Displ[3] + " <==");
		}
		else if(round == 4) {
			Messages.println("\n\n\t\t\tRounds  *********** " + rounds[0] + "  "  + rounds[1] + "  "  + rounds[2] + "  "  + rounds[3] + "  "  + rounds[4] + " ***********");
			Messages.println("\t\t\tWinning Players ==> "+ Displ[0] + "  "  + Displ[1]+ "  "  + Displ[2]+ "  "  + Displ[3]+ "  "  + Displ[4] + " <==");
		}		
	}
	
	public int getMaxScore(int[] total) {
		/* Find maximum value */
		int maxScore = 0;
		for (int i = 0; i < getPlayernumber(); i++) {
			if(total[i] > maxScore)
				maxScore = total[i]; 
		}
		return maxScore;
	}
	
	public void setTotal(int playerNum, int[] total, int value) {
		total[playerNum] = value;
	}
	
	public int getTotal(int playerNum, int[] total) {
		return total[playerNum];
	}
}// End public class Tournament extends Player{
