package kata;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import kata.tennis.game.MatchReferee;
import kata.tennis.player.Player;
import kata.tennis.points.ClassicPoint;
import kata.tennis.points.DeucePoint;
import kata.tennis.rules.DeuceRule;
import kata.tennis.rules.TieBreakRule;

public class TestTheGame {

	public TestTheGame() {}
	
	Player player1=new Player("Gomez");
	Player player2=new Player("Morticia");
	MatchReferee referee=new MatchReferee(player1,player2);
	boolean condition;
	
	// Test a simple point win (15-0) -> (30-0)
	@Test
	public final void testWinASimplePoint() {
		
		referee.getGameRule().setPointToPlayer(player1, ClassicPoint.QUINZE.getEnumPoint()); // player1 initial score=15
		referee.pointWon(player1); 
		
		condition=player1.getScore().equals(ClassicPoint.TRENTE.getEnumPoint());
		assertTrue("Score player 1 vaut 30",condition);
	}
	
	
	// Test another simple point win (0-30) -> (0-40)
	@Test
	public final void testAnotherSimplePoint() {
		
		referee.getGameRule().setPointToPlayer(player2, ClassicPoint.TRENTE.getEnumPoint()); // player2 initial score=30
		referee.pointWon(player2); 
		
		condition=player2.getScore().equals(ClassicPoint.QUARANTE.getEnumPoint());
		assertTrue("Score player 2 vaut 40",condition);
	}

	
	// Test nb of game wins 2 -> 3 at 30-40
	@Test
	public final void testGameWinClassicRule() {
		
		referee.getGameRule().setPointToPlayer(player1, ClassicPoint.TRENTE.getEnumPoint()); // 30
		referee.getGameRule().setPointToPlayer(player2, ClassicPoint.QUARANTE.getEnumPoint()); // 40
		player2.setNbGameWin(2);
		referee.pointWon(player2);
		
		condition=player2.getGameWin()==3;
		assertTrue("Number of games won by player2 is now 3",condition);
	}
	
	
	// Test 40A -> (ADV-40)
	@Test
	public final void testDeuceRule40A() {
		
		referee.setGameRule(new DeuceRule(player1,player2));
		
		referee.getGameRule().setPointToPlayer(player1, DeucePoint.QUARANTE.getEnumPoint()); // 40
		referee.getGameRule().setPointToPlayer(player2, DeucePoint.QUARANTE.getEnumPoint()); // 40
		referee.pointWon(player1);
		
		condition=player1.getScore().equals(DeucePoint.ADV.getEnumPoint())&&player2.getScore().equals(DeucePoint.QUARANTE.getEnumPoint());
		assertTrue("Score player1 =ADV & player2=40",condition);
	}

	// Test 40-ADV -> DEUCE-DEUCE 
	@Test
	public final void testDeuceRule40ADV() {
		
		referee.setGameRule(new DeuceRule(player1,player2));
		
		referee.getGameRule().setPointToPlayer(player1, DeucePoint.QUARANTE.getEnumPoint()); // 40
		referee.getGameRule().setPointToPlayer(player2, DeucePoint.ADV.getEnumPoint()); // ADV
		referee.pointWon(player1);
		
		condition=player1.getScore().equals(DeucePoint.DEUCE.getEnumPoint())&&player2.getScore().equals(DeucePoint.DEUCE.getEnumPoint());
		assertTrue("Score player1 =DEUCE & player2=DEUCE",condition);
	}
	
	
	// test game wins pass to 2 -> 3 after player 2 wins at 40-ADV
	@Test
	public final void testGameWinDeuceRules() {
		
		referee.setGameRule(new DeuceRule(player1,player2));
		
		referee.getGameRule().setPointToPlayer(player1, DeucePoint.QUARANTE.getEnumPoint()); // 40
		referee.getGameRule().setPointToPlayer(player2, DeucePoint.ADV.getEnumPoint()); // ADV
		player2.setNbGameWin(2);
		referee.pointWon(player2);
		
		condition=player2.getGameWin()==3;
		assertTrue("Number of games won by player2 is now 3",condition);
	}
	
	
	
	@Test
	public final void testTieBreakWinPoint() {
		
		referee.setGameRule(new TieBreakRule(player1,player2));
		
		referee.getGameRule().setPointToPlayer(player1,"3"); // 3 
		referee.getGameRule().setPointToPlayer(player2, "5"); // 5
		
		referee.pointWon(player2);

		condition=player2.getScore().equals("6");
		assertTrue("Number of points won by player2 is now 6",condition);
	}
	
	
	// Test wins tie break at 5-7, set wins 2 -> 3 
	@Test
	public final void testTieBreakWinGame() {
		
		referee.setGameRule(new TieBreakRule(player1,player2));
		
		referee.getGameRule().setPointToPlayer(player1, "5"); // 5
		referee.getGameRule().setPointToPlayer(player2, "6"); // 6
		
		player1.setNbGameWin(6);
		player2.setNbGameWin(6);
		player2.setNbSetWin(2);
	
		referee.setGamesInSet(7);
		
		referee.pointWon(player2);
		
		condition=player2.getSetWin()==3;
		assertTrue("Number of set won by player2 is now 3",condition);
	}
	
}
