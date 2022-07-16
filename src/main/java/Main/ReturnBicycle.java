package Main;

import Bicycle.Ticket;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static Bicycle.Ticket.*;

public class ReturnBicycle {
    static Scanner sc = new Scanner(System.in);
    static String id;
    static boolean helmet;
    static boolean condition;
    static String status;
    static LocalTime endTime;
    static double Amount;
    static int code;

    public static void returnBicycle() {
        System.out.println("What is the number of your ticket?:\n");
        int code = sc.nextInt();
        if (codes.contains(code)) {
            statusBicycle();
        } else {
            System.out.println("Ticket not found, please try again");
            boolean menu = true;
        }

    }
        public static void statusBicycle() {
            String ticket = "T-" + code;
            int i = codes.indexOf(codes.contains(ticket));
            System.out.println("Has helmet? \n" +
                    "1. Yes\n" +
                    "2. No\n");
            String h = sc.nextLine();
            if(h.equals("1")){
                System.out.println("Helmet, ok");
            } else if (h.equals("2")) {
                helmet = helmetList.set(i, false);

            }

            System.out.println("Good condition?: \n"+
                    "1. Yes\n" +
                    "2. No\n");

            String g = sc.nextLine();
            switch (g) {
                case "1":
                    System.out.println("Bicycle is in good condition");
                    break;
                case "2":
                    condition = conditionList.set(i, false);
                    break;
            }
            System.out.println("Return time?: \n" +
                    "Hour: ");
            int hour = sc.nextInt();
            System.out.println("Minutes: ");
            int minutes = sc.nextInt();
            endTime = LocalTime.of(hour,minutes);
            endTimeList.set(i+1,endTime);  //hacer un método que me permita determinar si se entrego a tiempo o cuanto tiempo tarde

            if(helmet == true && condition == true){ //falta agregar si se entregó a tiempo o no
                status = statusList.set(i+1,"OK");
            }else{
                status = statusList.set(i+1,"Pending");
            }

            String  bicycle = bicyclelist.get(i+1);
            String user = userlist.get(i+1);
            LocalDate date = dateList.get(i+1);
            LocalTime starTime = startTimeList.get(i+1);
            double amount = 10.0; // prueba
            generateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        }


    }
