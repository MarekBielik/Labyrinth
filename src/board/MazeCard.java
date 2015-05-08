package board;

import java.util.*;
import java.lang.*;

import static board.MazeCard.CANGO.*;

public class MazeCard {

    public enum CANGO {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }

     List<CANGO> ways;

    protected MazeCard(CANGO... ways) {
        this.ways = new Vector<>();

        for (CANGO way : ways)
            this.ways.add(way);
    }

    public boolean contains(CANGO... ways) {
        List<CANGO> waysSet = new Vector<>(Arrays.asList(ways));

        if (waysSet.size() == this.ways.size())
            return this.ways.containsAll(waysSet);
        else
            return false;
    }

    public static MazeCard create (String type) throws IllegalArgumentException {

        switch (type) {
            case "C":
                return new MazeCard(LEFT, UP);
                
            case "C1":
                return new MazeCard(DOWN, LEFT);
                                
            case "C2":
                return new MazeCard(RIGHT, DOWN);
                                                
            case "C3":
                return new MazeCard(RIGHT, UP);

            case "L":
                return new MazeCard(LEFT, RIGHT);
            
            case "L1":
                return new MazeCard(UP, DOWN);
            
            case "F":
                return new MazeCard(LEFT, UP, RIGHT);

            case "F1":
                return new MazeCard(LEFT, DOWN, RIGHT);
            
            case "F2":
                return new MazeCard(LEFT, UP, DOWN);
            
            case "F3":
                return new MazeCard(DOWN, UP, RIGHT);
            
            default:
                throw new IllegalArgumentException();
        }
    }

    public boolean canGo(MazeCard.CANGO dir) {

        return this.ways.contains(dir);
    }

    private CANGO nextRight(CANGO way) throws IllegalArgumentException {
        switch(way) {
            case LEFT:
                return UP;

            case UP:
                return RIGHT;

            case RIGHT:
                return DOWN;

            case DOWN:
                return LEFT;

            default:
                throw new IllegalArgumentException();
        }
    }

    public void turnRight() {
        ListIterator<CANGO> i = ways.listIterator();
        CANGO way;

        while (i.hasNext()) {
            way = i.next();
            i.set(nextRight(way));
        }
    }
}
