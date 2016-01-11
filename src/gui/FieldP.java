/**
 * Field Panel
 * 
 * Autoři:
 * xbieli05
 * xmatus29
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import board.*;
import labyrinth.Labyrinth;
import static board.MazeCard.CANGO.*;
import javax.swing.ImageIcon;
import player.Player;
import treasure.TreasureCard;

/**
 *
 * @author marek
 */
public class FieldP extends javax.swing.JPanel {
    
    int r = -1;
    int c = -1;

    TreasureCard treasureCard;
    
    /**
     * shows free field
     */
    public FieldP() {
        initComponents();
        
        setWay(c, r);
        
        //get free field
        treasureCard = Labyrinth.mazeBoard.freeField.mazeCard.getTreasureCard();
        
        if (treasureCard == null)  //in case of field without treasure card
            treasureL.setIcon(null);
        else
            treasureL.setIcon(getTreasureIcon(treasureCard));
        
        //there are no players on free field
        player1L.setIcon(null);
        player2L.setIcon(null);
        player3L.setIcon(null);
        player4L.setIcon(null);
    }
    
    /**
     * shows field in board
     */
    public FieldP( int c, int r) {
        initComponents();
        
        this.r = r;
        this.c = c;
        
        setWay(r, c);
        
        treasureCard = Labyrinth.mazeBoard.board[r][c].mazeCard.getTreasureCard();
        
        if (treasureCard == null)  //in case of field without treasure card
            treasureL.setIcon(null);
        else
            treasureL.setIcon(getTreasureIcon(treasureCard));
        
        //find out whether any players are on the field or not
        for (int n = 0; n < Labyrinth.numbeOfPlayers; n++) {
            if (n == 0 && Player.isPlayerOnField(n, c, r))
                player1L.setIcon(new ImageIcon("lib/media/BLUE1.png"));
            
            if (n == 1 && Player.isPlayerOnField(n, c, r))
                player2L.setIcon(new ImageIcon("lib/media//GREEN1.png"));
            
            if (n == 2 && Player.isPlayerOnField(n ,c, r))
                player3L.setIcon(new ImageIcon("lib/media//YELLOW1.png"));
            
            if (n == 3 && Player.isPlayerOnField(n, c, r))
                player4L.setIcon(new ImageIcon("lib/media//RED1.png"));
        }
        
    }
    /**
     * Nastaví směr.
     * @param c
     * @param r 
     */
    protected void setWay(int c, int r) {
       MazeCard card;
       
       if (c == -1)
           card = Labyrinth.mazeBoard.freeField.getCard();
       else
           card = Labyrinth.mazeBoard.board[c][r].getCard();
       
       if (card.contains(UP, DOWN)) {
           wayL.setIcon(new ImageIcon("lib/media/iUD.png"));
       }
       else if (card.contains(LEFT, RIGHT)) {
           wayL.setIcon(new ImageIcon("lib/media/iLR.png"));
       }
       /* ROH - section */
       else if (card.contains(UP, LEFT)) {
           wayL.setIcon(new ImageIcon("lib/media/rohLU.png"));
       }
       else if (card.contains(UP, RIGHT)) {
           wayL.setIcon(new ImageIcon("lib/media/rohRU.png"));
       }
       else if (card.contains(DOWN, LEFT)) {
           wayL.setIcon(new ImageIcon("lib/media//rohLD.png"));
       }
       else if (card.contains(DOWN, RIGHT)) {
           wayL.setIcon(new ImageIcon("lib/media//rohRD.png"));
       }
       /* T - section  */
       else if (card.contains(LEFT, RIGHT, DOWN)) {
           wayL.setIcon(new ImageIcon("lib/media/tLRD.png"));
       }
       else if (card.contains(LEFT, RIGHT, UP)) {
           wayL.setIcon(new ImageIcon("lib/media/tLRU.png"));
       }
       else if (card.contains(LEFT, UP, DOWN)) {
           wayL.setIcon(new ImageIcon("lib/media/tLUD.png"));
       }
       else if (card.contains(RIGHT, UP, DOWN)) {
           wayL.setIcon(new ImageIcon("lib/media/tRUD.png"));
       }
    }
    /**
     * Vrátí příslušný obrázek.
     * @param treasureCard
     */
    public static ImageIcon getTreasureIcon( TreasureCard treasureCard) {
        

        if (treasureCard.treasure.code == 0) {
            return (new ImageIcon("lib/media/s1.png"));
        }
        
        else if (treasureCard.treasure.code == 1) {
            return (new ImageIcon("lib/media//s2.png"));
        }
        
        else if (treasureCard.treasure.code == 2) {
            return (new ImageIcon("lib/media//s3.png"));
        }
        
        else if (treasureCard.treasure.code == 3) {
            return (new ImageIcon("lib/media//s4.png"));
        }
        
        else if (treasureCard.treasure.code == 4) {
            return (new ImageIcon("lib/media//s5.png"));
        }
        
        else if (treasureCard.treasure.code == 5) {
            return (new ImageIcon("lib/media//s6.png"));
        }   
        
        else if (treasureCard.treasure.code == 6) {
            return (new ImageIcon("lib/media//s7.png"));
        }
        
        else if (treasureCard.treasure.code == 7) {
            return (new ImageIcon("lib/media//s8.png"));
        }
        
        else if (treasureCard.treasure.code == 8) {
            return (new ImageIcon("lib/media//s9.png"));
        }
        
        else if (treasureCard.treasure.code == 9) {
            return (new ImageIcon("lib/media//s10.png"));
        }
        
        else if (treasureCard.treasure.code == 10) {
            return (new ImageIcon("lib/media//s11.png"));
        }
        
        else if (treasureCard.treasure.code == 11) {
            return (new ImageIcon("lib/media//s12.png"));
        }  
        
        else if (treasureCard.treasure.code == 12) {
            return (new ImageIcon("lib/media//s13.png"));
        }
        
        else if (treasureCard.treasure.code == 13) {
            return (new ImageIcon("lib/media//s14.png"));
        }
        
        else if (treasureCard.treasure.code == 14) {
            return (new ImageIcon("lib/media//s15.png"));
        }
        
        else if (treasureCard.treasure.code == 15) {
            return (new ImageIcon("lib/media//s16.png"));
        }
        
        else if (treasureCard.treasure.code == 16) {
            return (new ImageIcon("lib/media//s17.png"));
        }
        
        else if (treasureCard.treasure.code == 17) {
            return (new ImageIcon("lib/media//s18.png"));
        }  
        
        else if (treasureCard.treasure.code == 18) {
            return (new ImageIcon("lib/media//s19.png"));
        }
        
        else if (treasureCard.treasure.code == 19) {
            return (new ImageIcon("lib/media//s20.png"));
        }
        
        else if (treasureCard.treasure.code == 20) {
            return (new ImageIcon("lib/media//s21.png"));
        }
        
        else if (treasureCard.treasure.code == 21) {
            return (new ImageIcon("lib/media//s22.png"));
        }
        
        else if (treasureCard.treasure.code == 22) {
            return (new ImageIcon("lib/media//s23.png"));
        }
        
        else {
            return (new ImageIcon("lib/media//s24.png"));
        }          
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        player1L = new javax.swing.JLabel();
        player2L = new javax.swing.JLabel();
        player3L = new javax.swing.JLabel();
        player4L = new javax.swing.JLabel();
        treasureL = new javax.swing.JLabel();
        wayL = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(75, 75));
        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(75, 75));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jLayeredPane1.add(player1L, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        jLayeredPane1.add(player2L, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));
        jLayeredPane1.add(player3L, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));
        jLayeredPane1.add(player4L, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        treasureL.setPreferredSize(new java.awt.Dimension(50, 50));
        jLayeredPane1.add(treasureL, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        wayL.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        wayL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/iLR.png"))); // NOI18N
        wayL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wayLMouseClicked(evt);
            }
        });
        jLayeredPane1.add(wayL, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(jLayeredPane1);
    }// </editor-fold>//GEN-END:initComponents

    private void wayLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wayLMouseClicked
        Labyrinth.actionHandler(c, r);
    }//GEN-LAST:event_wayLMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel player1L;
    private javax.swing.JLabel player2L;
    private javax.swing.JLabel player3L;
    private javax.swing.JLabel player4L;
    private javax.swing.JLabel treasureL;
    private javax.swing.JLabel wayL;
    // End of variables declaration//GEN-END:variables
}
