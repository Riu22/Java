/*10- Escriu un programa que declari tres variables: a, b i c, amb valors 111, 444, i 8888
respectivament. Efectua a xor b i després el resultat d’aquesta operació xor a. */
public class exercici10 {
    public static void main(String[]arg){
        int a = 111;
        int b = 444;
        int c = 8888;
        a = a ^ b;
        c = c ^ a;
        System.out.println(c);
    }
    
}
