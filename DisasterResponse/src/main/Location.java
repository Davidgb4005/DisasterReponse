package main;

import java.util.Vector;

public abstract class Location {

    protected int uniqueId;
    protected String name;
    protected Strategy strategy;
    protected int occupants = 0;
    protected void addOccupant(){
        occupants ++;
    }
    protected void removeOccupant(){
        occupants--;
    }
    protected int getOccupants(){
        return occupants;
    }
    protected void setId(int i){
        uniqueId = i;
    }


    protected void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
