import java.util.Scanner;
public class pruebas {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); //en esta linea lo que se hace es declarar una variable que es sc para que actue como un escaner del sistema ATENTO QUE PUEDE SER QUE INTENTES HACERLO CON SCANNER PERO EL SC AHORA ES EL SCANNER//q1
        
        System.out.println("Dime cuantos numeros quieres que vaya sumando" );
        int number = sc.nextInt();
                int num = 0;
                int suma = 0;  // Variable para acumular la suma de los números
        
                // Bucle que suma números correlativos desde 1 hasta 'number'
                for (int i = 1; i <= number; i++) {
                    suma = suma + suma;  // Acumular el valor de i en cada vuelta
                    System.out.println( suma);
                    suma++;
                }
        
        sc.close();
    }
}
