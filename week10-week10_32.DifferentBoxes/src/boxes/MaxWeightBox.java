/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author kdost
 */
public class MaxWeightBox extends Box {
    private Collection<Thing> things;
    private int maxWeight;
    
    public MaxWeightBox(int maxWeight) {
        this.maxWeight = maxWeight;
        this.things = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing) {
       int tempWeight = 0;
       for(Thing t : this.things) {
           tempWeight += t.getWeight();
       }
       if ((thing.getWeight() + tempWeight) <= this.maxWeight) {
           this.things.add(thing);
       }
    }
    @Override
    public boolean isInTheBox(Thing thing) {
        for(Thing t : this.things) {
            if( t.equals(thing)) {
                return true;
            }
        }
        return false;
    }

}
