package MidUserSubscriptions;

import main.SubscriptionInterface;
import main.Subscriptions;

public class ManyToManyBiDirectionalSubscription<T extends SubscriptionInterface,F extends SubscriptionInterface> extends Subscriptions<T,F>{
    public ManyToManyBiDirectionalSubscription(String name){
        super(name);
    }
    public void setOwner(F owner){
        for (F o: this.owner){
            if (owner.equals(o)){
                return;
            }

        }
        this.owner.add(owner);
        owner.addSubscriptionOwner(this);
    }
}
