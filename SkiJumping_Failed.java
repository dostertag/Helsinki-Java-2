package skijumping_failed;


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
public class Participant implements Comparable<Participant>{
    private String name;
    private int points;
    private List<Integer> jumps;
    
    public Participant(String name, int points) {
        this.name = name;
        this.points = 0;
        this.jumps = new ArrayList<Integer>();
    }
    @Override
    public String toString() {
        return this.name + " (" + this.points + ")";
    }
    @Override
    public int compareTo(Participant part) {
        return this.points - part.points;
    }
    
    public void addPoints(int points) {
        this.points += points;
    }
}

package skijumping_failed;


import java.util.ArrayList;
import java.util.Collections;
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
public class ParticipantList {
    private List<Participant> participants;
    // private Random random = new Random();
    
    public ParticipantList() {
        this.participants = new ArrayList<Participant>();
    }
    
    public void addParticipant(Participant participant) {
        this.participants.add(participant);
    }
    
    public void sort() {
        Collections.sort(this.participants);
    }
    
    public void reverseOrder() {
        Collections.reverse(this.participants);
    }
    
    public int getSize() {
        return this.participants.size();
    }
    @Override
    public String toString() {
        for (Participant part : this.participants) {
            System.out.println(part);
        }
    }
}

package skijumping_failed;


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
public class TextUserInterfaceFailed {
    private Scanner scanner;
    private int round;
    private ParticipantList participants;
    
    
    public TextUserInterfaceFailed() {
        this.scanner = new Scanner(System.in);
        this.round = 1;
        this.participants = new ParticipantList();
    }
    
    public void start() {
        System.out.println("Kumpula ski jumping week");
        System.out.println();
        enterParticipants();
        roundsStart();
        // printResults();
    }
    
    public void enterParticipants() {
        //ParticipantList jumpers = new ParticipantList();
        String inputName;
        System.out.println("Write the name of the participants one at a time; an empty string brings you to the jumping phase");
        while(true) {
            System.out.print("  Participant name: ");
            inputName = this.scanner.nextLine();
            if (inputName.isEmpty()) {
                break;
            } else {
                Participant newPar = new Participant(inputName, 0);
                this.participants.addParticipant(newPar);
            }
        }
        System.out.println("");
        System.out.println("The tounament begins!");
        System.out.println("");
        
    }
    public void roundsStart() {
        String command = "";
        while(true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            command = this.scanner.nextLine();
            System.out.println();
            System.out.println("Round " + this.round);
            System.out.println();
            if(command.isEmpty()) {
                break;
            } else {
                this.participants.sort();
                System.out.println("Jumping Order:");
                System.out.println("");
                printJumpingOrder(this.participants);
                System.out.println("");
                System.out.println("Results of round " + this.round);
            }
            
            
            
            this.round++;
        }
    }
    
    public void printJumpingOrder(ParticipantList participantList) {
        for (int i = 0; i < this.participants.getSize(); i++) {
            System.out.println(" " + (i + 1) + this.participants.toString());
        }
    }
}
