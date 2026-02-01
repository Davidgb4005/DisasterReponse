package main;

import java.util.Vector;

public abstract class Location implements SubscriptionInterface {

    protected int uniqueId;
    protected String name;
    public Strategy strategy;
    protected int occupants = 0;
    protected Vector<Subscriptions> subscriptionsOwner = new Vector<>();
    protected Vector<Subscriptions> subscriptionsSubscriber = new Vector<>();
    protected void addOccupant(){
        occupants ++;
    }
    protected void removeOccupant(){
        occupants--;
    }
    protected int getOccupants(){
        return occupants;
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
    protected void setId(int i){
        uniqueId = i;
    }


    protected void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
