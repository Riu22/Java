package contenidor;
import java.util.ArrayList;
import java.util.List;

class animal{}
class dog extends animal{
    String name;
    dog(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                '}' ;
    }
}

class cat extends animal{
    String name;
    cat(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "cat{" +
                "name='" + name + '\'' +
                '}' ;
    }
}

public class exercici7 {

    public static void main(String[] args) {
        List<animal> lista = new ArrayList<animal>();
        lista.add(new dog("Bob"));
        lista.add(new cat("Bab"));
    }

}
