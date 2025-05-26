package bidimensional;

import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = new int[3][3];
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[0][2] = 3;
        matriz[1][0] = 4;
        matriz[1][1] = 5;
        matriz[1][2] = 6;
        matriz[2][0] = 7;
        matriz[2][1] = 8;
        matriz[2][2] = 9;
        System.out.println("dime un numero del 1 al 9");
        int numero = sc.nextInt();

        for (int i = 0 ; i < matriz.length ; i++) {
            for (int j = 0; j < matriz[i].length ; j++) {
                if (numero == matriz[i][j]) {
                    System.out.println("encontre " + numero + " en la posicion " + matriz[i][j]);
                }
            }
        }

    }
}
