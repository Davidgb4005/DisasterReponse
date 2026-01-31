package EndUserTypes;

import main.Person;

import java.util.Vector;

public class Adult extends Person {
    public enum Gender{
        MALE,
        FEMALE,
        OTHER
    }
    public enum Color{
        BLACK,
        BLONDE,
        BROWN,
        RED,
        GRAY,
        WHITE,
        GREEN,
        BLUE,
        HAZEL,
        GOLDEN
    }
    public enum Language{
        ENGLISH,
        FRENCH,
        JAPANESE,
        OTHER
    }
    public Adult() {System.out.println("This is an Adult");}
    //General variables
    protected Gender gender;
    protected int age;
    protected int weight;
    protected Color hairColor;
    protected Color eyeColor;
    protected Vector<Language> languages = new Vector<>();
    protected Vector<Adult> relatives = new Vector<>();

}
class InvolvedBystander extends Adult{
    public InvolvedBystander() {System.out.println("This is an Adult InvolvedBystander");}
}
class UninvolvedBystander extends Adult{
    public UninvolvedBystander() {System.out.println("This is an Adult UninvolvedBystander");}
}
class Volunteer extends Adult{
    public Volunteer() {System.out.println("This is an Adult Volunteer");}
    int volunteerId;
}
class Employee extends Adult{
    public Employee() {System.out.println("This is an Adult Employee");}
    int employeeId;
}
