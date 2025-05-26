package bidimensional;

public class ejercicio4 {
    public static void main(String[] args) {
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
        int[][] reversa = new int[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                reversa[j][i] = matriz[i][j];
            }
        }
        for (int i = 0; i < reversa.length; i++) {
            for (int j = 0; j < reversa[0].length; j++) {
                System.out.print(reversa[i][j] + " ");
            }
            System.out.println();
        }
    }
}
