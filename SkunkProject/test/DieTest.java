import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.princeton.cs.introcs.StdOut;

class DieTest {

	@Test
	public void die_roll_is_always_greater_than_0_and_less_than_7()
	{
		int rolls = 500;
		int num;

		Die die = new Die();
		for (int i = 0; i < rolls; i++) {
			die.roll();
			num = die.getDieLastRoll();
			
			assertTrue(num > 0);
			assertTrue(num < 7);
		}
	}

	@Test
	public void die_roll_is_never_below_zero_and_more_then_seven()
	{
		int rolls = 500;
		int num;

		
		Die die = new Die();
		for (int i = 0; i < rolls; i++) {
			die.roll();
			num = die.getDieLastRoll();
			
			assertFalse(num < 0);
			assertFalse(num > 7);
		}
	}
		
	
	@Test
	public void RTest()
	{
		Die die = new Die();
		final int NUM_TRIALS = 10;
		double PerfectRatio = 1;
		int dieface;
		int one=0,two=0,three=0,four=0,five=0,six=0;
		for (int i = 0; i < NUM_TRIALS; i++)
		{
			die.roll();
			
			dieface = die.getDieLastRoll();
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
		assertTrue( one/NUM_TRIALS < PerfectRatio);
		assertTrue( two/NUM_TRIALS < PerfectRatio);
		assertTrue( three/NUM_TRIALS < PerfectRatio);
		assertTrue( four/NUM_TRIALS < PerfectRatio);
		assertTrue( five/NUM_TRIALS < PerfectRatio);
		assertTrue( six/NUM_TRIALS < PerfectRatio);
		System.out.println("\n\t==> Random: outputs are Not the same in all trials!");

	}
}
