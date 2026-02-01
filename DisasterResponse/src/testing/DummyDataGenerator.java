package testing;

import main.DisasterResponse;
import main.Equipment;
import main.Person;

import java.util.Arrays;
import java.util.Vector;
import java.util.Random;
public class DummyDataGenerator {
    Random rand = new Random();
    public static final Vector<String> PEOPLE =
            new Vector<>(Arrays.asList(
                    "Alice", "Bob", "Charlie", "Diana", "Ethan",
                    "Fiona", "George", "Hannah", "Ian", "Julia",
                    "Kevin", "Laura", "Michael", "Nina", "Oliver",
                    "Paula", "Quinn", "Rachel", "Samuel", "Tina",
                    "Umar", "Victoria", "William", "Xavier", "Yara",
                    "Zachary", "Aaron", "Bella", "Caleb", "Daphne"
            ));
    public static final Vector<String> EQUIPMENT =
            new Vector<>(Arrays.asList(
                    "Pants", "Hat", "Flashlight", "Gloves", "Toilet Paper",
                    "Jacket", "Boots", "Socks", "Backpack", "Water Bottle",
                    "Tent", "Sleeping Bag", "Map", "Compass", "First Aid Kit",
                    "Knife", "Rope", "Batteries", "Phone Charger", "Watch",
                    "Raincoat", "Sunglasses", "Helmet", "Mask", "Towel",
                    "Soap", "Toothbrush", "Notebook", "Pen", "Whistle"
            ));
    public void generateDummyPersons(int count, DisasterResponse dsr){
    for (int i = 0;i<count;i++){
        int a = rand.nextInt(PEOPLE.size());
        dsr.newPerson(PEOPLE.elementAt(a));
        }
    }
    public void generateDummyEquipment(int count, DisasterResponse dsr){
        for (int i = 0;i<count;i++){
            int a = rand.nextInt(EQUIPMENT.size());
            dsr.newEquipment(EQUIPMENT.elementAt(a),rand.nextInt(60,120));
        }
    }
    public void assignDummyEquipment(DisasterResponse dsr){
        Vector<Equipment> eqp = dsr.getEquipment();
        for (Person p : dsr.getPersons()){
            eqp.elementAt(rand.nextInt(eqp.size())).loanEquipment(rand.nextInt(40),p);
        }
    }
}
