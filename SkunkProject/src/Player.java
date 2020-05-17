
/*
 * UI class including Player user interface
 * Start player turns, Start game and winner declaration
 */

public class Player implements Messages {
	private int numPlayers = 0;
	String[] namePlayers = new String[MAXPLAYER];
	int player_Num;
	int lastTurnScore = 0;
	int CurrentPlayerChipRemain = 0;
	int CurrentKittyChipRemainfromPreviousRounds = 0;
	int numWinnerthisround = 0;
	char rounds[] = { 'S', 'K', 'U', 'N', 'K' };
	int[] TotalScore = new int[] { 0, 0, 0, 0, 0 };
	int[] TotalChipCount = new int[] { 0, 0, 0, 0, 0 };
	int[] winRound = new int[] { 0, 0, 0, 0, 0, 0 };
	int[] lastGameScore = new int[] { 0, 0, 0, 0, 0 };
	int[][] RoundScore = new int[MAXGAME][MAXPLAYER];
	int[][] RoundChips = new int[MAXGAME][MAXPLAYER];
	static int tempTotalGamescore = 0;
	static int[] DsplWRnd = new int[] { 0, 0, 0, 0, 0 };

	//////////////////////////////////////////////////////////////
	/*
	 * void Player method Users enter player numbers and player name
	 */

	public void player() {

		String PaddingName = "Player_";
		String playername = "";
		/* Set number of Players */
		while (true) {
			try {
				String numinput = Messages.UI(AskUserInput);
				numPlayers = Integer.parseInt(numinput);
				if ((getPlayernumber() > 5) || (getPlayernumber() < 2))
					Messages.print(InputBound);
				else
					break;
			} catch (Exception e) {
				Messages.println(InputMismatch);
			}
		} // End While(true)

		/*
		 * Create a String & int array to save Players names & Total scores Loop over
		 * array to save user input
		 */
		for (int i = 0; i < getPlayernumber(); i++) {
			if (getPlayernumber() > 1)
				playername = Messages.UI("Enter player's name: ");
			else
				playername = Messages.UI("Enter player's name: ");
			setPlayer(i, playername);

			/* Padding player name is it's a single char */
			if (namePlayers[i].length() == 1) {
				namePlayers[i] = PaddingName + namePlayers[i];
			}
		}

		Messages.println("\n");
		for (int i = 0; i < getPlayernumber(); i++) {
			Messages.println("\t\t" + (i + 1) + ": " + namePlayers[i]);
		}

		player_Num = 0;
	}// End public void player ()

	//////////////////////////////////////////////////////////////
	/*
	 * public void WinnerDeclaration method Retrive score, penalties, find max score
	 * and declare winners
	 */

	public void WinnerDeclaration() {
		Roll roll = new Roll();
		int TotalBonus = roll.getKittyChipCounts();
		int Bonus = 0;
		int remainder = 0;
		int ChipRemain = 0;
		int gWin = 0;
		int RoundMaxScore = 0;
		int game;

		game = Tournament.round;

		if (game == MAXGAME - 1) {
			Messages.println(FinalGameKitty + (CurrentKittyChipRemainfromPreviousRounds + TotalBonus));
			TotalBonus += CurrentKittyChipRemainfromPreviousRounds;
		}

		/* Intialize roung winners here */
		numWinnerthisround = 0;
		Messages.println("\n\n\t\t========>> End of Round \"" + rounds[game] + "\" Summary <<========");

		/* Select the Winner(s) with highest score */
		RoundMaxScore = FindMaxScore(lastGameScore);
		for (int i = 0; i < getPlayernumber(); i++) {
			if (roll.getGameScore(i) >= RoundMaxScore) {
				PrintWinner(roll, i, namePlayers[i], Message1, Message2);
				winRound[i]++;
				numWinnerthisround++;
				/* Start from 0, ->-DsplWRnd[0] = 1 */
				DsplWRnd[game] = i + 1;
				TotalScore[i] += roll.getGameScore(i);
			} else if (roll.getGameScore(i) > 0) {
				PrintLooserWithScore(roll, i, namePlayers[i], Message4, Message5);
				if (roll.updateChipCount(i) >= 5) {
					ChipRemain = roll.updateChipCount(i) - 5;
					TotalChipCount[i] += ChipRemain;
					TotalBonus += 5;
					RoundChips[game][i] -= 5;
				} else {
					ChipRemain = 0;
					TotalChipCount[i] += ChipRemain;
					TotalBonus += roll.updateChipCount(i);
				}
				if (roll.updateChipCount(i) > 0)
					Messages.println(Tab3Mesg + namePlayers[i] + Message_has + ChipRemain + Message4);
				TotalScore[i] += roll.getGameScore(i);
			} else if (roll.getGameScore(i) == 0) {
				PrintZeroScoreLooser(roll, i, namePlayers[i], Message4, Message6);
				if (roll.updateChipCount(i) >= 10) {
					ChipRemain = roll.updateChipCount(i) - 10;
					TotalChipCount[i] += ChipRemain;
					TotalBonus += 10;
					RoundChips[game][i] -= 10;
				} else {
					ChipRemain = 0;
					TotalChipCount[i] += ChipRemain;
					TotalBonus += roll.updateChipCount(i);
				}
				if (roll.updateChipCount(i) > 0)
					Messages.println(Tab3Mesg + namePlayers[i] + Message_has + ChipRemain + Message4);
				TotalScore[i] += roll.getGameScore(i);
			}
		}
		if (numWinnerthisround > 1) {
			DsplWRnd[game] = 0; /////// We have tie game here!
			Bonus = TotalBonus / numWinnerthisround;
			Messages.println(Message8 + Bonus + Message13 + "\"" + rounds[game] + "\"");
			remainder = TotalBonus % numWinnerthisround;

			if (remainder > 0) {

				/* Last round, Add this remained chips to total bonus */
				if (game == MAXGAME - 1) {
					TotalBonus += remainder;
				}

				/* Save the remained chips to kittybox for final round */
				else {
					CurrentKittyChipRemainfromPreviousRounds += remainder;
					Messages.println(remainder + GameReport3);
				}
			}
		} else {
			Bonus = TotalBonus;
			Messages.println(Message9 + Bonus + Message13);
		}

		/*
		 * TotalChipCount = 0 at beginning and accumuate after each game/round This loop
		 * Adds remain chips to TotalChipCount after each round/game (TotalCHIP = 50 at
		 * each round start)
		 */
		for (int i = 0; i < getPlayernumber(); i++) {

			if (numWinnerthisround > 1) {
				if (roll.getGameScore(i) >= RoundMaxScore) {
					ChipRemain = roll.updateChipCount(i) + Bonus;
					gWin++;
					Messages.println(Message10 + gWin + ": " + namePlayers[i] + Message12 + ChipRemain + Message13);
					TotalChipCount[i] += ChipRemain;
					RoundChips[game][i] += Bonus;
				}
			} else {
				if (roll.getGameScore(i) >= RoundMaxScore) {
					ChipRemain = roll.updateChipCount(i) + Bonus;
					Messages.println(Message16 + namePlayers[i] + Message11 + Message12 + ChipRemain + Message13);
					TotalChipCount[i] += ChipRemain;
					RoundChips[game][i] += Bonus;
				}
			}

		}
	}// End WinnerDeclaration


	////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * Utilities Functions & Methods
	 */

	public void setPlayer(int index, String namePlayer) {

		namePlayers[index] = namePlayer;
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

	public int FindMaxScore(int[] total) {
		// Find maximum value
		int maxScore = 0;
		for (int i = 0; i < getPlayernumber(); i++) {
			if (total[i] > maxScore)
				maxScore = total[i];
		}
		return maxScore;
	}

	public void PrintWinner(Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
		Messages.println("\n\t\t******* " + playerName + Mess1);
		Messages.println(Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
		Messages.println(Tab3Mesg + playerName + Message_has + Wroll.updateChipCount(playerNum) + Mess2);
	}

	public void PrintLooserWithScore(Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
		Messages.println("\n" + Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
		Messages.println(Tab3Mesg + playerName + Message_has + Wroll.updateChipCount(playerNum) + Mess1);
		if (Wroll.updateChipCount(playerNum) > 5)
			Messages.println(Tab3Mesg + playerName + Mess2);
		else if (Wroll.updateChipCount(playerNum) > 0)
			Messages.println(Tab3Mesg + playerName + Message17);
	}

	public void PrintZeroScoreLooser(Roll Wroll, int playerNum, String playerName, String Mess1, String Mess2) {
		Messages.println("\n" + Tab3Mesg + playerName + " score is " + Wroll.getGameScore(playerNum));
		Messages.println(Tab3Mesg + playerName + Message_has + Wroll.updateChipCount(playerNum) + Mess1);
		if (Wroll.updateChipCount(playerNum) > 10)
			Messages.println(Tab3Mesg + playerName + Mess2);
		else if (Wroll.updateChipCount(playerNum) > 0)
			Messages.println(Tab3Mesg + playerName + Message17);
	}

}// End Player class
