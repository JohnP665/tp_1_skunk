import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;

import edu.princeton.cs.introcs.StdOut;
import org.junit.jupiter.api.Test;

class TurnTest {

	String Option;
	boolean looseTurn = false;
	@Test
	public void LostTurnIfAnyFaceValueIsOne_test() {
		Turn turn = new Turn();
		turn.setChoice("y");
		Option = turn.getChoice();
		
		if(Option == "y") {
			
			int i = 0;
			while(true) {
				Dice DieRoll = new Dice();
				int die1Face = DieRoll.die1GetLastRoll();
				int die2Face = DieRoll.die2GetLastRoll();
				StdOut.println("Roll " + (i++) + ":   " + die1Face + " and " + die2Face);
				if(i==100) {
					 StdOut.println("Die Roll Error!");
					break;				
				}
				else if ((die1Face == 1 || die2Face == 1)) {
					 looseTurn = true;
					 StdOut.println("\n ==> Player lost Turn");
					 break;
				}
			}
			if(i<100)
				assertTrue(looseTurn);
			else 
				assertFalse(looseTurn);
		}				
	}
	
	@Test
	public void ResetTunrTest() {
		for (int i = 0; i < 1000; i++) {
			Roll roll1 = new Roll();
			
			if (roll1.getTurnScore() > 0) 
			{
				roll1.resetTurnScore();
				assertTrue(roll1.getTurnScore() == 0);
			}
		}
	}
	
	private final ByteArrayOutputStream outContent1 = new ByteArrayOutputStream();
	@Test
	public void out() throws IOException {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    Turn t = new Turn();
	    t.SkunkMsg();
	    String n = outContent.toString();
	    String s = "\n\t***** You rolled a Single-Skunk!!! *****" + System.getProperty("line.separator") + "\t***** You lose your turn and all TurnScore. *****" + System.getProperty("line.separator") + "\t***** You pay 1 chips to the kitty. *****" + System.getProperty("line.separator");
	    assertEquals(s, n);
	    outContent.reset();
	    System.setOut(System.out);
	}


	@After
	public void restoreStreams() {
	   System.setOut(System.out);
	}
	
}
