import java.util.Scanner;

public class turtle7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el número de pétalos: ");
        int numPetalos = sc.nextInt(); 
        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);  
        Flor(t, numPetalos);
        t.show();
        sc.close();
    }

    public static void Flor(Turtle t, int numPetalos) {
        int longitud = 200; 
        int angulo = 360 / numPetalos; 
        for (int i = 0; i < numPetalos; i++) {
            Petalo(t, longitud);
            t.turnRight(angulo);
        }
    }

    public static void Petalo(Turtle t, int Petalo) {
        for (int i = 0; i < 30; i++) {  
            t.forward(Petalo / 30); 
            t.turnRight(3);  
        }
        t.turnRight(120); 
        for (int i = 0; i < 30; i++) {
            t.forward(Petalo / 30);  
            t.turnRight(3);  
        }
        t.turnRight(120);  
    }
}
