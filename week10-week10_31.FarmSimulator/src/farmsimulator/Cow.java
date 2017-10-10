/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Random;

/**
 *
 * @author kdost
 */
public class Cow implements Milkable, Alive{
    
    private static final String[] NAMES = new String[]{
    "Anu", "Arpa", "Essi", "Heluna", "Hely",
    "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
    "Jaana", "Jami", "Jatta", "Laku", "Liekki",
    "Mainikki", "Mella", "Mimmi", "Naatti",
    "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
    "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};
        
    private String name;
    private int udders;
    private Random rand = new Random();
    private double currentMilk;
    
    public Cow() {
        this.name = NAMES[rand.nextInt(NAMES.length)];
        this.udders = 15 + rand.nextInt(26);
        this.currentMilk = 0;
    }
    public Cow(String name) {
        this.name = name;
        this.udders = 15 + rand.nextInt(26);
        this.currentMilk = 0;
    }
    public String getName() {
        return this.name;
    }
    public double getCapacity() {
        return this.udders;
    }
    @Override
    public String toString() {
        return this.name + " " + this.currentMilk + "/" + this.udders;
    }
    public double getAmount() {
        return this.currentMilk;
    }
    @Override
    public double milk() {
        double returnThisMilk = this.currentMilk;
        this.currentMilk = 0.0;
        return returnThisMilk;        
    }

    @Override
    public void liveHour() {
        double milkProduct = Math.ceil(0.7 + (2 - 0.7) * rand.nextDouble());
        if (this.currentMilk + milkProduct <= this.udders) {
            this.currentMilk += milkProduct;
        }
    }
    
    
}
