package kata.tennis.player;

import kata.tennis.points.ClassicPoint;

public class Player {
	
	private String playerName; 
	private String score=ClassicPoint.ZERO.getEnumPoint(); 
	private int gameWin=0; // the number of games won 
	private int setWin=0; // the number of sets won
	
	
	public Player(String playerName) {
		this.playerName=playerName;
	}
	
	
	public String getName() {
		return this.playerName;
	}
	
	
	public String getScore() {
		return this.score;
	}


	public void setScore(String currentScore) {
		this.score = currentScore;
	}

	
	public int getGameWin() {
		return gameWin;
	}
	
	public void setNbGameWin(int gameWin) {
		this.gameWin=gameWin;
	}


	public int getSetWin() {
		return this.setWin;
	}
	
	public void setNbSetWin(int setWin) {
		this.setWin=setWin;
	}

	
	
}
