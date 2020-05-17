import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_tostring {
	int last = 0;
	@Test
	public void test() {
		Die die1 = new Die();
		last = die1.getDieLastRoll();
		assertTrue(last > 0 & last < 7);
		assertEquals("Die: " + last,die1.toString());
	}

}
