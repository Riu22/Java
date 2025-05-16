package leer_archivos;

import java.io.*;

public class primeras_impresiones {
    public static void main(String[] args) throws IOException {
        File fc = new File("./leer_archivos");
        fc.list();
        String[] ficheros = fc.list();
        for(String s: ficheros){
            System.out.println(s);
        }

        InputStream entrada = new FileInputStream("./leer_archivos/hola.txt");
        int valor = entrada.read();
        while (valor != -1) {
            System.out.print((char) valor);
            valor = entrada.read();
        }
        entrada.close();

        OutputStream salida = new FileOutputStream("./leer_archivos/hola.txt");
        salida.write(104);
        String s = "patata";
        for (int i = 0; i < s.length(); i++) {
            salida.write(s.charAt(i));
        }
        salida.close();

        Reader leer = new FileReader("./leer_archivos/hola.txt");
        BufferedReader br = new BufferedReader(leer);
        String linea = br.readLine();
        System.out.println(linea);
        br.close();

        Writer writer = new FileWriter("./leer_archivos/hola.txt");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write("hola");
        bw.flush();
        bw.close();


    }
}
