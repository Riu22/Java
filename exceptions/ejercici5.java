package exceptions;

public class ejercici5 {
    public static void main(String[] args) {
        int[] a = {1,2};
        int count = 10;
        while (true) {
            try{
                System.out.printf("%d ", a[count]);
                break;
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.printf("no tengo la posicion %d\n", count);
            }finally{
                count--;
            }
        }

    }
}
