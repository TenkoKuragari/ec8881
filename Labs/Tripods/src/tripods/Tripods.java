package tripods;

import sort.QuickSort;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * A program that finds the optimal placement of a number of tripods in an
 * N * M grid of numbers.  A tripod can touch three adjacent cells, based on orientation,
 * e.g. a north facing tripod touches the east, south and west cells.
 *
 * The goal is to find the placement of a number of tripods, such that the
 * total sums of the cells that all combined tripods touch is maximum.
 *
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class Tripods {
    /** there are 4 corners where a tripod cannot be placed in any direction */
    public final static int CORNERS = 4;
    /** when the number of cells exceeds this number it won't be displayed to standard output */
    public final static int MAX_CELLS_TO_DISPLAY = 10000;

    /**
     * Read the 2-D number grid into a 2 dimension native array. This method should
     * print the following to standard output:
     *
     * Rows: #, Columns: #
     *
     * @param filename the file with the number grid
     * @return the newly created 2-D native array of numbers
     * @throws IOException if the file cannot be found or there is an error reading
     */
    public static int[][] loadGrid(String filename) throws IOException {
        File file = new File(filename);
        Scanner bob = new Scanner(file);
        int [][] grid = new int[0][0];
        int rowNumber = -1;
        while (bob.hasNextLine()) {
            String line = bob.nextLine();
            String[] gridinfo = line.split(" ");
            if (rowNumber == -1) {
                grid = new int[Integer.parseInt(gridinfo[0])][Integer.parseInt(gridinfo[1])];
                System.out.println("Rows: " + gridinfo[0] + ", Columns: " + gridinfo[1]);
            } else {
                int columnNumber = 0;
                for (String x : gridinfo) {
                    grid[rowNumber][columnNumber] = Integer.parseInt(x);
                    columnNumber++;
                }
            }
            rowNumber++;
        }
        return grid;
    }

    /**
     * Get the number of rows in the grid.
     *
     * @param grid the 2-D grid of numbers
     * @return number of rows
     */
    public static int getNumRows(int[][] grid) {
        return grid.length;
    }

    /**
     * Get the number of columns in the grid.
     *
     * @param grid the 2-D grid of numbers
     * @return number of columns
     */
    public static int getNumColumns(int[][] grid) {
        return grid[0].length;
    }

    /**
     * Get the maximum number of tripods that could be placed on the board.
     * A tripod cannot be placed in any of the four corners of the grid in
     * any orientation.
     *
     * @param grid the 2-D grid of numbers
     * @return the maximum number of tripods that can placed in the grid
     */
    public static int getMaxTripods(int[][] grid) {
        return getNumRows(grid) * getNumColumns(grid) - CORNERS;
    }

    /**
     * Display the grid to standard output, only if the number of cells is less
     * than or equal to MAX_CELLS_TO_DISPLAY.  If that size exceeds, print
     * "Too many cells to display" instead.  For example with tripods-3.txt:
     *
     *  0 3 7 9
     *  2 5 1 4
     *  3 3 2 1
     *  4 6 8 4
     *  4 1 2 0
     *
     * @param grid the 2-D grid of numbers
     */
    public static void displayGrid(int[][] grid) {
        if (getNumRows(grid) * getNumColumns(grid) > MAX_CELLS_TO_DISPLAY) {
            System.out.println("Too many cells to display");
        } else {
            for (int[] smallList : grid) {
                String oneRow = "";
                for (int number : smallList) {
                    oneRow += number + " ";
                }
                System.out.println(oneRow.substring(0, oneRow.length() - 1));
            }
        }
    }

    /**
     * A spot is valid if the tripod can be placed in the cell at (row, col),
     * taking into account the direction of the tripod and the location of its
     * three legs.
     *
     * @param grid the 2-D grid of numbers
     * @param row tripod's row (centered)
     * @param col tripod's column (centered)
     * @param dir the direction the tripod is facing
     * @return whether the tripod can be placed in the spot or not
     */
    public static boolean isSpotValid(int[][] grid, int row, int col, Direction dir) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (dir == Direction.NORTH) {
            if (row - 1 < 0) {
                return false;
            } else if (col - 1 < 0 || col + 1 >= columns) {
                return false;
            } else {
                return true;
            }
        } else if (dir == Direction.EAST) {
            if (col + 1 >= columns) {
                return false;
            } else if (row - 1 < 0 || row + 1 >= rows) {
                return false;
            } else {
                return true;
            }
        } else if (dir == Direction.SOUTH) {
            if (row + 1 >= rows) {
                return false;
            } else if (col - 1 < 0 || col + 1 >= columns) {
                return false;
            } else {
                return true;
            }
        } else if (dir == Direction.WEST) {
            if (col - 1 < 0) {
                return false;
            } else if (row - 1 < 0 || row + 1 >= rows) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Given a tripod at a location in the grid and facing a certain direction,
     * sum the numbers in the grid that the three legs of the tripod stand on.
     *
     * @param grid the 2-D grid of numbers
     * @param row tripod's row (centered)
     * @param col tripod's column (centered)
     * @param dir the direction the tripod is facing
     *
     * @rit.pre spot must be valid
     *
     * @return the sum of the tripods legs
     */
    public static int getSum(int[][] grid, int row, int col, Direction dir) {
        int sum = 0;
        if (isSpotValid(grid, row, col, dir))
            if (dir == Direction.NORTH) {
                sum += grid[row - 1][col] + grid[row][col + 1] + grid[row][col - 1];
            } else if (dir == Direction.EAST) {
                sum += grid[row - 1][col] + grid[row + 1][col] + grid[row][col + 1];
            } else if (dir == Direction.SOUTH) {
                sum += grid[row + 1][col] + grid[row][col + 1] + grid[row][col - 1];
            } else if (dir == Direction.WEST) {
                sum += grid[row - 1][col] + grid[row + 1][col] + grid[row][col - 1];
            }
        return sum;
    }

    /**
     * Given a grid, generates the optimal sums of each spot in the grid
     *
     * @param grid the 2-D grid of numbers
     *
     * @rit.pre spot must be valid
     *
     * @return full collection of valid tripod locations
     */
    public static ArrayList<Tripod> generateSums(int[][] grid) {
        ArrayList<Tripod> optimalSum = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int sum = 0;
                Tripod x = new Tripod(0, 0, Direction.NORTH, 0);
                if (getSum(grid, i, j, Direction.NORTH) > sum) {
                    if (isSpotValid(grid, i, j, Direction.NORTH)) {
                        sum = getSum(grid, i, j, Direction.NORTH);
                        x = new Tripod(i, j, Direction.NORTH, sum);
                    }
                }
                if (getSum(grid, i, j, Direction.SOUTH) > sum) {
                    if (isSpotValid(grid, i, j, Direction.SOUTH)) {
                        sum = getSum(grid, i, j, Direction.SOUTH);
                        x = new Tripod(i, j, Direction.SOUTH, sum);
                    }
                }
                if (getSum(grid, i, j, Direction.EAST) > sum) {
                    if (isSpotValid(grid, i, j, Direction.EAST)) {
                        sum = getSum(grid, i, j, Direction.EAST);
                        x = new Tripod(i, j, Direction.EAST, sum);
                    }
                }
                if (getSum(grid, i, j, Direction.WEST) > sum) {
                    if (isSpotValid(grid, i, j, Direction.WEST)) {
                        sum = getSum(grid, i, j, Direction.WEST);
                        x = new Tripod(i, j, Direction.WEST, sum);
                    }
                }
                optimalSum.add(x);
            }
        }
        return optimalSum;
    }

    /**
     * Assuming all the optimal tripods have been sorted by descending
     * sums, display them in order from largest to smallest based on the
     * number of tripods that the user desired. In the end display the tota
     * l sum of them.
     *
     * @param tripods list of Tripod dataclasses
     * @param numTripods number of tripods you want displayed
     */
    public static void displayOptimalPlacements(ArrayList<Tripod> tripods, int numTripods) {
        int sum = 0;
        System.out.println("Optimal placement:");
        for (int i = 0; i < numTripods; i++) {
            Tripod t = tripods.get(i);
            sum += t.sum();
            System.out.println((i + 1) + ": location: " + "(" + t.row() + "," + t.col() + "), direction: " + t.dir() + ", sum: " + t.sum());
        }
        System.out.println("Total sum: " + sum);
    }

    /**
     * The main program takes the file name from the command line.  It then
     * loads the file into a 2-D native array which is then displayed.
     * Next the user is prompted for how many tripods they want for
     * the optimal sum.  If the number of tripods does not exceed the
     * total number that can be placed, the optimal tripods by location
     * are generated, then sorted by descending sum and then displayed
     * to the user.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Tripods filename");
        } else {
            try {
                int[][] grid = loadGrid(args[0]);
                displayGrid(grid);
                System.out.print("Number of tripods: ");
                Scanner jimmy = new Scanner(System.in);
                int tripodAmount = jimmy.nextInt();
                if (tripodAmount <= getMaxTripods(grid)) {
                    ArrayList<Tripod> sortedList = QuickSort.quickSort(generateSums(grid));
                    Collections.reverse(sortedList);
                    displayOptimalPlacements(sortedList, tripodAmount);
                } else {
                    System.out.println("Too many tripods to place!");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
