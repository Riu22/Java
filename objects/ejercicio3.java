package objects;
interface conducible{
    void conducir();
}

abstract class vehiculo{
    int veloicdadMaxima;
    int velocidadActual;

    abstract void frenar();
    void acelerar(int incremento){
        if(veloicdadMaxima > velocidadActual){
        velocidadActual += incremento;}
        else {System.out.println("No se puede acelerar");}

    }
}

class auto extends vehiculo implements conducible{
    int cantidadPuertas;

    auto(int cantidadPuertas, int veloicdadMaxima, int velocidadActual){
        this.veloicdadMaxima = veloicdadMaxima;
        this.velocidadActual = velocidadActual;
        this.cantidadPuertas = cantidadPuertas;
    }

    void frenar(){
        veloicdadMaxima = 0;
    }
    public void conducir(){
        if(velocidadActual > 0){
            System.out.println("Esta en movimiento");
        }
    }
}
public class ejercicio3 {
    public static void main(String[] args) {
        auto a = new auto(4,300,100);
        a.conducir();
        while(true){
            a.acelerar(80);
        }
    }
}
