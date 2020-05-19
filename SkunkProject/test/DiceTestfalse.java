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
			
			int num = dice.getLastRoll();
					assertFalse(num < 2);
					assertFalse(num > 13);
			}
	}

	@Test
	public void dice_constructor()
	{
		Die die1 = new Die(2);
		Die die2 = new Die(3);
		Dice dice = new Dice(die1, die2);	
		int num = die1.getDieLastRoll(); 
		int num2 = die2.getDieLastRoll(); 
		int sum = num + num2;		
		int num1 = dice.getLastRoll();
		assertTrue(5 == sum);
			}



}
