/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farmsimulator;

import java.util.Collection;

/**
 *
 * @author kdost
 */
public class Barn {
    private BulkTank tank;
    private MilkingRobot bob;
    
    public Barn(BulkTank tank) {
        this.tank = tank;
    }
    public BulkTank getBulkTank() {
        if (this.tank == null) {
            return null;
        } else {
            return this.tank;
        }
    }
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.bob = milkingRobot;
        this.bob.setBulkTank(this.tank);
    }
    public void takeCareOf(Cow cow) {
        if(this.bob == null) {
            throw new IllegalStateException ("No bob yet!");
        } else {
            this.bob.milk(cow);
        }
    }
    public void takeCareOf(Collection<Cow> cows) {
        if(this.bob == null) {
            throw new IllegalStateException("No bob yet! Please install!");
        } else {
            for (Cow c : cows) {
                this.bob.milk(c);
            }
        }
    }
    public String toString() {
        return "Barn: " + this.tank.toString();
    }
}
