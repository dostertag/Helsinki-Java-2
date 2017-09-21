
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Jumper implements Comparable<Jumper>{
    private String name;
    private int totalPoints;
    private List<Integer> jumps;

    
    public Jumper(String name){
        this.name = name;
        this.totalPoints = 0;
        this.jumps = new ArrayList<Integer>();
    }
    
    public void addPoints(int points){
        this.totalPoints += points;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void addJump(int jump){
        this.jumps.add(jump);
    }
    
    @Override
    public int compareTo(Jumper jumper){
        return jumper.totalPoints - this.totalPoints;
    }
    
    @Override
    public String toString(){
        return this.name + " (" + this.totalPoints + " points)";
    }
    
    public void printJumpLengths(){
        String formattedString = this.jumps.toString().replace("[", "").replace(",", " m,").replace("]", " m");
        System.out.print("            jump lengths: " + formattedString);
    }
   
}


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Participants {
    private List<Jumper> participants;
    private Random random = new Random();
    
    public Participants(){
        this.participants = new ArrayList<Jumper>();
    }
    
    public void add(Jumper jumper){
        this.participants.add(jumper);
    }
    
    public void play(){
        for(Jumper j : this.participants){
            int jumpLength = random.nextInt(120 - 60 + 1) + 60;
            j.addJump(jumpLength);
            List<Integer> evaluations = new ArrayList<Integer>();
            for( int i = 0; i < 5; i++){
                int eval = random.nextInt(20 - 10 + 1) + 10;
                evaluations.add(eval);   
            }
            System.out.println("  " + j.getName());
            System.out.println("    length: " + jumpLength);
            System.out.println("    judge votes: " + evaluations);
            Collections.sort(evaluations);
            evaluations.remove(0);
            evaluations.remove(evaluations.size() - 1);
            int sumOfEvaluations = 0;
            for(int i : evaluations){
                sumOfEvaluations = sumOfEvaluations + i;
            }
            int points = jumpLength + sumOfEvaluations;
            j.addPoints(points);
        }
    }
    
    public void print(){
        for(Jumper j : this.participants){
            System.out.println(j);
        }
    }
    
    public void printInOrder(){
        for(int i = 0; i < this.participants.size(); i++){
            int counter = i + 1;
            System.out.println("  " + counter + ". " + this.participants.get(i));
        }
    }
    
    public void printResults(){
        System.out.println("Position    Name");
        int counter = 1;
        for(Jumper j : this.participants){
            System.out.println(counter + "           " + j);
            j.printJumpLengths();
            counter++;
            System.out.println();
        }
    }
    
    public void sort(){
        Collections.sort(this.participants);
    }
    
    public void reverse(){
        Collections.reverse(this.participants);
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
    private Participants participants;
    
    public TextUserInterface(){
        this.reader = new Scanner(System.in);
        this.participants = new Participants();
    }
    
    public void launch(){
        this.getParticipants();
        this.round();
        this.results();
    }
    
    public void getParticipants(){
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");
        while(true){
            System.out.println("  Participant name: ");
            String name = reader.nextLine();
            if(name.isEmpty()){
                break;
            }
            Jumper jumper = new Jumper(name);
            this.participants.add(jumper);
        }
        System.out.println();
        System.out.println("The tournament begins!");
        System.out.println();
    }
    
    public void round(){
        int roundNumber = 1;
        while(true){
            System.out.println("Write \"jump\" to jump; otherwise you quit: ");
            String input = reader.nextLine();
            if(input.equals("quit")){
                break;
            }else if(input.equals("jump")){
                System.out.println();
                System.out.println("Round " + roundNumber);
                System.out.println();
                participants.sort();
                participants.reverse();
                System.out.println("Jumping order:");
                participants.printInOrder();
                System.out.println();
                System.out.println("Results of round " + roundNumber);
                participants.play();
                System.out.println();
                roundNumber++;
            }
        }
        System.out.println();
        System.out.println("Thanks!");
        System.out.println();
    }
    
    public void results(){
        participants.sort();
        System.out.println("Tournament results: ");
        participants.printResults();
    }    
}


public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        TextUserInterface textui = new TextUserInterface();
        textui.launch();
        
    }
}
