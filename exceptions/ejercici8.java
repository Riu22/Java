package exceptions;

public class ejercici8 {
    public static void main(String[] args) {
    try {
        f();
    }catch(Exception e) {
        System.out.println(e);
    }
    }
    static void f() throws Exception{
    try{
        g();
    }catch(Exception e){
        throw new exceptions3();
    }
    }
    static void g() throws Exception{
        throw new prova_exceptions("hola");
    }
}
