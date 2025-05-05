package exceptions;

import java.util.ArrayList;
import java.util.List;

class FueraDeIndex extends Exception {
    public FueraDeIndex(String mensaje) {
        super(mensaje);
    }
}

class EmmagatzemarNumeros {
    private List<Integer> numeros = new ArrayList<>();

    public void add(int num) throws FueraDeIndex {
        if (numeros.size() >= 5) {
            throw new FueraDeIndex("No es poden afegir més de 5 números.");
        }
        numeros.add(num);
    }

    public List<Integer> getNumeros() {
        return numeros;
    }
}

public class ejercici10 {
    public static void main(String[] args) {
        EmmagatzemarNumeros caixa = new EmmagatzemarNumeros();

        try {
            for (int i = 1; i <= 6; i++) {
                caixa.add(i);
                System.out.println("Afegit: " + i);
            }
        } catch (FueraDeIndex e) {
            System.out.println("Excepció capturada: " + e.getMessage());
        }
    }
}
