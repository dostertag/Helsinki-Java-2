
import java.io.File;
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
public class Printer {
    
    private File f;
    private Scanner reader;
    
    public Printer(String fileName) throws Exception {
        this.f = new File(fileName);
        this.reader = new Scanner(this.f, "UTF-8");
    }
    
    public void printLinesWhichContain(String word) {
        if (word.isEmpty()) {
            while (this.reader.hasNextLine()) {
                String thisLine = this.reader.nextLine();
                System.out.println(thisLine);
            }
        } else {
            while (this.reader.hasNextLine()) {
                String line = this.reader.nextLine();
                String lineLower = line.toLowerCase();
                if (lineLower.contains(word.toLowerCase())) {
                    System.out.println(line);
                }
            }
        }
    }

}
