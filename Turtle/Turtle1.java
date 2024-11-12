import java.util.Scanner;
/*
 1- Dibuixa el següent gràfic. Paràmetres: Nombre de quadres en horitzontal, nombre de quadres en
vertical i longitud de costat.
 */
public class Turtle1 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("dime el numero de lineas ");
        int rows = sc.nextInt();
        System.out.println("dime el numeros de columnas");
        int columns = sc.nextInt();
        int sideLength = 50;
        int spacing = 10;
        Turtle t = new Turtle(500, 500);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cuadradito(t, sideLength);
                t.setPenDown(false);
                t.forward(sideLength + spacing);
                t.setPenDown(true);
            }
            moverme(t,sideLength, spacing, columns);

        }

        t.show();
        sc.close();
    }

    public static void cuadradito(Turtle t, int lados) {
        for (int i = 0; i < 4; i++) {
            t.forward(lados);
            t.turnRight(90);
        }
    }
    public static void moverme(Turtle t, int sideLength, int spacing, int columns){
        t.setPenDown(false);
        t.turnRight(90);
        t.forward(sideLength + spacing);
        t.turnRight(90);
        t.forward(columns * (sideLength + spacing));
        t.turnRight(180);
        t.setPenDown(true);
    }
}
