import java.util.Scanner;
/*Escriu un programa que generi una piràmide de números com la següent, on n és el nombre
de files (introduït per l'usuari):
1
22
333
4444
...
nnnnn...n (n vegades)

Cada fila i ha de contenir el número i repetit i vegades. Utilitza un bucle for per
aconseguir-ho. */
public class bucle10 {
    public static void main(String arg []){
        Scanner sc = new Scanner(System.in);
        System.out.println("dame un numero y te hare una piramide con una cantidad de  filas igual que el numero que me des");
        int a = sc.nextInt();;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <i ; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
        sc.close();
    }
}
