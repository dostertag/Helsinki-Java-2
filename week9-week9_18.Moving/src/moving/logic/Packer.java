/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moving.logic;

import java.util.ArrayList;
import java.util.List;
import moving.domain.Box;
import moving.domain.Thing;

/**
 *
 * @author kdost
 */
public class Packer {
    private Box box;
    private List<Box> boxes;
    
    public Packer(int boxesVolume) {
        this.box = new Box(boxesVolume);
        this.boxes = new ArrayList<Box>();
    }
    public List<Box> packThings(List<Thing> things) {
        if(this.boxes.isEmpty() == true) {
            this.boxes.add(box);
            for (Thing thing : things) {
                if (this.box.addThing(thing) == true) {
                    
                } else {
                    Box addABox = new Box(this.box);
                    addABox.addThing(thing);
                    this.boxes.add(addABox);
                }
            }
        }
        return this.boxes;
    }

}
