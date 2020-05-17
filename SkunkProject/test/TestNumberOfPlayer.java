import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNumberOfPlayer {
	int NumPlayer = 1;
	boolean booleaaIsTrue = false;
	@Test
	public void numPlayertest() {
		Player player = new Player();
		player.setPlayernumber(NumPlayer);
	
		assertTrue(player.getPlayernumber()==NumPlayer);
		
	}

}
