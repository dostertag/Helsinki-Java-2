/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmethodstest;

import java.util.Objects;

/**
 *
 * @author kdost
 */
public class Book {
    
    private String name;
    private int publishingYear;
    
    public Book(String name, int publishingYear) {
        this.name = name;
        this.publishingYear = publishingYear;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getYear() {
        return this.publishingYear;
    }
    
    
    public String toString() {
        return this.name + " (" + this.publishingYear + ")";
    }

//    @Override
//    public int hashCode() {
//        int hash = 5;
//        hash = 17 * hash + Objects.hashCode(this.name);
//        hash = 17 * hash + this.publishingYear;
//        return hash;
//    }
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            System.out.println("was null");
            return false;
        }
        
        if (this.getClass() != object.getClass()) {
            System.out.println("different classes");
            return false;
        }
        
        Book compared = (Book) object;
        
        if (this.publishingYear != compared.getYear()) {
            System.out.println("different publishing years");
            return false;
        }
        // System.out.println("publishing year check good");
        
        if (this.name == null || !this.name.equals(compared.getName())) {
            System.out.println("name null or different");
            return false;
        }
        return true;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objectmethodstest;

/**
 *
 * @author kdost
 */
public class ObjectMethodsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Book firstBook = new Book("Book", 1999);
        Book secondBook = new Book("Book", 1999);
        Book thirdBook = firstBook;
        
        System.out.println(firstBook);
        System.out.println(secondBook);
        
        if (firstBook.equals(secondBook)) {
            System.out.println("Yup");
        } else {
            System.out.println("Nope");
        }
        
        if (firstBook.equals(thirdBook)) {
            System.out.println("YupYup");
        } else {
            System.out.println("NopeNope");
        }
//        Book objectBook = new Book("Objectbook", 2000);
//        Book anotherObjectBook = new Book("Objectbook", 2000);
//
//        if (objectBook.equals(anotherObjectBook)) {
//            System.out.println("The books are the same");
//        } else {
//            System.out.println("The books are not the same");
//        }
    }
    
}
