package main;

import java.util.Vector;

public abstract class Person implements SubscriptionInterface {
//API variables
    protected int uniqueId;
    protected Strategy strategy;
    protected Location location;
    protected String name;
    protected Vector<Subscriptions> subscriptionsOwner = new Vector<>();
    protected Vector<Subscriptions> subscriptionsSubscriber = new Vector<>();
    protected void setId(int i){
        uniqueId = i;
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
    public int getId(){
        return uniqueId;
    }
    //Subscription Interface
    public void addSubscriptionOwner(Subscriptions subscriptions){
        subscriptionsOwner.add(subscriptions);
    }
    public void removeSubscriptionOwner(Subscriptions subscriptions){
        subscriptionsOwner.remove(subscriptions);
    }
    public void addSubscriptionSubscriber(Subscriptions subscriptions){
        subscriptionsSubscriber.add(subscriptions);
    }
    public void removeSubscriptionSubscriber(Subscriptions subscriptions){
        subscriptionsSubscriber.remove(subscriptions);
    }

    public String getName(){
        return this.name;
    }
    public Location getLocation() {
        return this.location;
    }
    public Strategy getStrategy(){
        return strategy;
    }
}
