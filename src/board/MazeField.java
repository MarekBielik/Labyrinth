package board;

import treasure.TreasureCard;

public class MazeField {

    int row, col;
    MazeCard mazeCard;
    TreasureCard treasureCard;

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
    
    public TreasureCard getTreasureCard() {
        return treasureCard;
    }
    
    public void putTreasureCard (TreasureCard treasureCard) {
        this.treasureCard = treasureCard;
    }

}
