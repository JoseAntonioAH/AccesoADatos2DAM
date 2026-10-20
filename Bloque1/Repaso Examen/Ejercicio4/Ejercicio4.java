package Ejercicio4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio4 {
    public static void main(String[] args) {
        try {
            File foto = new File("./Ejercicio4/foto.png");
            File fotoCopia = new File("./Ejercicio4/foto_copia.png");

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(foto));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fotoCopia));

            int contador = 0;
            int data;
            byte[] buffer = new byte[1024];

            while ((data=bis.read(buffer))!=-1) {
                bos.write(buffer, 0, data);
                contador++;
                System.out.println("Fin copia bloque "+contador);
            }

            bis.close();
            bos.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
