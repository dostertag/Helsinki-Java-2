/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package containers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdost
 */
public class ContainerHistory {
    
    private ArrayList<Double> history;
    
    public ContainerHistory() {
        this.history = new ArrayList<Double>();
    }
    public void add(double situation) {
        this.history.add(situation);
    }
    public void reset() {
        this.history.clear();
    }
    @Override
    public String toString() {
        return this.history.toString();
    }
    public double maxValue() {
        double temp = 0;
        if (this.history.isEmpty()) {
            return 0.0;
        } else {
            for (double d : this.history) {
                if(d > temp) {
                    temp = d;
                }
            }
        }
        return (double)temp;
    }
    public double minValue() {
        double temp = Double.MAX_VALUE;
        if (this.history.isEmpty()) {
            return 0.0;
        } else {
            for (double d : this.history) {
                if (d < temp) {
                    temp = d;
                }
            }
        }
        return temp;
    }
    public double average() {
        double average = 0;
        if (this.history.isEmpty()) {
            return 0.0;
        } else {
            for (double d : this.history) {
                average += d;
            }
        }
        return (double)average / this.history.size();
    }
    public double greatestFluctuation() {
//        double someAverage = this.average();
//        double temp = 0;
//        for (double d : this.history) {
//            temp += (d - someAverage) * (d - someAverage);
//        }
//        return temp / (this.history.size() - 1);

        List<Double> fluctuations = new ArrayList<Double>();
        double greatestFluctuation = 0;
        if(this.history.isEmpty() || this.history.size() == 1){
            return greatestFluctuation;
        }else{
            for(int i = this.history.size() - 1; i >= 1; i--){
                double fluctuation = Math.abs(this.history.get(i) - this.history.get(i-1));
                fluctuations.add(fluctuation);
            }
        }
        for(double f : fluctuations){
            if(greatestFluctuation < f){
                greatestFluctuation = f;
            }
        }
        return greatestFluctuation;

    }
    public double variance(){
        double varianceSum = 0.0;
        if(this.history.isEmpty() || this.history.size() == 1){
            return varianceSum;
        }else{
            for(double v : this.history){
                varianceSum += (double)(v - this.average())*(v - this.average());
            }
        }
        double variance = (double)varianceSum/(this.history.size() - 1);
        return variance;
    }
    
}
