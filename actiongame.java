package battleshipgame;

import java.util.Scanner;
import java.util.Scanner;

public class actiongame {
	Gameboard gameboard1 = new Gameboard();
	Scanner input = new Scanner(System.in);
	
	public void startGame(){
		
		gameboard1.difficultyInfo();
		gameboard1.createShipArray();
		gameboard1.fillBoard();
		gameboard1.positionShips();
		gameboard1.outputGame();
		gameboard1.endGame();
	}
	
	
}
