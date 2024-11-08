import java.util.Scanner;
/*
Exercici 2: Generar una sèrie de números utilitzant for
Crea un programa que imprimeixi els primers n números de la sèrie: 1, 4, 9, 16,
25... (és a dir, els quadrats dels números naturals), on n és un número introduït per
l'usuari. Utilitza un bucle for.
 */
public class bucle2 {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Buenas noches señor ¿Seria tan amable de darme un numero?  y yo hire haciendo el cuadrado de los numeros, el total de veces sera el numero que me de");
        int number = sc.nextInt();
        int sqrt= 0;
        for (int i = 0; i <= number; i++) {
            sqrt = i * i;
            System.out.println("el cuadrado de "+i + " es " + sqrt);
        }
        sc.close();
    }
}
