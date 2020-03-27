import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestNumberOfPlayer {
	int NumPlayer = 1;
	boolean booleaaIsTrue = false;
	@Test
	void test() {
		Player player = new Player();
		player.setPlayernumber(NumPlayer);
	
		assertTrue(player.getPlayernumber()==NumPlayer);
		
	}

}
