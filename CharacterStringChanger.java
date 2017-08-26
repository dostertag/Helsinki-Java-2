/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Change {
    
    // private int numberOfChanges;
    private final char from;
    private final char replaced;
    
    public Change (char fromCharacter, char toCharacter) {
        // this.numberOfChanges = 0;
        this.from = fromCharacter;
        this.replaced = toCharacter;
    }
    
    public String change(String characterString) {
        return characterString.replace(from, replaced);
    }
    
}


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kdost
 */
public class Changer {
    
    private final ArrayList<Change> listChanges;
    
    public Changer() {
        listChanges = new ArrayList<Change>();
    }
    public void addChange(Change change) {
        listChanges.add(change);
    }
    
    public String change(String charaterString) {
        // String returnedString = "";
        for (Change ch : listChanges) {
            // returnedString = ch.change(charaterString);
            charaterString = ch.change(charaterString);
        }
        // return returnedString;
        return charaterString;
    }
}
//  would not change the first character when temporarily assigning a new String value
//  had to change passed in value to change in place.... no idea why
