
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

	/* Roll class variable initializtion method */
	public void init() {
		this.newDice = new Dice();
		if (loseTurn = false) { // Reset current scores for new turn or new player
			rollScore = 0;
			turnScore = 0;
			sum = 0;
			throwNumer = 0;
			for (int i = 0; i < 10; i++)
				thisTurnScore[i] = 0;
				playerChipCountLooseInThisRoll = 0;
			resetTurn = false;
		}
	}
	
	/* Double Skunk Method */
	public void DoubleSkunk(int playerNum) {
		rollScore = 0;
		turnScore = 0;
		playerChipCountLooseInThisRoll = 4;
		if(TotalCHIP[playerNum] < playerChipCountLooseInThisRoll) {
			KittyChipCount += TotalCHIP[playerNum];
			penaltyCHIP[playerNum] += TotalCHIP[playerNum];
			TotalCHIP[playerNum] = 0;
		}
		else {	
			KittyChipCount += playerChipCountLooseInThisRoll;			
			TotalCHIP[playerNum] -= playerChipCountLooseInThisRoll;
			penaltyCHIP[playerNum] += playerChipCountLooseInThisRoll;
		}
		Gamescore[playerNum] = 0;
		loseTurn = true;
		resetTurn = true;
		throwNumer = 0;

	}
	
	/* Skunk Deuce method */
	public void DeuceSkunk(int playerNum) {
		rollScore = 0;
		turnScore = 0;
		playerChipCountLooseInThisRoll = 2;
		if(TotalCHIP[playerNum] < playerChipCountLooseInThisRoll) {
			KittyChipCount += TotalCHIP[playerNum];
			penaltyCHIP[playerNum] += TotalCHIP[playerNum];
			TotalCHIP[playerNum] = 0;
		}
		else {	
			KittyChipCount += playerChipCountLooseInThisRoll;			
			TotalCHIP[playerNum] -= playerChipCountLooseInThisRoll;
			penaltyCHIP[playerNum] += playerChipCountLooseInThisRoll;
		}
		loseTurn = true;
		resetTurn = true;
		throwNumer = 0;
	}
	
	/* Single Skunk Method */
	public void SingleSkunk(int playerNum) {
		rollScore = 0;
		turnScore = 0;
		playerChipCountLooseInThisRoll = 1;
		if(TotalCHIP[playerNum] < playerChipCountLooseInThisRoll) {
			KittyChipCount += TotalCHIP[playerNum];
			penaltyCHIP[playerNum] += TotalCHIP[playerNum];
			TotalCHIP[playerNum] = 0;
		}
		else {	
			KittyChipCount += playerChipCountLooseInThisRoll;			
			TotalCHIP[playerNum] -= playerChipCountLooseInThisRoll;
			penaltyCHIP[playerNum] += playerChipCountLooseInThisRoll;
		}
		loseTurn = true;
		resetTurn = true;
		throwNumer = 0;
	}
	
	/* No Skunk Method */
	public void goodRoll(int playerNum) {
		resetTurn = false;
		loseTurn = false;
		rollScore = newDice.getLastRoll();
		turnScore += rollScore;
		thisTurnScore[throwNumer] = rollScore;
		Gamescore[playerNum] += rollScore;
		throwNumer++;
		if (throwNumer > 9) // to prevent out of bound
			throwNumer = 0;	
	}

////////////////////////////////////////////////////////////////////////////////////////
	
/*
* ThrowDice  Methods: rolling 2 dice at once and record the score and chips, decide skunk penalties or good score
*/

	public int throwDice(int playerNum) {
		
		init();
	
	/* Double Skunk rolled */
		if (isDoubleSkunk()) {
			DoubleSkunk(playerNum);
		}
	/* Skunk Deuce rolled */
		else if (isDeuceSkunk()) {
			DeuceSkunk(playerNum);
		}
	/* Skunk rolled */
		else if (isSingleSkunk()) {
			SingleSkunk(playerNum);
		}
	/*  Good roll */
		else {
			goodRoll(playerNum);
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

////////////////////////////////////////////////////////////////////////////////////////
	
/*
* Utilities Functions & Methods
*/
	public boolean isDoubleSkunk() {		
		return (newDice.getLastRoll() == 2);
	}
	
	public boolean isDeuceSkunk() {		
		return (newDice.getLastRoll() == 3);
	}
	
	public boolean isSingleSkunk() {		
		return ((newDice.die1GetLastRoll() == 1 || newDice.die2GetLastRoll() == 1));
	}

	public boolean playerLosesTurn() {
		return this.loseTurn;
	}
	
	public void setplayerLosesTurn(boolean value) {
		this.loseTurn = value;
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
	
	public void setTurnScore(int value) {
		turnScore = value;
	}

	public int getGameScore(int playerNum) {
		return Gamescore[playerNum];
	}
	
	public void setGameScore(int playerNum, int value) {
		Gamescore[playerNum] = value;
	}


	public void resetGameScore(int playerNum) {
		Gamescore[playerNum] = 0;
	}

	public int updateChipCount(int playNum) {
		return TotalCHIP[playNum];
	}
	
	public void setChipCount(int playNum, int value) {
		TotalCHIP[playNum] = value;
	}
/* Reset Player TotalCHIP for nagative amount due to paying too much penalties*/	
	public void SetPlayerChipCount(int playNum,int value) {
		TotalCHIP[playNum] = value;
	}

	public int getPlayerPenaltyChipCounts(int playerNum) {
		return penaltyCHIP[playerNum];
	}
	

	public void setPlayerPenaltyChipCounts(int playerNum, int value) {
		penaltyCHIP[playerNum] = value;
	}
	
	public int getKittyChipCounts() {
		return KittyChipCount;
	}
	
	public void setKittyChipCounts(int value) {
		KittyChipCount = value;
	}
}



