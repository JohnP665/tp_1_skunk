/*
 * UI messages using in Player , Tournament and Turn Class (children of Player classes)
 */

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public interface Messages {
	
	final public int MAXPLAYER = 5;
	final public int MAXGAME = 5;
	final int TURNLIMIT = 10;
	final public int MAXROUNDSCORE = 100;
	public String Tab2Mesg = "\t\t";
	public String Tab3Mesg = "\t\t\t";
	public String Message_has = " has ";
	public String AskUserInput = "How many players? ";
	public String InputBound = "Maximum is 5, Minimum is 2\n";
	public String AskUserStartRoll =  ", Do you want to roll ? [y or n] ";
	public String Ask_User = "\nroll again? [y or n] ";
    public String Re_Enter = "[y/n] only! Re-enter ";
    public String AskUserLastRoll =  ", Do you want to roll your FINAL turn? [y or n] ";
    public String InputMismatch = "InputMismatchException, Please Re-enter! ";
    public String PlayFirst = ", You Play first!\n";
    public String TurnStart = "Starting turn for ";
    public String LastTurnScore = "'s Last Turn Score: ";
    public String CurrentKitty = "Current Kitty chips: ";
    public String FinalKitty ="\nKitty chip after Adding Looser's penalty: ";
    public String FinalGameKitty ="\nLast Round Kitty chip ";
    public String Message1 = " is a winner *******";
    public String Message2 = " chips remaining (without Winning Bonus)";
    public String Message3 = " is loosing the game";
    public String Message4 = " chips remaining";
    public String Message5 = " loose 5 more chips for loosing game";
    public String Message6 = " loose 10 more chips for loosing game";
    public String Message8 = "\nThe bonus for each winner: ";
    public String Message9 = "\nThe bonus for the winner is: ";
    public String Message10 = "Winner";
    public String Message11 = " is the Winner and";
    public String Message12 = " has total ";
    public String Message13 = " chips ";
    public String Message14 = " chip(s) remain is shared by ";
    public String Message15 = " winners ";
    public String Message16 = "********** Bravo!!! " ;
    public String Message17 = " pays all the remained chip for loosing game";
    public String FinalRollMesg1 = " roll one more time";
    public String FinalRollMesg2 = "  is rolling ...";
    public String FinalRollMesg3 = "score for this Roll: ";
    public String FinalRollMesg4 = "Roll score for game: ";
    public String FinalRollMesg5 = "'s chip count: ";
    public String FinalRollMesg6 = " roll one more time";
    public String FinalRollMesg7 = "Player chip count: ";
    public String FinalRollMesg8 = "Kitty chip count: ";
    public String FinalRollMesg9 = "Roll limit exceeded, Next Player turn!";
    public String ThrowDisp = "\n========> Roll ";
    public String TurnReport1 = "'s this Roll Score: ";
    public String TurnReport2 = "'s this Turn Score: "; 
    public String TurnReport3 = "'s Game Score: ";
    public String TurnReport4 = "Total turn score: ";
    public String TurnReport5 = "'s Total Penalty Chips: ";
    public String GameReport1 = "==>> Total game score is: ";
    public String GameReport2 = "'s Total game score: ";
    public String GameReport3 = " chip(s)  remained in this round is saved in KittyBox for final round";  
    public String GameReport4 = ", Game Score: ";
    public String GameReport5 = "  Chip Remained: ";
    public String RoundMessage1 = "'s total score accumulated after round \"";
    public String RoundMessage2 = "'s total chips accumulated after round \"";
    public String RoundMessage3 = "\n>>>>> Player reached the max round score!!!";
    public String RoundMessage4 = " Final turn for other players. <<<<<";
    public String RoundMessage5 = "\n========>>  Only one player remaining, Round is ended!!! <<========";
    public String doubleSkunk1 = "\n\t***** You rolled a Double-Skunk!!! ****";
    public String doubleSkunk2 = "\t***** You lose your turn and all GameScore. *****";
    public String doubleSkunk3 = "\t***** You pay 4 chips to the kitty. *****";
	public String deuceSkunk1 = "\n\t***** You rolled a Skunk-Deuce!!! *****";
	public String deuceSkunk2 = "\t***** You lose your turn and all TurnScore. *****";
	public String deuceSkunk3 = "\t***** You pay 2 chips to the kitty. *****";
	public String singleSkunk1 = "\n\t***** You rolled a Single-Skunk!!! *****";
	public String singleSkunk2 = "\t***** You lose your turn and all TurnScore. *****";
	public String singleSkunk3 = "\t***** You pay 2 chips to the kitty. *****";
	
	
	public static String UI(String message)
	{
		StdOut.print(message + "==>> ");
		String read = StdIn.readLine();
		return read;
	}
	

	public static void print(String message)
	{
		StdOut.print(message);
	}
	

	public static void println(String message)
	{
		StdOut.println(message);
	}
    
}


