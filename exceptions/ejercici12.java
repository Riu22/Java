package exceptions;

public class ejercici12 {
    public static void main(String[] args) {
        try {
            try {
                System.out.println("Dins del try intern");
                throw new Exception("Excepció llençada al try intern");
            } finally {
                System.out.println("Bloc finally intern executat");
            }
        } catch (Exception e) {
            System.out.println("Excepció capturada al catch extern: " + e.getMessage());
        } finally {
            System.out.println("Bloc finally extern executat");
        }
    }
}
