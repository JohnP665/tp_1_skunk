

//import edu.princeton.cs.introcs.StdOut;

public class Die {
	private int DielastRoll;
	private int RollType = 1;
	// Since the Die constructor did not import the int[] properly, I added the
	// int[] here:
	// private int[] seqRoll = {1,2,3,4,5,6};
	private int[] seqRoll = new int[] { 1, 2, 3, 4, 5, 6 };
	int i = 0;

	public Die() {
		// StdOut.println("Die() object is constructed now.");
		this.roll();
	}

	public Die(int[] seqRolls) {
		// StdOut.println("Die(int[] seqRolls) object is constructed now.");
		// predictable = true;
		this.roll();
		this.seqRoll = seqRolls;
	}

	public int getDieLastRoll() // getter or accessor method
	{
		return this.DielastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything. New: Modified this function to enable predictable die results.
	{
		if (RollType == 1) {
			this.DielastRoll = (int) (Math.random() * 6 + 1);
		} else {
			if (seqRoll[i] < 6) {
				i++;
			} else {
				i = 0;
			}
			this.DielastRoll = seqRoll[i];
		}
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getDieLastRoll();
	}

}
//
//
////import edu.princeton.cs.introcs.StdOut;
//
//public class Die
//{
//	private int DielastRoll;
//	private int RollType = 1;
//	// Since the Die constructor did not import the int[] properly, I added the int[] here:
////	private int[] seqRoll = {1,2,3,4,5,6};
//	private int[] seqRoll = new int[]{1,2,3,4,5,6};
//	int i = 0;
//	
//	public Die()
//	{
////		StdOut.println("Die() object is constructed now.");
//		this.roll();
//	}
//
//	public Die(int[] seqRolls)
//	{
////		StdOut.println("Die(int[] seqRolls) object is constructed now.");
//		// predictable = true;
//		this.roll();
//		this.seqRoll = seqRolls;		
//	}
//	
//	public int getDieLastRoll() // getter or accessor method
//	{
//		return this.DielastRoll;
//	}
//
//	public void roll() // note how this changes Die's state, but doesn't return
//						// anything. New: Modified this function to enable predictable die results.
//	{
//		if (RollType == 1) {
//		this.DielastRoll = (int) (Math.random() * 6 + 1);
//		}
//		else {
//			if (seqRoll[i] < 6) {
//				i++;
//			}
//			else {
//				i = 0;
//			}
//			this.DielastRoll = seqRoll[i];
//		}
//	}
//	
//	@Override
//	public String toString() // this OVERRIDES the default Object.toString()
//	{
//		return "Die: " + this.getDieLastRoll();
//	}
//
//}
//
