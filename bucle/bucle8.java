import java.util.Scanner;
/*Exercici 8: Imprimir números en ordre invers amb for
Escriu un programa que demani un número n i després imprimeixi els números des de n fins
a 1 en ordre invers utilitzant un bucle for. */
public class bucle8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un numero y hare la cuenta atras");
        int user = sc.nextInt();
        int count = user;
        for (int i = 0; i <= user; i++) {
            System.out.println(count);
            count--;
        }
        sc.close();
    }
}
