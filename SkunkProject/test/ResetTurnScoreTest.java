import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResetTurnScoreTest {

	@Test
	public void test() {
		for (int i = 0; i < 1000; i++) {
			Roll roll1 = new Roll();
			
			if (roll1.getTurnScore() > 0) 
			{
				roll1.resetTurnScore();
				assertTrue(roll1.getTurnScore() == 0);
			}
		}
	}

}
