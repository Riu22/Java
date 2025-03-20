package objects;

abstract class Figura{
    String nombre;
    abstract double calcularArea();
    abstract double calcularPerimetro();
    void imprimir(){
        System.out.println("Figura: " + nombre);
        System.out.println("Área: " + calcularArea());
        System.out.println("Perímetro: " + calcularPerimetro());
        System.out.println("-----------------------");    };
}

class circulo extends Figura{
    double radio;

    circulo(double radio){
        this.radio=radio;
        this.nombre = "circulo";
    };

    @Override
    double calcularArea() {
       double pi = 3.14;
       radio = radio*radio;
       return pi*radio;
    }

    @Override
    double calcularPerimetro() {
        double pi = 3.14;
        return 2*pi*radio;
    }
}

class rectangulo extends Figura{
    double altura;
    double base;

    rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
        this.nombre = "Rectángulo";
    }
    @Override
    double calcularArea() {
        return base*altura;
    }

    @Override
    double calcularPerimetro() {

        double baseAltura = base+altura;
        return baseAltura*2;
    }
}
public class ejercicio1 {

    public static void main(String[] args) {
        circulo c1 = new circulo(2);
        rectangulo r1 = new rectangulo(2,5);
        c1.imprimir();
        r1.imprimir();
    }
}

