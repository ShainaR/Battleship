package battleshipgame;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class battleship {
	
	
	public static void main(String[] args) {
		int size = 0;
		int x=0;
		char[][] gameBoard1 = null;
		Random rand = new Random();
		int temp = rand.nextInt(5) + 1;
		ArrayList<String> location = new ArrayList<String>();
		
		
		
		
		Scanner input = new Scanner(System.in);
		
		Gameboard gameboard1 = new Gameboard();
		
		gameboard1.difficultyInfo();
		gameboard1.outputGame();
		
		gameboard1.setShips(location);	

  }
}
