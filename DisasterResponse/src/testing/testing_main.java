package testing;
import EndUserTypes.Child;
import EndUsersSubscriptions.InjurySubscription;
import EndUsersSubscriptions.MissingPersonSubscription;
import main.*;

import java.util.Vector;

public class testing_main {
    public static void main(String [] args){

        DisasterResponse disasterResponse = new DisasterResponse();
        InjurySubscription brokenBoneSubscription = new InjurySubscription("Broken Bone");
        MissingPersonSubscription missingPersonSubscription = new MissingPersonSubscription("Missing Person");

        disasterResponse.setLocationFactory(CustomLocation::new);
        disasterResponse.setPersonFactory(Child::new);
        disasterResponse.newLocation("University of Calgary");
        brokenBoneSubscription.subscribe(disasterResponse.newPerson("Alice"));
        missingPersonSubscription.subscribe(disasterResponse.newPerson("Bob"));
        missingPersonSubscription.subscribe(disasterResponse.newPerson("Robert"));
        brokenBoneSubscription.doAction();

        System.out.println(missingPersonSubscription.registerMissingPerson(disasterResponse.getPersons().elementAt(1),"Bob","Robert"));
        System.out.println(missingPersonSubscription.registerMissingPerson(disasterResponse.getPersons().elementAt(2),"Robert","Bob"));

    }

}
