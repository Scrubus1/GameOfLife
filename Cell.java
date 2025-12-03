public class Cell {

    int state;

    public Cell() {
        state = 0;
    }

    @Override
    public String toString() {
        return state == 0 ? "." : String.valueOf(state);
    }
    
}
