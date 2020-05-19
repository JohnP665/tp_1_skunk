/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */

public class Dice {
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice() {
		// StdOut.println("Dice() object is constructed now.");
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die1.roll();
		this.die2 = new Die();
		this.die2.roll();
		this.lastRoll = die1.getDieLastRoll() + die2.getDieLastRoll();
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
//		this.die1.roll();
		this.die2 = die2;
//		this.die2.roll();
		this.lastRoll = die1.getDieLastRoll() + die2.getDieLastRoll();
	}

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll() {
		return this.lastRoll;
	}

	public int die1GetLastRoll() {
		return die1.getDieLastRoll();
	}

	public int die2GetLastRoll() {
		return die2.getDieLastRoll();
	}

}

