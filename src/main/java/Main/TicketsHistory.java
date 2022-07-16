package Main;

import Bicycle.Ticket;
import DataAccess.DataAccessImpl;
import Exceptions.DataAccessEx;
import Exceptions.DataWritingEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketsHistory {

    private int code;
    private String user;
    private String fullName;
    private double amount;
    private String status;

    static Scanner sc = new Scanner(System.in);
    static DataAccessImpl impl = new DataAccessImpl();
    static List<TicketsHistory> ticketFileList = new ArrayList<>();
    static List<String> header = new ArrayList<>();


    public TicketsHistory(int code, String user, String fullName, double amount, String status) {
        this.code = code;
        this.user = user;
        this.fullName = fullName;
        this.amount = amount;
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

        impl.createFile("tickets.txt");
        header.add("Code");
        header.add("UserID");
        header.add("Name");
        header.add("Amount($)");
        header.add("Status");

        try {
            impl.writeFile2("tickets.txt", header, true );
        } catch (DataWritingEx e) {
            throw new RuntimeException(e);
        }
    }


    public static void saveTicket(int code, String user, String fullname, double amount, String status){
        code ++;
        TicketsHistory ticketFile = new TicketsHistory(code,user,fullname,amount,status);
        ticketFile.setCode(code);
        ticketFile.setUser(user);
        ticketFile.setFullName(fullname);
        ticketFile.setAmount(amount);
        ticketFile.setStatus(status);

        ticketFileList.add(ticketFile);

        try {
            impl.writeFile("tickets.txt", ticketFileList, true);
        } catch (DataWritingEx e) {
            throw new RuntimeException(e);
        }
       /*
        try {
            impl.writeFile("tickets.txt",ticketFile, true);
        } catch (DataWritingEx e) {
            throw new RuntimeException(e);
        }

        */

    }

    @Override
    public String toString() {
        return
               "T-"+ code +"   "+ user +"   "+ fullName +"   "+ amount +"   "+ status ;
    }
}
