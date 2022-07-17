package Main;

import java.util.Formatter;
import java.util.Scanner;

public class prueba {
    public static void main(String[] args) {
        Scanner miScanner = new Scanner(System.in);

        System.out.print("Introduce un número: ");

        int numero = miScanner.nextInt();



        //Queremos que tenga 5 cifras

        //Para hacerlo hay que usar la clase Formatter



        Formatter obj = new Formatter();

        String numeroCeros = String.valueOf(obj.format("%05d", numero));



        System.out.println(numeroCeros);

    }
    }

