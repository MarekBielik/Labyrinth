/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import labyrinth.Labyrinth;
import java.awt.*;
import java.rmi.server.LoaderHandler;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent.*;
import javax.swing.JLayeredPane;
import player.Player;

/**
 *
 * @author marek
 */
public class GameP extends javax.swing.JPanel {

    public ArrayList<FieldP> pack = new ArrayList<FieldP>();
    
    /**
     * Creates new form GameP
     */
    public GameP() {
        initComponents();
        
        switch (Labyrinth.boardSize) {
            
            case 5: board.setPreferredSize(new java.awt.Dimension(380, 380));
                    Labyrinth.gui.setSize(380, 700);
                    this.setPreferredSize(new java.awt.Dimension(380, 700));
                    break;
            case 7: board.setPreferredSize(new java.awt.Dimension(550, 550));
                    this.setPreferredSize(new java.awt.Dimension(600, 850));
                    Labyrinth.gui.setSize(530, 850);                
                    break;
            case 9: Labyrinth.gui.setSize(680, 1000);
                    board.setPreferredSize(new java.awt.Dimension(680, 680));
                    this.setPreferredSize(new java.awt.Dimension(900, 1000));              
                    break;
           case 11: board.setPreferredSize(new java.awt.Dimension(830, 830));
                    this.setPreferredSize(new java.awt.Dimension(830, 1100));
                    Labyrinth.gui.setSize(830, 1100);
                    break;
        }
        
        switch (Labyrinth.numbeOfPlayers)
        {
            case 2:
                Player3JP.setVisible(false);
                Player4JP.setVisible(false);
                break;
            case 3:
                Player4JP.setVisible(false);
                break;
            case 4:
                break;
            default:
                Player3JP.setVisible(false);
                Player4JP.setVisible(false);
                break;
        }
        
        repaint();
     
        printBoard();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        board = new javax.swing.JPanel();
        PlayersLP = new javax.swing.JLayeredPane();
        Player1JP = new javax.swing.JPanel();
        P1nameL = new javax.swing.JLabel();
        P1pictureL = new javax.swing.JLabel();
        P1skoreL = new javax.swing.JLabel();
        P1scoreCounterL = new javax.swing.JLabel();
        Player2JP = new javax.swing.JPanel();
        P2nameL = new javax.swing.JLabel();
        P2pictureL = new javax.swing.JLabel();
        P2scoreL = new javax.swing.JLabel();
        P2scoreCounterL = new javax.swing.JLabel();
        Player3JP = new javax.swing.JPanel();
        P3nameL = new javax.swing.JLabel();
        P3pictureL = new javax.swing.JLabel();
        P3scoreL = new javax.swing.JLabel();
        P3scoreCounterL = new javax.swing.JLabel();
        Player4JP = new javax.swing.JPanel();
        P4nameL = new javax.swing.JLabel();
        P4scoreL = new javax.swing.JLabel();
        P4scoreCounterL = new javax.swing.JLabel();
        P4pictureL1 = new javax.swing.JLabel();
        controlP = new javax.swing.JPanel();
        playerTreasureP = new javax.swing.JPanel();
        actualPlayer = new javax.swing.JLabel();
        playerCard = new javax.swing.JLabel();
        nextB = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(100, 200));
        setPreferredSize(new java.awt.Dimension(0, 0));

        board.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        board.setMinimumSize(new java.awt.Dimension(375, 375));
        board.setPreferredSize(new java.awt.Dimension(380, 380));
        board.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        add(board);

        PlayersLP.setMinimumSize(new java.awt.Dimension(500, 110));
        PlayersLP.setPreferredSize(new java.awt.Dimension(450, 220));
        PlayersLP.setLayout(new java.awt.FlowLayout());

        Player1JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Player1JP.setPreferredSize(new java.awt.Dimension(90, 100));

        P1nameL.setText("Player 1");

        P1pictureL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/BLUE1.png"))); // NOI18N

        P1skoreL.setText("Skore:");

        P1scoreCounterL.setText("0");

        javax.swing.GroupLayout Player1JPLayout = new javax.swing.GroupLayout(Player1JP);
        Player1JP.setLayout(Player1JPLayout);
        Player1JPLayout.setHorizontalGroup(
            Player1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player1JPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Player1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P1nameL)
                    .addGroup(Player1JPLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(P1pictureL))
                    .addGroup(Player1JPLayout.createSequentialGroup()
                        .addComponent(P1skoreL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(P1scoreCounterL)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        Player1JPLayout.setVerticalGroup(
            Player1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player1JPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P1nameL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P1pictureL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Player1JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P1skoreL)
                    .addComponent(P1scoreCounterL))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        PlayersLP.add(Player1JP);

        Player2JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Player2JP.setPreferredSize(new java.awt.Dimension(90, 100));

        P2nameL.setText("Player 2");

        P2pictureL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/GREEN1.png"))); // NOI18N

        P2scoreL.setText("Skore:");

        P2scoreCounterL.setText("0");

        javax.swing.GroupLayout Player2JPLayout = new javax.swing.GroupLayout(Player2JP);
        Player2JP.setLayout(Player2JPLayout);
        Player2JPLayout.setHorizontalGroup(
            Player2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player2JPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Player2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P2nameL)
                    .addComponent(P2pictureL)
                    .addGroup(Player2JPLayout.createSequentialGroup()
                        .addComponent(P2scoreL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(P2scoreCounterL)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        Player2JPLayout.setVerticalGroup(
            Player2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player2JPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P2nameL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P2pictureL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Player2JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P2scoreL)
                    .addComponent(P2scoreCounterL))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PlayersLP.add(Player2JP);

        Player3JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Player3JP.setPreferredSize(new java.awt.Dimension(90, 100));

        P3nameL.setText("Player 3");

        P3pictureL.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/YELLOW1.png"))); // NOI18N

        P3scoreL.setText("Skore:");

        P3scoreCounterL.setText("0");

        javax.swing.GroupLayout Player3JPLayout = new javax.swing.GroupLayout(Player3JP);
        Player3JP.setLayout(Player3JPLayout);
        Player3JPLayout.setHorizontalGroup(
            Player3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player3JPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Player3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P3nameL)
                    .addComponent(P3pictureL)
                    .addGroup(Player3JPLayout.createSequentialGroup()
                        .addComponent(P3scoreL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(P3scoreCounterL)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        Player3JPLayout.setVerticalGroup(
            Player3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player3JPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P3nameL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P3pictureL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Player3JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P3scoreL)
                    .addComponent(P3scoreCounterL))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PlayersLP.add(Player3JP);

        Player4JP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Player4JP.setPreferredSize(new java.awt.Dimension(90, 100));

        P4nameL.setText("Player 4");

        P4scoreL.setText("Skore:");

        P4scoreCounterL.setText("0");

        P4pictureL1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/RED1.png"))); // NOI18N

        javax.swing.GroupLayout Player4JPLayout = new javax.swing.GroupLayout(Player4JP);
        Player4JP.setLayout(Player4JPLayout);
        Player4JPLayout.setHorizontalGroup(
            Player4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player4JPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Player4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(P4nameL)
                    .addGroup(Player4JPLayout.createSequentialGroup()
                        .addComponent(P4scoreL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(P4scoreCounterL))
                    .addComponent(P4pictureL1))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        Player4JPLayout.setVerticalGroup(
            Player4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Player4JPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(P4nameL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(P4pictureL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Player4JPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P4scoreL)
                    .addComponent(P4scoreCounterL))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        PlayersLP.add(Player4JP);

        controlP.setPreferredSize(new java.awt.Dimension(380, 110));

        playerTreasureP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTreasureP.setMinimumSize(new java.awt.Dimension(140, 130));
        playerTreasureP.setPreferredSize(new java.awt.Dimension(90, 100));
        playerTreasureP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        actualPlayer.setText("Player1:");
        playerTreasureP.add(actualPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 20));

        playerCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/s1.png"))); // NOI18N
        playerTreasureP.add(playerCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 50));

        controlP.add(playerTreasureP);

        nextB.setText("Next");
        nextB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBActionPerformed(evt);
            }
        });
        controlP.add(nextB);

        PlayersLP.add(controlP);

        add(PlayersLP);
    }// </editor-fold>//GEN-END:initComponents

    private void nextBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextBActionPerformed


    public void printBoard() {
        for(int r = 1; r < Labyrinth.mazeBoard.board.length; r++) {
            for (int c = 1; c < Labyrinth.mazeBoard.board.length; c++) {
                board.add(new FieldP(c, r));
            }
        }
        
        controlP.add(new FieldP());
        
        playerCard.setIcon(FieldP.getTreasureIcon(Player.players[Player.activePos].treasureCard));
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P1nameL;
    private javax.swing.JLabel P1pictureL;
    private javax.swing.JLabel P1scoreCounterL;
    private javax.swing.JLabel P1skoreL;
    private javax.swing.JLabel P2nameL;
    private javax.swing.JLabel P2pictureL;
    private javax.swing.JLabel P2scoreCounterL;
    private javax.swing.JLabel P2scoreL;
    private javax.swing.JLabel P3nameL;
    private javax.swing.JLabel P3pictureL;
    private javax.swing.JLabel P3scoreCounterL;
    private javax.swing.JLabel P3scoreL;
    private javax.swing.JLabel P4nameL;
    private javax.swing.JLabel P4pictureL1;
    private javax.swing.JLabel P4scoreCounterL;
    private javax.swing.JLabel P4scoreL;
    private javax.swing.JPanel Player1JP;
    private javax.swing.JPanel Player2JP;
    private javax.swing.JPanel Player3JP;
    private javax.swing.JPanel Player4JP;
    private javax.swing.JLayeredPane PlayersLP;
    private javax.swing.JLabel actualPlayer;
    private javax.swing.JPanel board;
    private javax.swing.JPanel controlP;
    private javax.swing.JButton nextB;
    private javax.swing.JLabel playerCard;
    private javax.swing.JPanel playerTreasureP;
    // End of variables declaration//GEN-END:variables
}
