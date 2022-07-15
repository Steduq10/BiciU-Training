package Bicycle;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static Main.BorrowBicycle.codes;

public class Ticket {

    //Necesito un contador para generar el número del tiquete y que aumente su número de uno en uno por cada
    // tiquete generado.
    private static int code;
    private String bicycle;
    private String user;
    private LocalDate date;
    private LocalTime starTime;
    private LocalTime endTime;
    private boolean helmet;
    private boolean condition;
    private String status;
    private double amount;

    public Ticket(){
        code++;
    }

    public Ticket(int code, String bicycle, String user, LocalDate date, LocalTime starTime, LocalTime endTime, boolean helmet, boolean condition, String status, double amount) {
        this.code = code;
        this.bicycle = bicycle;
        this.user = user;
        this.date = date;
        this.starTime = starTime;
        this.endTime = endTime;
        this.helmet = helmet;
        this.condition = condition;
        this.status = status;
        this.amount = amount;
    }

    public static int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBicycle() {
        return bicycle;
    }

    public void setBicycle(String bicycle) {
        this.bicycle = bicycle;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStarTime() {
        return starTime;
    }

    public void setStarTime(LocalTime starTime) {
        this.starTime = starTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public boolean isHelmet() {
        return helmet;
    }

    public void setHelmet(boolean helmet) {
        this.helmet = helmet;
    }

    public boolean isCondition() {
        return condition;
    }

    public void setCondition(boolean condition) {
        this.condition = condition;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "A Ticket was generated! \n" +
                "Code: T-" + code + "\n" +
                "Bicycle: " + bicycle + "\n" +
                "User: " + user + "\n" +
                "Date:" + date + "\n" +
                "Start time: " + starTime + "\n" +
                "End time:" + endTime + "\n" +
                "Helmet: " + helmet + "\n" +
                "Good condition: " + condition + "\n" +
                "Status: " + status + "\n" +
                "Amount:" + amount + "\n";
    }

    public static void generateTicket(int code, String bicycle, String user, LocalDate date, LocalTime starTime, LocalTime endTime,boolean helmet, boolean condition, String status, double amount){
        code ++;
        Ticket ticket = new Ticket( code, bicycle, user, date, starTime, endTime, helmet, condition, status, amount);
        ticket.setCode(code);
        ticket.setBicycle(bicycle);
        ticket.setUser(user);
        ticket.setDate(date);
        ticket.setStarTime(starTime);
        ticket.setEndTime(endTime);
        ticket.setHelmet(helmet);
        ticket.setCondition(condition);
        ticket.setStatus(status);
        ticket.setAmount(amount);

        System.out.println(ticket.toString());
    }
}
