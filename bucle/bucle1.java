import java.util.Scanner;
/*
Exercici 1: Sumar les xifres d'un número utilitzant while
Escriu un programa que demani un número a l'usuari i sumi totes les seves xifres utilitzant
un bucle while. Per exemple, si l'usuari introdueix 123, el programa ha de retornar 6 (1 + 2
+ 3).
 */
public class bucle1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un número para sumar sus cifras:");
        int usuario = sc.nextInt();
        int divisor = 1000000;
        int suma = 0;
        int residuo= 0;
        while (usuario != 0) {
            residuo = usuario % divisor;
            usuario = usuario / divisor;
            suma = suma + usuario;
            usuario = residuo;
            divisor = divisor / 10;
        }
        System.out.println("La suma de las cifras es: " + suma);
        sc.close();
    }
}
