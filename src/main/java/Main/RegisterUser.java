package Main;

import Person.Person;
import Person.Student;
import Person.Professor;
import java.util.Scanner;


public class RegisterUser {
    static Scanner sc = new Scanner(System.in);

    public static void registerUser(){

        System.out.println("What type of use are you?:\n" +
                "1. Student (S)\n" +
                "2. Professor (P)\n");
        String type = sc.nextLine();

        switch (type){
            case "1":
                createStudent();
                break;
            case "2":
                createProfessor();
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

        Person student = new Student(DNI, name, surname,age,false);
        student.setDNI(DNI);
        student.setName(name);
        student.setSurname(surname);
        student.setAge(age);

        System.out.println("¡Register completed\n" +
                " \n" +
                "ID: S-" + student.getDNI() +"\n" +
                "Name: " + student.getName() + " " + student.getSurname() +"\n" +
                "Age: " + student.getAge());


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

        Person professor = new Professor(DNI, name, surname,age,false);
        professor.setDNI(DNI);
        professor.setName(name);
        professor.setSurname(surname);
        professor.setAge(age);

        System.out.println("¡Register completed\n" +
                " \n" +
                "ID: S-" + professor.getDNI() +"\n" +
                "Name: " + professor.getName() + " " + professor.getSurname() +"\n" +
                "Age: " + professor.getAge());

    }

}
