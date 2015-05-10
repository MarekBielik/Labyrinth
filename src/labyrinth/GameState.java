/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinth;

import board.MazeBoard;
import java.io.Serializable;
import player.Player;
import treasure.CardPack;

/**
 *
 * @author marek
 * Stores one state of the game.
 */
public class GameState implements Serializable {
    
    protected MazeBoard mazeBoard;
    protected CardPack cardPack;
    protected Player[] players;
    protected int activePos = Player.activePos;
    
    public GameState (boolean store) {
        if (store) {
            mazeBoard = Labyrinth.mazeBoard;
            cardPack = Labyrinth.pack;
            players = Player.players;
            activePos = Player.activePos;
        }
    }
    
}
