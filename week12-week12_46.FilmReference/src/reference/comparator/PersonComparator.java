/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.Map;
import reference.domain.Person;

/**
 *
 * @author kdost
 */
public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> peopleIdentities;

    public PersonComparator(Map<Person, Integer> peopleIdentities) {
        this.peopleIdentities = peopleIdentities;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if(peopleIdentities.get(o1) == peopleIdentities.get(o2)) {
            return 0;
        } else if (peopleIdentities.get(o1) < peopleIdentities.get(o2)) {
            return 1;
        } else {
            return -1;
        }
    }
    
}
