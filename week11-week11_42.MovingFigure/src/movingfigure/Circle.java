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
public class Circle extends Figure {

    private int diameter;
    
    public Circle(int x, int y, int diam) {
        super(x, y);
        diameter = diam;
    }
    
    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval(this.getX(), this.getY(), diameter, diameter);
    }
    
}
