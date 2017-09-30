
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Person implements Comparable<Person> {
    private String name;
    private Set<String> numbers;
    private String address;
    
    public Person(String name){
        this.name = name;
        this.numbers = new HashSet<String>();
        this.address = "";
    }
    
    public void addNumber(String number){
        this.numbers.add(number);
    }
    
    public void addAddress(String street, String city){
        this.address = street + " " + city;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public Set<String> getNumbers(){
        return this.numbers;
    }
    
    @Override
    public String toString(){
        if(!numbers.isEmpty() && !address.isEmpty()){
            return "\naddress: " + address + "\nphone numbers: " + numbers;
        }else if(!numbers.isEmpty() && address.isEmpty()){
            return "\naddress unknown" + "\nphone numbers: " + numbers;
        }else if(!address.isEmpty()){
            return "\naddress: " + address + "\nphone number not found";
        }else{
            return null;
        }
    }
    
    @Override
    public int compareTo(Person compared){
        if(this.name != null && compared.name != null){
            return this.name.compareToIgnoreCase(compared.name);
        }else{
            return 0;
        }
    }
}
