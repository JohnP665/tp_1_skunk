import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.princeton.cs.introcs.StdOut;

class PlayerTest {

	int NumPlayer = 2;
	String[] playerName = new String[] {"Player 1","Player 2"};
	String pName;
	
	@Test
	void PlayerNumTest() {
		Player player = new Player();
		player.setPlayernumber(NumPlayer);
		int expectedplayerNum = player.getPlayernumber();
		StdOut.println("\nexpectedNumber is: " + expectedplayerNum);
		assertTrue(expectedplayerNum==NumPlayer);
	}
		
	@Test
	void PlayerNameTest() {
		Player player = new Player();
		pName = playerName[0];
		player.setPlayer(0, pName);
		String expectedName = Player.getPlayer(pName);
		StdOut.println("\nexpectedName is: " + expectedName);
		assertEquals(expectedName,playerName[0]);		
	}

}
