package main;

import java.util.Vector;
import java.util.function.Supplier;

public class DisasterResponse {
    private static Vector<Location> locations = new Vector<Location>();
    private static Vector<Person> persons = new Vector<Person>();
    private static Vector<Subscriptions> subscriptions = new Vector<>();
    private static Vector<Equipment> equipment = new Vector<>();
    private Vector<Strategy> strategy = new Vector<>();
    private Location defaultLocation;
    private LocationFactory locationFactory = new LocationFactory();
    private PersonFactory personFactory = new PersonFactory();
    private EquipmentFactory equipmentFactory = new EquipmentFactory();

    public void setLocationFactory(Supplier<? extends Location> locationCreator){
        locationFactory.setCreator(locationCreator);
    }
    public void setPersonFactory(Supplier<? extends Person> personCreator){
        personFactory.setCreator(personCreator);
    }
    public void setEquipmentFactory(Supplier<? extends Equipment> equpimentCreator){
        equipmentFactory.setCreator(equpimentCreator);
    }

    public Location newLocation(String name){
        Location tempLocation = locationFactory.create(name);
        locations.add(tempLocation);
        if (defaultLocation == null){
            defaultLocation = tempLocation;
        }
        return tempLocation;
    }

    public Person newPerson(String name){
        Person tempPerson = personFactory.create(name);
        persons.add(tempPerson);
        tempPerson.location = defaultLocation;
        return tempPerson;
    }
    public Equipment newEquipment(String name,int units){
        Equipment tempEquipment = equipmentFactory.create(name, units);
        equipment.add(tempEquipment);
        return tempEquipment;
    }

    public void setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public void registerStrategy(Strategy strategy){
        this.strategy.add(strategy);
    }
    public void registerPersonAtLocation(Person p, Location l) {
        if (p.location != null) {
            p.location.removeOccupant();
        }
        p.location = l;
        l.addOccupant();
    }

    public Vector<Person> getPersons(){
        return (Vector<Person>)persons.clone();
    }
    public Vector<Equipment> getEquipment(){
        return (Vector<Equipment>) equipment.clone();
    }
    public Vector<Location> getLocations(){
        return (Vector<Location>) locations.clone();
    }
    public Vector<Strategy> getStrategy(){
        return (Vector<Strategy>) strategy.clone();
    }
}
