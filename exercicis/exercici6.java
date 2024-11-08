import java.util.Scanner;
/* 6- Escriu un programa que multipliqui per 8 un número emprant només l’operació de desplaçament
bit a bit.  */
public class exercici6 {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime un numero y lo multiplicare por desplazamiento de bit");
        int a = sc.nextInt();
        int b = a << 3;
        System.out.println(b);
        sc.close();
    }
}
