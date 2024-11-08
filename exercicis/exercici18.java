import java.util.Scanner;

public class exercici18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Dime el año:");
        int any = sc.nextInt();

        boolean esBixest = false;

        // Verificar si el año es bisiesto (bixest)
        if ((any % 4 == 0 && any % 100 != 0) || (any % 400 == 0)) {
            esBixest = true;
        }

        // Mostrar resultado
        if (esBixest) {
            System.out.println("El año " + any + " es bisiesto.");
        } else {
            System.out.println("El año " + any + " no es bisiesto.");
        }

        sc.close();
    }
}
