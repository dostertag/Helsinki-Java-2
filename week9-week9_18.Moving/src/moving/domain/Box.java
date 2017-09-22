/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kdost
 */
public class Box implements Thing{
    private int maximumCapacity;
    private List<Thing> boxItems;
    // private int currentVolume;
    
    public Box(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        this.boxItems = new ArrayList<Thing>();
        // this.currentVolume = 0;
    }
    public Box(Box newBox) {
        this.boxItems = new ArrayList<Thing>();
        this.maximumCapacity = newBox.maximumCapacity;
    }
    public boolean addThing(Thing thing) {
        if(this.getVolume() + thing.getVolume() > this.maximumCapacity) {
            return false;
        } else {
            this.boxItems.add(thing);
            return true;
        }
    }

    @Override
    public int getVolume() {
        int currentVolume = 0;
        for (Thing t : this.boxItems) {
            currentVolume += t.getVolume();
        }
        return currentVolume;
    }
    
}
