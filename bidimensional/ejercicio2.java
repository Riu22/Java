package bidimensional;

public class ejercicio2 {
    public static void main(String[] args) {
        int[][] matriz = new int[2][2];
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[1][0] = 3;
        matriz[1][1] = 4;
        int resultado = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                resultado += matriz[i][j];
            }
        }
        System.out.println(resultado);
    }
}
