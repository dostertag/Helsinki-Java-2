/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Calculator {
    
    private Reader reader;
    private int counter;
    
    public Calculator() {
        this.reader = new Reader();
        this.counter = 0;
    }
    
    public void start() {
        
        while (true) {
            System.out.print("command: ");
            String command = this.reader.readString();
            if (command.equals("end")) {
                break;
            }
            
            if (command.equals("sum")) {
                this.sum();
            } else if (command.equals("difference")) {
                this.difference();
            } else if (command.equals("product")) {
                this.product();
            }
            
            
        }
        this.statistics();
    }
    
    private void sum () {
        this.counter++;
        System.out.print("Value 1: ");
        int firstValue;
        firstValue = reader.readInteger();
        System.out.print("Value 2: ");
        int secondValue = reader.readInteger();
        
        System.out.println("Sum of the values " + (firstValue + secondValue));
        
    }
    
    private void difference() {
        this.counter++;
        int firstValue, secondValue;
        System.out.print("Value 1: ");
        firstValue = reader.readInteger();
        System.out.print("Value 2: ");
        secondValue = reader.readInteger();
        
        System.out.println("difference of the values " + (firstValue - secondValue));
        
    }
    
    private void product() {
        this.counter++;;
        int firstValue, secondValue;
        System.out.print("Value 1: ");
        firstValue = reader.readInteger();
        System.out.print("Value 2: ");
        secondValue = reader.readInteger();
        System.out.println("product of the values " + (firstValue * secondValue));
    }
    
    private void statistics() {
        System.out.println("Calculations done: " + this.counter);
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
public class Reader {
    
    private Scanner reader;
    
    public Reader() {
        this.reader = new Scanner(System.in);
    }
    
    public String readString() {
        return this.reader.nextLine();
    }
    
    public int readInteger() {
       // int returnedValue = this.reader. 
        return Integer.parseInt(this.reader.nextLine());
    }
}
