package main;

import java.util.Vector;

public abstract class Subscriptions<T> {
    private String subscriptionName;
    protected Vector<T> subscribers = new Vector<T>();

    public Subscriptions(String name){
        this.subscriptionName = name;
    }
    public void subscribe(T data){
        subscribers.add(data);
    }
    public void unsubscribe(T data){
        subscribers.remove(data);
    }
    public Vector<T> getSubscribers(){
        return (Vector<T>)subscribers.clone();
    }
    public String getSubscriptionName(){
        return subscriptionName;
    }
}
