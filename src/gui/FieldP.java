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
import treasure.TreasureCard;

/**
 *
 * @author marek
 */
public class FieldP extends javax.swing.JPanel {
    
    int r = -1;
    int c = -1;

    
    public FieldP() {
        initComponents();
        
        setWay(c, r);
        setTreasure(r, c);
    }
    
    /**
     * Creates new form fieldP
     */
    public FieldP( int c, int r) {
        initComponents();
        
        this.r = r;
        this.c = c;
        
        setWay(r, c);
        setTreasure(r, c);
        
        player1L.setIcon(null);
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
    
    protected void setTreasure(int r, int c) {
        TreasureCard treasureCard;
        
        if (c == -1)
            treasureCard = Labyrinth.mazeBoard.freeField.getTreasureCard();
        else
            treasureCard = Labyrinth.mazeBoard.board[r][c].getTreasureCard();
        
        if (treasureCard == null)
            return;
        
        if (treasureCard.treasure.code == 0) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s1Image));
        }
        
        if (treasureCard.treasure.code == 1) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s2Image));
        }
        
        if (treasureCard.treasure.code == 2) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s3Image));
        }
        
        if (treasureCard.treasure.code == 3) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s4Image));
        }
        
        if (treasureCard.treasure.code == 4) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s5Image));
        }
        
        if (treasureCard.treasure.code == 5) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s6Image));
        }   
        
        if (treasureCard.treasure.code == 6) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s7Image));
        }
        
        if (treasureCard.treasure.code == 7) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s8Image));
        }
        
        if (treasureCard.treasure.code == 8) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s9Image));
        }
        
        if (treasureCard.treasure.code == 9) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s10Image));
        }
        
        if (treasureCard.treasure.code == 10) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s11Image));
        }
        
        if (treasureCard.treasure.code == 11) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s12Image));
        }  
        
        if (treasureCard.treasure.code == 12) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s13Image));
        }
        
        if (treasureCard.treasure.code == 13) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s14Image));
        }
        
        if (treasureCard.treasure.code == 14) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s15Image));
        }
        
        if (treasureCard.treasure.code == 15) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s16Image));
        }
        
        if (treasureCard.treasure.code == 16) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s17Image));
        }
        
        if (treasureCard.treasure.code == 17) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s18Image));
        }  
        
        if (treasureCard.treasure.code == 18) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s19Image));
        }
        
        if (treasureCard.treasure.code == 19) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s20Image));
        }
        
        if (treasureCard.treasure.code == 20) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s21Image));
        }
        
        if (treasureCard.treasure.code == 21) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s22Image));
        }
        
        if (treasureCard.treasure.code == 22) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s23Image));
        }
        
        if (treasureCard.treasure.code == 23) {
            treasureL.setIcon(new ImageIcon(Labyrinth.s24Image));
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

        player1L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/BLUE1.png"))); // NOI18N
        jLayeredPane1.add(player1L, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        player2L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/GREEN1.png"))); // NOI18N
        jLayeredPane1.add(player2L, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        player3L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/RED1.png"))); // NOI18N
        jLayeredPane1.add(player3L, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        player4L.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/YELLOW1.png"))); // NOI18N
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
        System.out.println("User clicked on row:" + r);
        System.out.println("User clicked on column:" + c);
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
