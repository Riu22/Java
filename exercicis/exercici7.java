import java.util.Scanner;
/*7- Escriu un programa que divideixi un número per 2 només emprant l’operació de desplaçament
bit a bit. */
public class exercici7 {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero y lo multiplicare por desplazamiento de bit");
        int a = sc.nextInt();
        int b = a >> 1;
        System.out.println(b);
        sc.close();
    }
}
