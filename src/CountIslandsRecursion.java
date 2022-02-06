public class CountIslandsRecursion {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 0},
                        {1, 1, 0, 1, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0}};

        int[][] grid2 = {{1, 1, 0, 0, 0},
                         {1, 1, 0, 0, 0},
                         {0, 0, 1, 0, 0},
                         {0, 0, 0, 1, 1}};

        int[][] grid3 = {{0, 1, 0, 1, 1},
                         {1, 1, 0, 1, 1},
                         {0, 0, 1, 0, 0},
                         {0, 0, 0, 1, 1}};

        int[][] grid4 = {{0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0},
                         {0, 0, 0, 0, 0}};

        int[][] grid5 = {{0, 1, 1, 1, 0, 1, 1},
                         {1, 1, 0, 0, 0, 0, 1},
                         {0, 1, 0, 0, 1, 0, 1},
                         {0, 1, 0, 0, 0, 0, 1},
                         {0, 1, 1, 1, 1, 1, 1}};

        System.out.println("grid 1: " + countIslands(grid)); // 1
        System.out.println("grid 2: " + countIslands(grid2)); // 3
        System.out.println("grid 3: " + countIslands(grid3)); // 4
        System.out.println("grid 4: " + countIslands(grid4)); // 0
        System.out.println("grid 5: " + countIslands(grid5)); // 2
    }

    private static void exploreIsland(int row, int col, int[][] grid) {

        if(row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] == 0) {
            return;
        }

        if(grid[row][col] == 1) {
            grid[row][col] = 0;
            exploreIsland(row, col+1, grid); // check right
            exploreIsland(row+1, col, grid); // check below
            exploreIsland(row, col-1, grid); // check left
            exploreIsland(row-1, col, grid); // check top
        }
    }

    public static int countIslands(int[][] grid) {
        int numberOfIslands = 0;

        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid[row].length; column++) {
                int currentPosition = grid[row][column];

                if(currentPosition != 0) {
                    exploreIsland(row, column, grid);
                    numberOfIslands++;
                }

            }
        }
        return numberOfIslands;
    }
}
