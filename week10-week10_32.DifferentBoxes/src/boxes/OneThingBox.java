/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author kdost
 */
public class OneThingBox extends Box{
    private Thing thing;
    
    public OneThingBox() {
        
    }

    @Override
    public void add(Thing thing) {
        if(this.thing == null) {
            this.thing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        return thing.equals(this.thing);
    }
    
}
