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
    public boolean equals (Object o) {
        if (o == this)
            return true;

        if (!(o instanceof TreasureCard))
            return false;

        TreasureCard card = (TreasureCard) o;

        return card.treasure == treasure;
    }
}
