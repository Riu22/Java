import java.util.Scanner;
/* 5- Escriu un programa que, donat un número (int) canvii tots els seus bits (els 0 per 1 i els 1 per 0).  */

public class exercici5 {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Buenas tardes, ¿sería tan amable de darme un número y se lo diré en binario y haré un XOR?");
        int a = sc.nextInt();
        System.out.println("Di cuantos bits quiere que tenga el resultado");
        int ceros = sc.nextInt();
    
        String binario = Integer.toBinaryString(a);

        int b = binario.length();
        
        while (b > ceros) {
            ceros++;
            System.out.println("El número en binario tiene solo " + b + " ahora lo incremento");

            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Perdon pero  dejo de funcionar el programa");
            }
        }
        

        int mascara = (1 << b) - 1; 
        
        int Xor = a ^ mascara; 
        
        String Xor_like = String.format("%" + ceros + "s", Integer.toBinaryString(Xor)).replace(' ', '0');

        System.out.println("El número en binario es: " + binario);

        System.out.println("El resultado de hacer XOR es: " + Xor_like);
        System.out.println("El número resultante en decimal es: " + Xor);

        sc.close(); 
    }
}
