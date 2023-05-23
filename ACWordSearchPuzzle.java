// Programmer: Adam Curtin
// CS 145 Java
// Date: 5/19/2023
// Assignment: Word Search Puzzle
// Purpose: Represents the word search puzzle itself. Generates the grid,
//  places words in grid, contains methods for printing puzzle and solution.


package puzzleAssignmentbyAdam;

import java.util.List;

public class ACWordSearchPuzzle {
    private char[][] randomGrid;
    private char[][] solutionGrid;

    // method to generate the puzzle
    public void generatePuzzle(List<String> userWords) throws Exception {
    	// Solved Grid
        solutionGrid = generateSolutionGrid(userWords);
        // Random grid based on solved grid
        randomGrid = generateRandomGrid(solutionGrid);
    } // end generatePuzzle

    // method to print puzzle if it has been generated
    // else print message telling user to generate first
    public void printPuzzle() {
        if (randomGrid != null) {
            System.out.println("\nPuzzle:");
            printGrid(randomGrid);
        } else {
            System.out.println("\nPlease generate a puzzle first.");
        } // end if else
    } // end printPuzzle

    // Print the solved puzzle if it has been generated.
    // else print message telling user what to do.
    public void printSolution() {
        if (solutionGrid != null) {
            System.out.println("\nSolution:");
            printGrid(solutionGrid);
        } else {
            System.out.println("\nPlease generate a puzzle first.");
        } // end if else
    } // end printSolution

    // method to generate the solution grid based on user words
    private static char[][] generateSolutionGrid(List<String> words) throws Exception {
    	// create new grid for solution
        char[][] solutionGrid = createEmptyGrid();

        // for each word provided by the user
        for (String word : words) {
            boolean placed = false;

            // While not placed, keep trying to place until successfully placed
            while (!placed) {
                int row = getRandomStartingRow(solutionGrid.length, word.length());
                int col = getRandomStartingColumn(solutionGrid[0].length, word.length());
                int orientation = getRandomOrientation();

                // Check if word can be placed in current position and orientation
                if (canPlaceWord(solutionGrid, word, row, col, orientation)) {
                    placeWord(solutionGrid, word, row, col, orientation);
                    placed = true;
                }
            }

            // If word can't be placed in any position, throw exception
            if (!placed) {
                throw new Exception("Failed to place the word: " + word);
            }
        }

        return solutionGrid;
    } // end generateSolutionGrid

    // Create an empty grid filled with '-' to indicate empty cells
    private static char[][] createEmptyGrid() {
        char[][] grid = new char[12][18];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '-';
            } // end inner for
        } // end outer for
        return grid;
    } // end createEmptyGrid

    // Get a random starting row for word placement
    private static int getRandomStartingRow(int numRows, int wordLength) {
        return (int) (Math.random() * (numRows - wordLength + 1));
    } // end getRandomStartingRow

    // Get random starting column for placing word
    private static int getRandomStartingColumn(int numCols, int wordLength) {
        return (int) (Math.random() * (numCols - wordLength + 1));
    } // end getRandomStartingColumn

    // Get random orientation for placing word
    // 0 is Horizontal, 1 is Vertical, 2 is Diagonal
    private static int getRandomOrientation() {
        return (int) (Math.random() * 3);
    } // end getRandomOrientation

    // Check if word can be placed in given position and orientation
    private static boolean canPlaceWord(char[][] grid, String word, int row, int col, int orientation) {
        int wordLength = word.length();

        if (orientation == 0) {
        	// Check if there are no conflicts with existing characters in the grid
            for (int i = 0; i < wordLength; i++) {
                if (grid[row][col + i] != '-' && grid[row][col + i] != word.charAt(i)) {
                    return false;
                }
            }
        } else if (orientation == 1) {
        	// Check if there are no conflicts with existing characters in the grid
            for (int i = 0; i < wordLength; i++) {
                if (grid[row + i][col] != '-' && grid[row + i][col] != word.charAt(i)) {
                    return false;
                }
            }
        } else if (orientation == 2) {
        	// Check if there are no conflicts with existing characters in the grid
            for (int i = 0; i < wordLength; i++) {
                if (grid[row + i][col + i] != '-' && grid[row + i][col + i] != word.charAt(i)) {
                    return false;
                } // end if
            } // end for
        } // end else if

        return true;
    } // end canPlaceWord

    // Place word in grid at given position and orientation
    private static void placeWord(char[][] grid, String word, int row, int col, int orientation) {
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (orientation == 0) {
                grid[row][col + i] = character;
            } else if (orientation == 1) {
                grid[row + i][col] = character;
            } else {
                grid[row + i][col + i] = character;
            } // end if else if else
        } // end for
    } // end placeWord

    // Generate a random grid based on solution grid
    private static char[][] generateRandomGrid(char[][] solutionGrid) {
        char[][] randomGrid = new char[12][18];

        // Copy the solution grid to random grid
        for (int i = 0; i < solutionGrid.length; i++) {
            System.arraycopy(solutionGrid[i], 0, randomGrid[i], 0, solutionGrid[i].length);
        } // end for

        // Replace empty cells with random chars
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                if (randomGrid[i][j] == '-') {
                    randomGrid[i][j] = (char) ('A' + (int) (Math.random() * 26));
                } // end if
            } // end inner for
        } // end outer for

        return randomGrid;
    } // end generateRandomGrid

    // print the grid
    private static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            } // end inner for
            System.out.println();
        } // end outer for
    } // end printGrid
} // end ACWordSearchPuzzle


