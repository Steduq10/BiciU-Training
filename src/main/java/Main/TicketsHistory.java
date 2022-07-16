package Main;

import DataAccess.DataAccessImpl;
import Exceptions.DataAccessEx;

import java.util.Scanner;

public class TicketsHistory {
    static Scanner sc = new Scanner(System.in);
    static DataAccessImpl impl = new DataAccessImpl();

    public static void menuHistory(){
        System.out.println("**************************");
        System.out.println("Welcome to history menu");
        System.out.println("**************************");

        System.out.println("Select a option:\n" +
                "1. Show all tickets\n" +
                "2. Search by code\n" +
                "3. Search by status");
        int option = sc.nextInt();

        switch (option){
            case 1:
                System.out.println("all tickets");
                break;
            case 2 :
                System.out.println("by code");
                break;
            case 3 :
                System.out.println("by status");
                break;
        }
    }

    public static void createHistory() throws DataAccessEx {

        impl.createFile("tickets");
    }

}
