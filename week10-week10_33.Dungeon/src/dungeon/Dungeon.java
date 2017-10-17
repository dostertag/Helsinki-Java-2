/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kdost
 */
public class Dungeon {
    private GameGrid game;
    private int moves;
    private Scanner reader;
    
    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        this.game = new GameGrid(length, height, vampires, vampiresMove);
        this.moves = moves;
        this.reader = new Scanner(System.in);
    }
    
    public void run(){
        int i = moves;
        System.out.println(i);
        game.printGameGrid();
        while(i > 0){
            if(this.game.returnCharacters().size() == 1){
                break;
            }
            String input = reader.nextLine();
            ArrayList<String> commands = new ArrayList<String>();
            for(int j = 0; j < input.length(); j++){
                commands.add(input.substring(j, j+1));
            }
            game.moveAndRemoveCharacters(commands);
            i--;
            System.out.println(i);
            game.printGameGrid();
        }
        if(game.returnCharacters().size() == 1){
            System.out.println("YOU WIN");
        }else{
            System.out.println("YOU LOSE");
        }
    }
    
}
