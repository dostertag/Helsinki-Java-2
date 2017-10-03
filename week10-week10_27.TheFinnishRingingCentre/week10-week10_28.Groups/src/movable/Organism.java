/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

/**
 *
 * @author kdost
 */
public class Organism implements Movable {

    private int posX;
    private int posY;
    
    public Organism (int x, int y) {
        this.posX = x;
        this.posY = y;
    }
    
    @Override
    public void move(int dx, int dy) {
        this.posX += dx;
        this.posY += dy;
    }
    public String toString() {
        return "x: " + this.posX + "; y: " + this.posY;
    }
    
}
