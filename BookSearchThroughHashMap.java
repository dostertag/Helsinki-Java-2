/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchforbooks;

import java.util.HashMap;

/**
 *
 * @author kdost
 */
public class SearchForBooks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashMap<String, Book> bookCollection = new HashMap<>();
        Book senseAndSensibility = new Book("Sense and Sensibility", 1811, "...");
        Book prideAndPrejudice = new Book("Pride and Prejudice", 1813, "...");
        
        //HashMap<String, Book> bookCollection = new HashMap<>();
        bookCollection.put(senseAndSensibility.getName(), senseAndSensibility);
        bookCollection.put(prideAndPrejudice.getName(), prideAndPrejudice);
       
        Book book = bookCollection.get("Persuasion");
        System.out.println(book);
        System.out.println();
        book = bookCollection.get("Pride and Prejudice");
        System.out.println(book);
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchforbooks;

/**
 *
 * @author kdost
 */
public class Book {
    
    private String name;
    private String contents;
    private int publishingYear;
    
    public Book(String name, int publishingYear, String contents) {
        this.name = name;
        this.contents = contents;
        this.publishingYear = publishingYear;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPublishingYear() {
        return this.publishingYear;
    }
    
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    
    public String getContents() {
        return this.contents;
    }
    
    public void setContents(String contents) {
        this.contents = contents;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + " (" + this.publishingYear + ")\n"
                + "Contents: " + this.contents;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchforbooks;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kdost
 */
public class Library {
    
    private HashMap<String, Book> collection;
    
    public Library() {
        this.collection = new HashMap<String, Book>();
    }
    
    public void addBook(Book book) {
        String name = stringCleaner(book.getName());
        if (this.collection.containsKey(name)) {
            System.out.println("The book is already in the Library");
        } else {
            collection.put(name, book);
        }
    }
    
    public void removeBook(String bookName) {
        bookName = stringCleaner(bookName);
        
        if (this.collection.containsKey(bookName)) {
            this.collection.remove(bookName);
        } else {
            System.out.println("The book was not found, you can't remove it!");
        }
    }
    
    private String stringCleaner(String string) {
        if (string == null) {
            return "";
        } 
        string = string.toLowerCase();
        return string.trim();
    }
    
    public Book getBook(String bookName) {
        bookName = stringCleaner(bookName);
        return this.collection.get(bookName);
    }
    
    public ArrayList<Book> bookList() {
        return new ArrayList<Book>(this.collection.values());
    }
    
//    public Book getBookUsingItsBeginningCharacters(String beginning) {
//        beginning = stringCleaner(beginning);
//        
//        for (String key : this.collection.keySet()) {
//            if (key.startsWith(beginning)) {
//                return this.collection.get(key);
//            }
//        }
//        return null;
//    }
    
    
}
