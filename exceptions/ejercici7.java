package exceptions;

import java.util.Scanner;

class exceptions1 extends Exception{}
class exceptions2 extends Exception{}
class exceptions3 extends Exception{}

public class ejercici7 {
    public static void main(String[] args) {
        try {
         funcion();
        }catch(Exception e) {
            if(e instanceof exceptions1){
                System.out.println("1 exception");
            }
            if(e instanceof exceptions2){
                System.out.println("2 exception");
            }
            if(e instanceof exceptions3){
                System.out.println("3 exception");
            }
        }
    }
    static void funcion() throws exceptions1,exceptions2,exceptions3 {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el valor de la posicion: ");
        int x = sc.nextInt();
        switch(x){
            case 1:
                throw new exceptions1();
                case 2:
                    throw new exceptions2();
                    case 3:
                        throw new exceptions3();
        }
    }
}
