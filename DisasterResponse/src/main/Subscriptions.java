package main;

import java.util.Vector;

public abstract class Subscriptions<T extends SubscriptionInterface,F extends SubscriptionInterface>{
    private String subscriptionName;
    protected Vector<T> subscribers = new Vector<T>();
    protected Vector<F> owner = new Vector<F>();

    public Subscriptions(String name){
        this.subscriptionName = name;
    }
    public Vector<F> getOwner(){
        return this.owner;
    }
    public void subscribe(T subscriber){
        subscriber.addSubscriptionSubscriber(this);
        subscribers.add(subscriber);}

    public void unsubscribe(T subscriber) {
        subscriber.removeSubscriptionSubscriber(this);
        subscribers.remove(subscriber);

    }
    public Vector<T> getSubscribers(){
        return (Vector<T>)subscribers.clone();
    }

    public String getSubscriptionName(){
        return subscriptionName;
    }
    public void DebugPrint(){
        for (T s : subscribers){
            if (subscribers.isEmpty()){
                System.out.println(" - This Subscription Has No Subscribers");
                return;
            }
            else{
                System.out.println("Subscriber : "+s.getName());
            }
        }
        for (F o : owner){
            if (owner.isEmpty()){
                System.out.println("There Are No Owners");
                return;
            }
            else{
                System.out.println("Owner : "+o.getName());
            }
        }
    }
}
