package objects;
//polimorfismo
import java.util.Scanner;

interface autenticable{
    boolean autenticar(String usuario, String contrasena);
}
abstract class MetodoPago{
    double saldoDisponible;
    String Titular;

    MetodoPago(String Titular,double saldoDisponible){
        this.Titular=Titular;
        this.saldoDisponible=saldoDisponible;
    }

    abstract boolean realizarPago(double monto);

}
class TarjetaCredito extends MetodoPago implements autenticable{
    String usuario;
    String contrasena;
    double limiteCredito;

    TarjetaCredito(String usuario, String contrasena, double limiteCredito, String Titular, double saldoInicial){
        super(Titular, saldoInicial);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.limiteCredito = limiteCredito;
    }

    public boolean autenticar(String usuario, String contrasena){
        if(this.usuario.equals(usuario) && this.contrasena.equals(contrasena)){
            return true;
        }else {return false;}
    }

    @Override
    boolean realizarPago(double monto) {
        if(monto<=saldoDisponible + limiteCredito){
            saldoDisponible-=monto;
            System.out.println("Pago de $" + monto + " realizado con éxito. Saldo disponible: $" + saldoDisponible);
            return true;
        }else {
            System.out.println("No hay dinero para realizar el pago");
            return false;}
    }
    public String getTitular() {
        return Titular;
    }
}
public class ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del titular: ");
        String titular = sc.nextLine();

        System.out.print("Ingrese usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Ingrese contraseña: ");
        String contrasena = sc.nextLine();

        System.out.print("Ingrese saldo inicial: ");
        double saldoInicial = sc.nextDouble();

        System.out.print("Ingrese límite de crédito: ");
        double limiteCredito = sc.nextDouble();

        TarjetaCredito tarjeta = new TarjetaCredito(usuario, contrasena, limiteCredito, titular, saldoInicial);

        System.out.print("Ingrese usuario para autenticación: ");
        String usuarioIngresado = sc.next();

        System.out.print("Ingrese contraseña: ");
        String contrasenaIngresada = sc.next();

        if (tarjeta.autenticar(usuarioIngresado, contrasenaIngresada)) {
            System.out.println("Autenticación exitosa.");

            // Intentar realizar un pago
            System.out.print("Ingrese el monto a pagar: ");
            double monto = sc.nextDouble();

            tarjeta.realizarPago(monto);
        } else {
            System.out.println("Autenticación fallida. No se puede realizar el pago.");
        }

        sc.close();
    }
}
