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
        treasureCard = Labyrinth.mazeBoard.freeField.getTreasureCard();
        
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
        
        treasureCard = Labyrinth.mazeBoard.board[r][c].getTreasureCard();
        
        if (treasureCard == null)  //in case of field without treasure card
            treasureL.setIcon(null);
        else
            treasureL.setIcon(getTreasureIcon(treasureCard));
        
        //find out whether any players are on the field or not
        for (int n = 0; n < Labyrinth.numbeOfPlayers; n++) {
            if (n == 0 && Player.isPlayerOnField(n, c, r))
                player1L.setIcon(new ImageIcon(Labyrinth.p1Image));
            
            if (n == 1 && Player.isPlayerOnField(n, c, r))
                player2L.setIcon(new ImageIcon(Labyrinth.p2Image));
            
            if (n == 2 && Player.isPlayerOnField(n ,c, r))
                player3L.setIcon(new ImageIcon(Labyrinth.p3Image));
            
            if (n == 3 && Player.isPlayerOnField(n, c, r))
                player4L.setIcon(new ImageIcon(Labyrinth.p4Image));
        }
        
    }
    
    protected void setWay(int c, int r) {
       MazeCard card;
       
       if (c == -1)
           card = Labyrinth.mazeBoard.freeField.getCard();
       else
           card = Labyrinth.mazeBoard.board[c][r].getCard();
       
       if (card.contains(UP, DOWN)) {
           wayL.setIcon(new ImageIcon(Labyrinth.iUD));
       }
       else if (card.contains(LEFT, RIGHT)) {
           wayL.setIcon(new ImageIcon(Labyrinth.iLR));
       }
       /* ROH - section */
       else if (card.contains(UP, LEFT)) {
           wayL.setIcon(new ImageIcon(Labyrinth.rohLU));
       }
       else if (card.contains(UP, RIGHT)) {
           wayL.setIcon(new ImageIcon(Labyrinth.rohRU));
       }
       else if (card.contains(DOWN, LEFT)) {
           wayL.setIcon(new ImageIcon(Labyrinth.rohLD));
       }
       else if (card.contains(DOWN, RIGHT)) {
           wayL.setIcon(new ImageIcon(Labyrinth.rohRD));
       }
       /* T - section  */
       else if (card.contains(LEFT, RIGHT, DOWN)) {
           wayL.setIcon(new ImageIcon(Labyrinth.tLRD));
       }
       else if (card.contains(LEFT, RIGHT, UP)) {
           wayL.setIcon(new ImageIcon(Labyrinth.tLRU));
       }
       else if (card.contains(LEFT, UP, DOWN)) {
           wayL.setIcon(new ImageIcon(Labyrinth.tLUD));
       }
       else if (card.contains(RIGHT, UP, DOWN)) {
           wayL.setIcon(new ImageIcon(Labyrinth.tRUD));
       }
    }
    
    public static ImageIcon getTreasureIcon( TreasureCard treasureCard) {
        

        if (treasureCard.treasure.code == 0) {
            return (new ImageIcon(Labyrinth.s1Image));
        }
        
        else if (treasureCard.treasure.code == 1) {
            return (new ImageIcon(Labyrinth.s2Image));
        }
        
        else if (treasureCard.treasure.code == 2) {
            return (new ImageIcon(Labyrinth.s3Image));
        }
        
        else if (treasureCard.treasure.code == 3) {
            return (new ImageIcon(Labyrinth.s4Image));
        }
        
        else if (treasureCard.treasure.code == 4) {
            return (new ImageIcon(Labyrinth.s5Image));
        }
        
        else if (treasureCard.treasure.code == 5) {
            return (new ImageIcon(Labyrinth.s6Image));
        }   
        
        else if (treasureCard.treasure.code == 6) {
            return (new ImageIcon(Labyrinth.s7Image));
        }
        
        else if (treasureCard.treasure.code == 7) {
            return (new ImageIcon(Labyrinth.s8Image));
        }
        
        else if (treasureCard.treasure.code == 8) {
            return (new ImageIcon(Labyrinth.s9Image));
        }
        
        else if (treasureCard.treasure.code == 9) {
            return (new ImageIcon(Labyrinth.s10Image));
        }
        
        else if (treasureCard.treasure.code == 10) {
            return (new ImageIcon(Labyrinth.s11Image));
        }
        
        else if (treasureCard.treasure.code == 11) {
            return (new ImageIcon(Labyrinth.s12Image));
        }  
        
        else if (treasureCard.treasure.code == 12) {
            return (new ImageIcon(Labyrinth.s13Image));
        }
        
        else if (treasureCard.treasure.code == 13) {
            return (new ImageIcon(Labyrinth.s14Image));
        }
        
        else if (treasureCard.treasure.code == 14) {
            return (new ImageIcon(Labyrinth.s15Image));
        }
        
        else if (treasureCard.treasure.code == 15) {
            return (new ImageIcon(Labyrinth.s16Image));
        }
        
        else if (treasureCard.treasure.code == 16) {
            return (new ImageIcon(Labyrinth.s17Image));
        }
        
        else if (treasureCard.treasure.code == 17) {
            return (new ImageIcon(Labyrinth.s18Image));
        }  
        
        else if (treasureCard.treasure.code == 18) {
            return (new ImageIcon(Labyrinth.s19Image));
        }
        
        else if (treasureCard.treasure.code == 19) {
            return (new ImageIcon(Labyrinth.s20Image));
        }
        
        else if (treasureCard.treasure.code == 20) {
            return (new ImageIcon(Labyrinth.s21Image));
        }
        
        else if (treasureCard.treasure.code == 21) {
            return (new ImageIcon(Labyrinth.s22Image));
        }
        
        else if (treasureCard.treasure.code == 22) {
            return (new ImageIcon(Labyrinth.s23Image));
        }
        
        else {
            return (new ImageIcon(Labyrinth.s24Image));
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
