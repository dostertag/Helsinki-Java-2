/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdost
 */
public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    // private boolean state;
    
    public AverageSensor() {
        this.sensors = new ArrayList<Sensor>();
        this.readings = new ArrayList<Integer>();
        // this.state = false;
    }
    
    public void addSensor(Sensor additional) {
        this.sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        for (Sensor sense : this.sensors) {
            if(!sense.isOn()) {
                return false;
                //this.state = false;
            }
        }
        // this.state = true;
        return true;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void on() {
        for (Sensor sense : this.sensors) {
            sense.on();;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void off() {
        for (Sensor sense : this.sensors) {
            sense.off();
        }
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int measure() {
        int averageTemp = 0;
        for (Sensor sense : this.sensors) {
            if (sense.isOn()) {
                // this.readings.add(sense.measure());
                averageTemp += sense.measure();
            } else {
                throw new IllegalStateException("Some sensor is off");
            }
        }
        int average = averageTemp / this.sensors.size();
        this.readings.add(average);
        return average;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
}
