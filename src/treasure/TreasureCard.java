package treasure;

/**
 * @author xbieli05
 */
public class TreasureCard {

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
