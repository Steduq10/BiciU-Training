package Main;

import Bicycle.Bicycle;
import Bicycle.Ticket;
import DataAccess.DataAccessImpl;
import Exceptions.DataAccessEx;
import Person.Person;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static Main.RegisterUser.users;
import static Main.RegisterUser.ids;
import static Main.RegisterUser.names;
import static Main.RegisterUser.debt;
public class BorrowBicycle {
    static Scanner sc = new Scanner(System.in);
    static String id;
    static List<String> bicyclesData = new ArrayList<>();
    public static List<String> codes = new ArrayList<>();
    static List<String> colors = new ArrayList<>();
    static List<String> types = new ArrayList<>();
    static List<Boolean> available = new ArrayList<>();

    static List<Bicycle> bicycles = new ArrayList<>();

    static DataAccessImpl impl = new DataAccessImpl();
    public static void fileReader() throws DataAccessEx {
       // impl.createFile("tickets.txt");
        TicketsHistory.createHistory();

        File file = new File("bicycles data.txt");
        try {
            BufferedReader obj = new BufferedReader(new FileReader(file));
            String read;
            while ((read = obj.readLine()) != null ){
                //System.out.println(read);
                bicyclesData.add(read);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String bici: bicyclesData) {
            String[] split = bici.split(";");
            for(int i =0; i < split.length; i++) {


                if (split[i].contains("BIC-")) {

                    codes.add(split[i]);
                } else if (split[i].contains("red") || split[i].contains("blue") || split[i].contains("green") | split[i].contains("yellow") || split[i].contains("purple")) {
                    // System.out.println(split[i]);
                    colors.add(split[i]);
                } else if (split[i].contains("Mountain") || split[i].contains("Road")) {
                    types.add(split[i]);
                } else if (split[i].contains("true")) {
                    boolean bool = Boolean.parseBoolean(split[i]);
                    // System.out.println(bool);
                    available.add(bool);
                }

            }
        }
        for (int i = 0; i < codes.size(); i++) {
            String code = codes.get(i);
            String type = types.get(i);
            String color = colors.get(i);
            boolean ava = available.get(i);
            Bicycle bicycle = new Bicycle(code,type,color,ava);
            bicycle.setCodeCycle(code);
            bicycle.setType(type);
            bicycle.setColor(color);
            bicycle.setAvailable(ava);

            bicycles.add(bicycle);

        }

        }

        public static void borrowBicycle(){
            System.out.println("What type of user are you?:\n" +
                    "1. Student (S)\n" +
                    "2. Professor (P)\n");
            String type = sc.nextLine();

            switch (type){
                case "1":
                    borrowStudent();

                    break;
                case "2":
                    borrowProfessor();

                    break;
            }
        }

        public static void borrowStudent() {
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
            int i = ids.indexOf(ids.contains("S-" + id));

            if (debt.get(i + 1) == true) {
                System.out.println("The user: " + names.get(i + 1) + " has a ticket with debt. Please cancel it and try again\n");
                boolean menu = true;
            } else if (debt.get(i + 1) == false) {
                System.out.println("Select the bicycle's type:\n" +
                        "1. Road\n" +
                        "2. Mountain\n");
                selectType();
            }

        }

        public static void borrowProfessor(){
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
            int i = ids.indexOf(ids.contains("P-" + id));
            if (debt.get(i + 1) == true) {
                System.out.println("The user: " + names.get(i + 1) + " has a ticket with debt. Please cancel it and try again\n");
                boolean menu = true;
            } else if (debt.get(i + 1) == false) {
                System.out.println("Select the bicycle's type:\n" +
                        "1. Road\n" +
                        "2. Mountain\n");
                selectType();
            }
        }

        public static void selectType(){
            String option = sc.nextLine();
            switch (option) {
                case "1":
                    int i_Random = randomNumber(0, types.size() - 1);
                    String type = types.get(i_Random);

                    while (type.equals("Mountain")) {
                        i_Random = randomNumber(0, types.size() - 1);
                        type = types.get(i_Random);
                    }
                    int j = 0;
                    while (available.get(i_Random) == false && j < available.size()) {
                        System.out.println("Looking for a Road bicycle. Wait a moment please");
                        j++;
                    }

                    if (available.get(i_Random) == false) {
                        System.out.println("There are no Road bicycles available. Choose another one");
                        boolean menu = true;
                    } else if (available.get(i_Random) == true) {
                        System.out.println("Bicycle chosen!\n" +
                                "Code: " + codes.get(i_Random) + "\n" +
                                "Type: " + types.get(i_Random) + "\n" +
                                "Color: " + colors.get(i_Random) + "\n");

                        available.set(i_Random, false);
                        int ticket = Ticket.getCode();
                        int i = ids.indexOf(ids.contains("S-" + id));
                        LocalDate date = LocalDate.now();
                        //LocalTime startTime = LocalTime.now();
                        System.out.println("Start time?: \n" +
                                "Hour: ");
                        int hour = sc.nextInt();
                        System.out.println("Minutes: ");
                        int minutes = sc.nextInt();
                        LocalTime startTime = LocalTime.of(hour,minutes);
                        LocalTime endTime = null;
                        boolean helmet = true;
                        boolean condition = true;
                        String status = "Active";
                        double amount = 0.0;
                        System.out.println("A Ticket was generated!");
                        Ticket.generateTicket(ticket, codes.get(i_Random), ids.get(i+1), date,startTime, endTime,helmet, condition, status, amount );
                        TicketsHistory.saveTicket(ticket,ids.get(i+1),names.get(i+1),amount,status);

                    }
                    break;
                case "2":
                    i_Random = randomNumber(0, types.size() - 1);
                    type = types.get(i_Random);

                    while (type.equals("Road")) {
                        i_Random = randomNumber(0, types.size() - 1);
                        type = types.get(i_Random);
                    }
                    j = 0;
                    while (available.get(i_Random) == false && j < available.size()) {
                        System.out.println("Looking for a Road bicycle. Wait a moment please");
                        j++;
                    }

                    if (available.get(i_Random) == false) {
                        System.out.println("There are no Mountain bicycles available. Choose another one");
                        boolean menu = true;
                    } else if (available.get(i_Random) == true) {
                        System.out.println("Bicycle chosen!\n" +
                                "Code: " + codes.get(i_Random) + "\n" +
                                "Type: " + types.get(i_Random) + "\n" +
                                "Color: " + colors.get(i_Random) + "\n");

                        available.set(i_Random, false);
                        int ticket = Ticket.getCode();
                        int i = ids.indexOf(ids.contains("S-" + id));
                        LocalDate date = LocalDate.now();
                        //LocalTime startTime = LocalTime.now();
                        System.out.println("Start time?: \n" +
                                "Hour: ");
                        int hour = sc.nextInt();
                        System.out.println("Minutes: ");
                        int minutes = sc.nextInt();
                        LocalTime startTime = LocalTime.of(hour,minutes);

                        LocalTime endTime = null;
                        boolean helmet = true;
                        boolean condition = true;
                        String status = "Active";
                        double amount = 0.0;
                        System.out.println("A Ticket was generated!");
                        Ticket.generateTicket(ticket, codes.get(i_Random), ids.get(i+1), date,startTime, endTime,helmet, condition, status, amount );
                        TicketsHistory.saveTicket(ticket,ids.get(i+1),names.get(i+1),amount,status);

                    }
                    break;
            }
        }

        public static int randomNumber(int min, int max){
            return ThreadLocalRandom.current().nextInt(min,max + 1);
        }

    }






