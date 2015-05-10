package board;

import java.util.*;
import java.lang.*;

import static board.MazeCard.CANGO.*;
import java.io.Serializable;
import treasure.TreasureCard;

/**
 * Reprezentuje jeden kámen, který se umisťuje na políčka hrací plochy.
 * Kámen uchovává informaci o cestě, tj. směrech, kudy lze kámen opustit.
 * @author Luboš
 */
public class MazeCard implements Serializable {
    /**
     * Vnořený výčtový typ.
     * Definuje čtyři hodnoty reprezentující směr, kudy lze opustit kámen.
     */
    public enum CANGO {
        LEFT,
        UP,
        RIGHT,
        DOWN
    }
    
    /**
     * treasure card stored on this mazecard
     */
    public TreasureCard treasureCard;
    
    /**
     * ways stored in card
     */
     List<CANGO> ways;
     
    /**
     * Vrátí kartu s pokladem.
     * @return 
     */
    public TreasureCard getTreasureCard() {
        return treasureCard;
    }
    
    /**
     * Vloží kartu s pokladem.
     * @param treasureCard 
     */
    public void putTreasureCard (TreasureCard treasureCard) {
        this.treasureCard = treasureCard;
    }     
    /**
     * Odstraní kartu s pokladem.
     */
    public void removeTreasureCard () {
        this.treasureCard = null;
    }

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
    /**
     * Vyzvoří kámen podle zadaného typu (C, L, F).
     * @param type
     * @return
     * @throws IllegalArgumentException 
     */
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
    /**
     * Vrací informaci (true or false), zda je možné opustit kámen daným směrem.
     * @param dir
     * @return 
     */
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
    /**
     * Otočí kámen o 90 stupňů doprava.
     */
    public void turnRight() {
        ListIterator<CANGO> i = ways.listIterator();
        CANGO way;

        while (i.hasNext()) {
            way = i.next();
            i.set(nextRight(way));
        }
    }
}
