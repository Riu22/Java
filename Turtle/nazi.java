public class nazi {
    public static void main(String[] args) {
        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);  // Coloca la tortuga en el centro (0, 0)

        int numeroLados = 4;  // Cuadrado (puedes cambiar el número de lados)
        int tamañoPoligono = 200;  // Tamaño de los lados del polígono

        // Dibuja la figura con el número de lados y tamaño de los triángulos
        DibujarFigura(t, numeroLados, tamañoPoligono);

        t.show();
    }

    // Método para dibujar la figura
    public static void DibujarFigura(Turtle t, int numeroLados, int tamañoPoligono) {
        int anguloPoligono = 360 / numeroLados;  // Ángulo entre los vértices del polígono

        // Dibuja el polígono y coloca triángulos en cada vértice
        for (int i = 0; i < numeroLados; i++) {
            // Dibuja el triángulo apuntando al centro
            Triangulo(t, tamañoPoligono);  
            t.turnRight(anguloPoligono);  // Gira para la siguiente esquina del polígono
        }
    }

    // Método para dibujar un triángulo con el tamaño especificado
    public static void Triangulo(Turtle t, int tamaño) {
        // La tortuga parte desde el centro y dibuja un triángulo hacia el exterior
        // Primero, la tortuga avanza hacia el vértice de un lado del polígono (base del triángulo)
        t.forward(tamaño);  // Dibuja un lado del triángulo (base)

        // Luego, gira para que la punta del triángulo apunte al centro
        t.turnRight(180);  // Gira 180 grados para ir hacia el centro
        t.forward(tamaño);  // Dibuja la línea de vuelta al centro

        // Ahora, gira para formar el siguiente lado del triángulo
        t.turnLeft(180 - 360 / 4);  // Este cálculo asegura que la tortuga se posicione correctamente
        t.forward(tamaño);  // Dibuja el siguiente lado del triángulo

        t.turnLeft(180 - 360 / 4);  // Gira para completar el triángulo
        t.forward(tamaño);  // Dibuja el último lado, cerrando el triángulo
    }
}
