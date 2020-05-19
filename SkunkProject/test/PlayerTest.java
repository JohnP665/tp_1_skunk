import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;


class PlayerTest {

	int NumPlayer = 2;
	String[] playerName = new String[] {"Player 1","Player 2"};
	String pName;
	
	@Test
	public void PlayerNumTest() {
		Player player = new Player();
		player.setPlayernumber(NumPlayer);
		int expectedplayerNum = player.getPlayernumber();
		StdOut.println("\nexpectedNumber is: " + expectedplayerNum);
		assertTrue(expectedplayerNum==NumPlayer);
	}
		
	@Test
	public void PlayerNameTest() {
		Player player = new Player();
		pName = playerName[0];
		player.setPlayer(0, pName);
		String expectedName = Player.getPlayer(pName);
		StdOut.println("\nexpectedName is: " + expectedName);
		assertEquals(expectedName,playerName[0]);		
	}
	
	@Test
	public void Player_fine_maxScore() {
		Player player = new Player();
		player.setPlayernumber(3);
		int[] total = {1,4,3};
		int max = player.FindMaxScore(total);
		assertEquals(4,max);		
	}
	

}
