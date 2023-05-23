// Programmer: Adam Curtin
// CS 145 Java
// Date: 5/19/2023
// Assignment: Word Search Puzzle
// Purpose: Provides utility methods for managing the word search puzzle
// Handles and validates user input, displays menu options and instructions. 

package puzzleAssignmentbyAdam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ACManagePuzzle {
    public static List<String> getUserWords(Scanner scanner) {
        System.out.println("Enter 5 words to be placed in the word search.");

        List<String> userWords = new ArrayList<>();
        // set to 5 words. Adjust to user choice if time allows
        for (int i = 1; i <= 5; i++) {
            System.out.print("Word " + i + ": ");
            String line = scanner.nextLine().trim();

            // check if word length exceeds maximum allowed length
            if (line.length() > 18) { // Adjust the maximum word length as needed
                System.out.println("Word is too long. Please enter a word with fewer than 18 characters.");
                i--; // Decrement i to repeat the loop for the same word index
                continue; // Skip to the next iteration of the loop
            } // end if greater than 18

            // Validate user input contains A-Z chars
            while (line.isEmpty() || !line.matches("[a-zA-Z]+")) {
                System.out.println("Invalid input. Please enter a valid word.");
                System.out.print("Word " + i + ": ");
                line = scanner.nextLine().trim();
            } // end while
            userWords.add(line.toUpperCase());
        } // end for 1-5
        return userWords;
    } // end get userWords
    
    // print the menu options for the user
    public static void printMenu() {
        System.out.println("\nMENU:");
        System.out.println("G - Generate a puzzle");
        System.out.println("P - Print the puzzle");
        System.out.println("S - See the solution");
        System.out.println("Q - Quit");
        System.out.print("Enter your choice: ");
    } // end printMenu

    // display instructions to the user
    public static void instructions() {
        System.out.println("Hello and welcome to my word search generator");
        System.out.println("Words will be hidden up, down, left, right, diagonal, even backwards!");
        System.out.println("You may choose from these options.");
        System.out.println("Please Generate puzzle before trying to print");
    } // end instructions
    
} // end ACManagePuzzle





