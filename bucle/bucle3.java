import java.util.Scanner;
/*
Exercici 3: Comptar números positius i negatius amb do...while
Escriu un programa que permeti a l'usuari introduir números fins que introdueixi un 0. El
programa ha de comptar quants d'aquests números van ser positius i quants negatius
utilitzant un bucle do...while.
 */
public class bucle3 {
    public static void main(String arg []){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame numeros pero que no sean cero y al final cuando pongas un cero te dire cuantos numeros son negativos y cuantos positivos");
        int number= sc.nextInt();
        int pos = 0;
        int neg = 0;
        do {
            if (number > 0){
                pos++;
            } else if (number< 0) {
               neg++;

            }
            System.out.println("Dame mas numeros");
            number = sc.nextInt();
        }while (number !=0);
        System.out.println("la cantidad de numeros positivos son "+ pos);
        System.out.println("La cantidad de numeros negativos son "+neg);
        sc.close();
    }
}
