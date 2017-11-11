/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static wormgame.Direction.DOWN;
import static wormgame.Direction.LEFT;
import static wormgame.Direction.RIGHT;
import static wormgame.Direction.UP;
import wormgame.domain.Worm;

/**
 *
 * @author kdost
 */
public class KeyboardListener implements KeyListener {
    private Worm worm;
    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                worm.setDirection(LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                worm.setDirection(RIGHT);
                break;
            case KeyEvent.VK_UP:
                worm.setDirection(UP);
                break;
            case KeyEvent.VK_DOWN:
                worm.setDirection(DOWN);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    
}
