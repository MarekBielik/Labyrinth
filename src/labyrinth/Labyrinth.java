package labyrinth;

import board.*;
import gui.GuiF;
import java.awt.Image;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by marek on 4/12/15.
 */
public class Labyrinth {

    /**
     *
     */
    public static GuiF gui;
    public static int boardSize = 7;
    public static int numbeOfPlayers;
    public static int cardPackSize;
    public static MazeBoard mazeBoard;
    
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
    }
    
}
