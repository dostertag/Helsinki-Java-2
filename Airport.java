
public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        TextUserInterface ui = new TextUserInterface();
        ui.start();
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
public class Plane {
    private String name;
    private int capacity;
    // private Flights flights;
    
    public Plane(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        // this.flights = new Flights();
    }
    @Override
    public String toString() {
        return this.name + " (" + this.capacity + " ppl)";
    }
    
    public String getPlane() {
        return this.name;
    }
    
    public int getCapacity() {
        return this.capacity;
    }
//    public void addFlight(Plane plane, String fromAndTo) {
//        plane.flights.addFlight(fromAndTo);
//    }
    
    
    
}

/**
 *
 * @author kdost
 */
public class Flights {
    private String depart;
    private String arrive;
    
    public Flights(String depart, String arrive) {
        this.depart = depart;
        this.arrive = arrive;
        
    }
    @Override
    public String toString() {
        return "(" + this.depart + "-" + this.arrive + ")";
    }
    
   
}


import java.util.ArrayList;
import java.util.HashMap;
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
public class PlaneDirectory {
    private ArrayList<Plane> planes;
    private ArrayList<Flights> flights;
    private Map<Plane, ArrayList<Flights>> database;
    
    public PlaneDirectory(){
        this.planes = new ArrayList<Plane>();
        this.flights = new ArrayList<Flights>();
        this.database = new HashMap<Plane, ArrayList<Flights>>();
    }
    
    public void addPlane(String id, int capacity){
        ArrayList<Flights> init = new ArrayList<Flights>();
        Plane plane = new Plane(id, capacity);
        this.planes.add(plane);
        this.database.put(plane, init);
    }
    
    public void addFlight(String id, String depart, String arriv){
        Plane plane = new Plane("",0);
        for(Plane p : this.planes){
            if(p.getPlane().equals(id)){
                plane = p;
            }
        }
        Flights flight = new Flights(depart, arriv);
        this.database.get(plane).add(flight);
    }
    
    public void printPlanes(){
        for(Plane p : this.planes){
            System.out.println(p);
        }
    }
    
    public void printFlights(){
        for(Plane p : this.database.keySet()){
            ArrayList<Flights> flights = this.database.get(p);
            for(Flights f : flights){
                System.out.println(p + " " + f);
            }
        }
    }
    
    public void printPlaneInfo(String id){
        for(Plane p : this.planes){
            if(p.getPlane().equals(id)){
                System.out.println(p);
            }
        }
    }
    
}
    


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class TextUserInterface {
    
    private Scanner reader;
    private PlaneDirectory planeDirectory;
    
    public TextUserInterface() {
        reader = new Scanner(System.in);
        planeDirectory = new PlaneDirectory();
    }
    
    public void start() {
        
        airportPanel();
        flightService();
    }
    
    public void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        
        while (true) {
            String userInput;
            System.out.println("Choose operation:");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            System.out.print("> ");
            userInput = reader.nextLine();
            if ("x".equals(userInput)) {
                break;
            } else if ("1".equals(userInput)) {
                addAirplane();
            } else if ("2".equals(userInput)) {
                addFlight();
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
    
    public void flightService() {
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        
        while (true) {
            String userInput;
            System.out.println("Choose operation:");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            System.out.print("> ");
            userInput = reader.nextLine();
            if ("x".equals(userInput)) {
                break;
            } else if ("1".equals(userInput)) {
                planeDirectory.printPlanes();
            } else if ("2".equals(userInput)) {
                planeDirectory.printFlights();
            } else if ("3".equals(userInput)) {
                printPlaneInfo();
            } else {
                System.out.println("Unknown command!");
            }
        }
    }
    
    public void addAirplane() {
        System.out.print("Give plane ID: ");
        String userPlaneID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int planeCapacity = Integer.parseInt(reader.nextLine());
        planeDirectory.addPlane(userPlaneID, planeCapacity);
    }
    
    public void addFlight() {
        System.out.print("Give plane ID: ");
        String userResponse = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String departureCode = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String destinationCode = reader.nextLine();
        planeDirectory.addFlight(userResponse, departureCode, destinationCode);
    }
//    
//    public void printPlanes() {
//        
//    }
//    
//    public void printFlights() {
//        
//    }
    
    public void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String userInput = reader.nextLine();
        planeDirectory.printPlaneInfo(userInput);
    }
}
