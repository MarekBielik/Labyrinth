package treasure;

/**
 * @author xbieli05
 */
public class Treasure {

    protected final int code;

    protected final static int SIZE_OF_SET = 24;

    protected static Treasure [] treasureSet;

    private Treasure(int code) {

        this.code = code;
    }

    public static void createSet() {

        treasureSet = new Treasure[SIZE_OF_SET];

        for (int i = 0; i < SIZE_OF_SET; i++)
            treasureSet[i] = new Treasure(i);
    }

    public static Treasure getTreasure(int code) {

        if (code >= SIZE_OF_SET)
            return null;
        else
            return treasureSet[code];
    }
}