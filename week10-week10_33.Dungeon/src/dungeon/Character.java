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
public abstract class Character {
    
    String name;
    int length;
    int heigth;
    int x;
    int y;
    
    public Character(String name, int length, int height){
        this.name = name;
        this.length = length;
        this.heigth = height;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void move(ArrayList<String> moves){
    }
    
    public void move(int moves, boolean vampireMoves){ 
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    @Override
    public String toString(){
        return this.name + " " + this.x + " " + this.y;
    }
    
    @Override
    public boolean equals(Object object){
        if(object == null){
            return false;
        }
        Character compared = (Character) object;
        if(this.x == compared.x && this.y == compared.y){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }
}
