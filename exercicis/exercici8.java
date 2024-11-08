import java.util.Scanner;
/*8- Escriu un programa que multipliqui per 9 un número emprant només l’operació de desplaçament
i l’operació de suma. */
public class exercici8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero y lo multiplicare por 9 con las operaciones de bits");
        int a = sc.nextInt();
        int b = a;
        int c = a << 3;
        c = c + b;
        System.out.println(c);
        sc.close();
    }
}
