package exceptions;

import java.util.Scanner;

public class ejercici2 {
    public static void main(String[] args) {
        try {
            Scanner sc = null;
            sc.nextLine();
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
