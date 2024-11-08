public class turtle4 {
    public static void main(String[] args) {
        Turtle t = new Turtle(500, 500);

        int stepLength = 50;
        int angle = 90;
        int repetitions = 3;

        t.forward(25);
        moveUp(t, stepLength, angle, repetitions);
        moveDown(t, stepLength, angle, repetitions);
        t.show();
    }

    public static void moveUp(Turtle t, int stepLength, int angle, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            t.turnLeft(angle);
            t.forward(stepLength);
            t.turnRight(angle + 45);
            t.forward(stepLength + 23);
            t.turnLeft(angle - 45);
        }
    }

    public static void moveDown(Turtle t, int stepLength, int angle, int repetitions) {
        t.turnRight(angle + 39);
        t.forward(stepLength + 29);
        t.turnRight(angle + 49);

        for (int i = 0; i < repetitions - 1; i++) {
            t.forward(stepLength);
            t.turnLeft(angle + 45);
            t.forward(stepLength + 23);
            t.turnRight(angle + 45);
        }
        t.forward(stepLength);
        t.turnLeft(angle);
        t.forward(25);
    }
}
