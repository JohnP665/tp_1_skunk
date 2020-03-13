import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import edu.princeton.cs.introcs.StdOut;

public class DieRandomTest
{
	Die die = new Die();
	public static final int NUM_TRIALS = 10;
	
	@Test
	public void RTest()
	{
		double PerfectRatio = 1;
		int dieface;
		int one=0,two=0,three=0,four=0,five=0,six=0;
		for (int i = 0; i < NUM_TRIALS; i++)
		{
			die.roll();
			
			dieface = die.getLastRoll();
			StdOut.println((i+1) + "- " + "Die: " + dieface );
			switch(dieface) {
			case 1: one++; break;
			case 2: two++; break;
			case 3: three++; break;
			case 4: four++; break;
			case 5: five++; break;
			case 6: six++; break;
			}
		}	
//		Double obj1 = new Double(one/NUM_TRIALS);
//		Double obj2 = new Double(PerfectRatio);
//		int compareValue = obj1.compareTo(obj2);
//		assertTrue(compareValue < 0);
			
		assertTrue( one/NUM_TRIALS < PerfectRatio);
		assertTrue( two/NUM_TRIALS < PerfectRatio);
		assertTrue( three/NUM_TRIALS < PerfectRatio);
		assertTrue( four/NUM_TRIALS < PerfectRatio);
		assertTrue( five/NUM_TRIALS < PerfectRatio);
		assertTrue( six/NUM_TRIALS < PerfectRatio);
		System.out.println("\n\t==> Random: outputs are Not the same in all trials!");

	}
}


