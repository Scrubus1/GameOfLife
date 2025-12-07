import java.util.ArrayList;

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
                grid[y][x].isAlive = changeState(y, x, countNeighbors(y, x)); 
            }
        }
    }

    /**
     * Iterates through the neighbor (diagonal & orthogonal) cells and counts alive neighbors
     * @param y Index of row array within grid
     * @param x Index of element within row array
     * @return Returns the number of alive neighbors
     */
    public ArrayList<Cell> countNeighbors(int y, int x) {
        ArrayList<Cell> neighbors = new ArrayList<>();
        // Searches adjacent cells, checks their state, and keeps count of how many neighbors are alive
        // Uses ternary operators to exclude search values outside of the grid 
        for (int searchRow = (y == 0 ? 0 : -1); searchRow <= (y == 19 ? 0 : 1); searchRow++) {
            for (int searchCol = (x == 0 ? 0 : -1); searchCol <= (x == 19 ? 0 : 1); searchCol++) {
                if (grid[y+searchRow][x+searchCol].isAlive && (searchRow != 0 || searchCol != 0)) {
                    neighbors.add(grid[y + searchRow][x + searchCol]);
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
    public boolean changeState(int y, int x, ArrayList<Cell> neighbors) {
        int neighborCount = neighbors.size();
        if (grid[y][x].isAlive && (neighborCount == 2 || neighborCount == 3)) {
            return true;
        }
        else if (grid[y][x].isAlive && (neighborCount < 2 || neighborCount > 3)) {
            return false;
        } 
        else if (grid[y][x].isAlive == false && neighborCount == 3 ) {
            neighbors.remove((int) (Math.random() * 3));
            grid[y][x].dna.matchPairs(neighbors.get(0).dna, neighbors.get(1).dna);
            return true;
        }
        else {
            return false;
        }
    }

    public void seedGrid() {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                if ((int) (Math.random() * 7) == 0) {
                    grid[y][x].isAlive = true;
                }
            }
        }
    }

    public int cellsAlive() {
        int count = 0;
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (grid[y][x].isAlive) {
                    count++;
                }
            }
            
        }
        return count;
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
}