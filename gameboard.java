package battleshipgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Gameboard {
	
	// hits and misses
	private int hits, misses;
	private ArrayList<Integer> shipLengthArray = new ArrayList<Integer>();
	private ArrayList<Integer> shipCharArray = new ArrayList<Integer>();
	int guess;
	private int level;
	private int availableMissiles;
	private int boardSize;
	private char[][] gameBoard;
	private int shipSize;
	private int shipMarker;
	private int ship;
	private String shipString;
	private Ships ships;
	

	Random rand = new Random();
	
	// Scanner to retain user input
	Scanner input = new Scanner(System.in);
	
	
	//constructor for Gameboard

	//public Gameboard(char[][] game){
		//this.gameBoard = game;
		//outputGame();
	//}
	

	// initializing the whole board to empty ('E')
	private void fillBoard() {
		for(int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gameBoard[i][j] = 'E';
			}
		}
	}

	
	// method to print board
	public void outputGame() 
	{ 
		fillBoard();
		positionShips();
		
		System.out.print("     ");
		for (int i = 0; i < gameBoard[0].length; i++) {
			System.out.printf("%3d", i+1);

		}
		
		System.out.println();
		//loop through array's rows
		for (int row = 0; row < gameBoard.length; row++)
		{	
			System.out.print(" ");
			System.out.printf("%3c", getLetter(row+1));
	
			// loop through columns of current row
			for (int column = 0; column < gameBoard[0].length; column++) {
				   // gameBoard[row][column] = '~';
					System.out.printf("%3c", gameBoard[row][column]);
					
				//System.out.print(gameBoard[row][column]);
			}
			System.out.println();

		}
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
				gameBoard = new char[6][6];
				
			} else if (level == 2)
			{
				System.out.println("STANDARD eh? You're on your way!");
				availableMissiles = 50;
				System.out.println("You have " + availableMissiles + " missiles to start with. Best of luck!");
				boardSize = 9;
				gameBoard = new char[9][9];
				
			} else if (level == 3)
			{
				System.out.println("Feeling risky today huh? You're probably going to lose, but give ADVANCED a try.");
				availableMissiles = 75;
				System.out.println("You have " + availableMissiles + " missiles to start with. Put those skills to good use.");
				boardSize = 12;
				gameBoard = new char[12][12];
			}
			System.out.println();
	}
	
	public void set(char[][] gameBoard){
		this.gameBoard=gameBoard;
		return;
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
		difficultyInfo();
		createShipArray();
		//System.out.println("The board size is " + boardSize);
					
			boolean shipsOnBoard = false;
			
			
				
				//boolean placeHorizontal = rand.nextBoolean();
		while (!shipsOnBoard){		
				// generate random number for ship placement, either vertical or horizontal starting place
				int col = rand.nextInt(boardSize);
				int row = rand.nextInt(boardSize);
				
				
				//loops through arrayLists that hold enum values for shipSize and shipMarker
				for (int j = 0; j < shipLengthArray.size();j++) {
					
					for (int i = 0; i < shipLengthArray.get(j); i++) {
					gameBoard[row][i+1] = getLetter(shipCharArray.get(j));	
					//System.out.println("j = " + j);
					}
					
					// generate new random for next ship
				
					row = rand.nextInt(boardSize);
					// if either row or column is not empty ('E') then start the iteration over again
					//if (gameBoard[row][i+1] != 'E')
						//continue;

				}
				shipsOnBoard = true;

		}
			

		
	 }
	 


}


		

	

