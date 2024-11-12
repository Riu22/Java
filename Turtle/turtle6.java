import java.util.Scanner;
/*
 6- Dibuixa el següent gràfic. Paràmetres: nombre de voltes de l'espiral i número de costats del
polígon de base.
*/
public class turtle6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dime el numero de vueltas que quieres que haga");
        int vueltas =sc.nextInt();       
        System.out.println("dime el numero de numero de lados que tiene que tener");
        int lados = sc.nextInt();         

        Turtle t = new Turtle(500, 500);
        t.goTo(0, 0);           

        Espiral(t, vueltas, lados);
        sc.close();
        t.show();
    }

    public static void Espiral(Turtle t, int vueltas, int lados) {
        int longitudInicial = 10;  
        int incremento = 5;        
        int angulo = 360 / lados;  

        int pasosTotales = vueltas * lados;
        int longitudActual = longitudInicial;

        for (int i = 0; i < pasosTotales; i++) {
            t.forward(longitudActual); 
            t.turnRight(angulo);       
            longitudActual += incremento;
        }
    }
}
