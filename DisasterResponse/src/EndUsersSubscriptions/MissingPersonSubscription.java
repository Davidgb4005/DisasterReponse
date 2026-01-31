package EndUsersSubscriptions;

import main.Person;
import main.Subscriptions;

import java.util.*;

public class MissingPersonSubscription extends Subscriptions<Person> {
    public MissingPersonSubscription(String name){
        super(name);
    }

    class Pair{
        public Pair(Person p,String looker,String lookee){
            this.looker=p;
            this.lookerName=looker;
            this.lookeeName = lookee;
        }
        Person looker;
        String lookerName;
        String lookeeName;
    }

    public Vector<Pair> lookingForPersons = new Vector<>();

    public Person registerMissingPerson(Person looker,String lookerName,String lookeeName){
        for (Pair p : lookingForPersons){
            if (p.lookeeName.equals(lookerName) && p.lookerName.equals(lookeeName)){
                lookingForPersons.remove(p);
                System.out.println(lookerName+" Found "+lookeeName);
                return p.looker;
        }
        }
        lookingForPersons.add(new Pair(looker,lookerName,lookeeName));
        return null;
    }
    public void unregiesterMissingPerson(Person looker,String lookerName,String lookeeName){
        for (Pair p : lookingForPersons) {
            if (p.looker.equals(looker) && p.lookeeName.equals(lookerName)) {
                lookingForPersons.remove(p);
            }
        }
    }
}