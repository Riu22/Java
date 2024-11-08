import java.util.Scanner;
/*Escriu un programa que permeti a l'usuari introduir n qualificacions i calculi la mitjana de
totes elles. L'entrada de qualificacions finalitza quan l'usuari introdueix un número negatiu.
Utilitza un bucle while per a aquest exercici. */
public class bucle6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int suma = 0;
        int count = 0;
        System.out.println("Introduce las qualificaciones hasta que metas un numero negativo asi acabara");
        while (true) {
            System.out.print("qualificacion: ");
            int qualificacio = scanner.nextInt();
            if (qualificacio < 0) { 
                break;
            }
            suma += qualificacio;  
            count++;               
        }
        if (count > 0) {
            double mitjana = (double) suma / count;
            System.out.println("La mediana es: " + mitjana);
        } else {
            System.out.println("no introduiste ningun numero");
        }
        
        scanner.close();
    }

   
}


