package battleshipgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Gameboard {
	
	private int EMPTY_SPACE = 0;
	// hits and misses
	private int hits, misses;
	private ArrayList<Integer> shipLengthArray = new ArrayList<Integer>();
	private ArrayList<Integer> shipCharArray = new ArrayList<Integer>();
	int guess;
	private int level;
	private int availableMissiles;
	private int boardSize;
	private int[][] gameBoard;
	private int shipSize;
	private int shipMarker;
	private int ship;
	private String shipString;
	private Ships ships;
	private int shotsFired = 0;
	

	Random rand = new Random();
	
	// Scanner to retain user input
	Scanner input = new Scanner(System.in);
	
	
	//constructor for Gameboard

//	public Gameboard(char[][] game){
	//	this.gameBoard = game;
		//fillBoard();
	//}
	

	// initializing the whole board to empty ('E')
	private void fillBoard() {
		for(int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gameBoard[i][j] = -1;
			}
		}
	}

	
	// method to print board
	public void outputGame() 
	{ 
	
		char water = '~';
		char miss = '*';
		char hit = 'X';
		
		//fillBoard();
		//positionShips();
		
		System.out.print("   ");
		for (int i = 0; i < gameBoard[0].length; i++) {
			System.out.printf("%3d", i+1);
			System.out.print("  ");

		}
		
		System.out.println();
		//loop through array's rows
		for (int row = 0; row < gameBoard[0].length; row++)
		{	
			System.out.printf("%3c", getLetter(row+1));
			
	
			// loop through columns of current row
			for (int column = 0; column < gameBoard[0].length; column++) {
				//fillBoard();
				    //gameBoard[row][column] = -1;
				
					if (gameBoard[row][column] == 0)
						System.out.printf("%3c", water);
					if (gameBoard[row][column] == 1)
						System.out.printf("%3c", miss);
					if (gameBoard[row][column] == 2)
						System.out.printf("%3c", hit);
					System.out.printf("%3c", gameBoard[row][column]);
					
				//System.out.print(gameBoard[row][column]);
			}
	
			System.out.println();

		}
	}
	
	public void endGame() {		
		
		//System.out.print(missiles);
		//missiles = 3;
		while (availableMissiles != 0) {
			shotsFired++;
			
			System.out.println("Choose the coordinate to attack. Enter the row (LETTER) you wish to attack: ");
			// convert letter to integer
			String guess = input.next();
			
			char charInput = guess.charAt(0); 

			int coord1 = getNumber(charInput);
			
			// ensures guess doesn't go off the board
			//int row = input.nextInt() - 1;
			
			//create validation loop
			
			System.out.println("Choose the column you want to attack (NUMBER): ");
			int coord2 = input.nextInt() - 1;
			
			//int col = input.nextInt() - 1;

			for (int j = 0; j < shipLengthArray.size(); j++) {
			// checks to see if it was a hit or a miss
			for (int i = 0; i < shipLengthArray.get(j); i++) {
				if (gameBoard[coord1][coord2] == getLetter(shipCharArray.get(j))) {
					gameBoard[coord1][coord2] = 2;
				}
			}
		}
			
			boolean result;
			// check coordinate to see if it's empty
			if (gameBoard[coord1][coord2] == 0) {
				gameBoard[coord1][coord2] = 1;
				System.out.println("miss");
				result = false;
				misses++;
			} else if (gameBoard[coord1][coord2] == 2) {
				System.out.println("hit");
				result = true;
				hits++;
			}
			
			outputGame();
			availableMissiles--;
		}
	}
	
	public int getNumber(char input) {
		int row = 0;
		
		switch(input){
		case 'A':
			row = 0;
			break;
		case 'B':
			row = 1;
			break;
		case 'C':
			row = 2;
			break;
		case 'D':
			row = 3;
			break;
		case 'E':
			row = 4;
			break;
		case 'F':
			row = 5;
			break;
		case 'G':
			row = 6;
			break;
		case 'H':
			row = 7;
			break;
		case 'I':
			row = 8;
			break;
		case 'J':
			row = 9;
			break;
		case 'K':
			row = 10;
			break;
		case 'L':
			row = 11;
			break;
		
		}
		
		
		return row;
}

	
	
	
	// converts int to char for column
	public char getLetter(int i){
		  return (char) (i + 64);
		}
	
	// method to prompt user to choose difficulty, assign level, and print board
	public void difficultyInfo() {
		// prompt user to choose difficult
			
		System.out.print("Choose your level of difficulty.");
		System.out.print("\n" + "Enter 1 for Easy, 2 for Standard, and 3 for Advanced. ");
		level = input.nextInt();
			
		// checks to ensure valid level is chosen
		while (level != 1 && level != 2 && level != 3)
		{
			level = 0;
			System.out.print("You have not chosen a valid option. Please try again.");
				if (level == 0)
				{
					System.out.print("Choose your level of difficulty.");
					System.out.print("\n" + "Enter 1 for Easy, 2 for Standard, and 3 for Advanced. ");
					level = input.nextInt();
				} 
			}
			
			if (level == 1)
			{
				level = 1;
				System.out.println("I see you've chosen to take it EASY. Sharpen up those skills my friend."); 
				availableMissiles = 30;
				System.out.println("You have " + availableMissiles + " missiles to start with. Don't waste them.");
				boardSize = 6;
				gameBoard = new int[6][6];
				
			} else if (level == 2)
			{
				System.out.println("STANDARD eh? You're on your way!");
				availableMissiles = 50;
				System.out.println("You have " + availableMissiles + " missiles to start with. Best of luck!");
				boardSize = 9;
				gameBoard = new int[9][9];
				
			} else if (level == 3)
			{
				System.out.println("Feeling risky today huh? You're probably going to lose, but give ADVANCED a try.");
				availableMissiles = 75;
				System.out.println("You have " + availableMissiles + " missiles to start with. Put those skills to good use.");
				boardSize = 12;
				gameBoard = new int[12][12];
			}
			System.out.println();
	}
	
	public void setBoard(int[][] board){
		board = this.gameBoard;
	}
	
	public int missiles(int bombs) {
		bombs = this.availableMissiles;
		return bombs;
	}
	
	public int boardSize(int size) {
		size = this.boardSize;
		return size;
	}

	
	//SHIP CLASS
	/*
	
	// method to check user's guess
	public String checkGuess(String userGuess) {
		String result = "miss";
		// check to see if userGuess is inside location arrayList
		int index = location.indexOf(userGuess);
		
		if (index >= 0){
			location.remove(index);
			if (location.isEmpty()) {
				result = "kill";
			} else {
				result = "hit";
			}
		}
		
		System.out.println(result);
		
		return result;
	}
	*/
	
	// method to track score
	public int trackScore(int score) {
		return score;
	}
	
	
	public enum Ships {
		
		// int shipMarker is later converted to char.
		// these values are according to our getLetter method to convert to ascii values
		AIRCRAFT (5, 1, "Aircraft Carrier"),
		BATTLESHIP (4, 2, "Battleship"),
		DESTROYER (3, 4, "Destroyer"),
		SUBMARINE (3, 19, "Submarine"),
		PATROL (2, 16, "Patrol");
		
		// instance fields
		final int shipSize;
		final int shipMarker;
		final String shipString;
		
		// enum constructor
		Ships(int shipSize, int shipMarker, String shipString) {
			this.shipSize = shipSize;
			this.shipMarker = shipMarker;
			this.shipString = shipString;
		}
		
		public int getShipLength() {
			return shipSize;
		}
		
		public int getShipMarker() {
			return shipMarker;
		}
		
		public String getShipString() {
			return shipString;
		}
	}
	
	// add ships from enum ship class to array list
	// allows access in ship positioning method
	public void createShipArray(){
		//stores each ship length from enum
		shipLengthArray.add(ships.AIRCRAFT.getShipLength()); 
		shipLengthArray.add(ships.BATTLESHIP.getShipLength()); 
		shipLengthArray.add(ships.DESTROYER.getShipLength()); 
		shipLengthArray.add(ships.SUBMARINE.getShipLength()); 
		shipLengthArray.add(ships.PATROL.getShipLength()); 
		
		// stores each ship marker from enum
		shipCharArray.add(ships.AIRCRAFT.getShipMarker());
		shipCharArray.add(ships.BATTLESHIP.getShipMarker());
		shipCharArray.add(ships.DESTROYER.getShipMarker());
		shipCharArray.add(ships.SUBMARINE.getShipMarker());
		shipCharArray.add(ships.PATROL.getShipMarker());
		

		//System.out.print(shipLengthArray.size());
		//System.out.println();
		
		//for (int i = 0; i < shipLengthArray.size(); i++) {
		//System.out.println(shipLengthArray.get(i));
		//System.out.println(getLetter(shipCharArray.get(i)));
		//}
	}
	
	// method to position ships
	public void positionShips() 
	{
		fillBoard();
		difficultyInfo();
		createShipArray();
		//System.out.println("The board size is " + boardSize);
					
			
			//loops through arrayLists that hold enum values for shipSize and shipMarker
			for (int j = 0; j < shipLengthArray.size();j++) {
				boolean shipsOnBoard = false;
			
			start:
			while (!shipsOnBoard){		
				
				boolean horizontal = rand.nextBoolean();

				// generate random number for ship placement, either vertical or horizontal starting place
				int col = rand.nextInt(boardSize);
				int row = rand.nextInt(boardSize);
				
			//	if (gameBoard[row][col] != 'E')
				//	continue start;
				if (horizontal) {
					
					for (int i = 0; i < shipLengthArray.get(j); i++) {
					gameBoard[row][i+1] = getLetter(shipCharArray.get(j));
					
					//System.out.println("j = " + j);
					}

					
				} else { //vertically
					
					for (int i = 0; i < shipLengthArray.get(j); i++) {
						gameBoard[i+1][col] = getLetter(shipCharArray.get(j));	
						
						//System.out.println("j = " + j);
					}
					
					
				}
			
					// generate new random for next ship
				
					//row = rand.nextInt(boardSize);
					// if either row or column is not empty ('E') then start the iteration over again
					
				shipsOnBoard = true;
				}
				

		}
			

		
	 }
	 


}
