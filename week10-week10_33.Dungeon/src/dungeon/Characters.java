/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;

/**
 *
 * @author kdost
 */
public class Characters {
    private ArrayList<Character> characters;
    
    public Characters(int length, int height, int vampires){
        characters = new ArrayList<Character>();
        Player player = new Player("@", length, height);
        characters.add(player);
        while(characters.size() <= vampires){
            Vampire v = new Vampire("v", length, height);
            if(!characters.contains(v)){
                characters.add(v);
            }
        }
    }
    
    public void PrintCharacters(){
        for(Character c : characters){
            System.out.println(c);
        }
    }
    
    public ArrayList<Character> returnCharacters(){
        return characters;
    }
    
    public void moveAndRemoveCharacters(ArrayList<String> moves, boolean vampiresMove){
        ArrayList<Character> vampiresMoved = new ArrayList<Character>();
        Character player = new Player("", 0, 0);
        for(Character c : characters){
            if(c.getName().equals("@")){
                c.move(moves);
                player = c;
            }else{
                c.move(moves.size(), vampiresMove);
                if(!vampiresMoved.contains(c)){
                    vampiresMoved.add(c);
                }
                
            }
        }
        ArrayList<Character> toBeRemoved = new ArrayList<Character>();
        for(Character vamp : vampiresMoved){
            if(vamp.equals(player)){
                toBeRemoved.add(vamp);
            }
        }
        vampiresMoved.removeAll(toBeRemoved);
        characters.clear();
        characters.add(player);
        characters.addAll(vampiresMoved);
    } 
}
