import java.util.Scanner;
/*Exercici 5: Números primers en un rang amb for
Crea un programa que mostri tots els números primers entre 1 i n, on n és un número
introduït per l'usuari. Utilitza un bucle for per realitzar-ho. */
public class bucle5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        int n = scanner.nextInt();
        System.out.println("Los primeros " + n + " los numeros primeros son");
        for (int numero = 2, primersTrobats = 0; primersTrobats < n; numero++) {
            boolean esPrimer = true;
            for (int j = 2; j < numero; j++) {
                if (numero % j == 0) {
                    esPrimer = false;
                    break;
                }
            }
            if (esPrimer) {
                System.out.print(numero + " ");
                primersTrobats++;  
            }
        }
        scanner.close();
    }
}
