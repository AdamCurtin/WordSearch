// Programmer: Adam Curtin
// CS 145 Java
// Date: 5/19/2023
// Assignment: Word Search Puzzle
// Purpose: Test Class. Responsible for main execution of word search puzzle program.
// Handles user input, menu options, and interaction with other classes.

package puzzleAssignmentbyAdam;

import java.util.Scanner;
import java.util.List;


public class ACPuzzleMain {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        ACWordSearchPuzzle puzzle = new ACWordSearchPuzzle();

        ACManagePuzzle.instructions();

        boolean running = true;
        while (running) {
        	// Display menu options
            ACManagePuzzle.printMenu();
            char choice = scanner.nextLine().toUpperCase().charAt(0);
            
            // Generate, Print, Solve, Quit program options.
            switch (choice) {
                case 'G':
                    System.out.println("\nGenerating puzzle...");
                    List<String> userWords = ACManagePuzzle.getUserWords(scanner);
                    puzzle.generatePuzzle(userWords);
                    break;
                case 'P':
                    puzzle.printPuzzle();
                    break;
                case 'S':
                    puzzle.printSolution();
                    break;
                case 'Q':
                    running = false;
                    break;
                default:
                    System.out.println("\nInvalid choice. \nPlease type [G][P][S]or[Q].");
                    break;
            } // end switch case
        } // end while running loop
        scanner.close();
        System.out.println("\nThank you for playing!");
    } // end main method

} // end ACPuzzleMain




