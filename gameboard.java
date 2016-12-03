package battleshipgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Gameboard {

	// Declare constants
	String EMPTY_SPACE = "0";
	
	// array to hold ships
	//Ships[] ShipsArray = new Ships[5];
	
	// ships
	/*
	private int AIRCRAFT=5;
	private int BATTLESHIP=4;
	private int DESTROYER=3;
	private int SUBMARINE=3;
	private int PATROL=2;
	*/
	
	// hits and misses
	private int hits, misses;
	private ArrayList<Integer> shipArray = new ArrayList<Integer>();
	int guess;
	private int level;
	private int availableMissiles;
	private int boardSize;
	private int[][] gameBoard;
	//shipType[] ships = new shipType[5]; //
	private int shipSize;
	private char shipMarker;
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
	

	// initializing the whole board to -1
	private void fillBoard() {
		// initializing the board array to -1
		// -1 will equal empty space, aka water on the battleship board
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
	
	public void set(int[][] gameBoard){
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
		AIRCRAFT (5, 'A', "Aircraft Carrier"),
		BATTLESHIP (4, 'B', "Battleship"),
		DESTROYER (3, 'D', "Destroyer"),
		SUBMARINE (3, 'S', "Submarine"),
		PATROL (2, 'P', "Patrol");
		
		// instance fields
		final int shipSize;
		final char shipMarker;
		final String shipString;
		
		// enum constructor
		Ships(int shipSize, char shipMarker, String shipString) {
			this.shipSize = shipSize;
			this.shipMarker = shipMarker;
			this.shipString = shipString;
		}
		
		public int getShipLength() {
			return shipSize;
		}
		
		public char getShipMarker() {
			return shipMarker;
		}
		
		public String getShipString() {
			return shipString;
		}
	}
	
	// add ships from enum ship class to array list
	// allows access in ship positioning method
	public void createShipArray(){
		
		shipArray.add(ships.AIRCRAFT.getShipLength()); 
		shipArray.add(ships.BATTLESHIP.getShipLength()); 
		shipArray.add(ships.DESTROYER.getShipLength()); 
		shipArray.add(ships.SUBMARINE.getShipLength()); 
		shipArray.add(ships.PATROL.getShipLength()); 

		System.out.print(shipArray.size());
		System.out.println();
		
		for (int i = 0; i < shipArray.size(); i++) {
		System.out.println(shipArray.get(i));
		}
	}
	
	// method to position ships
	public void positionShips() 
	{
		difficultyInfo();
		createShipArray();
		System.out.println("The board size is " + boardSize);
		
			int shipCounter = 0;
			
			boolean shipOnBoard = false;
			
			
				
				//boolean placeHorizontal = rand.nextBoolean();
				
				//int row = rand.nextInt(boardSize);
				int col = rand.nextInt(boardSize);
				int row = rand.nextInt(boardSize);

				
				for (int j = 0; j < shipArray.size();j++) {

					for (int i = 0; i < shipArray.get(j); i++) {
					gameBoard[row][i+1] = 'A';		
					System.out.println("j = " + j);
				
					}
					row = rand.nextInt(boardSize);

				}
			
			
				/*
				for (int j = 0; j < ships.BATTLESHIP.getShipLength(); j++) {
					//int row = rand.nextInt(boardSize);
					//int col = rand.nextInt(boardSize);
					gameBoard[j+1][col] = ships.BATTLESHIP.getShipMarker();
				}
			
				for (int j = 0; j < ships.DESTROYER.getShipLength(); j++) {
					//int row = rand.nextInt(boardSize);
					//int col = rand.nextInt(boardSize);
					gameBoard[row][j + 1] = ships.DESTROYER.getShipMarker();
				}
				
				for (int j = 0; j < ships.SUBMARINE.getShipLength(); j++) {
					//int row = rand.nextInt(boardSize);
				//	int col = rand.nextInt(boardSize);
					gameBoard[j+1][col] = ships.SUBMARINE.getShipMarker();
				}
				
				for (int j = 0; j < ships.PATROL.getShipLength(); j++) {
					//int row = rand.nextInt(boardSize);
					//int col = rand.nextInt(boardSize);
					gameBoard[row][j + 1] = ships.PATROL.getShipMarker();
				}
				*/
			
		
	 }
	 


}


		

