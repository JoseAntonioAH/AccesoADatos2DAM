package Ejercicio7;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            File archvo = new File("./Ejercicio7/asientos.txt");
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Dime en que asiento empiezo a contar");
            int asiento = Integer.parseInt(sc.nextLine());

            System.out.println("Dime cuantos asientos quieres consultar");
            int numAsientos = Integer.parseInt(sc.nextLine());

            byte[] arrayBytes = new byte[numAsientos];
            RandomAccessFile raf = new RandomAccessFile(archvo, "r");

            raf.seek(asiento);
            raf.read(arrayBytes, 0, numAsientos);

            for (int i = 0; i < arrayBytes.length; i++) {
                System.out.print((char)arrayBytes[i]);
            }

            sc.close();
            raf.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
