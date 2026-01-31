package main;

import java.util.Vector;
import java.util.function.Supplier;

public class DisasterResponse {
    private static Vector<Location> locations = new Vector<Location>();
    private static Vector<Person> persons = new Vector<Person>();
    private static Vector<Subscriptions> subscriptions = new Vector<>();
    private Strategy strategy;
    private LocationFactory locationFactory = new LocationFactory();
    private PersonFactory personFactory = new PersonFactory();

    public void setLocationFactory(Supplier<? extends Location> locationCreator){
        locationFactory.setCreator(locationCreator);
    }
    public void setPersonFactory(Supplier<? extends Person> personCreator){
        personFactory.setCreator(personCreator);
    }
    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public Location newLocation(String name){
        Location tempLocation = locationFactory.create(name);
        locations.add(tempLocation);
        return tempLocation;
    }
    public Person newPerson(String name){
        Person tempPerson = personFactory.create(name);
        persons.add(tempPerson);
        return tempPerson;
    }


    public void registerPersonAtLocation(Person p,Location l) {
        if (p.location != null) {
            p.location.removeOccupant();
        }
        p.location = l;
        l.addOccupant();
    }

    public Vector<Person> getPersons(){
        return (Vector<Person>)persons.clone();
    }

}
