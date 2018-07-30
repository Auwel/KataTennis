package kata.tennis.rules;

import kata.tennis.player.Player;

public class TieBreakRule extends GameRule {

	private Integer scorePlayer1=0,scorePlayer2=0;
	 
	public TieBreakRule(Player player1, Player player2) {
		this.player1 = player1;
		this.player2=player2;	
	}
	
	
	@Override
	public void updatePoints(Player player) {

		if(player.getName()==player1.getName()) {
			scorePlayer1+=1;
			player1.setScore(scorePlayer1.toString());
		}
		
		else {
			scorePlayer2+=1;
			player2.setScore(scorePlayer2.toString());
		}
		
		isTieBreakFinished();
	}
	
	
	private void isTieBreakFinished() {
		if( (scorePlayer1-scorePlayer2)>=2 &&scorePlayer1>=7) {
			player1.setScore("WIN");
			scorePlayer1=0;
			scorePlayer2=0;
			
		}
		
		else if( (scorePlayer2-scorePlayer1)>=2 &&scorePlayer2>=7) {
			player2.setScore("WIN");
			scorePlayer1=0;
			scorePlayer2=0;
		}
	}

	
	@Override
	public void setPointToPlayer(Player playerWin, String point) {
		playerWin.setScore(point);
		if(playerWin.getName()==player1.getName()) {
			scorePlayer1=Integer.parseInt(point);
		}
		else {
			scorePlayer2=Integer.parseInt(point);
		}
	}

}
