package kata.tennis.rules;

import kata.tennis.player.Player;

public abstract class GameRule{
	
	protected Player player1,player2; // We will use the players inside rules classes through updatePoints(Player player) to set the score of the players
	
	public abstract void updatePoints(Player player); // give the next score for the players

	public abstract void setPointToPlayer(Player playerWin,String point); // is used for unit testing and set score to the players
	
}
