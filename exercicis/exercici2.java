import java.util.Scanner;
/*2- Fes un programa que calculi l’àrea d’un triangle. A = (base * altura) / 2 */
public class exercici2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Demanar la base i l'altura del triangle
        System.out.print("Introdueix la base del triangle: ");
        double base = sc.nextDouble();
        
        System.out.print("Introdueix l'altura del triangle: ");
        double altura = sc.nextDouble();

        // Calcular l'àrea del triangle
        double area = (base * altura) / 2;

        // Mostrar el resultat
        System.out.println("L'àrea del triangle és: " + area);

        sc.close();
    }
}
