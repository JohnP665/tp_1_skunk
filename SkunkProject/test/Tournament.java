import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class TournamentTest {
	int[] TotalScore = new int[] { 50, 25, 43, 18, 60 };
	int maxValue = 60;
	int playerNum = 3;
	int sitPlayerNum = 0;
	int[] playerChipcCount = new int[] {15,0,20};
	
	@Test
	public void FindMaxValuetest() {
		int maxScore = 0;
		for (int i = 0; i < 5; i++) {
			if(TotalScore[i] > maxScore)
				maxScore = TotalScore[i]; 
		}
		StdOut.println("\nExpectMaxValue : " + maxValue);
		StdOut.println("MaxScore : " + maxScore);
		assertTrue(maxScore == maxValue);	
	}
	
	@Test
	public void checkSitPlayer() {
		int expectValue = 1;
		for (int i=0; i<playerNum; i++) {
			if(playerChipcCount[i] == 0)
				sitPlayerNum++;
		}
		StdOut.println("\nexpectValue : " + expectValue);
		StdOut.println("sitPlayerNum : " + sitPlayerNum);

		assertEquals(expectValue,sitPlayerNum);

	}
}
