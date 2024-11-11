import java.util.Scanner;

public class turtle9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el número de lados del polígono: ");
        int numeroLados = scanner.nextInt();
        System.out.print("Introduce el tamaño del polígono (radio): ");
        int tamañoFigura = scanner.nextInt();
        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);  
        DibujarFigura(t, numeroLados, tamañoFigura);
        t.show();  
        scanner.close();  
    }

    public static void DibujarFigura(Turtle t, int numeroLados, int tamañoFigura) {
        int anguloPoligono = 360 / numeroLados;  
        int tamañoTriangulo = CalcularTamañoTriangulo(tamañoFigura, numeroLados);
        for (int i = 0; i < numeroLados; i++) {
            t.turnRight(anguloPoligono / 2);  
            Triangulo(t, tamañoTriangulo); 
            t.turnRight(anguloPoligono / 2); 
        }
    }
    public static int CalcularTamañoTriangulo(int tamañoFigura, int numeroLados) {
        double ladoPoligono = 2 * tamañoFigura * Math.sin(Math.PI / numeroLados);
        return (int) Math.round(ladoPoligono);  
    }
    public static void Triangulo(Turtle t, int tamaño) {
        for (int i = 0; i < 3; i++) {
            t.forward(tamaño);  
            t.turnRight(120);  
        }
    }
}
