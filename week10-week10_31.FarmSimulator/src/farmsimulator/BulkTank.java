/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

/**
 *
 * @author kdost
 */
public class BulkTank {
    private double capacity;
    private double volume;
    
    public BulkTank() {
        this.capacity = 2000.00;
        this.volume = 0.00;
    }
    public BulkTank(double capacity) {
        this.volume = 0.00;
        this.capacity = capacity;
    }
    public double getCapacity() {
        return this.capacity;
    }
    public double getVolume() {
        return this.volume;
    }
    public double howMuchFreeSpace() {
        return this.capacity - this.volume;
    }
    public void addToTank(double amount) {
        if(amount <= this.howMuchFreeSpace()){
            this.volume += amount;
        }else{
            this.volume = this.capacity;
        }
    }
    public double getFromTank(double amount) {
        if (this.volume >= amount) {
            this.volume -= amount;
            return amount;
        } else {
            this.volume = 0;
            return amount;
        }
    }
    public String toString() {
        return Math.ceil(this.volume) + "/" + Math.ceil(this.capacity);
    }
}
