package Main;

import Person.Person;
import Person.Student;
import Person.Professor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegisterUser {
    static Scanner sc = new Scanner(System.in);
    static List<Person> users = new ArrayList<Person>();

    static List<String> ids = new ArrayList<>();

    static List<String> names = new ArrayList<>();

    static List<Boolean> debt = new ArrayList<>();
    public static void registerUser(){



        System.out.println("What type of user are you?:\n" +
                "1. Student (S)\n" +
                "2. Professor (P)\n");
        String type = sc.nextLine();

        switch (type){
            case "1":
                createStudent();

                break;
            case "2":
                createProfessor();
               /*
                for (Person person : users) {
                    System.out.println(person);
                }*/
                break;
        }
    }

    public static void createStudent(){

        System.out.println("Insert your DNI: ");
        String DNI = sc.nextLine();
        System.out.println("Insert your name: ");
        String name = sc.nextLine();
        System.out.println("Insert your surname: ");
        String surname = sc.nextLine();
        System.out.println("Insert your age: ");
        int age = sc.nextInt();
        boolean debts = false;

        Person student = new Student(DNI, name, surname,age, debts);
        String ID = ("S-"+ DNI);
        student.setDNI(ID);
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);


        System.out.println("¡Register completed!\n" +
                " \n" +
                "ID: " + student.getDNI() +"\n" +
                "Name: " + student.getName() + " " + student.getSurname() +"\n" +
                "Age: " + student.getAge()+ "\n");

        users.add(student);
        ids.add("S-"+DNI);
        names.add(student.getName() + " " + student.getSurname());
        debt.add(debts);

    }

    public static void createProfessor(){
        System.out.println("Insert your DNI: ");
        String DNI = sc.nextLine();
        System.out.println("Insert your name: ");
        String name = sc.nextLine();
        System.out.println("Insert your surname: ");
        String surname = sc.nextLine();
        System.out.println("Insert your age: ");
        int age = sc.nextInt();
        boolean debts = false;
        Person professor = new Professor(DNI, name, surname,age,debts);
        String ID = ("P-"+ DNI);
        professor.setDNI(ID);
        professor.setName(name);
        professor.setSurname(surname);
        professor.setAge(age);

        System.out.println("¡Register completed!\n" +
                " \n" +
                "ID: " + professor.getDNI() +"\n" +
                "Name: " + professor.getName() + " " + professor.getSurname() +"\n" +
                "Age: " + professor.getAge() + "\n");

        users.add(professor);
        ids.add("P-"+DNI);
        names.add(professor.getName() + " " + professor.getSurname());
        debt.add(debts);
    }

}
