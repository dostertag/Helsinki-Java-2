/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author kdost
 */
public class Employees {
    private List<Person> emps;
    
    public Employees() {
        this.emps = new ArrayList<Person>();
    }
    public void add(Person person) {
        emps.add(person);
    }
    public void add(List<Person> persons) {
        for (Person p : persons) {
            emps.add(p);
        }
    }
    public void print() {
        Iterator<Person> iterator = emps.iterator();
        while(iterator.hasNext()) {
            Person currentP = iterator.next();
            System.out.println(currentP);
        }
    }
    public void print(Education education) {
        Iterator<Person> iterator = emps.iterator();
        while(iterator.hasNext()) {
            Person currentP = iterator.next();
            if(currentP.getEducation() == education) {
                System.out.println(currentP);
            }
        }
    }
    public void fire(Education education) {
        Iterator<Person> iterator = emps.iterator();
        while(iterator.hasNext()) {
            if (iterator.next().getEducation() == education) {
                iterator.remove();
            }
        }
    }
}
