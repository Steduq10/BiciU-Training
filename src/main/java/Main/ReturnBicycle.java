package Main;

import Bicycle.Ticket;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static Bicycle.Ticket.*;
import static Main.TicketsHistory.*;

public class ReturnBicycle {
    static Scanner sc = new Scanner(System.in);
    static String id;
    static boolean helmet;
    static boolean condition;
    static String status;
    static LocalTime endTime;
    static double amount;
    static int code;
    static int i;

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
        i = codes.indexOf(codes.contains(ticket));
        //returnHelmet();
        System.out.println("Has helmet? \n" +
                "1. Yes\n" +
                "2. No ");
        int answer = sc.nextInt();
        helmet = helmetList.get(i + 1);
        if (answer == 1) {
            System.out.println("Helmet, ok");
            helmet = helmetList.get(i + 1);
        } else if (answer == 2) {
            //helmet = helmetList.set(i+1, false);
            helmet = false;
            System.out.println("Helmet, Not returned");
        }
        System.out.println("Status Helmet updated");


        System.out.println("Good condition?: \n" +
                "1. Yes\n" +
                "2. No ");
        int good = sc.nextInt();
        condition = conditionList.get(i + 1);
        if (good == 1) {
            System.out.println("Bicycle is in good condition");
            condition = conditionList.get(i + 1);
        } else if (good == 2) {
            // condition = conditionList.set(i+1, false);
            condition = false;
        }
        System.out.println("Status bicycle condition updated");
        System.out.println("Return time?: \n" +
                "Hour: ");
        int hour = sc.nextInt();
        System.out.println("Minutes: ");
        int minutes = sc.nextInt();
        endTime = LocalTime.of(hour, minutes);
        endTimeList.set(i + 1, endTime);
        status = statusList.get(i + 1);
       /* if (helmet == true && condition == true) { //falta agregar si se entregó a tiempo o no
            //status = statusList.set(i+1,"OK");
            status = "OK";
        } else {
            status = statusList.set(i + 1, "Pending");
            status = "Pending";
        }

        */
        String fullname = fullnameList.get(i+1);
        String bicycle = bicyclelist.get(i + 1);
        String user = userlist.get(i + 1);
        LocalDate date = dateList.get(i + 1);
        LocalTime starTime = startTimeList.get(i + 1);
        amount = 0;
        calculationDebts();
        TicketsHistory.saveTicket(code,user,fullname,amount,status);

        //generateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        System.out.println("Ticket updated!");
        updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        bicycleAvailable();
        System.out.println("Proceed payment?: \n" +
                "1. Yes\n" +
                "2. No");
        int pay = sc.nextInt();

        if (pay == 1) {
            PayTicket.payTicket();

        } else if (pay == 2) {
            System.out.println("Thanks for returning the bicycle, remember pay the ticket to be able to let a bicycle in another time");
        }


    }

    public static void calculationDebts() {
        Duration duration = Duration.between(startTimeList.get(i + 1), endTimeList.get(i + 1));
        //System.out.println("Time elapsed: " + duration.toMinutes() + "minutes");

        if (duration.toMinutes() > 30) {
            System.out.println("Bicycle was returned: " + duration.toMinutes() + " minutes late.");
            if (helmet == true && condition == true && duration.toMinutes() <30) {
                status = "OK";}
            else {
                //status = statusList.set(i + 1, "Pending");
                status = "Pending";
            }
            double timesLate = Math.floor(duration.toMinutes() / 30);
            double paidLate = timesLate * 3;
            System.out.println("Must to pay " + paidLate + " usd.");
            amount += paidLate;
        }

        if (helmet == false) {
            double paidHelmet = 5.0;
            System.out.println("The bicycle was returned with no helmet, must to pay " + paidHelmet + " usd.");
            amount += paidHelmet;
        }

        if (condition == false) {
            double paidDamaged = 5.0;
            System.out.println("The bicycle was returned damaged, must to pay " + paidDamaged + " usd.");
            amount += paidDamaged;
        }

        System.out.println("Total amount to pay: " + amount + " usd.");

    }

    public static void bicycleAvailable() {
        String bicycleCode = bicyclelist.get(i + 1);
        int position = BorrowBicycle.codes.indexOf(bicycleCode);
        BorrowBicycle.available.set(position , true);
        // System.out.println(bicycleCode + " is in the position " + position + "and now is available status is " + BorrowBicycle.available.get(position + 1));
    }


}