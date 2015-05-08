package board;

import java.util.Random;

import static board.MazeCard.CANGO.*;

public class MazeBoard {

    public MazeField freeField;
    public MazeField[][] board;

    public static MazeBoard createMazeBoard(int n) {

        return new MazeBoard(n);
    }

    public MazeBoard(int n) {
        board = new MazeField [n+1] [n+1];

        for (int i = 1; i < board.length; i++)
            for (int j = 1; j < board.length; j++)
                board[i][j] = new MazeField(i,j);

        freeField = new MazeField(0, 0);
    }

    public void newGame() {
        Random rand = new Random();
        int r;
        Random randT = new Random();
        int t;        
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

        freeField.putCard(tmpCard);
    }

    public MazeField get(int r, int c) {
        if (r > board.length || c > board.length ||
                r < 1 || c < 1)
            return null;

        return board[r][c];
    }

    public MazeCard getFreeCard() {
        return freeField.getCard();
    }

    public void shift(MazeField mf) {
        int c = mf.col();
        int r = mf.row();
        MazeCard tmpFreeCard;
        int lastIndex = board.length - 1;

        if(r > lastIndex || c > lastIndex)
            return;

        if (r == 1 && c % 2 == 0) {
            tmpFreeCard = board[lastIndex][c].getCard();

            for (int i = lastIndex; i > 1;)
                board[i][c].putCard(board[--i][c].getCard());

            board[1][c].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
        }

        else if (r % 2 == 0 && c == 1) {
            tmpFreeCard = board[r][lastIndex].getCard();

            for (int i = lastIndex; i > 1;)
                board[r][i].putCard(board[r][--i].getCard());

            board[r][1].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
        }

        else if (r == lastIndex && c % 2 == 0) {
            tmpFreeCard = board[1][c].getCard();

            for (int i = 1; i < lastIndex;)
                board[i][c].putCard(board[++i][c].getCard());

            board[lastIndex][c].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
        }

        else if (r % 2 == 0 && c == lastIndex) {
            tmpFreeCard = board[r][1].getCard();

            for (int i = 1; i < lastIndex;)
                board[r][i].putCard(board[r][++i].getCard());

            board[r][lastIndex].putCard(freeField.getCard());
            freeField.putCard(tmpFreeCard);
        }
    }

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











