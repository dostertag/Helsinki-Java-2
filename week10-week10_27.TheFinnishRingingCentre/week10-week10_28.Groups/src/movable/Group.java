/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdost
 */
public class Group implements Movable {

    private List<Movable> groupOne;
    // private final ArrayList<Movable> groupOne;
    
    public Group() {
        this.groupOne = new ArrayList<Movable>();
    }
    
    @Override
    public void move(int dx, int dy) {
        for (Movable thing : this.groupOne) {
            thing.move(dx, dy);
        }
    }
    
    @Override
    public String toString() {
        String returnString = "";
        for (Movable thing : this.groupOne) {
            returnString += thing.toString() + "\n";
        }
        return returnString;
    }
    
    public void addToGroup(Movable movable) {
        this.groupOne.add(movable);
    }
    
}
