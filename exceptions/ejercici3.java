package exceptions;

public class ejercici3 {
    public static void main(String[] args) {
        int [] a = {1,2};
        try{
            System.out.println(a[3]);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
