package main;

import java.util.function.Supplier;

public class PersonFactory {
    private static int uniqueIdGenerator = 0;
    private Supplier<? extends Person> creator;
    public  void setCreator(Supplier<? extends Person> creatorFn){
        creator = creatorFn;
    }

    public Person create(String name) {
       Person tempPerson = creator.get();
       tempPerson.setId(uniqueIdGenerator++);
       tempPerson.name = name;
       return tempPerson;
    }
}
