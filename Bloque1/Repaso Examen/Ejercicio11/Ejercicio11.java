package Ejercicio11;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Ejercicio11 {
    public static void main(String[] args) {
        try {
            File archivo = new File("./Ejercicio11/datos.txt");

            LineNumberReader ln = new LineNumberReader(new FileReader(archivo));
            String linea;

            

            while ((linea = ln.readLine())!=null) {
                StreamTokenizer token = new StreamTokenizer(new StringReader(linea));
                System.out.println("Linea: "+ln.getLineNumber());

                while (token.nextToken()!=StreamTokenizer.TT_EOF) {
                    if (token.ttype==StreamTokenizer.TT_WORD) {
                        System.out.println("Palabra:"+token);
                    }else if (token.ttype == StreamTokenizer.TT_NUMBER) {
                        System.out.println("Numero:"+token);
                        
                    }
                }
            }

            ln.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
