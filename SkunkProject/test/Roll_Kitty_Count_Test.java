import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class Roll_Kitty_Count_Test {

	@Test
	void test() {
	//	public void Kitty_Count_add_as_playerscore_decrease(){
		int num = 0;
		
		Roll roll1 = new Roll();
		roll1.throwDice(1);
		num = roll1.getRollScore();
	    int kittychip = roll1.getKittyChipCounts();
	    int playerchip = roll1.updateChipCount(1);
	    int total = roll1.getDie1Score() + roll1.getDie2Score();
	    StdOut.println(num);
	    StdOut.println(total); 
	    StdOut.println(playerchip);
	    StdOut.println(kittychip);
	    // Skunk Deuce rolled
	    if (total == 3)
		{
	    	assertTrue(playerchip == 48 && kittychip == 2);
		}
		else if (total == 2) 
		{
//			StdOut.println(num);
			assertTrue(playerchip == 46 && kittychip == 4);
		}
		else if (roll1.getDie1Score() == 1 || roll1.getDie2Score() == 1 )
		{
			assertTrue(playerchip == 49 && kittychip == 1);
		}
		else
		{
			assertTrue(playerchip == 50 && kittychip == 0);	
		}
	
	}

}
