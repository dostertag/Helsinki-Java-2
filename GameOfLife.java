/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author kdost
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        for (int i = 0; i < super.getWidth(); i++) {
            for (int j = 0; j < super.getHeight(); j++) {
                if (new Random().nextDouble() < d) {
                    this.turnToLiving(i, j);
                }
            }
        }
    }

    @Override
    public boolean isAlive(int i, int i1) {
        if (isInBounds(i, i1)) {
            return super.getBoard()[i][i1];
        } 
        return false;
    }

    @Override
    public void turnToLiving(int i, int i1) {
        if (isInBounds(i, i1)) {
            super.getBoard()[i][i1] = true;
        }
    }

    @Override
    public void turnToDead(int i, int i1) {
        if (isInBounds(i, i1)) {
            super.getBoard()[i][i1] = false;
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int numLivingNeighbours = 0;
        for (int j = i - 1; j <= i + 1; j++) {
            for (int k = i1 -1; k <= i1 + 1; k++) {
                if (isInBounds(j, k) && isAlive(j, k)) {
                    numLivingNeighbours++;
                }
            }
        }
        if (isAlive(i, i1)) {
            numLivingNeighbours--;
        }
        return numLivingNeighbours;
    }

    @Override
    public void manageCell(int i, int i1, int i2) {
        if (i2 > 3 || i2 < 2) {
            turnToDead(i, i1);
        } else if (i2 == 3) {
            turnToLiving(i, i1);
        }
    }
    private boolean isInBounds(int x, int y) {
        if (x < 0 || y < 0 || x >= super.getWidth() || y >= super.getHeight()) {
            return false;
        }
        return true;
    }
}
