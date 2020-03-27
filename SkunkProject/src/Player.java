
import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

public class Player {

	final int MAXPLAYER = 5;
	int tempTotalGamescore = 0;
	int j = 0;
	int currentPlayerTotalScore = 0;
	int rollNumber = 0;
	private int numPlayers = 0;
	private String[] namePlayers = new String[MAXPLAYER];
	Roll roll = new Roll();
	Turn turn = new Turn();

	public Player () {
		
	}	
	
	public void startGame() {
		j = 0;
		StdOut.println("\n");
		if(numPlayers > 1)
			StdOut.println(namePlayers[j] + ", You Play first!");
		StdOut.println("Starting turn for " + namePlayers[j]);
		StdOut.println(namePlayers[j] + ", Do you want to roll ? [y or n]");

		while (tempTotalGamescore < 100) {

			turn.playerTurn(j, namePlayers[j], rollNumber);
			rollNumber = 0;
			/*
			 * print score
			 */
			StdOut.println("\n\t<<<<< Turn Summary >>>>>");		
			StdOut.println("\n" + namePlayers[j] + "'s Last Turn Score is: " + turn.lastTurnScore);
			StdOut.println(namePlayers[j] + "'s Total Game Score is: " + roll.getGameScore(j));
			StdOut.println(namePlayers[j] + "'s chip count: " + roll.updateChipCount(j));
			StdOut.println("Current Kitty chips: " + roll.getKittyChipCounts());

			roll.resetTurnScore();
			rollNumber = 0;

			tempTotalGamescore = roll.getGameScore(j);
			if (tempTotalGamescore >= 100) {
				break;
			}

			j++;
			if (j == numPlayers)
				j = 0;
			StdOut.println("\n\n\t========>> New turn for " + namePlayers[j] + " <<========");
			for (int i = 0; i < 10; i++)
				turn.rollTurn[i] = 0;

			StdOut.println(namePlayers[j] + ", Do you want to roll ? [y or n]");

		} // while (tempTotalGamescore)

		if (tempTotalGamescore >= 100) {
			for (int i = 0; i < numPlayers; i++) {
				if (roll.getGameScore(i) >= 100)
					continue;
				StdOut.println("\n========>> Final roll for " + namePlayers[i] + " <<========");
				StdOut.println(namePlayers[i] + " roll one more time");
				StdOut.println(namePlayers[i] + " is rolling");
				roll.throwDice(i);
				StdOut.println("Die1: " + roll.getDie1Score() + "   Die2: " + roll.getDie2Score());
				if (roll.getRollScore() == 2) {
					turn.rollTurn[i] = 0;
					roll.resetGameScore(i);
					rollNumber = 0;
					StdOut.println("score for this Turn: " + roll.getTurnScore());
					StdOut.println("Roll score for game: " + roll.getGameScore(i));
					StdOut.println("chip count: " + roll.updateChipCount(i));
				}
				if (roll.getRollScore() == 3) {
					turn.rollTurn[i] = 0;
					rollNumber = 0;
					StdOut.println("score for this Turn: " + roll.getTurnScore());
					StdOut.println("Roll score for game: " + roll.getGameScore(i));
					StdOut.println("chip count: " + roll.updateChipCount(i));
				}

				else if ((roll.getDie1Score() != 1) && (roll.getDie2Score() != 1)) {
					StdOut.println("Total score for this roll is " + roll.getRollScore());
					StdOut.println("Roll score for game: " + roll.getGameScore(i));
					StdOut.println("chip count: " + roll.updateChipCount(i));
				}
				StdOut.println("Player chip count: " + roll.updateChipCount(i));
				StdOut.println("Kitty chip count: " + roll.getKittyChipCounts());
			}
		}
		WinnerDeclaration();
	}//End public void startGame ()

	public void player () {
		StdOut.println("\n");
		StdOut.println("Player should be familiar with this game rules.");
		StdOut.println("Player has 50 chips to play the game.");
		StdOut.println("\n\nThis TP_1 phase has only one player.");
		StdOut.println("\n");
		
		//Set number of Players
//		StdOut.println("How many players? ");
//		numPlayers = StdIn.readInt();
//		numPlayers = 1;
		setPlayernumber(1);
		// Create a String & int array to save Players names & Total scores
		// Loop over array to save user input
		for (int i = 0; i < numPlayers; i++) {
			if(numPlayers > 1)
			  StdOut.print("Enter a player " + (i+1) + " 's name: ");
			else
			  StdOut.print("Enter a player's name: ");
			namePlayers[i] = StdIn.readString();
		}	
		startGame();
		StdOut.println("\n");
	}//End public void player ()

	public void WinnerDeclaration() {

		int winner = 0;
		for (int i = 0; i < numPlayers; i++) {
			if (roll.getGameScore(i) >= 100) {
				winner++;
			}
		}

		StdOut.println("\n\n\t======== Bravo, we have winner ========\n");

		int TotalBonus = roll.getKittyChipCounts();
		int Bonus = TotalBonus / winner;
		int remainder = TotalBonus % winner;
		StdOut.println("\n");
		for (int i = 0; i < numPlayers; i++) {
			if (roll.getGameScore(i) >= 100) {
				StdOut.println(namePlayers[i] + " is a winner");
				StdOut.println(namePlayers[i] + " score: " + roll.getGameScore(i));
				StdOut.println(namePlayers[i] + " has " + roll.updateChipCount(i) + " chips remaining");
				StdOut.println(namePlayers[i] + " has " + Bonus + " bonus chips");
				StdOut.println(namePlayers[i] + " has total " + (roll.updateChipCount(i) + Bonus) + " chips");
			} else {
				StdOut.println(namePlayers[i] + " is loosing the game");
				StdOut.println(namePlayers[i] + " score: " + roll.getGameScore(i));
				StdOut.println(namePlayers[i] + " has " + roll.updateChipCount(i) + " chips remaining");
			}
			StdOut.println("\n");
		}
		if (remainder > 0) {
			StdOut.println("The " + remainder + " chip(s) remain is shared by " + winner + " winners ");
		}
	
		StdOut.println("\n\t\t\tGAME IS OVER\n");
	}// End WinnerDeclaration
	
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


