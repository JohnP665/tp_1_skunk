import static org.junit.jupiter.api.Assertions.*;
import edu.princeton.cs.introcs.StdOut;

import org.junit.jupiter.api.Test;

class DiceTest {

	static int rolls = 50;
    int num;
	@Test
	public void dice_roll_is_always_greater_than_1_and_less_than_13()
	{
		Dice dice = new Dice();
		for (int i = 0; i < rolls; i++) {
	//		dice.roll();
			
			num = dice.getLastRoll();
					assertTrue(num > 1);
					assertTrue(num < 13);
			}
	}
	
	@Test
	public void dice_roll_will_not_be_less_than_2_and_greater_than_thirteen()
	{
		Dice dice = new Dice();
		for (int i = 0; i < rolls; i++) {
//			dice.roll();
			
			num = dice.getLastRoll();
					assertFalse(num < 2);
					assertFalse(num > 13);
			}
	}
	
	@Test	
	public void test_tostring () {
		int last = 0;
		
		Die die1 = new Die();
		last = die1.getDieLastRoll();
		StdOut.println("\nFace Value of " +  last + " is greater than 0 and less than 7  \" 0 < "+ last + " < 7 \"");
		
		assertTrue(last > 0 & last < 7);
		assertEquals("Die: " + last,die1.toString());
	}



}

