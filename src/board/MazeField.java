package board;

import treasure.TreasureCard;

public class MazeField {

    public int row, col;
    public MazeCard mazeCard;

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
        return mazeCard;
    }

    public void putCard(MazeCard mazeCard) {
        this.mazeCard = mazeCard;
    }
    
}
