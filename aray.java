import java.util.ArrayList;
import java.util.Scanner;

public class aray {
    public static void  main(String args[]){
      Scanner sc = new Scanner(System.in);
        ArrayList<Float> mates = new ArrayList<>();
        ArrayList<Float> lengua = new ArrayList<>();
        ArrayList<String> alumno = new ArrayList<>();
        System.out.println("Dame el nombre del alumno y recuerde con un . saldra del programa: ");
        int contador = 1;
        while (true){
            System.out.printf("Alumno " + contador + ";");
            String input = sc.nextLine();
            if (input.equals(".")){
                break;
            }
            alumno.add(input);
            System.out.printf("Nota de mates de " + alumno.get(contador -1) + ";");
            float input2 = sc.nextFloat();
            mates.add(input2);
            sc.nextLine();
            System.out.printf("Nota de lengua de " + alumno.get(contador -1) + ";");
            float input3 = sc.nextFloat();
            lengua.add(input3);
            sc.nextLine();
            contador++;
        }
        float mediaM = 0;
        float mediaL = 0;
        for (int i = 0; i <mates.size() ; i++) {
                mediaM = mediaM + mates.get(i);
                mediaL = mediaL + lengua.get(i);
        }
        mediaM = mediaM / alumno.size();
        mediaL = mediaL / alumno.size();

        System.out.println("\nLista de alumnos y sus notas:");
        System.out.printf("%-20s %-20s %-20s\n", "Alumno", "Nota de mates", "Nota de lengua");

        for (int i = 0; i < alumno.size(); i++) {
            System.out.printf("%-20s %-20.2f %-20.2f\n", alumno.get(i), mates.get(i), lengua.get(i));
        }
        System.out.printf("\n%-20s %-20.2f %-20.2f\n", "Media", mediaM, mediaL);
    }
}
