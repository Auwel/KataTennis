package kata.tennis.player;



public class Player {


	
	
	private String playerName; 
	private String score="0"; // Score of the player during the current game;
	private int gameWin=0; // the number of games won 
	private int setWin=0; // the number of sets won
	
	
	public Player(String playerName) {
		this.playerName=playerName;
		this.score="0";
		this.gameWin=0;
		this.setWin=0;
		
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
