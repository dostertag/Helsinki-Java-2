/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdost
 */
public class Farm implements Alive {
    private String owner;
    private List<Cow> herd;
    private Barn barn;
    //private MilkingRobot bob;
    
    public Farm(String name, Barn barn) {
        this.owner = name;
        // BulkTank tank = new BulkTank();
        this.barn = barn;
        this.herd = new ArrayList<Cow>();
        // this.bob = new MilkingRobot();
        // this.barn.installMilkingRobot(new MilkingRobot());
    }

    @Override
    public void liveHour() {
        for(Cow c : this.herd) {
            c.liveHour();
        }
    }
    public String getOwner() {
        return this.owner;
    }
    public void addCow(Cow cow) {
        this.herd.add(cow);
    }
    private String printHerd() {
        String returnString = "";
        if (this.herd.isEmpty()) {
            returnString = "No cows.";
        } else {
            returnString = "Animals:" + "\n";
            for(Cow c : this.herd) {
                returnString += "        " + c.toString() + "\n";
            }
        }
        return returnString;
    }
    @Override
    public String toString() {
        return "Farm owner: " + this.getOwner() + "\n" +
                this.barn.toString() + "\n" +
                this.printHerd();
//        System.out.println("Farm owner: " + this.getOwner());
//        System.out.println(this.barn.toString());
//        this.printHerd();
    }
    public void manageCows() {
        this.barn.takeCareOf(this.herd);
    }
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.barn.installMilkingRobot(milkingRobot);
    }
}
