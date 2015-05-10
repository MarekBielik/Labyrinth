package board;

import java.io.Serializable;
import treasure.TreasureCard;
/**
 * Reprezentuje políčko na hrací desce.
 * Každé políčko je identifikováno pozicí [row, col], která je nastavena při inicializaci v konstruktoru a dále se nemění (čísluje se od 1). Na políčko je možné umístit hrací kámen.
 * @author Luboš
 */
public class MazeField implements Serializable {

    public int row, col, pomR, pomC;
    public MazeCard mazeCard;

    public MazeField(int row, int col) {
        this.row = row;
        this.col = col;
    }
    /**
     * Vrací číslo řádku.
     * @return 
     */
    public int row() {
        return row;
    }
    /**
     * Vrací číslo sloupce.
     * @return 
     */
    public int col() {
        return col;
    }
    /**
     * Vrací hrací kámen, který je umístěn na políčku. Pokud na políčku žádný kámen neexistuje, vrátí null.
     * @return 
     */
    public MazeCard getCard() {
        return mazeCard;
    }
    /**
     * Vloží kámen na políčko.
     * @param mazeCard 
     */
    public void putCard(MazeCard mazeCard) {
        this.mazeCard = mazeCard;
    }
    
}
