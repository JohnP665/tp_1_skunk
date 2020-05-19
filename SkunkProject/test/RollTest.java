import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class RollTest {

	@Test
	public void Rollingtest() {
	
		Roll roll1 = new Roll();
	    int kittychip = 0;	
	    int playerchip = roll1.updateChipCount(1);
	    int rollScore = 0;  
	    StdOut.println("playerchip at start: " + playerchip);
	    StdOut.println("kittychip at start: " + kittychip);
	    StdOut.println("\n");
	    
	    	roll1.throwDice(1);
	    	rollScore = roll1.getDie1Score() + roll1.getDie2Score();
	    	StdOut.println("Die1: " + roll1.getDie1Score() + ", Die2: " + roll1.getDie2Score());
	    	StdOut.println("\n");
			if (rollScore == 2) 
			{				
		    	 kittychip += 4;
		    	 playerchip -= 4;
				
			    StdOut.println("Player loos 4 chips "); 			    
			    StdOut.println("playerchips remain: " + playerchip);
			    StdOut.println("kittychips: " + kittychip);
			    StdOut.println("\n");
			}
	
			else if (rollScore == 3)
			{
		    	 
		    	 kittychip += 2;
		    	 playerchip -= 2;
				    StdOut.println("Player lost 2 chips "); 			    
				    StdOut.println("playerchips remain: " + playerchip);
				    StdOut.println("kittychips: " + kittychip);
				    StdOut.println("\n");
			}
			else if (roll1.getDie1Score() == 1 || roll1.getDie2Score() == 1 )
			{
		    	 kittychip += 1;
		    	 playerchip -= 1;
	
				    StdOut.println("Player lost 1 chips "); 			    
				    StdOut.println("playerchips remain: " + playerchip);
				    StdOut.println("kittychips: " + kittychip);
				    StdOut.println("\n");
			}
			else
			{
			    StdOut.println("Player lost 0 chips "); 			    
			    StdOut.println("playerchips remain: " + playerchip);
			    StdOut.println("kittychips: " + kittychip);
			    StdOut.println("\n");
			}
				    		 
			if(rollScore == 2)
				assertTrue(playerchip == 46 && kittychip == 4);
			else if(rollScore == 3)
				assertTrue(playerchip == 48 && kittychip == 2);
			else if (roll1.getDie1Score() == 1 || roll1.getDie2Score() == 1 )
				assertTrue(playerchip == 49 && kittychip == 1);
			else if(rollScore == 2)
				assertTrue(playerchip == 50 && kittychip == 0);	  
	}
	
	@Test
	public void testing_Rol_diceScorel() {
	       Roll r = new Roll();
//	       Dice d = new Dice();
	       r.throwDice(1);
	       int sum1 = r.diceScore();
	       System.out.println("the sum" + sum1);
//	       Dice d = new Dice();
	       int sum2 = r.getDie1Score() + r.getDie2Score();
	       System.out.println("the sum2 " + sum2);
	       assertTrue(sum1 == sum2);
	}	  
	
	@Test
	public void testing_resetTurnScore() {
	       Roll r = new Roll();
	       r.setTurnScore(20);
	       r.resetTurnScore();
	       int sum = r.getTurnScore();	      
	       assertTrue(0 == sum);
	}

	@Test
	public void testing_resetGameScore() {
	       Roll r = new Roll();
	       r.setGameScore(2,20);
	       r.resetGameScore(2);
	       int sum = r.getGameScore(2);	      
	       assertTrue(0 == sum);
	}

	@Test
	public void testing_player_loses_turn() {
	       Roll r = new Roll();
	       r.setplayerLosesTurn(true);
	       r.resetGameScore(2);
	       boolean sum = r.playerLosesTurn();	      
	       assertTrue(sum);
	}

	@Test
	public void testing_player_penaltychip_count() {
	       Roll r = new Roll();
	       r.setPlayerPenaltyChipCounts(2, 100);
	       int sum = r.getPlayerPenaltyChipCounts(2);	      
	       assertTrue(sum == 100);
		       
	}

}
