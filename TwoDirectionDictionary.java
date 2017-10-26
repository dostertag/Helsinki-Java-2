/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.util.stream.Collectors.joining;

/**
 *
 * @author kdost
 */
public class MindfulDictionary {
    private Map<String, String> dictOne;
    private File file;
    private Scanner input;
    
    public MindfulDictionary() {
        this.dictOne = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) {
        this.dictOne = new HashMap<String, String>();
        this.file = new File(file);
    }
    public boolean load() {
        try {
            String[] tempSplit;
            this.input = new Scanner(this.file);
            while (this.input.hasNextLine()) {
                String line = this.input.nextLine();
                tempSplit = line.split(":");
                this.dictOne.put(tempSplit[0], tempSplit[1]);
            }
            return true;           
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            return false;
        }
    }
    public void add(String word, String translation) {
        if(!this.dictOne.containsKey(word)) {
            this.dictOne.put(word, translation);
        }
        // System.out.println(this.dictOne.get(word));
    }
    public String translate(String word) {
        String tempKey = "";
        if (this.dictOne.containsKey(word)) {
            return this.dictOne.get(word);
        } else if (this.dictOne.containsValue(word)){
            for (Map.Entry<String, String> k : this.dictOne.entrySet()) {
                if (word.equals(k.getValue())){
                    tempKey = k.getKey();
                    return tempKey;
                }
            }
        } 
        return null;
        
    }
    public <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
    public void remove(String word) {
        
        if (this.dictOne.containsKey(word)) {
            this.dictOne.remove(word);
        } else {
            String key = getKeyByValue(this.dictOne, word);
            this.dictOne.remove(key);
        }
    }
    public boolean save() {

        String toFile = "";
        String temp = "";
        for (String key : this.dictOne.keySet()) {
            temp = key + ":" + this.dictOne.get(key) + "\n";
            toFile += temp;
        }
        try {
            FileWriter writer = new FileWriter(this.file);
            writer.write(toFile);
            writer.close();
        } catch (IOException e){
            System.out.println("dude, you broke it! ---- problem writing to file.");
            return false;
        }
        return true;
    }
    
}
