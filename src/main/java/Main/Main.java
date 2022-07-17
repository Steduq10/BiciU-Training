package Main;

import Exceptions.DataAccessEx;
import Main.RegisterUser;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        boolean menu = false;
        do {
            System.out.println("Welcome to Bici-U");
            System.out.println("Please select one of the following options: \n" +
                    "1. Register user\n" +
                    "2. Borrow Bicycle\n" +
                    "3. Return Bicycle\n" +
                    "4. Pay tickets\n" +
                    "5. Tickets history\n" +
                    "6. Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    RegisterUser.registerUser();
                    menu = true;
                    break;
                case 2:

                    try {
                        BorrowBicycle.fileReader();
                    } catch (DataAccessEx e) {
                        throw new RuntimeException(e);
                    }
                    BorrowBicycle.borrowBicycle();
                    menu = true;
                    break;
                case 3:
                    System.out.println("Here go Return Bicycle");
                    ReturnBicycle.returnBicycle();

                    break;
                case 4:
                    System.out.println("Here go pay tickets");
                    PayTicket.payTicket();

                    break;
                case 5:
                    System.out.println("Tickets history");
                    TicketsHistory.menuHistory();
                    menu = true;
                    break;
                case 6:
                    System.out.println("Goodbye. See you soon!");
                    menu = false;
                    break;
                default:
                    System.out.println("Insert a correct option");
                    menu = true;
            }
        }while (menu == true);

    }
}
