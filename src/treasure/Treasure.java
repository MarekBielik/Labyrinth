package treasure;

import java.io.Serializable;

/**
 * @author xbieli05
 */
public class Treasure implements Serializable {

    public final int code;

    protected final static int SIZE_OF_SET = 24;

    public static Treasure [] treasureSet;
    

    public Treasure(int code) {

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
