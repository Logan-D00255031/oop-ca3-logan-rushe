import java.util.ArrayDeque;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {

        // Create Grid
        int[][] grid = new int[10][10];
        grid[0] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        grid[1] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        grid[2] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        grid[3] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        grid[4] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        grid[5] = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        grid[6] = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        grid[7] = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        grid[8] = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        grid[9] = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        //System.out.println(test[6][5]);

        // Get starting x and y from user
        Scanner start = new Scanner(System.in);
        System.out.print("Start X: ");
        int x = start.nextInt();
        System.out.print("Start Y: ");
        int y = start.nextInt();
        //System.out.println(x + ", " + y);

        // Create stack and push the staring point to the stack
        ArrayDeque<Pair> cellsToVisit = new ArrayDeque<>();
        cellsToVisit.push(new Pair(x, y));

        // Start count at 1
        int count = 1;

        // Loop until the stack is empty
        while (!cellsToVisit.isEmpty()) {
            // Get current cell from top of stack
            Pair currentCell = cellsToVisit.pop();
            // Set x and y to the cell's x and y
            x = currentCell.getX();
            y = currentCell.getY();

            //System.out.println(cellsToVisit);
            //System.out.println(currentCell);

            // Check if current cell has already been filled
            if(grid[x][y] == 0) {
                // Set the current cell to the count
                grid[x][y] = count;
                // Increase the count
                count++;
            }
            // End loop if already filled
            else {
                break;
            }

            // West is not filled
            if (x > 0 && grid[x - 1][y] == 0) {
                cellsToVisit.push(new Pair(x - 1, y));
            }
            // South is not filled
            if (y > 0 && grid[x][y - 1] == 0) {
                cellsToVisit.push(new Pair(x, y - 1));
            }
            // East is not filled
            if (x < 9 && grid[x + 1][y] == 0) {
                cellsToVisit.push(new Pair(x + 1, y));
            }
            // North is not filled
            if (y < 9 && grid[x][y + 1] == 0) {
                cellsToVisit.push(new Pair(x, y + 1));
            }
        }

        // Display Grid
        System.out.println();
        System.out.println("After Fill:");
        for (int i = 0; i < grid.length; i++) {
            for (int[] ints : grid) {
                System.out.print(ints[9 - i]);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
