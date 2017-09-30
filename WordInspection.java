/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeArray.reverse;

/**
 *
 * @author kdost
 */
public class WordInspection {
    
    private File file;
    private Scanner reader;
    private List<String> fileRead;
    private final String vowels = "aeiouyäö";
    
    public WordInspection (File file) throws Exception {
        this.file = file;
        this.reader = new Scanner(file, "UTF-8");
        this.fileRead = new ArrayList<String>();
        while(this.reader.hasNextLine()) {
            this.fileRead.add(reader.nextLine());
        }
    }
    
    public int wordCount() {
        return this.fileRead.size();
    }
    
    public List<String> wordsContainingZ() {
        List<String> returnList = new ArrayList<String>();
        for (String s : this.fileRead) {
            if (s.contains("z")) {
                returnList.add(s);
            }
        }
        return returnList;
    }
    
    public List<String> wordsEndingInL() {
        List<String> returnList = new ArrayList<String>();
        for (String s : this.fileRead) {
            int lastLetter = s.length() - 1;
            if (s.substring(lastLetter).equals("l")) {
                returnList.add(s);
            }
        }
        System.out.println(returnList);
        return returnList;
    }
    
    public List<String> palindromes() {
        List<String> someList = new ArrayList<String>();
        for (String something : this.fileRead) {
            if (this.isPalindrome(something)) {
                someList.add(something);
            }
        }
        return someList;
    }
    
    private String reverse(String something) {
        String paliCheck = "";
        for (int i = something.length() - 1; i >= 0; i--) {
            paliCheck += something.charAt(i);
        }
        return paliCheck;
    }
    
    private boolean isPalindrome(String input) {
        return input.equals(this.reverse(input));
    } 
    
    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsThatcontain = new ArrayList<String>();
        for (String s : this.fileRead) {
            if (this.containsAllVowels(s)) {
                wordsThatcontain.add(s);
            }
        }
        return wordsThatcontain;
    }
    
    private boolean containsAllVowels(String somthing) {
        for (char vowels : this.vowels.toCharArray()) {
            if (!somthing.contains("" + vowels)) {
                return false;
            }
        }
        return true;
    }
}
