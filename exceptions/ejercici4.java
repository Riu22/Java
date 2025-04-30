package exceptions;
class prova_exceptions extends Exception{
    String msg;
    prova_exceptions(String msg){
        this.msg=msg;
    }
    void getmsg(){
        System.out.println(msg);
    }
}
public class ejercici4 {
    public static void main(String[] args) {
        try{
            throw new  prova_exceptions("hola");
        }catch(prova_exceptions e){
            e.getmsg();
        }
    }
}
