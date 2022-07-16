package Main;

import Bicycle.Ticket;

import java.time.LocalTime;
import java.util.Scanner;

import static Main.RegisterUser.ids;
import static Main.RegisterUser.names;

public class ReturnBicycle {
    static Scanner sc = new Scanner(System.in);
    static String id;
    static boolean helmet;
    static boolean status;
    static LocalTime endTime; //Seguir ejemplo del ejercicio de sanipet. Ingresar la hora manualmente.
    static double Amount;


    public static void returnBicycle(){
        System.out.println("What type of user are you?:\n" +
                "1. Student (S)\n" +
                "2. Professor (P)\n");
        String type = sc.nextLine();

        switch (type){
            case "1":
                returnStudent();

                break;
            case "2":
                returnProfessor();

                break;
        }
    }

    public static void returnStudent(){
        System.out.println("Please insert your DNI: ");
        id = sc.nextLine();
        String user = "S-"+id;
        if   (ids.contains("S-" + id)) {
            int i = ids.indexOf(ids.contains("S-" + id));
            System.out.println("Welcome: " + names.get(i + 1));
        } else {
            System.out.println("User not found, please register or try again");
            boolean menu = true;
        }
    }


    public static void returnProfessor(){
        System.out.println("Please insert your DNI: ");
        String id = sc.nextLine();
        String user = "P-"+id;
        if(ids.contains("P-"+id)){
            int i = ids.indexOf(ids.contains("P-"+id));
            System.out.println("Welcome: " + names.get(i+1));
        } else {
            System.out.println("User not found, please register or try again");
            boolean menu = true;
        }
    }

    public static void statusBicycle(){
        int code = Ticket.getCode();
        int i = ids.indexOf(ids.contains("S-" + id)); //corregir para que se ajuste a usuario professor
        System.out.println("Has helmet? \n" +
                "1. Yes\n" +
                "2. No\n");
        String h = sc.nextLine();
        switch (h){
            case "1":
                System.out.println("Helmet, ok");
                break;
            case "2":

        }

    }
}
