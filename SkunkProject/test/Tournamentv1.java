import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import edu.princeton.cs.introcs.StdOut;

class Tournamentv1 {

			int[] TotalScore = new int[] { 50, 25, 43, 18, 60 };
			int maxValue = 60;
			int playerNum = 3;
			int sitPlayerNum = 0;
			int[] playerChipcCount = new int[] {15,0,20};
			
			@Test
			public void FindMaxValuetest() {

				Tournament t = new Tournament("test");
				t.setPlayernumber(5);
				int max = t.getMaxScore(TotalScore);
				StdOut.println("\nExpectMaxValue : " + max);
				assertTrue(60 == max);	
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
			
			@Test
			public void check_set_total() {
				int[] total = new int[3]; 
				Tournament t = new Tournament("test");
				t.setTotal(2,total, 10);
				int expectValue = t.getTotal(2,total);
				assertEquals(10,expectValue);

			}
		
	/*
	 * @Test public void check_the_displayEndOfRoundWinner() { final
	 * ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	 * System.setOut(new PrintStream(outContent)); int[] total = {3,2,1,4,5};
	 * Tournament t = new Tournament("test"); t.setround(0);
	 * t.DisplayEndOfRoundWinner(total); String n = outContent.toString(); String s
	 * = "\n\n\t\t\tRounds  ********** S **********" +
	 * System.getProperty("line.separator") + "\t\t\tWinning Player ==> 3 <==" +
	 * System.getProperty("line.separator") ;
	 */   
		/*
		 * outContent.reset();
		 * 
		 * t.setround(4); t.DisplayEndOfRoundWinner(total); String n1 =
		 * outContent.toString(); String s1 =
		 * "\n\n\t\t\tRounds  *********** S  K  U  N  K ***********" +
		 * System.getProperty("line.separator") +
		 * "\t\t\tWinning Players ==> 3  2  1  4  5 <==" +
		 * System.getProperty("line.separator") ;
		 * 
		 * outContent.reset();
		 * 
		 * t.setround(3); t.DisplayEndOfRoundWinner(total); String n2 =
		 * outContent.toString(); String s2 =
		 * "\n\n\t\t\tRounds  *********** S  K  U  N ***********" +
		 * System.getProperty("line.separator") +
		 * "\t\t\tWinning Players ==> 3  2  1  4 <==" +
		 * System.getProperty("line.separator") ;
		 * 
		 * outContent.reset();
		 * 
		 * t.setround(2); t.DisplayEndOfRoundWinner(total); String n3 =
		 * outContent.toString(); String s3 =
		 * "\n\n\t\t\tRounds  *********** S  K  U ***********" +
		 * System.getProperty("line.separator") +
		 * "\t\t\tWinning Players ==> 3  2  1 <==" +
		 * System.getProperty("line.separator") ;
		 * 
		 * outContent.reset();
		 * 
		 * t.setround(1); t.DisplayEndOfRoundWinner(total); String n4 =
		 * outContent.toString(); String s4 =
		 * "\n\n\t\t\tRounds  *********** S  K ***********" +
		 * System.getProperty("line.separator") + "\t\t\tWinning Players ==> 3  2 <==" +
		 * System.getProperty("line.separator") ;
		 * 
		 * assertEquals(s4, n4); assertEquals(s3, n3); assertEquals(s1, n1);
		 */
			 /*  
			//    assertEquals(s, n);
		//	    assertEquals(s2, n2);
			//    System.setOut(System.out);
			    
			    
			}*/
			
		

			
			
			


	}



