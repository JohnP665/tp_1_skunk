import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DieTest {

	static int rolls = 5;
	int num;

	@Test
	public void die_roll_is_always_greater_than_0_and_less_than_7()
	{
		Die die = new Die();
		for (int i = 0; i < rolls; i++) {
			die.roll();
			num = die.getLastRoll();
			
			assertTrue(num > 0);
			assertTrue(num < 7);
		}
	}

}
