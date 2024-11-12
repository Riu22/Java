import java.util.Scanner;
/*
2- Dibuixa el següent gràfic. Paràmetres: número d'escalons, píxels totals en vertical i píxels totals
en horitzontal.
 */
public class turtle2 {
    public static void main(String arg[]){
        Turtle t = new Turtle(500, 500);
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame cuantos escalones tengo que hacer");
        int veces = sc.nextInt();
        int x = 25;
        int y = 90;

        t.turnRight(y);
        escalones(t,x,y,veces);
        subir(t,x,y,veces);
        t.forward(x);

        t.show();
        sc.close();
    }
    public static void escalones(Turtle t,int x, int y, int veces){
        for (int i = 0; i < veces; i++) {
            t.forward(x);
            t.turnRight(y);
            t.forward(x);
            t.turnLeft(y);
        }
    }
    public static void subir(Turtle t, int x,int y, int veces){
        for (int i = 0; i < veces; i++) {
            t.forward(x);
            t.turnLeft(y);
            t.forward(x);
            t.turnRight(y);

        }
    }
}
