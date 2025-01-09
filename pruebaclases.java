import java.util.Scanner;
import  java.util.ArrayList;

public class pruebaclases {
    static class alumno {
        private String nombre;
        private float mates;
        private float lengua;

        public alumno(String nombre, float mates, float lengua){
            this.nombre = nombre;
            this.mates = mates;
            this.lengua = lengua;
        }
        public String getNombre() {
            return nombre;
        }

        public float getMates() {
            return mates;
        }

        public float getLengua() {
            return lengua;
        }

        public void imprimirinfo() {
            System.out.printf("%-20s %-20.2f %-20.2f\n", nombre, mates, lengua);
        }

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<alumno> alumnos = new ArrayList<>();

            System.out.println("Dame el nombre del alumno y recuerde con un . saldrá del programa: ");


        int contador = 1;
            while (true) {
            System.out.printf("Alumno " + contador + ": ");
            String nombre = sc.nextLine();
            if (nombre.equals(".")) {
                break;
            }

            System.out.printf("Nota de mates de " + nombre + ": ");
            float mates = sc.nextFloat();

            System.out.printf("Nota de lengua de " + nombre + ": ");
            float lengua = sc.nextFloat();
            sc.nextLine();


            alumno nuevoAlumno = new alumno(nombre, mates, lengua);
            alumnos.add(nuevoAlumno);

            contador++;
        }


        float mediaM = 0;
        float mediaL = 0;
            for (alumno alumno : alumnos) {
            mediaM += alumno.getMates();
            mediaL += alumno.getLengua();
        }

        mediaM = mediaM / alumnos.size();
        mediaL = mediaL / alumnos.size();


            System.out.println("\nLista de alumnos y sus notas:");
            System.out.printf("%-20s %-20s %-20s\n", "Alumno", "Nota de mates", "Nota de lengua");


            for (alumno alumno : alumnos) {
            alumno.imprimirinfo();
        }


            System.out.printf("\n%-20s %-20.2f %-20.2f\n", "Media", mediaM, mediaL);
    }
}
