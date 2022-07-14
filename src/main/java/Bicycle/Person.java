package Bicycle;

public abstract class Person {
    private String DNI;
    private String name;
    private String surname;
    private int age;
    private boolean debts;

    public Person(String DNI, String name, String surname, int age, boolean debts) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.debts = debts;
        debts = false;
    }
}
