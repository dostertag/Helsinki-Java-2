
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
    private List<String> fileRead;
    
    public Printer(String fileName) throws Exception {
        this.f = new File(fileName);
        this.reader = new Scanner(this.f, "UTF-8");
        this.fileRead = new ArrayList<String>();
        while (this.reader.hasNextLine()) {
            this.fileRead.add(this.reader.nextLine());
        }
        // this.fileRead.split("\n");
        // System.out.println(this.fileRead);
    }
    
    public void printLinesWhichContain(String word) {
        if (word.isEmpty()) {
            for (int i = 0; i < this.fileRead.size(); i++) {
                System.out.println(this.fileRead.get(i));
            }
        } else {
            for (int j = 0; j < this.fileRead.size(); j++) {
                if (this.fileRead.get(j).contains(word)) {
                    System.out.println(this.fileRead.get(j));
                }
            }
        }
    }

}


}
