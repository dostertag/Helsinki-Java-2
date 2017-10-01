
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class RingingCentre {
    private final Map<Bird, List<String>> center = new HashMap<Bird, List<String>>();
    
//    public RingingCentre() {
//        this.center = new HashMap<Bird, List<String>>();
//    }
    public void observe(Bird bird, String place) {
        List<String> places = new ArrayList<String>();
        if (this.center.keySet().contains(bird)) {
            this.center.get(bird).add(place);
        } else {
            places.add(place);
            this.center.put(bird, places);
        }
    }
    
    public void observations(Bird bird) {
        if (this.center.get(bird) == null) {
            System.out.println(bird.toString() + " observations: " + 0);
        } else {
            System.out.println(bird.toString() + " observations: " + this.center.get(bird).size());
            System.out.println(this.center.get(bird));
        }
    }
}
