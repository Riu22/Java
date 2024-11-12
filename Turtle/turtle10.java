/*
 10- Dibuixa el següent gràfic.
 */

public class turtle10 {
    public static void main(String[] args) {
        Turtle t = new Turtle(800, 600);
        int diametre = (int) (360.0 / Math.PI);

        t.forward(diametre);

        cuarto(t, 1);

        t.turnRight(90);
        t.forward(diametre);

        cuarto2(t, -1);

        t.show();
    }


    private static void cuarto(Turtle t, int angle) {
        t.turnRight(90 * angle);
        for (int i = 0; i < 90; i++) {
            t.turnRight(1);
            t.forward(1);
        }
    }

    private static void cuarto2(Turtle t, int angle) {
        t.turnRight(90 * angle);
        for (int j = 0; j < 90; j++) {
            t.turnLeft(1);
            t.forward(1);
        }
    }
}
