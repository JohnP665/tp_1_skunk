import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class DieTestfalse {

	static int rolls = 1000;
	int num;

	@Test
	public void die_roll_is_never_below_zero_and_more_then_seven()
	{
		Die die = new Die();
		for (int i = 0; i < rolls; i++) {
			die.roll();
			num = die.getDieLastRoll();
			
			assertFalse(num < 0);
			assertFalse(num > 7);
		}
	}

}

