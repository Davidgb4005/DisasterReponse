package main;


public interface SubscriptionInterface extends Debugger{
    public void addSubscriptionOwner(Subscriptions subscriptions);
    public void removeSubscriptionOwner(Subscriptions subscriptions);

    public void addSubscriptionSubscriber(Subscriptions subscriptions);
    public void removeSubscriptionSubscriber(Subscriptions subscriptions);
}
