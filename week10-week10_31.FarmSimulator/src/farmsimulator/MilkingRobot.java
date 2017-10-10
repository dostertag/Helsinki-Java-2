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
public class MilkingRobot {
    private BulkTank someTank;
    
    public MilkingRobot() {
        
    }
    public BulkTank getBulkTank() {
        if (this.someTank == null) {
            return null;
        } else {
            return this.someTank;
        }
    }
    public void setBulkTank(BulkTank bulkTank) {
        this.someTank = bulkTank;
    }
    public void milk(Milkable milkable) {
        if(this.getBulkTank() == null) {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        } else {
            this.someTank.addToTank(milkable.milk());
        }
    }
}
