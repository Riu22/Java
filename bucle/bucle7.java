import java.util.Scanner;
/*Exercici 7: Nombre de termes per superar un valor amb do...while
Crea un programa que sumi termes consecutius (1, 2, 3,...) fins que la suma superi un
valor S introduït per l'usuari. Utilitza un bucle do...while per calcular quants termes van
ser necessaris per superar S. */
public class bucle7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un valor S: ");
        int S = sc.nextInt();  
        int sum = 0;           
        int count = 0;        
        do {
            count++;           
            sum += count;      
        } while (sum <= S);    
        System.out.println("Se necesitan " + count + " termes para superar " + S);
        sc.close();  
    }
}
