/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author kdost
 */
public class Thermometer implements Sensor{

    private boolean state;
    private Random random;
    
    public Thermometer() {
        this.state = false;
        random = new Random();
    }
    @Override
    public boolean isOn() {
        return this.state;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void on() {
        this.state = true;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void off() {
        this.state = false;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int measure() {
        int measureReturn;
        if (this.state) {
            measureReturn = -30 + this.random.nextInt(30 - (-30) + 1);
            return measureReturn;
        } else {
            throw new IllegalStateException("Sensor is off");  
        }

    }
    
}
