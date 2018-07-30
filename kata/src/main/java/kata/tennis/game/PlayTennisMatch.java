package kata.tennis.game;

import java.util.Scanner;

import kata.tennis.player.Player;


public class PlayTennisMatch {

	private Scanner input = new Scanner(System.in);
	private Boolean matchIsPlaying=false;
	private Player player1=null, player2=null;
	private MatchReferee referee=null;
	private String playerName="";

	
	public PlayTennisMatch() {
		setPlayersAndReferee();
		beginTheMatch();
	}


	// Set up the players name and points & the referee who controls the flow of the game
	private void setPlayersAndReferee() {
		
		String nomPlayer1="",nomPlayer2="";
		boolean nameCondition= nomPlayer1.length()==0||nomPlayer2.length()==0;
		
		// Check if players have both a name
		while(nameCondition) {
			
			System.out.print("Rentrez le nom du premier joueur: ");
			nomPlayer1= input.nextLine();
	
			System.out.print("Rentrez le nom du deuxième joueur: ");
			nomPlayer2= input.nextLine();
			
			nameCondition= nomPlayer1.length()==0||nomPlayer2.length()==0;
			
			if(nameCondition) {
				System.out.println("\nVeuillez donner un nom au deux joueurs !\n");
			}
		}
		
		player1=new Player(nomPlayer1);
		player2=new Player(nomPlayer2);
		referee=new MatchReferee(player1, player2);
	}

// Start the match while loop until there is a winner 
	private void beginTheMatch() {
		
		matchIsPlaying=true;
		
		while(matchIsPlaying) {

			nextPlayingBall();
			matchIsPlaying=referee.checkTheWinner(); 

		}


	}

	// give a winner for the current point and update the scores
	private void nextPlayingBall() {
	
		while(playerName!=player1.getName()||playerName!=player2.getName()){
			
			System.out.print("Rentrez le nom du joueur gagnant le prochain point: ");
			System.out.println();
			
			playerName=input.nextLine();

			
			if(playerName.equals(player1.getName())){
				referee.pointWon(player1);
				
			}
			else if(playerName.equals(player2.getName())){
				referee.pointWon(player2);
			}
			else 
				System.out.println("Vous n'avez pas rentré un nom de joueur correct");
			
			referee.displayGameScore();
		}
	}

	
	
	public static void main(String[] args) {
		new PlayTennisMatch();
	}

	
}



