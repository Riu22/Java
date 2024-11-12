import java.util.Scanner;
/*
 5- Dibuixa el següent gràfic. Paràmetres: nombre de quadres concèntrics i longitud inicial del
quadre.
 */
public class turtle5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime cual sera el tamaño maximo del cuadrado");
        int initialSide = sc.nextInt();  
        int decrement = 10;  
        System.out.println("dime el tamaño minimo que tendra");   
        int minSide = sc.nextInt();       

        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);          

        cajas(t, initialSide, decrement, minSide);
        sc.close();
        t.show();
        
    }
    
    public static void cajas(Turtle t, int initialSide, int decrement, int minSide) {
        int currentSide = initialSide;
    
        while (currentSide >= minSide) {
            t.setPenDown(false);
            t.goTo(-currentSide / 2, -currentSide / 2); 
            t.setPenDown(true);
    
            for (int i = 0; i < 4; i++) {
                t.forward(currentSide);
                t.turnRight(90);
            }
    
            currentSide -= decrement;
        }
    }
}
    
