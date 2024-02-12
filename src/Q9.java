import java.util.Stack;

enum DIRECTION {NORTH, SOUTH, EAST, WEST}
public class Q9 {
    public static void display(int[][] image)
    {
        for (int x = 0; x < image.length; x++) {
            for (int y = 0; y < image[0].length; y++) {
                System.out.printf("%4d", image[x][y]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create Maze
        int[][] maze = new int[10][10];
        maze[0] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        maze[1] = new int[]{1, 0, 0, 0, 0, 1, 1, 1, 0, 1};
        maze[2] = new int[]{1, 1, 1, 1, 0, 0, 0, 0, 0, 1};
        maze[3] = new int[]{1, 1, 1, 1, 0, 1, 1, 1, 0, 1};
        maze[4] = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 1};
        maze[5] = new int[]{1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        maze[6] = new int[]{1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
        maze[7] = new int[]{1, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        maze[8] = new int[]{1, 1, 0, 1, 1, 0, 1, 1, 1, 1};
        maze[9] = new int[]{1, 1, 0, 1, 1, 1, 1, 1, 1, 1};
        //display(maze);

        // Stack for paths to take and paths already taken
        Stack<DirectionPair> pathsToTake = new Stack<>();
        Stack<DirectionPair> pathsTaken = new Stack<>();
        // Change x and y to choose starting location
        int x = 5;
        int y = 4;
        // West
        if (x > 0 && maze[y][x - 1] == 0) {
            pathsToTake.push(new DirectionPair(x, y, DIRECTION.WEST));
        }
        // South
        if (y < 9 && maze[y + 1][x] == 0) {
            pathsToTake.push(new DirectionPair(x, y, DIRECTION.SOUTH));
        }
        // East
        if (x < 9 && maze[y][x + 1] == 0) {
            pathsToTake.push(new DirectionPair(x, y, DIRECTION.EAST));
        }
        // North
        if (y > 0 && maze[y - 1][x] == 0) {
            pathsToTake.push(new DirectionPair(x, y, DIRECTION.NORTH));
        }
        boolean foundExit = false;

        while (!pathsToTake.isEmpty() && !foundExit) {
            DirectionPair currentCell = pathsToTake.pop();
            while (pathsTaken.contains(currentCell) && !pathsToTake.isEmpty()) {
                currentCell = pathsToTake.pop();
                //System.out.println("Path already taken");
            }
            pathsTaken.push(currentCell);
            x = currentCell.getX();
            y = currentCell.getY();
            DIRECTION direction = currentCell.getDirection();
            boolean inter = false;
            boolean deadEnd = false;

            //System.out.println(pathsToTake);
            //System.out.println(pathsTaken);
            //System.out.println(currentCell);
            System.out.printf("Heading %s from (%d, %d):\n", direction, x, y);

            if (direction == DIRECTION.WEST) {
                while (!inter && !deadEnd && !foundExit) {
                    x -= 1;
                    maze[y][x] = 2;
                    System.out.printf("\nAt (%d, %d)\n", x, y);
                    display(maze);
                    maze[y][x] = 0;
                    if (x > 0) {
                        // South
                        if (y < 9 && maze[y + 1][x] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.SOUTH));
                            inter = true;
                            System.out.println("Found path south");
                        }
                        // North
                        if (y > 0 && maze[y - 1][x] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.NORTH));
                            inter = true;
                            System.out.println("Found path north");
                        }
                        // West
                        if (maze[y][x - 1] == 0 && inter) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.WEST));
                            System.out.println("Path continues west");
                        } else if (maze[y][x - 1] == 1) {
                            deadEnd = true;
                            System.out.println("End of Path");
                        }
                    } else {
                        foundExit = true;
                    }
                }
            } else if (direction == DIRECTION.SOUTH) {
                while (!inter && !deadEnd && !foundExit) {
                    y += 1;
                    maze[y][x] = 2;
                    System.out.printf("\nAt (%d, %d)\n", x, y);
                    display(maze);
                    maze[y][x] = 0;
                    if (y < 9) {
                        // West
                        if (x > 0 && maze[y][x - 1] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.WEST));
                            inter = true;
                            System.out.println("Found path west");
                        }
                        // East
                        if (x < 9 && maze[y][x + 1] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.EAST));
                            inter = true;
                            System.out.println("Found path east");
                        }
                        // South
                        if (maze[y + 1][x] == 0 && inter) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.SOUTH));
                            System.out.println("Path continues south");
                        } else if (maze[y + 1][x] == 1) {
                            deadEnd = true;
                            System.out.println("End of Path");
                        }
                    } else {
                        foundExit = true;
                    }
                }
            } else if (direction == DIRECTION.EAST) {
                while (!inter && !deadEnd && !foundExit) {
                    x += 1;
                    maze[y][x] = 2;
                    System.out.printf("\nAt (%d, %d)\n", x, y);
                    display(maze);
                    maze[y][x] = 0;
                    if (x < 9) {
                        // South
                        if (y < 9 && maze[y + 1][x] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.SOUTH));
                            inter = true;
                            System.out.println("Found path south");
                        }
                        // North
                        if (y > 0 && maze[y - 1][x] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.NORTH));
                            inter = true;
                            System.out.println("Found path north");
                        }
                        // East
                        if (maze[y][x + 1] == 0 && inter) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.EAST));
                            System.out.println("Path continues east");
                        } else if (maze[y][x + 1] == 1) {
                            deadEnd = true;
                            System.out.println("End of Path");
                        }
                    } else {
                        foundExit = true;
                    }
                }
            } else if (direction == DIRECTION.NORTH) {
                while (!inter && !deadEnd && !foundExit) {
                    y -= 1;
                    maze[y][x] = 2;
                    System.out.printf("\nAt (%d, %d)\n", x, y);
                    display(maze);
                    maze[y][x] = 0;
                    if (y > 0) {
                        // West
                        if (x > 0 && maze[y][x - 1] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.WEST));
                            inter = true;
                            System.out.println("Found path west");
                        }
                        // East
                        if (x < 9 && maze[y][x + 1] == 0) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.EAST));
                            inter = true;
                            System.out.println("Found path east");
                        }
                        // South
                        if (maze[y - 1][x] == 0 && inter) {
                            pathsToTake.push(new DirectionPair(x, y, DIRECTION.NORTH));
                            System.out.println("Path continues north");
                        } else if (maze[y - 1][x] == 1) {
                            deadEnd = true;
                            System.out.println("End of Path");
                        }
                    } else {
                        foundExit = true;
                    }
                }
            }
            System.out.println();
        }
        if (foundExit) {
            System.out.printf("Found Exit at (%d, %d)\n", x, y);
        } else {
            System.out.println("No exit was found");
        }
    }
}
