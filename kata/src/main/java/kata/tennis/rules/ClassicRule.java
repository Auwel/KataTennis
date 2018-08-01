package kata.tennis.rules;

import kata.tennis.player.Player;
import kata.tennis.points.ClassicPoint;

//import kata.tennis.game.Score;
public class ClassicRule extends GameRule{

	
	public ClassicRule(Player player1, Player player2) {
		this.player1=player1;
		this.player2=player2;

	}

	

	@Override
	public void updatePoints(Player player) {
		
		
		if(player.getScore().equals(ClassicPoint.ZERO.getEnumPoint())) {
			player.setScore(ClassicPoint.QUINZE.getEnumPoint());
			return;
		}
			
		if(player.getScore().equals(ClassicPoint.QUINZE.getEnumPoint())) {
			player.setScore(ClassicPoint.TRENTE.getEnumPoint());
			return;
		}
		
		if(player.getScore().equals(ClassicPoint.TRENTE.getEnumPoint())) {
			player.setScore(ClassicPoint.QUARANTE.getEnumPoint());
			return;
		}
			
		if(player.getScore().equals(ClassicPoint.QUARANTE.getEnumPoint())) {
			player.setScore(ClassicPoint.WIN.getEnumPoint());
			return;
		}
		
	}


	@Override
	public void setPointToPlayer(Player playerWin, String point) {
		playerWin.setScore(point);
		
	}


	












}
