import java.util.Scanner;
/*1- Escriu un programa que sumi, resti, divideixi i multipliqui dos números. Fes-ho dos cops: primer
amb int i després amb double */
public class exercici1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("Dame 2 numeros: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.nextLine();
        
        System.out.printf("Ahora puedes elegir entre suma (+), resta (-), multiplicacion (*) o division (/): ");
        String operacion = sc.nextLine();

        if (operacion.equals("suma") || operacion.equals("+")) {
            int resultado = a + b;
            System.out.println("Resultado: " + resultado);
        }
        else if (operacion.equals("resta") || operacion.equals("-")) {
            int resultado = a - b;
            System.out.println("Resultado: " + resultado);
        }
        else if (operacion.equals("multiplicacion") || operacion.equals("*")) {
            int resultado = a * b;
            System.out.println("Resultado: " + resultado);
        }
        else if (operacion.equals("division") || operacion.equals("/")) {
            if (b != 0) {
                int resultado = a / b;
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Error: No se puede dividir por cero.");
            }
        } 
        else {
            System.out.println("Operación no válida.");
        }

          System.out.printf("Dame 2 numeros: ");
          double a1 = sc.nextDouble();
          double b1 = sc.nextDouble();
  
          sc.nextLine();
  
          System.out.printf("Ahora puedes elegir entre suma (+), resta (-), multiplicacion (*) o division (/): ");
          String operacion1 = sc.nextLine();
  
          if (operacion1.equals("suma") || operacion.equals("+")) {
              double c1 = a1 + b1;
              System.out.println("Resultado: " + c1);
          }
          else if (operacion1.equals("resta") || operacion.equals("-")) {
              double c1 = a1 - b1;
              System.out.println("Resultado: " + c1);
          }
          else if (operacion1.equals("multiplicacion") || operacion.equals("*")) {
              double c1 = a1 * b1;
              System.out.println("Resultado: " + c1);
          }
          else if (operacion1.equals("division") || operacion.equals("/")) {
              if (b1 != 0) {
                  double c1 = a1 / b1;
                  System.out.println("Resultado: " + c1);
              } else {
                  System.out.println("Error: No se puede dividir por cero.");
              }
          } 
          else {
              System.out.println("Operación no válida.");
          }
        sc.close();
    }
}
