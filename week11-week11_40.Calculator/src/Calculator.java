/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Calculator {
    private int value;
    
    public Calculator() {
        this.value = 0;
    }
    public int giveValue() {
        return value;
    }
    public void add(int amount) {
        value += amount;
    }
    public void subtract(int amount) {
        value -= amount;
    }
    public void reset() {
        value = 0;
    }
}
