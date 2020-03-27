import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceTestfalse {
	static int rolls = 50;
    int num;
    
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


}
