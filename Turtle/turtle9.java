/*
 9- Dibuixa el següent gràfic. Paràmetres: longitud de costat i número de triangles.
 */

import java.util.Scanner;
import static java.lang.Math.toRadians;

public class turtle9 {
    static Turtle t = new Turtle(800, 600);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el numero de lados que tendra tu figura: ");
        int ntriangles = sc.nextInt();
        System.out.println("Dime el tamaño al que quieres la figura: ");
        int costat = sc.nextInt();

        double gamma = (360d / (double) ntriangles);
        double beta = (180d - gamma) / 2d;
        double h = ((double) costat) / 2d / Math.cos(toRadians(beta));

        for (int i = 0; i < ntriangles; i++) {
            t.goTo(0,0);
            t.resetAngle();
            t.turnRight((int) (gamma * i));
            triangulo(t, h, beta, costat);
        }
        sc.close();
        t.show();

    }

    private static void triangulo(Turtle t, double h, double beta, int costat) {
        t.forward((int) h);
        t.turnRight(180);
        t.turnRight((int) beta);
        t.forward(costat);
        t.turnRight(180);
        t.turnRight((int) beta);
        t.forward((int) h);
    }
}
