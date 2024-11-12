/*
 8- Dibuixa el següent gràfic.
 */

public class turtle8{
    public static void main(String[] args) {
        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0); 
        Templario(t);
        t.show();
    }
    public static void Templario(Turtle t) {
        int tamañoTriangulo = 100; 
        for (int i = 0; i < 4; i++) {
            Triangulo(t, tamañoTriangulo);
            t.turnRight(90);  
        }
    }
    public static void Triangulo(Turtle t, int tamaño) {
        for (int i = 0; i < 3; i++) {
            t.forward(tamaño);  
            t.turnRight(120);  
        }
    }
}
