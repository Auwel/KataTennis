package kata.tennis.game;

import kata.tennis.player.Player;
import kata.tennis.points.ClassicPoint;
import kata.tennis.rules.ClassicRule;
import kata.tennis.rules.DeuceRule;
import kata.tennis.rules.GameRule;
import kata.tennis.rules.TieBreakRule;


/*
 * The MatchReferee Class is used for arbitrate a tennis match.
 * 
 */
public class MatchReferee {
	


	private GameRule[] rules; // Arrays to contain the different types of rule 
	
	private GameRule gameRule=null; // Define the rule for the curent game ( normal game, deuce rule, tie break )
	
	private Player player1=null,player2=null; // Define the players
	
	private int nbOfGamesToPlay=0; // Define the number of games to play
	
	private int nbOfSetToPlay=0; // Define the number of sets to play
	
	private String currentMatchState="", winnerPlayer=""; // Is used to display the score
	
	public MatchReferee(Player player1,Player player2) {
		rules=new GameRule[] {new ClassicRule(player1,player2),new DeuceRule(player1,player2),new TieBreakRule(player1,player2)};
		InitializeGame(player1,player2);
	}
	
	
	/*
	 * Getter and setter below are used for the Unit Testing
	 * simplify the scenario case test in UT
	 */
	public GameRule getGameRule(){
		return gameRule;
	}
	public void setGameRule(GameRule nextRule) {
		gameRule=nextRule;
	}
	
	public void setGamesInSet (int nbGames) {
		nbOfGamesToPlay=nbGames;
	}
	

	/*
	 * In
	 */
	
	private void InitializeGame(Player player1,Player player2) {
		this.player1=player1;
		this.player2=player2;
		InitializeRules();
	}

	
	/*
	 * Initialize the number of games and sets to play,
	 * Define the rule type we use at the beginning of the match 
	 */
	private void InitializeRules() {
		nbOfGamesToPlay=6;
		nbOfSetToPlay=3; 
		gameRule= rules[0]; // gameRule is defined as ClassicRule to manage score from 0 up to 40
	}

	
	/*
	 * Update the score of the players each time a point is scored
	 */
	public void pointWon(Player player) {
		
		gameRule.updatePoints(player);
		matchState(player);
	}
	
	
	/*
	 * matchState verifies the score of the players, 
	 * switch from one game rule to another if needed, 
	 * clean the attributes of Rules objects to re use them 
	 * display the current score of the game
	 */
	public void matchState(Player player) {		
		
		
		winnerPlayer=player.getName();
		
		
		// Condition on game win
		if(player.getScore().equals(ClassicPoint.WIN.getEnumPoint())) {
			currentMatchState="Game";
			player.setNbGameWin(player.getGameWin()+1);
			gameRule=rules[0];
			player1.setScore(ClassicPoint.ZERO.getEnumPoint());
			player2.setScore(ClassicPoint.ZERO.getEnumPoint());
			
			
			// Condition if a player won the number of games to complete one Set
			if(player.getGameWin()==nbOfGamesToPlay) {
				currentMatchState="Set";
				player.setNbSetWin(player.getSetWin()+1);
				player1.setNbGameWin(0);
				player2.setNbGameWin(0);
				this.nbOfGamesToPlay=6;
				gameRule=rules[0];
				
				//Condition to win the party 
				if(player.getSetWin()==nbOfSetToPlay) {
					currentMatchState="Match";
					return;
				}
				return;
			}
			
			
			// Condition if both of the player won 5 games each
			if(player1.getGameWin()==5 && player2.getGameWin()==5) {
				this.nbOfGamesToPlay=7;
				return;
			}
			
			
			// Condition for the tie-break event 
			if(player1.getGameWin()==6 && player2.getGameWin()==6) {
				gameRule=rules[2];
				return;
			}
						
			return;
		}
		
		// Condition under a one game play, if each players reach 40-40, we switch the Rules to DeuceRules 
		else if(player1.getScore().equals(ClassicPoint.QUARANTE.getEnumPoint()) && player2.getScore().equals(ClassicPoint.QUARANTE.getEnumPoint())) {	
			gameRule=rules[1];
			return;
		}
		
		else {
			currentMatchState="Point";
		}
			
	}

	/*
	 * Check if there is any victor and display the winner if there is one
	 */
	
	public boolean checkTheWinner() {
	
		
		// player 1 wins the match
		if((player1.getSetWin()==nbOfSetToPlay)){	
			return false;
		}
		
		// player 2 wins the match 
		else if(player2.getSetWin()==nbOfSetToPlay){
			return false;
		}
		
		else {
			return true;
		}

	}
	
	
	/*
	 * Display depending of the event 
	 */
	
	public void displayGameScore() {
		switch(currentMatchState) {

		case "Game":
			ViewRenderer.displayWinnerOfTheGame(winnerPlayer);
			ViewRenderer.displayScore(player1, player2);
			break;

		case "Set":
			ViewRenderer.displayWinnerOfTheSet(winnerPlayer);
			ViewRenderer.displayScore(player1, player2);
			break;

		case "Match":
			ViewRenderer.displayWinnerOfTheMatch(winnerPlayer);
			ViewRenderer.displayScore(player1, player2);
			break;

		case "Point":
			ViewRenderer.displayWinnerOfThePoint(winnerPlayer);
			ViewRenderer.displayScore(player1, player2);
			break;
		}
	}
}
