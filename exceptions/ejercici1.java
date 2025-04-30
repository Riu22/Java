package exceptions;

public class ejercici1 {
    public static void main(String[] args) {
       try{
           function();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }finally{
           System.out.println("finally");
       }
    }
    static void function() throws Exception {
        throw new Exception("HOla");

    }
}
