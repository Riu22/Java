package objects;

interface animal{
    void hacerSonido();
    void moverse();
}

class perro implements animal{
    String nombre;

    perro(String nombre){
        this.nombre = nombre;
    }
    public void hacerSonido(){
        System.out.println("Guau");
    }
    public void moverse(){
        System.out.println("El perro camina");
    }

}

class gato implements animal{
    String nombre;
    gato(String nombre){
        this.nombre = nombre;
    }
    public void hacerSonido(){
        System.out.println("miau");
    }
    public void moverse(){
        System.out.println("El gato camina");
    }

}

class pez implements animal{

    String nombre;
    pez(String nombre){
        this.nombre = nombre;
    }

    public void hacerSonido(){
        System.out.println("El pez no hace sonido");
    }
    public void moverse(){
        System.out.println("El pez nada");
    }
}
public class ejercicio5 {
    public static void main(String[] args) {
        pez p = new pez("Pez");
        gato g = new gato("Gato");
        perro p1 = new perro("Perro");
        p.hacerSonido();
        p.moverse();
        p1.hacerSonido();
        p1.moverse();
        g.hacerSonido();
        g.moverse();

    }
}
