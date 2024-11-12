import java.util.Scanner;
/*
 3- Dibuixa el següent gràfic. Paràmetres: longitud de costat, nombre de quadres en horitzontal i
nombre de quadres en vertical.
 */
public class turtle3 {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("dime el numero de lineas ");
        int rows = sc.nextInt();
        System.out.println("dime el numeros de columnas");
        int columns = sc.nextInt();
        int sideLength = 50;
        Turtle t = new Turtle(500, 500);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                cuadradito(t, sideLength);
                t.forward(sideLength );
            }
            moverme(t,sideLength,  columns);
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
    public static void moverme(Turtle t, int sideLength, int columns){
        t.turnRight(90);
        t.forward(sideLength );
        t.turnRight(90);
        t.forward(columns * (sideLength ));
        t.turnRight(180);
    }
}