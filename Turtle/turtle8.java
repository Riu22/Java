public class turtle8{
    public static void main(String[] args) {
        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);  // Coloca la tortuga en el centro

        // Dibuja el símbolo templario
        Templario(t);

        t.show();
    }

    public static void Templario(Turtle t) {
        int tamañoTriangulo = 100; // Tamaño de los triángulos

        // Dibuja los 4 triángulos
        for (int i = 0; i < 4; i++) {
            Triangulo(t, tamañoTriangulo);
            t.turnRight(90);  // Gira 90 grados para dibujar el siguiente triángulo
        }
    }

    public static void Triangulo(Turtle t, int tamaño) {
        // Dibuja un triángulo apuntando hacia el centro
        for (int i = 0; i < 3; i++) {
            t.forward(tamaño);  // Dibuja un lado del triángulo
            t.turnRight(120);  // Gira 120 grados para el siguiente lado
        }
    }
}
