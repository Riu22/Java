/*
7- Escriu una classe anomenada «Baralla» que conté un joc complet de cartes (espanyoles).
 */

import java.util.ArrayList;
import java.util.Collections;

public class clase7 {

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
            return numero + " de " + coll;
        }
    }

    static class Baralla {
        private ArrayList<Carta> cartes;

        public Baralla() {
            cartes = new ArrayList<>();

            String[] colls = {"oros", "copes", "espases", "bastos"};
            for (String coll : colls) {
                for (int numero = 1; numero <= 12; numero++) {
                    if (numero != 8 && numero != 9) {
                        cartes.add(new Carta(coll, numero));
                    }
                }
            }
        }

        public void barrejar() {
            Collections.shuffle(cartes);
        }

        public void mostrar() {
            for (Carta carta : cartes) {
                System.out.println(carta);
            }
        }
    }

    public static void main(String[] args) {
        Baralla baralla = new Baralla();

        System.out.println("Cartes abans de barrejar:");
        baralla.mostrar();

        baralla.barrejar();

        System.out.println("\nCartes després de barrejar:");
        baralla.mostrar();
    }
}
