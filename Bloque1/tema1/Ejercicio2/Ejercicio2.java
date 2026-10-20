package Ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio2 {
    public static void main(String[] args) {
        try {
            File foto1 = new File("./Ejercicio2/foto.png");
            File foto2 = new File("./Ejercicio2/foto_copia.png");

            FileInputStream fis = new FileInputStream(foto1);
            FileOutputStream fos = new FileOutputStream(foto2);
            int bait;
            int contador = 0;

            while ((bait = fis.read())>-1) {
                fos.write(bait);
                contador++;
            }

            System.out.println("La imagen tiene "+contador+" bytes");

            fis.close();
            fos.close();



        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
