package main;

import java.util.function.Supplier;

public class EquipmentFactory {
        static int uniqueIdGenerator = 0;
        public Supplier<? extends Equipment> creator;
        public  void setCreator(Supplier<? extends Equipment> creatorFn){
            creator = creatorFn;
        }

        public Equipment create(String name,int units) {
            Equipment tempEquipment = creator.get();
            tempEquipment.setId(uniqueIdGenerator++);
            tempEquipment.addEquipment(units);
            tempEquipment.name = name;
            return tempEquipment;
        }
    }
