package board;

public class MazeField {

    int row, col;
    MazeCard C;

    public MazeField(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public MazeCard getCard() {
        return C;
    }

    public void putCard(MazeCard C) {
        this.C = C;
    }

}
