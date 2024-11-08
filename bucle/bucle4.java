import java.util.Scanner;
/*
Exercici 4: Dibuixar un triangle d'asteriscs amb for
Escriu un programa que imprimeixi un triangle d'asteriscs de n files (sent n un número
introduït per l'usuari). Per exemple, si l'usuari introdueix 4, el programa ha de mostrar:
*
**
***
****
 */
public class bucle4 {
    public static void main(String arg []){
        Scanner sc = new Scanner(System.in);
        System.out.println("dame un numero y te hare una piramide con una cantidad de  filas igual que el numero que me des");
        int a = sc.nextInt();;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
