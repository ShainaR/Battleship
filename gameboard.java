package battleshipgame;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Gameboard {

	// Declare constants
	String EMPTY_SPACE = "0";
	
	// ships
	private int AIRCRAFT=5;
	private int BATTLESHIP=4;
	private int DESTROYER=3;
	private int SUBMARINE=3;
	private int PATROL=2;
	
	// hits and misses
	private int hits, misses;
	private ArrayList<String> location = new ArrayList<String>();
	private int level;
	private int availableMissiles;
	private int boardSize;
	private char[][] gameBoard;
	
	Random rand = new Random();
	int temp = rand.nextInt(5) + 1;
	
	// Scanner to retain user input
	Scanner input = new Scanner(System.in);
	
	// method to set random location of ships
	public void setShips(ArrayList<String> loc) {
		location = loc;
	}
	
	
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
	
	// method to track score
	public int trackScore(int score) {
		
		return score;
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
	
	// method to set ship info
	
	
	// method to position ships
	
	
	// method to print board
		public void outputGame() 
		{ 
			System.out.print("   ");
			for (int i = 0; i < gameBoard[0].length; i++) {
				System.out.printf("%3d", i+1);
			}
			System.out.println();
			//loop through array's rows
			for (int row = 0; row < gameBoard.length; row++)
			{	
				
				System.out.printf("%3d", row + 1);
				
				// loop through columns of current row
				for (int column = 0; column < gameBoard.length; column++) {
					
					gameBoard[row][column] = '~';
					System.out.printf("%3c", gameBoard[row][column]);
				}
				System.out.println();
			}
		}
	
	public void set(char[][] gameBoard){
		this.gameBoard=gameBoard;
	}
	
	public int missiles(int bombs) {
		bombs = this.availableMissiles;
		return bombs;
	}
	
	public int boardSize(int size) {
		size = this.boardSize;
		return size;
	}
	
	public void run(int x) {
		x = this.level;
		System.out.print(x);
	}
	
	public void printSize(int y) {
		y = this.boardSize;
		System.out.println(y);
	}

