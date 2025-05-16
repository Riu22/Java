package leer_archivos;
import java.io.*;
import java.util.*;

public class ejercicio1 {
    public static class Personaje {
        public String nombre;
        public int apariciones;
        public char genero;
        public int anyo;
        public String notas;
        public Personaje(String nombre, int apariciones, char genero, int anyo, String notas) {
            this.nombre = nombre;
            this.apariciones = apariciones;
            this.genero = genero;
            this.anyo = anyo;
            this.notas = notas;
        }
        public static Personaje leer(RandomAccessFile raf) throws IOException {
            byte[] nombreBytes = new byte[50];
            raf.readFully(nombreBytes);
            String nombre = new String(nombreBytes, "UTF-8").split("\0", 2)[0].trim();
            int apariciones = raf.readInt();
            char genero = (char) raf.readByte();
            int anyo = raf.readUnsignedShort();
            byte[] notasBytes = new byte[300];
            raf.readFully(notasBytes);
            String notas = new String(notasBytes, "UTF-8").split("\0", 2)[0].trim();
            return new Personaje(nombre, apariciones, genero, anyo, notas);
        }
    }

    public static List<Personaje> llegirPersonatges(File f) throws IOException {
        List<Personaje> llista = new ArrayList<>();
        try (RandomAccessFile raf = new RandomAccessFile(f, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                llista.add(Personaje.leer(raf));
            }
        }
        return llista;
    }

    public static int comptarHomes(List<Personaje> llista) {
        int count = 0;
        for (Personaje p : llista)
            if (p.genero == 'H' || p.genero == 'M') count++;
        return count;
    }
    public static int comptarDones(List<Personaje> llista) {
        int count = 0;
        for (Personaje p : llista)
            if (p.genero == 'D' || p.genero == 'F') count++;
        return count;
    }
    public static void anysExtrems(List<Personaje> llista) {
        int anyMin = Integer.MAX_VALUE, anyMax = Integer.MIN_VALUE;
        for (Personaje p : llista) {
            if (p.anyo < anyMin) anyMin = p.anyo;
            if (p.anyo > anyMax) anyMax = p.anyo;
        }
        System.out.println("Any més petit: " + anyMin);
        for (Personaje p : llista) if (p.anyo == anyMin) System.out.println(" - " + p.nombre);
        System.out.println("Any més gran: " + anyMax);
        for (Personaje p : llista) if (p.anyo == anyMax) System.out.println(" - " + p.nombre);
    }
    public static double mitjanaDones(List<Personaje> llista) {
        int sum = 0, count = 0;
        for (Personaje p : llista) {
            if (p.genero == 'D' || p.genero == 'F') {
                sum += p.apariciones;
                count++;
            }
        }
        return count == 0 ? 0 : (double) sum / count;
    }
    public static double varianciaHomes(List<Personaje> llista) {
        List<Integer> vals = new ArrayList<>();
        for (Personaje p : llista) {
            if (p.genero == 'H' || p.genero == 'M') vals.add(p.apariciones);
        }
        if (vals.size() == 0) return 0;
        double mitjana = vals.stream().mapToInt(Integer::intValue).average().getAsDouble();
        double sumq = 0;
        for (int x : vals) sumq += (x - mitjana) * (x - mitjana);
        return sumq / vals.size();
    }

    public static void main(String[] args) {
        File fitxer = new File("./leer_archivos/avengers.bin");
        List<Personaje> llista = new ArrayList<>();
        try {
            llista = llegirPersonatges(fitxer);
            System.out.println("Total personatges: " + llista.size());
            System.out.println("Homes: " + comptarHomes(llista));
            System.out.println("Dones: " + comptarDones(llista));
            anysExtrems(llista);
            System.out.printf("Mitjana aparicions (dones): %.2f\n", mitjanaDones(llista));
            System.out.printf("Variància aparicions (homes): %.2f\n", varianciaHomes(llista));
        } catch (IOException e) {
            System.err.println("Error llegint el fitxer: " + e.getMessage());
        }
    }
}