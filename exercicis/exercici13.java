import java.util.Scanner;

/*13- Fes un programa que calculi la distància entre dos punts (en un espai bidimensional). Cada
punt ve donat per dos números (coordenada x i coordenada y) */

public class exercici13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix la coordenada x1: ");
        double x1 = sc.nextDouble();
        System.out.print("Introdueix la coordenada y1: ");
        double y1 = sc.nextDouble();
        System.out.print("Introdueix la coordenada x2: ");
        double x2 = sc.nextDouble();
        System.out.print("Introdueix la coordenada y2: ");
        double y2 = sc.nextDouble();
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("La distància entre els punts (" + x1 + ", " + y1 + ") i (" + x2 + ", " + y2 + ") és: " + distancia);
        sc.close();
    }
}
