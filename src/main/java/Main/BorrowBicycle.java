package Main;

import Bicycle.Bicycle;
import Person.Person;

import java.io.*;
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
    static List<String> bicyclesData = new ArrayList<>();
    static List<String> codes = new ArrayList<>();
    static List<String> colors = new ArrayList<>();
    static List<String> types = new ArrayList<>();
    static List<Boolean> available = new ArrayList<>();

    static List<Bicycle> bicycles = new ArrayList<>();
    public static void fileReader(){
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
        //System.out.println(bicycles.toString());

        }

        public static void borrowBicycle(){
            System.out.println("What type of use are you?:\n" +
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

        public static void borrowStudent(){
            System.out.println("Please insert your DNI: ");
            String id = sc.nextLine();

            if(ids.contains("S-"+id)){
                int i = ids.indexOf(ids.contains("S-"+id));
                System.out.println("Welcome: " + names.get(i+1));
                } else {
                System.out.println("User not found, please register or try again");
                boolean menu = true;
            }
            int i = ids.indexOf(ids.contains("S-"+id));
            if(debt.get(i+1) == true){
                System.out.println("The user: " + names.get(i+1) + "has a ticket with debt. Please cancel it and try again");
                boolean menu = true;
            }else if(debt.get(i+1) == false){
                System.out.println("Select the bicycle's type:\n" +
                        "1. Road\n" +
                        "2. Mountain\n");
            }
            String option = sc.nextLine();

            switch (option){
                case "1":
                    int i_Random = randomNumber(0, types.size() - 1);
                    String type = types.get(i_Random);
                    while(type == "Road"){
                        if(available.get(i_Random) == true){
                            System.out.println("Bicycle chosen!\n" +
                                    "Code: " + codes.get(i_Random) +"\n" +
                                    "Type: " + types.get(i_Random) +"\n" +
                                    "Color: " + colors.get(i_Random) +"\n");
                        }else if(available.get(i_Random) == false){
                            
                        }
                    }

            }

        }

        public static void borrowProfessor(){
            System.out.println("Please insert your DNI: ");
            String id = sc.nextLine();

            if(ids.contains("P-"+id)){
                int i = ids.indexOf(ids.contains("P-"+id));
                System.out.println("Welcome: " + names.get(i+1));
            } else {
                System.out.println("User not found, please register or try again");
                boolean menu = true;
            }
        }

        public static int randomNumber(int min, int max){
            return ThreadLocalRandom.current().nextInt(min,max + 1);
        }

    }






