/*
1- Implementa una classe anomenada «QuadratMagic» que tingui un mètode «void imprimeix(int
n)» que mostri el quadrat següent (segons la dimensió que passem com a paràmetre):
1 1 1 1 1
1 2 3 4 5
1 3 6 10 15
1 4 10 20 35
1 5 15 35 70
etc...
 */

package Clases;
import java.util.Scanner;

class QuadratMagic {


    QuadratMagic(int n) {
    }

    void imprimeix(int n) {
        int[][] quadrat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    quadrat[i][j] = 1;
                } else {
                    quadrat[i][j] = quadrat[i - 1][j] + quadrat[i][j - 1];
                }
            }
        }

        int maxNum = quadrat[n - 1][n - 1];
        int width = Integer.toString(maxNum).length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%" + width + "d ", quadrat[i][j]);
            }
            System.out.println();
        }
    }
}

public class Clases1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quan grande quieres el cuadrado?: ");
        int n = sc.nextInt();

        QuadratMagic cuadrado = new QuadratMagic(n);

        cuadrado.imprimeix(n);
    }
}
