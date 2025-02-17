/*
2- Realitza una classe anomenada «Peix», que tingui una variable membre anomenada «nom». Fes
un mètode «setNom(String nom)» i un mètode «getNom()» (que retorna el nom del peix).
Implementa un constructor «còpia», que a partir d'un objecte «Peix» generi un nou objecte «Peix».
Implementa el mètode «public boolean equals(Peix p)» per poder comparar objectes «Peix» i
comprova que funciona correctament. Finalment, a la classe, implementa una variable «count» que
compti quants de peixos hem creat.
 */

package Clases;
import java.util.ArrayList;
import java.util.Scanner;

class Peix{
    private String nom;
    private static int count = 0;

    public Peix(){
        this.nom = "";
        count++;
    }

    public Peix(String nom){
        this.nom = nom;
        count++;
    }

    public Peix(Peix p){
        this.nom = p.nom;
        count++;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public boolean equals(Peix p) {
        if (p == null) return false;
        return this.nom.equals(p.nom);
    }

    public static int getCount() {
        return count;
    }
}

public class clase2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Peix> peces = new ArrayList<>();

        System.out.print("¿Cuántos peces quieres crear?: ");
        int numPeces = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPeces; i++) {
            System.out.print("Introduce el nombre del pez " + (i + 1) + ": ");
            String nombre = sc.nextLine();
            peces.add(new Peix(nombre));
        }

        System.out.println("\nLista de peces creados:");
        for (int i = 0; i < peces.size(); i++) {
            System.out.println("Pez " + (i + 1) + ": " + peces.get(i).getNom());
        }

        if (peces.size() > 1) {
            System.out.println("\nComparaciones entre peces:");
            for (int i = 0; i < peces.size(); i++) {
                for (int j = i + 1; j < peces.size(); j++) {
                    System.out.println("Pez " + (i + 1) + " es igual a Pez " + (j + 1) + "? " + peces.get(i).equals(peces.get(j)));
                }
            }
        }

        System.out.println("\nNúmero total de peces creados: " + Peix.getCount());
    }
}
