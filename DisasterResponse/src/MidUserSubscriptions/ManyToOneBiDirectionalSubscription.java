package MidUserSubscriptions;

import main.SubscriptionInterface;
import main.Subscriptions;

public class ManyToOneBiDirectionalSubscription<T extends SubscriptionInterface,F extends SubscriptionInterface> extends Subscriptions<T,F> {
    public ManyToOneBiDirectionalSubscription(String name) {
        super(name);
    }

    public void setOwner(F owner) {
        if (!this.owner.isEmpty()) {
            System.out.println("This is a Many To One Sub and Already Has owner");
            return;
        }
        owner.addSubscriptionOwner(this);
        this.owner.add(owner);
    }

    public void removeOwner(F owner) {
        for (F o : this.owner) {
            o.removeSubscriptionSubscriber(this);
            this.owner.remove(o);
        }
    }
}