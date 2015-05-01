package start;

import board.*;

import java.io.IOException;

/**
 * Created by marek on 4/12/15.
 */
public class Start {

    public static int size;
    public static MazeBoard board;
    public static int r,c;
    public static MazeField insField;

    public static void main(String [ ] args)  {
        char command;
        boolean over = false;

        size = 7;
        board = MazeBoard.createMazeBoard(size);

        while(!over) {
            switch (command = read()) {
                case 'p':
                    board.printBoard();
                    break;

                case 'n':
                    board.newGame();
                    System.out.print("Nova hra\n");
                    break;

                case 'q':
                    over = true;
                    break;

                case 's':
                    insField = new MazeField(r,c);
                    board.shift(insField);
                    break;
            }

        }

    }

    public static char read() {
        char command;

        try {
            while (true){
                switch (command = (char) System.in.read()) {
                    case 'p':
                        return 'p';

                    case 'n':
                        return 'n';

                    case 'q':
                        return 'q';

                    case 's':
                        r = System.in.read() - 48;
                        c = System.in.read() - 48;
                        return 's';

                    case '\n':
                        break;

                    default:
                        System.out.print("neznamy prikaz\n");
                        break;
                }
            }
        }
        catch (IOException e) {
            return '\uFFFF';
        }
    }

}
