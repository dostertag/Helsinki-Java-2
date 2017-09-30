/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author kdost
 */
public class PersonalDuplicateRemover implements DuplicateRemover {
    private int duplicatesRemoved;
    private Set<String> storage;
    
    public PersonalDuplicateRemover() {
        this.storage = new HashSet<String>();
        this.duplicatesRemoved = 0;
    }
    

    @Override
    public void add(String characterString) {
        if (!this.storage.contains(characterString)) {
            this.storage.add(characterString);
        } else {
            this.duplicatesRemoved++;
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicatesRemoved;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        Set<String> returnedSet = new HashSet<String>();
        returnedSet = (Set<String>) this.storage;
        return returnedSet;
    }

    @Override
    public void empty() {
        this.storage.clear();
        this.duplicatesRemoved = 0;
    }
    
}
