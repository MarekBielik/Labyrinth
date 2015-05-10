package treasure;

import java.io.Serializable;

/**
 * Reprezentuje jeden poklad. Každý poklad je identifikován svým kódem.
 * Kódy se přiděluji vzestupně od hodnoty 0. Každý objekt třídy Treasure je neměnný.
 * Třída obsahuje na statické úrovni pole uchovávající vygenerovaný set pokladů.
 * @author xbieli05
 */
public class Treasure implements Serializable {

    public final int code;

    protected final static int SIZE_OF_SET = 24;

    public static Treasure [] treasureSet;
    
    /**
     * Inicializace objektu, nastavení jeho kódu code. Voláno pouze z metody createSet().
     * @param code 
     */
    public Treasure(int code) {

        this.code = code;
    }
    /**
     * Vytvoří set pokladů, které lze poté používat.
     * Počet vygenerovaných pokladů je určen vnitřní proměnnou, která je nastavena na hodnotu 24.
     */
    public static void createSet() {

        treasureSet = new Treasure[SIZE_OF_SET];

        for (int i = 0; i < SIZE_OF_SET; i++)
            treasureSet[i] = new Treasure(i);
    }
    /**
     * Z vytvořeného setu vrací objekt pokladu odpovídající zadanému kódu code.
     * Pokud takový objekt neexistuje, vrací null.
     * @param code
     * @return 
     */
    public static Treasure getTreasure(int code) {

        if (code >= SIZE_OF_SET)
            return null;
        else
            return treasureSet[code];
    }
}
