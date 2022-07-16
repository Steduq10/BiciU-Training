package Main;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import static Bicycle.Ticket.*;

public class PayTicket {
    static Scanner sc = new Scanner(System.in);
    static int code;
    static int i;
    static double amount;
    static String status;

        public static void payTicket(){
            System.out.println("Enter ID ticket: ");
            int code = sc.nextInt();

            if (codes.contains(code)) {
                loadTicket();
            } else {
                System.out.println("Ticket not found, please try again");
                boolean menu = true;
            }
        }

        public static void loadTicket() {
            String ticket = "T-" + code;
            i = codes.indexOf(codes.contains(ticket));

            String  bicycle = bicyclelist.get(i+1);
            String user = userlist.get(i+1);
            LocalDate date = dateList.get(i+1);
            LocalTime starTime = startTimeList.get(i+1);
            LocalTime endTime = endTimeList.get(i+1);
            boolean helmet = helmetList.get(i+1);
            boolean condition = conditionList.get(i+1);
            amount = amountList.get(i+1);
            status = statusList.get(i+1);
            //generateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
            updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);

            System.out.println("Amount to pay: " + amount + " usd.");
            System.out.println("Please, insert the quantity of usd to pay: ");
            double usd = sc.nextDouble();
            if (usd == amount) {
                System.out.println("Thanks for paying. See you soon");
                status = "OK";
                //amount = 0;
                updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
            } else if (usd > amount) {
                System.out.println("Thanks for paying. See you soon");
                double spare = usd - amount;
                System.out.println("You have " + spare + " usd to spare.");
                status = "OK";
                //amount = 0;
                updateTicket(code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
            }
            else if(usd<amount){
                System.out.println("Please, insert the correct amount; You must to pay: " + amount + " usd");
            }



        }



}