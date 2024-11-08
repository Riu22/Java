import java.util.Scanner;
/*16-Fes un programa que efectui els següents càlculs, donades dues variables “a” i “b” (de tipus int:  */
public class exercici16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introdueix el valor de a: ");
        int a = sc.nextInt();
        System.out.print("Introdueix el valor de b: ");
        int b = sc.nextInt();
        int a2 = a * a;  
        int b2 = b * b;  
        int suma = a + b; 
        int resta = a - b; 
        int formula1 = resta * suma; 
        int formula2 = suma * suma; 
        int formula3 = a2 + b2; 
        int formula4 = formula2 - 2 * a * b;
        int formula5 = resta * resta; 
        int formula6 = formula2; 
        int formula7 = formula3; 
        int formula8 = (a * a * a) + (3 * a * a * b) + (3 * a * b * b) + (b * b * b); 
        int formula9 = (a * a * a) - (3 * a * a * b) + (3 * a * b * b) - (b * b * b); 
        int formula10 = (a - b) * (a2 + (a * b) + b2); 
        int formula11 = (a + b) * (a2 - (a * b) + b2); 
        int formula12 = a2 + 4 * (a * a * a) * b + 6 * (a * a * b * b) + 4 * (a * b * b * b) + (b2 * b2); 
        int formula13 = a2 - 4 * (a * a * a) * b + 6 * (a * a * b * b) - 4 * (a * b * b * b) + (b2 * b2); 
        int formula14 = (a - b) * (a + b) * (a2 + b2);
        System.out.println("a^2 - b^2 = (a - b)(a + b): " + formula1);
        System.out.println("(a + b)^2 = a^2 + 2ab + b^2: " + formula2);
        System.out.println("a^2 + b^2: " + formula3); 
        System.out.println("a^2 + b^2 = (a + b)^2 - 2ab: " + formula4);
        System.out.println("(a - b)^2 = a^2 - 2ab + b^2: " + formula5);
        System.out.println("(a + b + c)^2 = a^2 + b^2 + c^2 + 2ab + 2bc + 2ca (sense c): " + formula6);
        System.out.println("(a - b - c)^2 = a^2 + b^2 + c^2 - 2ab + 2bc - 2ca (sense c): " + formula7);
        System.out.println("(a + b)^3 = a^3 + 3a^2b + 3ab^2 + b^3: " + formula8);
        System.out.println("(a - b)^3 = a^3 - 3a^2b + 3ab^2 - b^3: " + formula9);
        System.out.println("a^3 - b^3 = (a - b)(a^2 + ab + b^2): " + formula10);
        System.out.println("a^3 + b^3 = (a + b)(a^2 - ab + b^2): " + formula11);
        System.out.println("(a + b)^4 = a^4 + 4a^3b + 6a^2b^2 + 4ab^3 + b^4: " + formula12);
        System.out.println("(a - b)^4 = a^4 - 4a^3b + 6a^2b^2 - 4ab^3 + b^4: " + formula13);
        System.out.println("a^4 - b^4 = (a - b)(a + b)(a^2 + b^2): " + formula14);
        sc.close();
    }
}
