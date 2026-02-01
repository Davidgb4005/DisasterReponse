package EndUsersSubscriptions;

import MidUserSubscriptions.ManyToOneBiDirectionalSubscription;
import main.Person;

import java.util.Vector;

public class MissingPersonSubscription extends ManyToOneBiDirectionalSubscription {
    public MissingPersonSubscription(String name){
        super(name);
    }
    public class MissingPair{
        MissingPair(Person looker,String lookee){
            this.lookee = lookee;
            this.looker = looker;
        }
        Person looker;
        String lookee;
    }
    Vector<MissingPair> missingPersons = new Vector<>();

    public void registerMissingPerson(Person looker, String lookee){
        missingPersons.add(new MissingPair(looker,lookee));
    }
    public Vector<Person> searchMissingPersons(String lookerName,String lookeeName){
        Vector<Person> tempVec = new Vector<>();
        for (MissingPair p : missingPersons){
            if (p.looker.getName().equals(lookeeName) && p.lookee.equals(lookerName)){
                tempVec.add(p.looker);
            }
        }
        return tempVec;
    }
}
