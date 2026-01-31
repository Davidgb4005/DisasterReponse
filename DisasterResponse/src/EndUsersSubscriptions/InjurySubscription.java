package EndUsersSubscriptions;

import main.Person;
import main.Subscriptions;

public class InjurySubscription extends Subscriptions<Person> {
    public InjurySubscription(String name){
        super(name);
    }
    public void doAction(){
        for (Person p : subscribers){
            System.out.println(p.getName()+" Is Suffering From "+this.getSubscriptionName());
        }
    }
}