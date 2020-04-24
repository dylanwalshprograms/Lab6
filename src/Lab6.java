import java.util.Random;
import java.util.Scanner;

public class Lab6 {
	
	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		int numRolls = 1;
		welcomeMessage();
		int userInt = dieSides();
		do {
			promptEnterKey();
			diceRoller(userInt, numRolls);
			numRolls++;
		} while (doesUserWantToContinue());
		System.out.println("Goodbye!");
	}
	
	public static void welcomeMessage() {
		System.out.println("Welcome to Grand Circus Casino!");
		System.out.println();	
	}
	
	public static int dieSides() {
		System.out.println("How many sides should each die have?");
		return scnr.nextInt();
	}
	
	public static void diceRoller(int userInt, int numRolls) {
		int dieOne = generateRandomDieRoll(userInt);
		int dieTwo = generateRandomDieRoll(userInt);
		System.out.println("Roll " + numRolls + ":");
		System.out.println(dieOne);
		System.out.println(dieTwo);
		if (dieOne == 1 && dieTwo == 1) {
			System.out.println("Snake Eyes!");
		}
		else if (dieOne + dieTwo == 3) {
			System.out.println("Ace Deuce");
		}
		else if (dieOne + dieTwo == 7) {
			System.out.println("Natural");
		}
		else if (dieOne + dieTwo == 11) { 
			System.out.println("Yo");
		}
		else if (dieOne == 6 && dieTwo == 6) { // i could keep doing these but imma go to bed
			System.out.println("Box cars");
		}
		System.out.println();
	}
	
	public static int generateRandomDieRoll(int userInt) {
		Random randGen = new Random();
		return randGen.nextInt(userInt) + 1;
	}
	
	public static void promptEnterKey() {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Press \"ENTER\" to roll the dice:");
		scnr.nextLine();
	}
	
	private static boolean doesUserWantToContinue() {
		System.out.print("Roll again? (y/n): ");
		return scnr.next().startsWith("y");
	}
}
