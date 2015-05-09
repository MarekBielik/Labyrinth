package treasure;

import java.io.Serializable;
import java.util.*;

/**
 * @author xbieli05
 */
public class CardPack implements Serializable{
    /**
     * @param pack a pack of cards
     */
    protected ArrayList<TreasureCard> pack = new ArrayList<TreasureCard>();


    public CardPack(int maxSize, int initSize) {
        for (int i = 0; i < initSize; i++)
            pack.add(new TreasureCard(Treasure.getTreasure(i)));
    }


    public TreasureCard popCard() {
        TreasureCard card = pack.get(0);
        pack.remove(0);
        return card;
    }

    public int size() {
        return pack.size();
    }

    public void shuffle() {
        Collections.shuffle(pack);
    }
}