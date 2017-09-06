/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_week8;

import java.util.ArrayList;

/**
 *
 * @author kdost
 */
public class Interface_Week8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<String> pages = new ArrayList<String>();
        pages.add("Split your method into short clear chunks.");
        pages.add("Devide the user interface logic from the application logic.");
        pages.add("At first, always code only a small program which solves only a part of the problem.");
        pages.add("Practice makes perfect. Make up your own fun project.");

        EBook book = new EBook("Programming Hints.", pages);
        for(int page = 0; page < book.howManyPages(); page++) {
            System.out.println(book.read());
    }
          
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_week8;

/**
 *
 * @author kdost
 */
public interface Readable {
    String read();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_week8;

/**
 *
 * @author kdost
 */
public class SMS implements Readable {
    private String sender;
    private String content;
    
    public SMS(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }
    
    public String getSender() {
        return this.sender;
    }
    
    public String read() {
        return this.content;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interface_week8;

import java.util.ArrayList;

/**
 *
 * @author kdost
 */
public class EBook implements Readable {
    private String name;
    private ArrayList<String> pages;
    private int pageNumber;
    
    public EBook (String name, ArrayList<String> pages) {
        this.name = name;
        this.pages = pages;
        this.pageNumber = 0;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int howManyPages() {
        return this.pages.size();
    }
    
    public String read() {
        String page = this.pages.get(this.pageNumber);
        nextPage();
        return page;
    }
    
    public void nextPage() {
        this.pageNumber += 1;
        if (this.pageNumber % this.pages.size() == 0) {
            this.pageNumber = 0;
        }
    }
}
