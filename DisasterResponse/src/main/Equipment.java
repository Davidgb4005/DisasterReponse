package main;

import java.util.Vector;

public abstract class Equipment implements SubscriptionInterface{
    protected String name;
    private int uniqueId;
    protected Vector<Subscriptions> subscriptionsOwner = new Vector<>();
    protected Vector<Subscriptions> subscriptionsSubscriber = new Vector<>();
    public class Pair{
        public Pair(int units,Person person){
            this.units = units;
            this.person = person;
        }
        public int units;
        public Person person;
    }
    public Vector<Pair> loanedUnits = new Vector<>();
    int equipmentTotal;
    int equipmentLoaned;
    int equipmentDestroyed;
    int equipmentAvailible;
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
    public void destroyEquipment(int units){
        equipmentTotal = equipmentTotal - units;
        equipmentAvailible = equipmentAvailible - units;
        equipmentDestroyed = equipmentDestroyed + units;
    }
    public void addEquipment(int units){
        equipmentTotal = equipmentTotal + units;
        equipmentAvailible = equipmentAvailible + units;
    }
    public void loanEquipment(int units,Person person){
        if (units>equipmentAvailible){
            System.out.println("Insufficent Equipment");
            return;
        }
        for (Pair p : loanedUnits){
            if (p.person.equals(person)){
                p.units = p.units + units;
                return;
            }
        }
        loanedUnits.add(new Pair(units,person));
        equipmentLoaned = equipmentLoaned + units;
        equipmentAvailible = equipmentAvailible - units;
    }
    public void returnEquipment(int units,Person person){
        for (Pair p : loanedUnits){
            if (p.person.equals(person)){
                if (p.units < units) {
                    System.out.println("You cannot return More units than loaned");
                    return;
                }
                p.units = p.units - units;
                equipmentAvailible = equipmentAvailible + units;
                if (p.units < 1){
                    loanedUnits.remove(p);
                }
                return;
            }
            else {
                System.out.println("User Not in System");
            }
        }
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return uniqueId;
    }
    public int getEquipmentTotal(){
        return equipmentTotal;
    }
    public int getEquipmentDestroyed() {
        return equipmentDestroyed;
    }
    public int getEquipmentLoaned() {
        return equipmentLoaned;
    }

    public int getEquipmentAvailible() {
        return equipmentAvailible;
    }
    protected void setId(int i){
        uniqueId = i;
    }

}
