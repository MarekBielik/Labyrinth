/**
 * Card Pack
 * 
 * Autoři:
 * xbieli05
 * xmatus29
 */

package treasure;

import java.io.Serializable;
import java.util.*;

/**
 * Reprezentuje balíček hracích karet.
 * @author xbieli05
 */
public class CardPack implements Serializable{
    /**
     * @param pack a pack of cards
     */
    protected ArrayList<TreasureCard> pack = new ArrayList<TreasureCard>();

    /**
     * Inicializace balíčku parametry maxSize a initSize.
     * Musí platit, že maxSize >= initSize.
     * Karty jsou v balíčku uspořádány vzestupně podle kódu pokladu.
     * @param maxSize
     * @param initSize 
     */
    public CardPack(int maxSize, int initSize) {
        for (int i = 0; i < initSize; i++)
            pack.add(new TreasureCard(Treasure.getTreasure(i)));
    }

    /**
     * Vyjme vrchní kartu z balíčku a vrátí ji.
     * @return 
     */
    public TreasureCard popCard() {
        TreasureCard card = pack.get(0);
        pack.remove(0);
        return card;
    }
    /**
     * Vrací aktuální počet karet v balíčku.
     * @return 
     */
    public int size() {
        return pack.size();
    }
    /**
     * Zamíchá kartami. Po této operaci se změní uspořádání karet v balíčku.
     */
    public void shuffle() {
        Collections.shuffle(pack);
    }
}