/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;

/**
 *
 * @author kdost
 */
public abstract class Figure {
    private int posX;
    private int posY;
    
    public Figure(int x, int y) {
        posX = x;
        posY = y;
    }
    public Figure() {
        
    }
    public abstract void draw(Graphics graphics);
    
    
    public void move(int x, int y) {
        this.posX += x;
        this.posY += y;
    }
    public int getX() {
        return posX;
    }
    public int getY() {
        return posY;
    }
}
