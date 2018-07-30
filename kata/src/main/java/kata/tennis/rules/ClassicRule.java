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
		
		switch(player.getScore()) {
		
		case "0":
			player.setScore(ClassicPoint.QUINZE.getEnumPoint());
			break;
			
		case "15":
			player.setScore(ClassicPoint.TRENTE.getEnumPoint());
			break;
		
		case "30":
			player.setScore(ClassicPoint.QUARANTE.getEnumPoint());
			break;
			
		case "40":
			player.setScore(ClassicPoint.WIN.getEnumPoint());
			break;
			
		}
	}


	@Override
	public void setPointToPlayer(Player playerWin, String point) {
		playerWin.setScore(point);
		
	}


	












}
