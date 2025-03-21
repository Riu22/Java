package objects;

interface Autonomo {
    void iniciarConduccion();
    void detenerConduccion();
}

abstract class Vehiculo {
    String modelo;
    double velocidadActual;
    double velocidadMaxima;

    Vehiculo(String modelo, double velocidadMaxima) {
        this.modelo = modelo;
        this.velocidadMaxima = velocidadMaxima;
        this.velocidadActual = 0;
    }

    abstract void acelerar(int incremento);
    abstract void frenar(int decremento);

    void mostrarEstado() {
        System.out.println("Modelo: " + modelo + ", Velocidad Actual: " + velocidadActual + " km/h");
    }
}

class CocheAutonomo extends Vehiculo implements Autonomo {
    String nivelAutonomia;

    CocheAutonomo(String modelo, double velocidadMaxima, String nivelAutonomia) {
        super(modelo, velocidadMaxima);
        this.nivelAutonomia = nivelAutonomia;
    }

    @Override
    void acelerar(int incremento) {
        if (velocidadActual + incremento > velocidadMaxima) {
            System.out.println("⚠ No se puede superar la velocidad máxima de " + velocidadMaxima + " km/h.");
        } else {
            velocidadActual += incremento;
            System.out.println("🚗 Acelerando... Velocidad actual: " + velocidadActual + " km/h");
        }
    }

    @Override
    void frenar(int decremento) {
        if (velocidadActual - decremento < 0) {
            velocidadActual = 0;
            System.out.println("🛑 El coche se ha detenido por completo.");
        } else {
            velocidadActual -= decremento;
            System.out.println("🛑 Frenando... Velocidad actual: " + velocidadActual + " km/h");
        }
    }

    @Override
    public void iniciarConduccion() {
        System.out.println("🚗 El coche autónomo ha iniciado la conducción en modo " + nivelAutonomia + ".");
    }

    @Override
    public void detenerConduccion() {
        System.out.println("🚗 El coche autónomo ha detenido la conducción.");
    }
}

public class ejercicio8 {
    public static void main(String[] args) {
        CocheAutonomo coche = new CocheAutonomo("Tesla Model X", 200, "Nivel 5");

        coche.iniciarConduccion();
        coche.acelerar(50);
        coche.acelerar(100);
        coche.frenar(30);
        coche.acelerar(70);
        coche.frenar(200);
        coche.detenerConduccion();
    }
}
