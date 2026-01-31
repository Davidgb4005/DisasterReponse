package main;

import java.util.function.Supplier;

public class LocationFactory {
    static int uniqueIdGenerator = 0;
    public Supplier<? extends Location> creator;
    public  void setCreator(Supplier<? extends Location> creatorFn){
        creator = creatorFn;
    }

    public Location create(String name) {
       Location tempLocation = creator.get();
       tempLocation.setId(uniqueIdGenerator++);
       tempLocation.name = name;
       return tempLocation;
    }
}
