package Ejercicio3;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce una posición:");
            int posicion = Integer.parseInt(sc.nextLine());
            
            System.out.println("Introduce un caracter:");
            char caracter = sc.nextLine().charAt(0);

            File archivo = new File("./Ejercicio3/datos.txt");

            RandomAccessFile raf = new RandomAccessFile(archivo, "rw");
            raf.seek(posicion);
            raf.write(caracter);

            raf.close();
            sc.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
