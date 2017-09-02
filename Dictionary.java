import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Dictionary dict = new Dictionary();

        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}


import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Dictionary {
    private HashMap<String, String> dictionary;
    
    public Dictionary() {
        this.dictionary = new HashMap<String, String>();
    }
    
    public void add(String key, String value) {
        this.dictionary.put(key, value);
    }
    
    public String translate(String key) {
        if (this.dictionary.containsKey(key)) {
            return this.dictionary.get(key);
        }
        return null;
    }
    
    public int amountOfWords() {
        return this.dictionary.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> newArrayList = new ArrayList<String>();
        for (String key : this.dictionary.keySet()) {
            newArrayList.add(key + "=" + this.dictionary.get(key));
        }
        return newArrayList;
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
    private Dictionary dictionary;
    
    public TextUserInterface(Scanner scanner, Dictionary dictionary) {
        this.reader = scanner;
        this.dictionary = dictionary;
    }
    
    public void start() {
        String userResponse;
        System.out.println("Statements: ");
        System.out.println("add - adds a word pair to the dictionary");
        System.out.println("translate - ");
        System.out.println("   quit - quit the text interface");
        while (true) {
            System.out.print("Statement: ");
            userResponse = reader.nextLine();
            if ("quit".equals(userResponse)) {
                break;
            } else if ("add".equals(userResponse)){
                this.add();
            } else if ("translate".equals(userResponse)) {
                this.translate();
            } else {
                System.out.println("Unknown statement");
            }
        }
        System.out.println("Cheers!");
    }
    
    public void translate() {
        String key;
        System.out.print("Give a word: ");
        key = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(key));
    }
    
    public void add() {
        String key;
        String value;
        System.out.print("In Finnish: ");
        key = reader.nextLine();
        System.out.print("Translation: ");
        value = reader.nextLine();
        dictionary.add(key, value);
    }
}
