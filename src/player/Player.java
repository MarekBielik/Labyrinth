/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import labyrinth.Labyrinth;
import treasure.TreasureCard;

/**
 *
 * @author marek
 */
public class Player implements Serializable{
    
       /**
        * player's name
        */
       public String name;  
    
       /**
        * horizontal position of player
        */
       public int x;
       
       /**
        * vertical position of player
        */
       public int y;
       
       /**
        * all players
        */
       public static Player[] players;
       
       /**
        * player's treasure card
        */
       public TreasureCard treasureCard;
       
       /**
        * player's score
        */
       public int score = 0;
       
       /**
        * points to active player
        */
       public static int activePos = 0;
       
       /**
        * creates players
        */
       public static void createPlayers() {
           players = new Player[Labyrinth.boardSize];
           for (int n = 0; n < Labyrinth.numbeOfPlayers; n++)
               players[n] = new Player(n);
       }
       
       /**
        * finds out whether the player is on the given field or not
        */
       public static boolean isPlayerOnField(int n, int x, int y) {
           if (players[n].x == x && players[n].y == y)
               return true;
           else 
               return false;
       }
       
       /**
        * creates a new player
        * @param n player's number
        */
       public Player(int n) {
           switch(n) {
               case 0:
                   x = 1;
                   y = 1;
                   name = "Player1:";
                   break;
                   
               case 1:
                   x = Labyrinth.boardSize;
                   y = Labyrinth.boardSize;
                   name = "Player2:";
                   break;
               case 2:
                   x = Labyrinth.boardSize;
                   y = 1;
                   name = "Player3:";
                   break;
               case 3:
                   x = 1;
                   y = Labyrinth.boardSize;
                   name = "Player4:";
                   break; 
           }
           
           treasureCard = Labyrinth.pack.popCard();
       }
       
       /**
        * turns activity to next player
        */
       public static void nextPlayer() {
           if (activePos == Labyrinth.numbeOfPlayers -1) //set activity to the first player
               activePos = 0;
           else
               ++activePos;
       }
       
}
