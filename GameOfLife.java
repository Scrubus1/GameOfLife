public class GameOfLife {
    public static void main(String[] args) throws InterruptedException {
        Grid board = new Grid(40, 40);
        board.populateGrid();
        board.seedGrid();
        System.out.println(board);
        
        while (board.cellsAlive() > 0) { 
            board.nextGeneration();
            System.out.println(board);
            Thread.sleep(500); // Sleep to make the display more legible
        }
    }
}
