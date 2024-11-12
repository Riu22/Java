import java.util.Scanner;
/*
 * 7- Dibuixa el següent gràfic. Paràmetres: nombre de fulles.
 */
public class turtle7 {
    static Turtle t = new Turtle(800, 600);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos petalos tendra tu flor?");
        int petalo = sc.nextInt();

        double grados = 360d / ( double)petalo;

        for (int i = 0; i < petalo; i++) {
            petalo(i*grados);
        }
        sc.close();
        t.show();
    }
    private static void petalo(double grados) {
        t.goTo(0,0);
        t.resetAngle();
        t.turnRight((int) grados);
        mediopetalo(t, true);
        t.goTo(0,0);
        t.resetAngle();
        t.turnRight((int) grados);
        t.turnRight(72);
        mediopetalo(t, false);
    }

    public static void mediopetalo (Turtle t, boolean dreta) {
        for (int i = 0; i < 25; i++) {
            t.forward(9);
            if (!dreta) t.turnLeft(3);
            else t.turnRight(3);
        }
    }
}