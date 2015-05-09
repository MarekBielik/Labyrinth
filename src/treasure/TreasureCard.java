package treasure;

import java.io.Serializable;

/**
 * @author xbieli05
 */
public class TreasureCard implements Serializable {

    public Treasure treasure;
    
 
    public TreasureCard(Treasure tr) {

        treasure = tr;
    }

    @Override
    public boolean equals (Object testCard) {
        if (testCard == this)
            return true;

        if (!(testCard instanceof TreasureCard))
            return false;

        TreasureCard card = (TreasureCard) testCard;

        return card.treasure == treasure;
    }
}
