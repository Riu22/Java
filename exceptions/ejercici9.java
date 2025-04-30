package exceptions;
class prova_Runtime extends RuntimeException{}
class runtime extends RuntimeException {}
public class ejercici9 {
    public static void main(String[] args) {
        try {
            f();
        }catch(runtime e) {
            System.out.println(e);
        }
    }
    static void f(){
        try{
            g();
        }catch(prova_Runtime e){
            throw new runtime();
        }
    }
    static void g(){
        throw new prova_Runtime();
    }
}
