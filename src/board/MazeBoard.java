/**
 * Maze Board
 * 
 * Autoři:
 * xbieli05
 * xmatus29
 */

package board;

import java.util.Random;

import static board.MazeCard.CANGO.*;
import java.io.Serializable;
import labyrinth.Labyrinth;


public class MazeBoard implements Serializable{


    
    /**
     * game mode
     */
    public enum MODE {
        TURN,
        MOVE
    }
    
    public MODE mode;
    
    public MazeField freeField;
    public MazeField[][] board;

    
    /**
     * Nastaveni modu
     * @param mode 
     */
    public void setMode (MODE mode) {
        this.mode = mode;
    }
    
    /**
     * Vytvoří hrací desku o velikost n.
     * @param n
     */
    public static MazeBoard createMazeBoard(int n) {

        return new MazeBoard(n);

    }
    
    /**
     * Reprezentuje hraci desku. Deska je rozdelena na policka a je ctvercova o rozmeru n.
     * Umožňuje generovat novou hru a posunovat kameny na řádcích či sloupcích.
     * @param n 
     */
    public MazeBoard(int n) {
        board = new MazeField [n+1] [n+1];

        for (int i = 1; i < board.length; i++)
            for (int j = 1; j < board.length; j++)
                board[i][j] = new MazeField(i,j);

        freeField = new MazeField(0, 0);
    }
    /**
     * Vytvoří novou hru. Generuje hraci kameny a umisťuje je na políčka. Současně vygeneruje jeden volný kámen, který uchová mimo políčka.
     */
    public void newGame() {
        /* hraci kameny */

        
        Random rand = new Random();
        int r;
        /* hraci kameny T */
        Random randT = new Random();
        int t;
        /* umisteni pokladu X */
        Random randX = new Random();
        int x;
        /* umisteni pokladu Y */
        Random randY = new Random();
        int y;
        
        MazeCard tmpCard = MazeCard.create("C");

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                r = rand.nextInt(6);
                t = rand.nextInt(4);
                /* ROH - section */
                if (i == 1 && j==1) 
                {
                    tmpCard = MazeCard.create("C2");
                }
                else if (i == 1 && j==board.length-1) 
                {
                    tmpCard = MazeCard.create("C1");
                }
                else if (i == board.length-1 && j == 1) 
                {
                    tmpCard = MazeCard.create("C3");
                }
                else if (i == board.length-1 && j == board.length-1) 
                {
                    tmpCard = MazeCard.create("C");
                }
                /* T - section */
                else if (i == 1 && j % 2 != 0 )
                {
                    tmpCard = MazeCard.create("F1");
                }
                else if (j == 1 && i % 2 != 0)
                {
                    tmpCard = MazeCard.create("F3");
                }
                else if (i == board.length-1 && j % 2 != 0)
                {
                    tmpCard = MazeCard.create("F");
                }
                else if (j == board.length-1 && i % 2 != 0)
                {
                    tmpCard = MazeCard.create("F2");
                }
                else if (i % 2 != 0 && j % 2 != 0)
                { /* nahodne generovani orientace tecek uvnitr hraci desky */
                    switch (t)
                    {
                        case 0:
                            tmpCard = MazeCard.create("F");
                            break;
                            
                        case 1:
                            tmpCard = MazeCard.create("F1");
                            break;
                            
                        case 2:
                            tmpCard = MazeCard.create("F2");
                            break;
                            
                        case 3:
                            tmpCard = MazeCard.create("F3");
                            break;                            
                    }
                }
                else /* nahodne generovani zbytku */
                switch (r) {
                    case 0:
                        tmpCard = MazeCard.create("L");
                        break;

                    case 1:
                        tmpCard = MazeCard.create("L1");
                        break;

                    case 2:
                        tmpCard = MazeCard.create("C");
                        break;
                        
                    case 3:
                        tmpCard = MazeCard.create("C1");
                        break;
                        
                    case 4:
                        tmpCard = MazeCard.create("C2");
                        break;
                      
                    case 5:
                        tmpCard = MazeCard.create("C3");
                        break;
                     
                }
                board[i][j].putCard(tmpCard);
                                
            }
            
        }


    /* nahodne vygenerovani umisteni hracich karet */  
        while(Labyrinth.pack.size()>0)
        {    
            x = rand.nextInt(board.length-1);
            y = rand.nextInt(board.length-1);
            x++;
            y++;
            if (x == 1 && y == 1) ;
            else
            if (x == 1 && y == board.length-1) ;
            else
            if (x == board.length-1 && y == 1) ;
            else
            if (x == board.length-1 && y == board.length-1) ;
            else
            if ((board[x][y].mazeCard.getTreasureCard() == null))
            {
                board[x][y].mazeCard.putTreasureCard(Labyrinth.pack.popCard());
            }
        }
        
        freeField.putCard(MazeCard.create("F1"));
         
    }
    /**
     * Provede vložení volného kamene na pozici políčka mf.
     * Podle pozice políčka mf se provede příslušné posunutí kamenů.
     * @param r
     * @param c
     */
    public MazeField get(int r, int c) {
        if (r > board.length || c > board.length ||
                r < 1 || c < 1)
            return null;

        return board[r][c];
    }

    public MazeCard getFreeCard() {
        return freeField.getCard();
    }
    
/**
 * Provede vložení volného kamene na pozici políčka mf.
 * Podle pozice políčka mf se provede příslušné posunutí kamenů.
 * @param mf 
 */
    public boolean shift(MazeField mf) {
        int c = mf.col();
        int r = mf.row();
        MazeCard tmpFreeCard;
        int lastIndex = board.length - 1;
        boolean boardShifted = false;
        if(r > lastIndex || c > lastIndex)
            return boardShifted;
        
        
        /* ↓ */
        if (r == 1 && c % 2 == 0 && ((r != mf.pomR && c != mf.pomC) || (r == mf.pomR))) {
            System.out.println("↓");
            mf.pomC = c;
            mf.pomR = r;
            boardShifted = true;

            tmpFreeCard = board[lastIndex][c].getCard();

            for (int i = lastIndex; i > 1;)
            {
                board[i][c].putCard(board[--i][c].getCard());
            }
            board[1][c].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
            
            /* priznak, abych posunuk hrace jen o jedno policko v nasledujici podmince */
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            int p4 = 0;

            for (r = 1; r < board.length; r++) /* pro vsechny radky */
            for (int n = 0; n < Labyrinth.numbeOfPlayers; n++) { /* pro vsechny hrace */
            if (n == 0 && player.Player.isPlayerOnField(n, c, r)) 
            {
                if (player.Player.isPlayerOnField(n, c, board.length-1)) /* je-li hrac na poslednim policku */
                {
                    if (p1 == 0)
                    {
                        player.Player.players[n].y = 1; /* tak ho dam na prvni */
                        player.Player.players[n].x = c;
                        p1++;
                    }
                }
                
                if (p1 == 0)
                {
                player.Player.players[n].y = r+1; /* jinak ho o 1 posunu */
                player.Player.players[n].x = c;
                p1++;
                }
            }
            /* to stejne pro dalsi hrace ... i dalsi smery */
            if (n == 1 && player.Player.isPlayerOnField(n, c, r))
            {
                
                if (player.Player.isPlayerOnField(n, c, board.length-1))
                {
                    if (p2 == 0)
                    {
                        player.Player.players[n].y = 1;
                        player.Player.players[n].x = c;
                        p2++;
                    }
                }
                
                if (p2 == 0)
                {
                player.Player.players[n].y = r+1;
                player.Player.players[n].x = c;
                p2++;
                }
            }
            
            if (n == 2 && player.Player.isPlayerOnField(n ,c, r))
            {
                
                if (player.Player.isPlayerOnField(n, c, board.length-1))
                {
                    if (p3 == 0)
                    {
                        player.Player.players[n].y = 1;
                        player.Player.players[n].x = c;
                        p3++;
                    }
                }
                
                if (p3 == 0)
                {
                player.Player.players[n].y = r+1;
                player.Player.players[n].x = c;
                p3++;
                }
            }
            
            if (n == 3 && player.Player.isPlayerOnField(n, c, r))
            {   
                if (player.Player.isPlayerOnField(n, c, board.length-1))
                {
                    if (p4 == 0)
                    {
                        player.Player.players[n].y = 1;
                        player.Player.players[n].x = c;
                        p4++;
                    }
                }                
                
                if (p4 == 0)
                {
                player.Player.players[n].y = r+1;
                player.Player.players[n].x = c;  
                p4++;
                }
            }
            }
            
        }
        /* → */

        else 
        if (r % 2 == 0 && c == 1 && ((r != mf.pomR && c != mf.pomC) || (c == mf.pomC)))
        {
            boardShifted = true;
            mf.pomC = c;
            mf.pomR = r;
            System.out.println("→");
            tmpFreeCard = board[r][lastIndex].getCard();

            for (int i = lastIndex; i > 1;)
                board[r][i].putCard(board[r][--i].getCard());

            board[r][1].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
            
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            int p4 = 0;

            for (c = 1; c < board.length; c++)
            for (int n = 0; n < Labyrinth.numbeOfPlayers; n++) {
            if (n == 0 && player.Player.isPlayerOnField(n, c, r)) 
            {
                if (player.Player.isPlayerOnField(n, board.length-1, r))
                {
                    if (p1 == 0)
                    {
                        player.Player.players[n].x = 1;
                        player.Player.players[n].y = r;
                        p1++;
                    }
                }
                
                if (p1 == 0)
                {
                player.Player.players[n].x = c+1;
                player.Player.players[n].y = r;
                p1++;
                }
            }
            
            if (n == 1 && player.Player.isPlayerOnField(n, c, r))
            {
                
                if (player.Player.isPlayerOnField(n, board.length-1, r))
                {
                    if (p2 == 0)
                    {
                        player.Player.players[n].x = 1;
                        player.Player.players[n].y = r;
                        p2++;
                    }
                }
                
                if (p2 == 0)
                {
                player.Player.players[n].x = c+1;
                player.Player.players[n].y = r;
                p2++;
                }
            }
            
            if (n == 2 && player.Player.isPlayerOnField(n ,c, r))
            {
                
                if (player.Player.isPlayerOnField(n, board.length-1, r))
                {
                    if (p3 == 0)
                    {
                        player.Player.players[n].x = 1;
                        player.Player.players[n].y = r;
                        p3++;
                    }
                }
                
                if (p3 == 0)
                {
                player.Player.players[n].x = c+1;
                player.Player.players[n].y = r;
                p3++;
                }
            }
            
            if (n == 3 && player.Player.isPlayerOnField(n, c, r))
            {   
                if (player.Player.isPlayerOnField(n, board.length-1, r))
                {
                    if (p4 == 0)
                    {
                        player.Player.players[n].x = 1;
                        player.Player.players[n].y = r;
                        p4++;
                    }
                }                
                
                if (p4 == 0)
                {
                player.Player.players[n].x = c+1;
                player.Player.players[n].y = r;  
                p4++;
                }
            }
            }
            
            
            
        }
        /* ↑ */
        else    
        if (r == lastIndex && c % 2 == 0 && ((r != mf.pomR && c != mf.pomC) || (r == mf.pomR))) {
            boardShifted = true;
            mf.pomC = c;
            mf.pomR = r;
            System.out.println("↑");
            
            
            tmpFreeCard = board[1][c].getCard();

            for (int i = 1; i < lastIndex;)
                board[i][c].putCard(board[++i][c].getCard());

            board[lastIndex][c].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
            
            
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            int p4 = 0;

            for (r = board.length-1; r > 0; r--)
            for (int n = 0; n < Labyrinth.numbeOfPlayers; n++) {
            if (n == 0 && player.Player.isPlayerOnField(n, c, r)) 
            {
                if (player.Player.isPlayerOnField(n, c, 1))
                {
                    if (p1 == 0)
                    {
                        player.Player.players[n].y = board.length-1;
                        player.Player.players[n].x = c;
                        p1++;
                    }
                }
                
                if (p1 == 0)
                {
                player.Player.players[n].y = r-1;
                player.Player.players[n].x = c;
                p1++;
                }
            }
            
            if (n == 1 && player.Player.isPlayerOnField(n, c, r))
            {
                
                if (player.Player.isPlayerOnField(n, c, 1))
                {
                    if (p2 == 0)
                    {
                        player.Player.players[n].y = board.length-1;
                        player.Player.players[n].x = c;
                        p2++;
                    }
                }
                
                if (p2 == 0)
                {
                player.Player.players[n].y = r-1;
                player.Player.players[n].x = c;
                p2++;
                }
            }
            
            if (n == 2 && player.Player.isPlayerOnField(n ,c, r))
            {
                
                if (player.Player.isPlayerOnField(n, c, 1))
                {
                    if (p3 == 0)
                    {
                        player.Player.players[n].y = board.length-1;
                        player.Player.players[n].x = c;
                        p3++;
                    }
                }
                
                if (p3 == 0)
                {
                player.Player.players[n].y = r-1;
                player.Player.players[n].x = c;
                p3++;
                }
            }
            
            if (n == 3 && player.Player.isPlayerOnField(n, c, r))
            {   
                if (player.Player.isPlayerOnField(n, c, 1))
                {
                    if (p4 == 0)
                    {
                        player.Player.players[n].y = board.length-1;
                        player.Player.players[n].x = c;
                        p4++;
                    }
                }                
                
                if (p4 == 0)
                {
                player.Player.players[n].y = r-1;
                player.Player.players[n].x = c;  
                p4++;
                }
            }
            }
        }
        /* ← */
        else if (r % 2 == 0 && c == lastIndex && ((r != mf.pomR && c != mf.pomC) || (c == mf.pomC))) 
        {
            boardShifted = true;
            mf.pomR = r;
            mf.pomC = c;
            System.out.println("←");
            tmpFreeCard = board[r][1].getCard();

            for (int i = 1; i < lastIndex;)
                board[r][i].putCard(board[r][++i].getCard());

            board[r][lastIndex].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
            
            
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            int p4 = 0;

            for (c = board.length-1; c > 0; c--)
            for (int n = 0; n < Labyrinth.numbeOfPlayers; n++) {
            if (n == 0 && player.Player.isPlayerOnField(n, c, r)) 
            {
                if (player.Player.isPlayerOnField(n, 1, r))
                {
                    if (p1 == 0)
                    {
                        player.Player.players[n].x = board.length-1;
                        player.Player.players[n].y = r;
                        p1++;
                    }
                }
                
                if (p1 == 0)
                {
                player.Player.players[n].x = c-1;
                player.Player.players[n].y = r;
                p1++;
                }
            }
            
            if (n == 1 && player.Player.isPlayerOnField(n, c, r))
            {
                
                if (player.Player.isPlayerOnField(n, 1, r))
                {
                    if (p2 == 0)
                    {
                        player.Player.players[n].x = board.length-1;
                        player.Player.players[n].y = r;
                        p2++;
                    }
                }
                
                if (p2 == 0)
                {
                player.Player.players[n].x = c-1;
                player.Player.players[n].y = r;
                p2++;
                }
            }
            
            if (n == 2 && player.Player.isPlayerOnField(n ,c, r))
            {
                
                if (player.Player.isPlayerOnField(n, 1, r))
                {
                    if (p3 == 0)
                    {
                        player.Player.players[n].x = board.length-1;
                        player.Player.players[n].y = r;
                        p3++;
                    }
                }
                
                if (p3 == 0)
                {
                player.Player.players[n].x = c-1;
                player.Player.players[n].y = r;
                p3++;
                }
            }
            
            if (n == 3 && player.Player.isPlayerOnField(n, c, r))
            {   
                if (player.Player.isPlayerOnField(n, 1, r))
                {
                    if (p4 == 0)
                    {
                        player.Player.players[n].x = board.length-1;
                        player.Player.players[n].y = r;
                        p4++;
                    }
                }                
                
                if (p4 == 0)
                {
                player.Player.players[n].x = c-1;
                player.Player.players[n].y = r;  
                p4++;
                }
            }
            }
        }
        
        return boardShifted;
    }
    /**
     * Vytiskne hrací desku.
     */
    public void printBoard() {
        System.out.print("  ");
        for (int i = 1; i < board.length; i++)
            System.out.print(i + "  ");
        System.out.print("\n");

        for (int i = 1; i < board.length; i++) {
            System.out.print(i+" ");
            for (int j = 1; j < board.length; j++) {
                printField(board[i][j]);
            }
            System.out.print("\n");
        }

        System.out.print("volny kamen: ");
        printField(freeField);
        System.out.print("\n");
    }
    /**
     * Vytiskne jednotlivá políčka.
     * @param field 
     */
    public void printField(MazeField field) {
        MazeCard card = field.getCard();

        if(card == null) {
            System.out.print("\u2591  ");
            return;
        }
        if (card.contains(LEFT, RIGHT))
            System.out.print("\u2501  ");

        else if (card.contains(LEFT, UP))
            System.out.print("\u251b  ");

        else if (card.contains(LEFT, UP, RIGHT))
            System.out.print("\u253b  ");
    }
}











