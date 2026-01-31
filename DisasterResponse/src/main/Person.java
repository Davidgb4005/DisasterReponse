package main;

import java.util.Vector;

public abstract class Person {
//API variables
    protected int uniqueId;
    protected Strategy strategy;
    protected Location location;
    protected String name;

    protected void setId(int i){
        uniqueId = i;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }


    public String getName(){
        return this.name;
    }
    public Strategy getStrategy(){
        return strategy;
    }
}
