package kata.tennis.rules;

import kata.tennis.player.Player;
import kata.tennis.points.DeucePoint;

public class DeuceRule extends GameRule {
	
	
	public DeuceRule(Player player1, Player player2) {
		this.player1 =player1;
		this.player2=player2;
	}
		
	@Override
	public void updatePoints(Player playerWin) {
		
		if(playerWin.getName()==player1.getName()){
			
			setPointsRelative(player1,player2);
		}
		
		else{
			setPointsRelative(player2,player1);
		}
	}
	
	
	private void setPointsRelative(Player playerWin,Player playerLoses ) {
		
		if(playerLoses.getScore()==DeucePoint.ADV.getEnumPoint()) {
			playerWin.setScore(DeucePoint.DEUCE.getEnumPoint());
			playerLoses.setScore(DeucePoint.DEUCE.getEnumPoint());
		}
		
		else if(playerWin.getScore()==DeucePoint.ADV.getEnumPoint()) {
			playerWin.setScore(DeucePoint.WIN.getEnumPoint());
		}
		
		else {
			playerWin.setScore(DeucePoint.ADV.getEnumPoint());
		}
	}
	


	@Override
	public void setPointToPlayer(Player playerWin, String point) {
		playerWin.setScore(point);
	}

}
