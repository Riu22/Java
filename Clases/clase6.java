/*
6- Escriu una classe anomenada «Carta» per representar una carta (naip). Cada carta té dues
 */

import java.util.Scanner;

public class clase6 {

    static class Carta {

        private String coll;
        private int numero;

        public Carta(String coll, int numero) {
            if (numero < 1 || numero > 12) {
                throw new IllegalArgumentException("El número ha de ser entre 1 i 12.");
            }
            if (!(coll.equals("oros") || coll.equals("copes") || coll.equals("espases") || coll.equals("bastos"))) {
                throw new IllegalArgumentException("Coll no vàlid. Ha de ser 'oros', 'copes', 'espases' o 'bastos'.");
            }

            this.coll = coll;
            this.numero = numero;
        }

        public String getColl() {
            return coll;
        }

        public int getNumero() {
            return numero;
        }

        public String toString() {
            return "Carta: " + numero + " de " + coll;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quantes cartes vols introduir?");
        int numCartes = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCartes; i++) {
            System.out.println("\nIntrodueix les dades de la carta " + (i + 1) + ":");

            System.out.print("Coll (oros, copes, espases, bastos): ");
            String coll = scanner.nextLine().trim();

            System.out.print("Número (1-12): ");
            int numero = scanner.nextInt();
            scanner.nextLine();

            try {
                Carta carta = new Carta(coll, numero);
                System.out.println(carta);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
