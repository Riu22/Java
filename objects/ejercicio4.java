package objects;

abstract class empleado{
    String nombre;
    double salarioBase;
    void imprimir(){
        System.out.println(nombre);
        System.out.println("SalarioBase" +salarioBase);
    }
}

class gerente extends empleado{
    double BonoGerente;

    gerente(String nombre, double salarioBase, double BonoGerente){
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.BonoGerente = BonoGerente;
    }
    void imprimir(){
         double salarioTotal = salarioBase + BonoGerente;
        System.out.println(nombre);
        System.out.println("SalarioBase " +salarioBase);
        System.out.println("BonoGerente " +BonoGerente);
        System.out.println("Salario TOtal " +salarioTotal);
    }


}

class programador extends empleado{
    int horasExtra;
    double pagoExtra;

    programador(String nombre, double salarioBase, int horasExtra, double pagoExtra){
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.horasExtra = horasExtra;
        this.pagoExtra = pagoExtra;
    }
    void imprimir(){
        double salarioTotal = salarioBase + (horasExtra*pagoExtra);
        System.out.println(nombre);
        System.out.println("SalarioBase " +salarioBase);
        System.out.println("HorasExtra " +horasExtra);
        System.out.println("PagoExtra " +pagoExtra);
        System.out.println("Salario TOtal " +salarioTotal);
    }
}
public class ejercicio4 {
    public static void main(String[] args) {
        gerente g = new gerente("Gerente", 100.0, 50);
        g.imprimir();

        programador p = new programador("Programador", 100.0, 50, 100);
        p.imprimir();
    }
}
