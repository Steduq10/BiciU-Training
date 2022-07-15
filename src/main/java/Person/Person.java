package Person;

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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDebts() {
        return debts;
    }

    public void setDebts(boolean debts) {
        this.debts = debts;
    }

    @Override
    public String toString() {
        return "ID: " + DNI +" " +
                "Name: " + name + " " + surname +" " +
                "Age: " + age + " " +
                "debts: " + debts;
    }
}
