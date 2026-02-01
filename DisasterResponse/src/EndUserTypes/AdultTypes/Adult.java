package EndUserTypes.AdultTypes;

import main.Person;

import java.util.Vector;

public abstract class Adult extends Person {
    public enum Gender{
        MALE,
        FEMALE,
        OTHER,
        UNKNOWN
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
        GOLDEN,
        UNKNOWN
    }
    public enum Language{
        ENGLISH,
        FRENCH,
        JAPANESE,
        OTHER,
        UNKNOWN
    }
    //General variables
    protected Gender gender = Gender.UNKNOWN;
    protected int age;
    protected int weight;
    protected Color hairColor = Color.UNKNOWN;
    protected Color eyeColor = Color.UNKNOWN;
    protected String birthDate;
    protected String admittanceDate;
    protected String additionalInfo;
    protected Vector<Language> languages = new Vector<>();
    protected Vector<Adult> relatives = new Vector<>();

}

