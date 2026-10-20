package Ejercicio6;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        try {
            File archivo = new File("./Ejercicio6/asientos.txt");
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Introduce el numero del asiento (0-19):");
            int asiento = Integer.parseInt(sc.nextLine());

            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");

            boolean disponible = true;

            if (asiento>19 || asiento<0) {
                System.out.println("Asiento no existente");
            }else{
                raf.seek(asiento);
                if (raf.read()=='L') {
                    disponible = true;
                }else{
                    disponible = false;
                }

                if (disponible) {
                    raf.seek(asiento);
                    raf.write('C');
                    System.out.println("Asiento reservado correctamente");
                }else{
                    System.out.println("Asiento no disponible");
                }
            }

            sc.close();
            raf.close();


        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
