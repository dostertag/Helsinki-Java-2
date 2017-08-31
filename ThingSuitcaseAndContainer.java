
public class Main {

    public static void main(String[] args) {
        // use this main class to test your program!
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    
    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 1; i <= 100; i++) {
            Thing thing = new Thing("brick", i);
            Suitcase suitcase = new Suitcase(i);
            suitcase.addThing(thing);
            container.addSuitcase(suitcase);
        }
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Thing {
    
    private String name;
    private int weight;
    
    public Thing (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public String toString() {
        return this.name + " (" + this.weight + ")kg";
    }
    
}


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Suitcase {
    
    private ArrayList<Thing> listOfItems;
    private int maxWeight;
    
    public Suitcase(int maximumWeightLimit) {
        this.listOfItems = new ArrayList<Thing>();
        this.maxWeight = maximumWeightLimit;
        
    }
        
    public void addThing(Thing thing) {
        if ((this.totalWeight() + thing.getWeight()) <= this.maxWeight) {
            this.listOfItems.add(thing);
        }
    }
    
    @Override
    public String toString() {
        if (this.listOfItems.size() < 1) {
            return "empty (0kg)";
        } else if (this.listOfItems.size() == 1) {
            return this.listOfItems.size() + " thing (" + this.totalWeight() + ")kg";
        } else {
            return this.listOfItems.size() + " things (" + this.totalWeight() + ")kg";
        }
    }
    
    public int totalWeight() {
        int sum = 0;
        for (Thing thing : this.listOfItems) {
            sum += thing.getWeight();
        }
        return sum;
    }
    
    public void printThings() {
        for (Thing thing : this.listOfItems) {
            System.out.println(thing.toString());
        }
    }
    
    public Thing heaviestThing() {
        Thing heaviestThing = new Thing("", 0);
        int heaviestWeight = 0;
        if (this.listOfItems.isEmpty()) {
            return null;
        } else {
            for (Thing thing : this.listOfItems) {
                if (thing.getWeight() > heaviestWeight) {
                    heaviestThing = thing;
                    heaviestWeight = thing.getWeight();
                }
            }
            
        }
        return heaviestThing;
    }
    
    
    
}


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Container {
    
    private int maximumWeightLimit;
    private ArrayList<Suitcase> listOfCases;
    
    public Container(int maximumWeightLimit) {
        this.maximumWeightLimit = maximumWeightLimit;
        this.listOfCases = new ArrayList<Suitcase>();
    }
    
    public void addSuitcase(Suitcase suitcase) {
        if ((this.totalWeightSuitcases() + suitcase.totalWeight()) <= this.maximumWeightLimit) {
            this.listOfCases.add(suitcase);
        }
    }
    
    @Override
    public String toString() {
        int weightOfAll = 0;
        for (Suitcase eachCase : this.listOfCases) {
            weightOfAll += eachCase.totalWeight();
        }
        return this.listOfCases.size() + " suitcases (" + weightOfAll + ")kg";
    }
    
    private int totalWeightSuitcases() {
        int totalWeightList = 0;
        for (Suitcase thisCase : this.listOfCases) {
            totalWeightList += thisCase.totalWeight();
        }
        return totalWeightList;
    }
    
    public void printThings() {
        for (Suitcase thisCase : this.listOfCases) {
            thisCase.printThings();
        }
    }
    
}
