import java.util.Scanner;

public class turtle9 {
    public static void main(String[] args) {
        // Crear objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario el número de lados y el tamaño del polígono
        System.out.print("Introduce el número de lados del polígono: ");
        int numeroLados = scanner.nextInt();

        System.out.print("Introduce el tamaño del polígono (radio): ");
        int tamañoFigura = scanner.nextInt();

        // Crear la tortuga
        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);  // Coloca la tortuga en el centro

        // Dibuja la figura con el número de lados y tamaño proporcionado por el usuario
        DibujarFigura(t, numeroLados, tamañoFigura);

        t.show();  // Muestra la tortuga

        scanner.close();  // Cierra el scanner
    }

    // Método para dibujar la figura
    public static void DibujarFigura(Turtle t, int numeroLados, int tamañoFigura) {
        int anguloPoligono = 360 / numeroLados;  // Ángulo entre los vértices del polígono

        // Calculamos el tamaño de los triángulos (dependiendo del tamaño de cada lado del polígono)
        int tamañoTriangulo = CalcularTamañoTriangulo(tamañoFigura, numeroLados);

        // Dibuja los triángulos en cada vértice del polígono
        for (int i = 0; i < numeroLados; i++) {
            // Gira la tortuga para que el triángulo apunte al centro
            t.turnRight(anguloPoligono / 2);  // Gira la tortuga a la mitad del ángulo
            Triangulo(t, tamañoTriangulo);  // Dibuja el triángulo
            t.turnRight(anguloPoligono / 2);  // Gira de nuevo para continuar al siguiente triángulo
        }
    }

    // Método para calcular el tamaño del triángulo
    public static int CalcularTamañoTriangulo(int tamañoFigura, int numeroLados) {
        // Calculamos el tamaño de la base del triángulo usando la fórmula del lado de un polígono inscrito en un círculo
        double ladoPoligono = 2 * tamañoFigura * Math.sin(Math.PI / numeroLados);
        return (int) Math.round(ladoPoligono);  // Redondeamos al número entero más cercano
    }

    // Método para dibujar un triángulo con el tamaño especificado
    public static void Triangulo(Turtle t, int tamaño) {
        // Dibuja el triángulo apuntando hacia el centro
        for (int i = 0; i < 3; i++) {
            t.forward(tamaño);  // Dibuja un lado del triángulo
            t.turnRight(120);  // Gira 120 grados para el siguiente lado del triángulo
        }
    }
}
