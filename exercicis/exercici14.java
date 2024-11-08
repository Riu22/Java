import java.util.Scanner;

/*14- Fes un programa que calculi la divisió de dos números tipus double i el resultat ho posi en una
variable de tipus int */
public class exercici14 {
    public static void main(String[]arg){
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame 2 numeros con decimales");
        double a = sc.nextDouble();
        System.out.println("Dame el segundo numero para dividir");
        double b = sc.nextDouble();
        int c = (int) a / (int) b;
        System.out.println(c);
        sc.close();
    }
}
