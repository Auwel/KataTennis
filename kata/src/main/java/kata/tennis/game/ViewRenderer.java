package kata.tennis.game;

import kata.tennis.player.Player;

public class ViewRenderer{

	
	public  static void displayScore(Player player1, Player player2) {
		
		System.out.println("\tScore\tGame\tSet");
		
		
		System.out.println("\t  "+
		player1.getScore()+"\t "
		+player1.getGameWin()+"\t "
		+player1.getSetWin()+"\t"
		+player1.getName());
		
		
		System.out.println("\t  "
		+player2.getScore()+"\t "
		+player2.getGameWin()+"\t "
		+player2.getSetWin()+"\t"
		+player2.getName()+"\n\n");
	}

	public static void displayWinnerOfThePoint(String winnerPlayer) {
		System.out.println(winnerPlayer+" emporte le point\n");
	}
	
	public static void displayWinnerOfTheGame(String winnerPlayer) {
		System.out.println(winnerPlayer+" emporte le jeu !\n\n");
	}

	public static void displayWinnerOfTheSet(String winnerPlayer) {
		System.out.println(winnerPlayer +" gagne le set !\n\n");
	}

	public static void displayWinnerOfTheMatch(String winnerPlayer) {
		System.out.println("\nEt le gagnant de la partie est "+winnerPlayer+" !!!");
		
	}

}
