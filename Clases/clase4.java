/*
4- Fes una classe anomenada «Nombre» amb les següents característiques:
• El constructor accepta un valor «int»
• El constructor accepta un «String» representant la forma «romana» del número
• Té un mètode anomenat «hex» que retorna un string amb la forma hexadecimal del número
• Té un mètode anomenat «bin» que retorna un string amb la forma binària del número.
 */

package Clases;

import java.util.Scanner;

class Nombre {
    private int valor;

    public Nombre(int valor) {
        this.valor = valor;
    }

    public Nombre(String romano) {
        this.valor = convertirRomanoANumero(romano);
    }

    public String hex() {
        return Integer.toHexString(valor).toUpperCase();
    }

    public String bin() {
        return Integer.toBinaryString(valor);
    }

    private int convertirRomanoANumero(String romano) {
        int resultado = 0;
        int anterior = 0;

        for (int i = romano.length() - 1; i >= 0; i--) {
            int valorActual = valorRomano(romano.charAt(i));

            if (valorActual < anterior) {
                resultado -= valorActual;
            } else {
                resultado += valorActual;
            }

            anterior = valorActual;
        }

        return resultado;
    }

    // Método auxiliar que asigna valores a los símbolos romanos
    private int valorRomano(char simbolo) {
        return switch (simbolo) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Símbolo romano no válido: " + simbolo);
        };
    }
}

public class clase4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese un número (puede ser en formato romano o decimal): ");
        String entrada = scanner.nextLine().trim();

        Nombre numero;
        if (esNumeroRomano(entrada)) {
            numero = new Nombre(entrada);
        } else {
            try {
                int valorDecimal = Integer.parseInt(entrada);
                numero = new Nombre(valorDecimal);
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número válido.");
                return;
            }
        }

        System.out.println("Número en hexadecimal: " + numero.hex());
        System.out.println("Número en binario: " + numero.bin());
    }
    private static boolean esNumeroRomano(String entrada) {
        return entrada.matches("^[IVXLCDM]+$");
    }
}
