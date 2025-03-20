package objects;

interface dispositivo{
    void encender();
    void apagar();
    boolean estaEncendido();
}

class Telefono implements dispositivo{
    String numero;
    boolean encendido;

    Telefono(String numero){
        this.numero = numero;
    }

    @Override
    public void encender() {
        encendido = true;
    }

    public void apagar(){
        encendido = false;
    }
    public boolean estaEncendido(){
      return encendido;
    }
    void imprimir(){
        System.out.println(numero);
        System.out.println("Estado" +(estaEncendido() ? " Encencdido" : " Apagado"));
    }
}

public class ejercicio2 {
    public static void main(String[] args) {
        Telefono t1 = new Telefono("123");
        t1.encender();
        t1.imprimir();
        t1.estaEncendido();
    }
}
