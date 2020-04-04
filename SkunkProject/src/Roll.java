
import edu.princeton.cs.introcs.StdOut;

public class Roll {

	private int rollScore = 0;
	private int turnScore = 0;
	private Dice newDice;
	private boolean loseTurn = false;
	private int playerChipCountLooseInThisRoll;
	static int KittyChipCount = 0;
	static int[] TotalCHIP = new int[] { 50, 50, 50, 50, 50 };
	static int[] penaltyCHIP = new int[] { 0, 0, 0, 0, 0 };
	static int[] Gamescore = new int[] { 0, 0, 0, 0, 0 };
	int[] thisTurnScore = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	int throwNumer = 0;
	boolean resetTurn = false;
	int sum = 0;
	int gameScore = 0;

	public void init() {
		this.newDice = new Dice();
		if (loseTurn = false) { // Reset current scores for new turn or new player
			rollScore = 0;
			turnScore = 0;
			sum = 0;
			throwNumer = 0;
			for (int i = 0; i < 10; i++)
				thisTurnScore[i] = 0;
			gameScore = 0;
			playerChipCountLooseInThisRoll = 0;
			resetTurn = false;
		}
	}

	public int throwDice(int playerNum) {
		init();

		// Double Skunk rolled
		if (newDice.getLastRoll() == 2) {
			rollScore = 0;
			turnScore = 0;
			gameScore = 0;
			playerChipCountLooseInThisRoll = 4;
			KittyChipCount += 4;
			TotalCHIP[playerNum] -= playerChipCountLooseInThisRoll;
			penaltyCHIP[playerNum] += playerChipCountLooseInThisRoll;
			Gamescore[playerNum] = 0;
			doubleSkunkMsg();
//			StdOut.println("\t***** You rolled a double skunk loose all scores for the game!!! ****");
//			StdOut.println("\t***** and you loose 4 chips this Turn !!! *****");
//			StdOut.println("\t***** and you loose your turn and all GameScore !!! *****");
			loseTurn = true;
			resetTurn = true;
			throwNumer = 0;

		}
		// Skunk Deuce rolled
		else if (newDice.getLastRoll() == 3) {
			rollScore = 0;
			turnScore = 0;
			playerChipCountLooseInThisRoll = 2;
			KittyChipCount += 2;
			TotalCHIP[playerNum] -= playerChipCountLooseInThisRoll;
			penaltyCHIP[playerNum] += playerChipCountLooseInThisRoll;
			deuceMsg();
//			StdOut.println("\t***** You rolled a skunk deuce!! *****");
//			StdOut.println("\t***** and you loose 2 chips this Turn !!! *****");
//			StdOut.println("\t***** and you loose your turn and all TurnScore !!! *****");
			loseTurn = true;
			resetTurn = true;
			throwNumer = 0;
		}
		// Skunk rolled
		else if ((newDice.getLastRoll() > 3) && (newDice.die1GetLastRoll() == 1 || newDice.die2GetLastRoll() == 1)) {
			rollScore = 0;
			playerChipCountLooseInThisRoll = 1;
			KittyChipCount += 1;
			TotalCHIP[playerNum] -= playerChipCountLooseInThisRoll;
			penaltyCHIP[playerNum] += playerChipCountLooseInThisRoll;
			SkunkMsg();
//			StdOut.println("\t***** You rolled a skunk!! *****");
//			StdOut.println("\t***** and you loose your turn and 1 chips this Turn !!! *****");
			loseTurn = true;
			resetTurn = false;
			throwNumer = 0;
		}
		// Good roll
		else {
			resetTurn = false;
			loseTurn = false;
			rollScore = newDice.getLastRoll();
			turnScore += rollScore;
			thisTurnScore[throwNumer] = rollScore;
			;
			Gamescore[playerNum] += rollScore;
			throwNumer++;
			if (throwNumer > 9) // to prevent out of bound
				throwNumer = 0;

		}

		sum = 0;
		if (resetTurn) {
			for (int i = 0; i < 10; i++)
				sum += thisTurnScore[i];

		}

		if (Gamescore[playerNum] >= sum)
			Gamescore[playerNum] -= sum;
		if (resetTurn) {
			for (int i = 0; i < 10; i++)
				thisTurnScore[i] = 0;
		}
		resetTurn = false;
		return rollScore;
	} // End public int throwDice(int playerNum)

	public void doubleSkunkMsg() {
		StdOut.println("\t***** You rolled a double skunk loose all scores for the game!!! ****");
		StdOut.println("\t***** and you loose 4 chips this Turn !!! *****");
		StdOut.println("\t***** and you loose your turn and all GameScore !!! *****");
	}
	
	public void deuceMsg() {
		StdOut.println("\t***** You rolled a skunk deuce!! *****");
		StdOut.println("\t***** and you loose 2 chips this Turn !!! *****");
		StdOut.println("\t***** and you loose your turn and all TurnScore !!! *****");
	}
	
	public void SkunkMsg() {
		StdOut.println("\t***** You rolled a skunk!!! *****");
		StdOut.println("\t***** and you loose your turn and 1 chips this Turn !!! *****");
	}
	
	public boolean playerLosesTurn() {
		return this.loseTurn;
	}

	public int getRollScore() {
		return this.rollScore;
	}

	public int getDie1Score() {
		return this.newDice.die1GetLastRoll();
	}

	public int getDie2Score() {
		return this.newDice.die2GetLastRoll();
	}

	public int diceScore() {
		return (getDie1Score() + getDie2Score());
	}

	public int getTurnScore() {
		return turnScore;
	}

	public void resetTurnScore() {
		turnScore = 0;
	}

	public int getGameScore(int playerNum) {
		return Gamescore[playerNum];
	}

	public void resetGameScore(int playerNum) {
		Gamescore[playerNum] = 0;
	}

	public int updateChipCount(int playNum) {
		return TotalCHIP[playNum];
	}

	public int getPlayerPenaltyChipCounts(int playerNum) {
		return penaltyCHIP[playerNum];
	}

	public int getKittyChipCounts() {
		return KittyChipCount;
	}
}


