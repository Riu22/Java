import java.util.Scanner;;
/*Exercici 9: Seqüència de Collatz amb while
Escriu un programa que demani un número a l'usuari i generi la seqüència de Collatz. La
seqüència de Collatz es defineix així:
● Si el número és parell, es divideix entre 2.
● Si és senar, es multiplica per 3 i se suma 1. El bucle continua fins que el número
sigui 1. Utilitza un bucle while per a aquest exercici. */
public class bucle9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Dame un nuemro para hacer una secuencia de collatz: ");
        int numero = sc.nextInt();
        
        System.out.print("Secuencia: " + numero);
    
        while (numero != 1) {
            if (numero % 2 == 0) {
                numero = numero / 2;  
            } else {
                numero = numero * 3 + 1;  
            }
            System.out.print(" -> " + numero);  
        }
        
        sc.close();
    }
}
