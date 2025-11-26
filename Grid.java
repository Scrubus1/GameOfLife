public class Grid {
    Cell[][] grid;

    public Grid(int width, int length) {
        this.grid = new Cell[width][length];
    }

    public void populateGrid() {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                grid[y][x] = new Cell();
            }
        }
    }
    
    public void nextGeneration() {
        int neighbors;
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                neighbors = 0;
                if (y == 0) {

                }
                for (int i = (y == 0 ? 0 : -1); i <= (y == 19 ? 0 : 1); i++) {
                    for (int t = (x == 0 ? 0 : -1); t <= (x == 19 ? 0 : 1); t++) {
                        if (grid[y+i][x+t].status == 1) {
                            neighbors += 1;
                        }
                    }
                }

                if (grid[y][x].status == 1 && (neighbors < 2 || neighbors > 3)) {
                    System.out.println(neighbors);
                    grid[y][x].status = 0;
                } 
                else if (grid[y][x].status == 0 && neighbors == 3 ) {
                    grid[y][x].status = 1;
                }
            }
        }
    }

    public void seedGrid(int y, int x) {
        grid[y][x].status = 1;
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
        board.seedGrid(5, 5);
        board.seedGrid(5, 6);
        board.seedGrid(6, 5);
        
        System.out.println(board);
        board.nextGeneration();
        System.out.println(board);
    }

}
