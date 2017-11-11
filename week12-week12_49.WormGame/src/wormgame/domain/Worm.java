/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;
import wormgame.domain.Piece;

/**
 *
 * @author kdost
 */
public class Worm {
    private int origX;
    private int origY;
    private Direction direction;
    private boolean grow;
    private List<Piece> wormList;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        origX = originalX;
        origY = originalY;
        direction = originalDirection;
        wormList = new ArrayList<Piece>();
        wormList.add(new Piece(originalX, originalY));
        grow = false;
    }
    public Direction getDirection() {
        return direction;
    }
    public void setDirection(Direction dir) {
        direction = dir;
    }
    public int getLength() {
        return wormList.size();
    }
    public List<Piece> getPieces() {
        return wormList;
    }
    public void move() {
        int newX = wormList.get(wormList.size() - 1).getX();
        int newY = wormList.get(wormList.size() - 1).getY();
        if (null != direction) switch (direction) {
            case UP:
                newY--;
                break;
            case DOWN:
                newY++;
                break;
            case LEFT:
                newX--;
                break;
            case RIGHT:
                newX++;
                break;
            default:
                break;
        }
        if (getLength() > 2 && !grow) {
            wormList.remove(0);
        }
        if (grow = true) {
            grow = false;
        }
        wormList.add(new Piece(newX, newY));
    }
    public void grow() {
        grow = true;
    }
    public boolean runsInto(Piece piece) {
        for (int i = 0; i < getLength(); i++) {
            if (wormList.get(i).getX() == piece.getX() && wormList.get(i).getY() == piece.getY()) {
                return true;
            }
        }
        return false;
    }
    public boolean runsIntoItself() {
        for (int i = 0; i < getLength() - 1; i++) {
            if (head().getX() == wormList.get(i).getX() && head().getY() == wormList.get(i).getY()) {
                return true;
            }
        }
        return false;
    }
    public Piece head() {
        return wormList.get(this.getLength() - 1);
    }
}
