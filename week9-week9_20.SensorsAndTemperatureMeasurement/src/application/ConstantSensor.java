/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author kdost
 */
public class ConstantSensor implements Sensor{

    private int measure;
    // private boolean state;
    public ConstantSensor(int measure){
        this.measure = measure;
        // this.state = true;
    }
    
    @Override
    public boolean isOn() {
        return true;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void on() {
        // this.state = true;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void off() {
        // this.state = false;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int measure() {
        return this.measure;
    }
    
}
