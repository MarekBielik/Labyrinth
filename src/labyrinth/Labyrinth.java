package labyrinth;

import board.*;
import gui.GuiF;
import gui.WinnerF;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import player.*;
import treasure.CardPack;
import treasure.Treasure;

/**
 * Created by marek on 4/12/15.
 */
public class Labyrinth {

    public static GuiF gui;
    public static int boardSize = 7;
    public static int numbeOfPlayers = 2;
    public static int cardPackSize = 12;
    public static MazeBoard mazeBoard;
    public static CardPack pack;
    public static Stack<byte[]> moveStack = new Stack();  
    
    public static Image iUD;
    public static Image iLR;
    public static Image rohLD;
    public static Image rohLU;
    public static Image rohRD;
    public static Image rohRU;
    public static Image tLRD;
    public static Image tLRU;
    public static Image tLUD;
    public static Image tRUD;
    
    public static Image s1Image;
    public static Image s2Image;
    public static Image s3Image;
    public static Image s4Image;
    public static Image s5Image;
    public static Image s6Image;
    public static Image s7Image;
    public static Image s8Image;
    public static Image s9Image;
    public static Image s10Image;
    public static Image s11Image;
    public static Image s12Image;
    public static Image s13Image;
    public static Image s14Image;
    public static Image s15Image;
    public static Image s16Image;
    public static Image s17Image;
    public static Image s18Image;
    public static Image s19Image;
    public static Image s20Image;
    public static Image s21Image;
    public static Image s22Image;
    public static Image s23Image;
    public static Image s24Image;
    
    public static Image p1Image;
    public static Image p2Image;
    public static Image p3Image;
    public static Image p4Image;
    

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        initGame();
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gui = new GuiF();
            }
        });
    }
    
    
    public static void initGame() {
        initImages();
        Treasure.createSet();
        
    }
    
    /**
     * Initializes images of maze ways and treasures.
     */
    public static void initImages() {
        
        //init player's images
        try {
             p1Image = ImageIO.read(Labyrinth.class.getResource("/media/BLUE1.png"));
            } catch (IOException ex) {}
        
        try {
             p2Image = ImageIO.read(Labyrinth.class.getResource("/media/GREEN1.png"));
            } catch (IOException ex) {}
        
        try {
             p3Image = ImageIO.read(Labyrinth.class.getResource("/media/YELLOW1.png"));
            } catch (IOException ex) {}
        
        try {
             p4Image = ImageIO.read(Labyrinth.class.getResource("/media/RED1.png"));
            } catch (IOException ex) {}
        
        //init ways' images
        try {
             iUD = ImageIO.read(Labyrinth.class.getResource("/media/iUD.png"));
            } catch (IOException ex) {}
        
        try {
             iLR = ImageIO.read(Labyrinth.class.getResource("/media/iLR.png"));
            } catch (IOException ex) {}
        
        try {
             rohLU = ImageIO.read(Labyrinth.class.getResource("/media/rohLU.png"));
            } catch (IOException ex) {}
        
        try {
             rohLD = ImageIO.read(Labyrinth.class.getResource("/media/rohLD.png"));
            } catch (IOException ex) {}
        
        try {
             rohRD = ImageIO.read(Labyrinth.class.getResource("/media/rohRD.png"));
            } catch (IOException ex) {}
        
        try {
             rohRU = ImageIO.read(Labyrinth.class.getResource("/media/rohRU.png"));
            } catch (IOException ex) {}
        
        try {
             tLRD = ImageIO.read(Labyrinth.class.getResource("/media/tLRD.png"));
            } catch (IOException ex) {}
                
        try {
             tLRU = ImageIO.read(Labyrinth.class.getResource("/media/tLRU.png"));
            } catch (IOException ex) {}
                
        try {
             tLUD = ImageIO.read(Labyrinth.class.getResource("/media/tLUD.png"));
            } catch (IOException ex) {}
                
        try {
             tRUD = ImageIO.read(Labyrinth.class.getResource("/media/tRUD.png"));
            } catch (IOException ex) {}   
        
        /* pictures */
        
        try {
             s1Image = ImageIO.read(Labyrinth.class.getResource("/media/s1.png"));
            } catch (IOException ex) {}    

        try {
             s2Image = ImageIO.read(Labyrinth.class.getResource("/media/s2.png"));
            } catch (IOException ex) {}  
        
        try {
             s3Image = ImageIO.read(Labyrinth.class.getResource("/media/s3.png"));
            } catch (IOException ex) {}  
        try {
             s4Image = ImageIO.read(Labyrinth.class.getResource("/media/s4.png"));
            } catch (IOException ex) {}  
        try {
             s5Image = ImageIO.read(Labyrinth.class.getResource("/media/s5.png"));
            } catch (IOException ex) {}  
        try {
             s6Image = ImageIO.read(Labyrinth.class.getResource("/media/s6.png"));
            } catch (IOException ex) {}  
    
        try {
             s7Image = ImageIO.read(Labyrinth.class.getResource("/media/s7.png"));
            } catch (IOException ex) {}  
        
        try {
             s8Image = ImageIO.read(Labyrinth.class.getResource("/media/s8.png"));
            } catch (IOException ex) {}  
        
        try {
             s9Image = ImageIO.read(Labyrinth.class.getResource("/media/s9.png"));
            } catch (IOException ex) {}  
        
        try {
             s10Image = ImageIO.read(Labyrinth.class.getResource("/media/s10.png"));
            } catch (IOException ex) {}  
        
        try {
             s11Image = ImageIO.read(Labyrinth.class.getResource("/media/s11.png"));
            } catch (IOException ex) {}  
        
        try {
             s12Image = ImageIO.read(Labyrinth.class.getResource("/media/s12.png"));
            } catch (IOException ex) {}  
        
        try {
             s13Image = ImageIO.read(Labyrinth.class.getResource("/media/s13.png"));
            } catch (IOException ex) {}  
        
        try {
             s14Image = ImageIO.read(Labyrinth.class.getResource("/media/s14.png"));
            } catch (IOException ex) {}  
        
        try {
             s15Image = ImageIO.read(Labyrinth.class.getResource("/media/s15.png"));
            } catch (IOException ex) {}  
        
        try {
             s16Image = ImageIO.read(Labyrinth.class.getResource("/media/s16.png"));
            } catch (IOException ex) {}  
        
        try {
             s17Image = ImageIO.read(Labyrinth.class.getResource("/media/s17.png"));
            } catch (IOException ex) {}  
        
        try {
             s18Image = ImageIO.read(Labyrinth.class.getResource("/media/s18.png"));
            } catch (IOException ex) {}  
        
        try {
             s19Image = ImageIO.read(Labyrinth.class.getResource("/media/s19.png"));
            } catch (IOException ex) {}  
        
        try {
             s20Image = ImageIO.read(Labyrinth.class.getResource("/media/s20.png"));
            } catch (IOException ex) {}  

        try {
             s21Image = ImageIO.read(Labyrinth.class.getResource("/media/s21.png"));
            } catch (IOException ex) {}  
        
        try {
             s22Image = ImageIO.read(Labyrinth.class.getResource("/media/s22.png"));
            } catch (IOException ex) {}  
        
        try {
             s23Image = ImageIO.read(Labyrinth.class.getResource("/media/s23.png"));
            } catch (IOException ex) {}  
        
        try {
             s24Image = ImageIO.read(Labyrinth.class.getResource("/media/s24.png"));
            } catch (IOException ex) {}  
 
                
    }
    
    /**
     * handles user's actions while game play
     * @param x horizontal coordinate on board
     * @param y vertical coordinate on board
     */
    public static void actionHandler (int x, int y) {
        
        int xDif;
        int yDif;
        
        if (x == -1) {
            //user clicked on free field
            //free field will be rotated
            //only if the game is in TURN mode
            if (mazeBoard.mode == MazeBoard.MODE.TURN) {
                mazeBoard.freeField.getCard().turnRight();
                gui.reDrawBoard();
                return;
            }
        }
        
        //player tries to shift fields in the board
        if (mazeBoard.mode == MazeBoard.MODE.TURN) {
            mazeBoard.freeField.col = x;
            mazeBoard.freeField.row = y;
            System.out.println("try shift");
            if (mazeBoard.shift(mazeBoard.freeField)) {
                gui.reDrawBoard();
                mazeBoard.mode = MazeBoard.MODE.MOVE;
                return;
            }
        }
        
        //player tries to move to neighboring field
        if (mazeBoard.mode == MazeBoard.MODE.MOVE) {
            xDif = x - Player.players[Player.activePos].x;
            yDif = y - Player.players[Player.activePos].y;
 
            //try to move to upper field
            if (xDif == 0 && yDif == -1) {
                if (mazeBoard.board[y][x].mazeCard.canGo(MazeCard.CANGO.DOWN) &&
                        mazeBoard.board[Player.players[Player.activePos].y]
                                       [Player.players[Player.activePos].x].mazeCard.canGo(MazeCard.CANGO.UP)) {
                    Player.players[Player.activePos].x = x;
                    Player.players[Player.activePos].y = y;
                    gui.reDrawBoard();
                }
            }
            
            //try to move to lower field
            if (xDif == 0 && yDif == 1) {
                if (mazeBoard.board[y][x].mazeCard.canGo(MazeCard.CANGO.UP) &&
                        mazeBoard.board[Player.players[Player.activePos].y]
                                       [Player.players[Player.activePos].x].mazeCard.canGo(MazeCard.CANGO.DOWN)) {
                    Player.players[Player.activePos].x = x;
                    Player.players[Player.activePos].y = y;
                    gui.reDrawBoard();
                }
            }
            
            //try to move to right field
            if (xDif == 1 && yDif == 0) {
                if (mazeBoard.board[y][x].mazeCard.canGo(MazeCard.CANGO.LEFT) &&
                        mazeBoard.board[Player.players[Player.activePos].y]
                                       [Player.players[Player.activePos].x].mazeCard.canGo(MazeCard.CANGO.RIGHT)) {
                    Player.players[Player.activePos].x = x;
                    Player.players[Player.activePos].y = y;
                    gui.reDrawBoard();
                }
            }
            
            //try to move to left field
            if (xDif == -1 && yDif == 0) {
                if (mazeBoard.board[y][x].mazeCard.canGo(MazeCard.CANGO.RIGHT) &&
                        mazeBoard.board[Player.players[Player.activePos].y]
                                       [Player.players[Player.activePos].x].mazeCard.canGo(MazeCard.CANGO.LEFT)) {
                    Player.players[Player.activePos].x = x;
                    Player.players[Player.activePos].y = y;
                    gui.reDrawBoard();
                }
            }
            
            if (mazeBoard.board[Player.players[Player.activePos].y]
                               [Player.players[Player.activePos].x].
                                getCard().getTreasureCard() != null) {
                
                if (mazeBoard.board[Player.players[Player.activePos].y]
                        [Player.players[Player.activePos].x].
                        getCard().treasureCard.equals
                                           (Player.players[Player.activePos].treasureCard)) {
                    //increment player's score
                    Player.players[Player.activePos].score++;
                    
                    //remove treasure card from the field
                    mazeBoard.board[Player.players[Player.activePos].y]
                            [Player.players[Player.activePos].x].mazeCard.removeTreasureCard();
                    
                    //get new player's treasure card
                    Player.players[Player.activePos].treasureCard = Labyrinth.pack.popCard();
                    
                    //in case of winner
                    if(Player.players[Player.activePos].score == cardPackSize / 2) {
                        WinnerF winnerF = new WinnerF(Player.players[Player.activePos].name);
                        gui.setEnabled(false);
                        winnerF.setVisible(true);
                    }
                    gui.reDrawBoard();
                }
            }
        }
    }
    
    /**
     * saves current state of game
     */
    public static void saveMove() {
        System.err.println("game saved");
        GameState gameState = new GameState(true);
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
        } catch (Exception e) {
        }
        
        try {
            oos.writeObject(gameState);
            oos.flush();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte[] byteData = bos.toByteArray();
        moveStack.push(byteData);
    }
    
    /**
     * restores previous state of game
     */
    public static void restoreMove() {
        if (moveStack.empty())
            return;
        
        GameState gameState = new GameState(false);
        
        ByteArrayInputStream bais = new ByteArrayInputStream(moveStack.pop());
        try {
            gameState = (GameState) new ObjectInputStream(bais).readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mazeBoard = gameState.mazeBoard;
        pack = gameState.cardPack;
        Player.players = gameState.players;
        Player.activePos = gameState.activePos;
    }
}
