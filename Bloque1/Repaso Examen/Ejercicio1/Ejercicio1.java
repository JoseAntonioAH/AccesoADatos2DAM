package Ejercicio1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            File archivo1 = new File("./Ejercicio1/datos.txt");
            File archivo2 = new File("./Ejercicio1/datos_copia.txt");

            FileReader fr = new FileReader(archivo1);
            FileWriter fw = new FileWriter(archivo2);

            int data;

            while ((data = fr.read())>-1) {
                fw.write(data);
            }

            fr.close();
            fw.close();

            System.out.println("Copia del archivo completada");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
