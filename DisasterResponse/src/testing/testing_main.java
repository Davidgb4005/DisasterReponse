package testing;
import EndUserTypes.AdultTypes.AdultSubTypes.*;
import EndUserTypes.EquipmentTypes.GenericEquipment;
import EndUserTypes.LocationTypes.LibraryLocation;
import EndUserTypes.LocationTypes.SchoolLocation;
import EndUsersSubscriptions.MissingPersonSubscription;
import MidUserSubscriptions.ManyToManyBiDirectionalSubscription;
import MidUserSubscriptions.ManyToOneBiDirectionalSubscription;
import main.*;

import java.util.Vector;

public class testing_main {
    public static void main(String [] args){
        //Init Main API Only Single Instance is neededd
        DisasterResponse ChildTest = new DisasterResponse();
        DisasterResponse AdultTest = new DisasterResponse();
        DisasterResponse EmployeeTest = new DisasterResponse();
        DisasterResponse VolunteerTest = new DisasterResponse();

        //Setting Factory Output Types
        ChildTest.setLocationFactory(SchoolLocation::new);
        Location uOfC = ChildTest.newLocation("University Of Calgary");
        ChildTest.setPersonFactory(Child::new);
        ChildTest.setEquipmentFactory(GenericEquipment::new);

        AdultTest.setLocationFactory(LibraryLocation::new);
        AdultTest.setDefaultLocation(uOfC);
        AdultTest.setPersonFactory(InvolvedBystander::new);
        EmployeeTest.setLocationFactory(SchoolLocation::new);
        EmployeeTest.setDefaultLocation(uOfC);
        EmployeeTest.setPersonFactory(Employee::new);
        VolunteerTest.setLocationFactory(SchoolLocation::new);
        VolunteerTest.setDefaultLocation(uOfC);
        VolunteerTest.setPersonFactory(Volunteer::new);

        DummyDataGenerator dummyGenerator = new DummyDataGenerator();

        dummyGenerator.generateDummyPersons(50,ChildTest);
        dummyGenerator.generateDummyPersons(100,AdultTest);
        dummyGenerator.generateDummyPersons(15,EmployeeTest);
        dummyGenerator.generateDummyPersons(30,VolunteerTest);

        dummyGenerator.generateDummyEquipment(20,ChildTest);

        dummyGenerator.assignDummyEquipment(ChildTest);

        //Inin a single Many <-> One subscription

        ManyToOneBiDirectionalSubscription<Child,Employee> SocialWorkerSubscription = new ManyToOneBiDirectionalSubscription("Children Social Workers");
        MissingPersonSubscription missingPersonSubscription = new MissingPersonSubscription("Missing Persons");
        int test =1;
        for (Person p : ChildTest.getPersons()){
            missingPersonSubscription.registerMissingPerson(p,"Sir Jimbob the 11th");
            if (p.getClass() == Employee.class){
                SocialWorkerSubscription.setOwner((Employee) p);
            }
            if (p.getClass() == Child.class){
                SocialWorkerSubscription.subscribe((Child) p);
            }
            System.out.println("Name: "+p.getName()+" Location: "+p.getLocation().getName()+" Class: "+p.getClass());
        }
        for (Equipment e: ChildTest.getEquipment()){
            for (Equipment.Pair p : e.loanedUnits){
                System.out.println(p.person.getName()+" Has "+p.units+" units of "+e.getName()+" There are "+e.getEquipmentAvailible()+" Remaining From lot "+e.getId() );
            }
        }
        SocialWorkerSubscription.DebugPrint();
        Vector<Person> result = missingPersonSubscription.searchMissingPersons("Sir Jimbob the 11th","Alice");
        for(Person p : result){
            System.out.println("JimBob Found "+p.getName()+p.getId());
        }
        Person child1 = ChildTest.newPerson("Lost Person 1");
        Person child2 = ChildTest.newPerson("Lost Person 2");
        missingPersonSubscription.registerMissingPerson(child1,"Lost Person 2");
        result = missingPersonSubscription.searchMissingPersons(child2.getName(),"Lost Person 1");
        for(Person p : result){
            System.out.println("Child 2 Fond  "+p.getName()+p.getId());
        }



    }

}
