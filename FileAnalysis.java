/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kdost
 */
public class Analysis {
    private File file;
    private Scanner scanner;
    private List<String> readTheFile;
        
    public Analysis(File file) throws FileNotFoundException {
        this.file = file;
        this.scanner = new Scanner(this.file);
        this.readTheFile = new ArrayList<String>();
        while(this.scanner.hasNextLine()) {
            this.readTheFile.add(this.scanner.nextLine());
        }
    }
    
    public int lines() {
        return this.readTheFile.size();
    }
    
    public int characters() {
        int totalChars = 0;
        for (String currentLine : this.readTheFile) {
            totalChars += currentLine.length();
        }
        return totalChars + this.readTheFile.size(); //adding newline characters to total for tests
    }
    
}
