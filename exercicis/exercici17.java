import java.util.Scanner;

public class exercici17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el mes en que naciste (1-12):");
        int mes = sc.nextInt();

        System.out.println("Dime el día que naciste:");
        int dia = sc.nextInt();

        boolean libra = false; 

        if ((mes == 9 && dia >= 23 && dia <= 30) || (mes == 10 && dia >= 1 && dia <= 22)) {
            libra = true; 
        }

        if (libra) {
            System.out.println("Eres del signo Libra.");
        } else {
            System.out.println("No eres del signo Libra.");
        }

        sc.close();
    }
}
