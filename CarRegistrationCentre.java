
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
public class VehicleRegister {
    private HashMap<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        this.owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (this.owners.get(plate) == null) {
            this.owners.put(plate, owner);
            return true;
        } else {
            return false;
        }
    }
    
    public String get(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return null;
        } else {
            return this.owners.get(plate);
        }
        
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (this.owners.get(plate) == null) {
            return false;
        } else {
            this.owners.remove(plate);
            return true;
        }
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : this.owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> ownersList = new ArrayList<String>();
        for (RegistrationPlate plate : this.owners.keySet()) {
            String owner = this.owners.get(plate);
            if (ownersList.contains(owner) == false) {
                ownersList.add(owner);
            }
        }
        for (String name : ownersList) {
            System.out.println(name);
        }
    }
}


public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }
    
    public String getReg() {
        return this.regCode;
    }
    
    public String getCountry() {
        return this.country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }
    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        
        if (this.getClass() != object.getClass()) {
            return false;
        }
        
        RegistrationPlate temp = (RegistrationPlate)object;
        
        if (this.country == null || !this.getCountry().equals(temp.getCountry())) {
            return false;
        }
        
        if (this.regCode == null || !this.regCode.equals(temp.getReg())) {
            return false;
        }
        return true;
    }
    
    public int hashCode() {
        if (this.country == null || this.regCode == null) {
            return 7;
        } 
        return this.country.hashCode() + this.regCode.hashCode();
    }
    
}


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // below is the same examle program as in the assignment

        RegistrationPlate reg1 = new RegistrationPlate("FI", "ABC-123");
        RegistrationPlate reg2 = new RegistrationPlate("FI", "UXE-465");
        RegistrationPlate reg3 = new RegistrationPlate("D", "B WQ-431");

        List<RegistrationPlate> finnish = new ArrayList<RegistrationPlate>();
        finnish.add(reg1);
        finnish.add(reg2);

        RegistrationPlate newPlate = new RegistrationPlate("FI", "ABC-123");

        if (!finnish.contains(newPlate)) {
            finnish.add(newPlate);
        }

        System.out.println("Finnish: " + finnish);
        // if the equals method hasn't been overwritten, the same registration plate is repeated in the list

        Map<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();
        owners.put(reg1, "Arto");
        owners.put(reg3, "Jürgen");

        System.out.println("owners:");
        System.out.println(owners.get(new RegistrationPlate("FI", "ABC-123")));
        System.out.println(owners.get(new RegistrationPlate("D", "B WQ-431")));
        // if the hashCode hasn't been overwritten, the owners are not found
    }
}
