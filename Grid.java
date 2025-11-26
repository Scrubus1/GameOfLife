public class Grid {
    Cell[][] grid;

    public Grid(int width, int length) {
        this.grid = new Cell[width][length];
    }

    /** 
     * Iterates through the empty grid and populate it with Cell objects
     */
    public void populateGrid() {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                grid[y][x] = new Cell();
            }
        }
    }
    
    /** 
     * Iterates through the populated grid and changes the state of cells to alive or dead
     * according to the conditions set by Conway's Game Of Life.
     */
    public void nextGeneration() {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                grid[y][x].state = changeState(y, x, countNeighbors(y, x)); 
            }
        }
    }

    /**
     * Iterates through the neighbor (diagonal & orthogonal) cells and counts alive neighbors
     * @param y Index of row array within grid
     * @param x Index of element within row array
     * @return Returns the number of alive neighbors
     */
    public int countNeighbors(int y, int x) {
        int neighbors = 0;
        // Searches adjacent cells, checks their state, and keeps count of how many neighbors are alive
        // Uses ternary operators to exclude search values outside of the grid 
        for (int searchRow = (y == 0 ? 0 : -1); searchRow <= (y == 19 ? 0 : 1); searchRow++) {
            for (int searchCol = (x == 0 ? 0 : -1); searchCol <= (x == 19 ? 0 : 1); searchCol++) {
                if (grid[y+searchRow][x+searchCol].state == 1 && (searchRow != 0 || searchCol != 0)) {
                    neighbors += 1;
                }
            }
        }
        return neighbors;
    }


    /**
     * Checks the specififed cell for its state and determines if it should be alive or dead according to the rules of the Game of Life
     * @param y Index of row array within grid
     * @param x Index of element within row array
     * @param neighbors Number of alive neighbors
     * @return Returns the desired state of the cell specified
     */
    public int changeState(int y, int x, int neighbors) {
        if (grid[y][x].state == 1 && (neighbors == 2 || neighbors == 3)) {
            return 1;
        }
        else if (grid[y][x].state == 1 && (neighbors < 2 || neighbors > 3)) {
            return 0;
        } 
        else if (grid[y][x].state == 0 && neighbors == 3 ) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void seedGrid(int y, int x) {
        grid[y][x].state = 1;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                builder.append(cell).append("  ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Grid board = new Grid(20, 20);
        board.populateGrid();
        board.seedGrid(0, 0);
        board.seedGrid(0, 19);
        board.seedGrid(1, 0);
        
        System.out.println(board);
        board.nextGeneration();
        System.out.println(board);
        board.nextGeneration();
        System.out.println(board);
    }

}
