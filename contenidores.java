import java.util.*;


public class contenidores {
    public static void main(String[] args) {
        System.out.println("--- LListes1 ---");
        llistes1();
        System.out.println("--- Iterators ---");
        // iterators();
        System.out.println("--- Cua ---");
        //cues();
        System.out.println("--- Piles ---");
        //piles();
        System.out.println("--- Conjunts ---");
        //conjunts();
        System.out.println("--- Mapes ---");
        // mapes();

    }

    static void llistes1() {
        // Crea llista d'enters anomenada "l1"
        List<Integer> l1 = new ArrayList<>();

        // Afegeix els números 10, 20 i 15
        l1.add(10);
        l1.add(20);
        l1.add(15);

        // Imprimeix la llista
        for (Integer i : l1) {
            System.out.println(i);
        }

        // Elimina el segon element
        l1.remove(1);

        // Imprimeix la llista
        for (Integer i : l1) {
            System.out.println(i);
        }

        // Crea llista d'enters anomenada "l2"
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(6);
        l2.add(9);

        // Afegeix la llista l1 a la llista l2
        l2.addAll(l1);
        // Imprimeix la llista l2
        for (Integer i : l2) {
            System.out.println(i);
        }

        // Elimina tots els valors de l1
        l1.clear();

        // Afegeix els tres primers elements de l2 a l1
        for (int i = 0; i < 2; i++) {
            l1.add(l2.get(i));
        }

        // Comprova si dins l1 hi ha el número 6
        if (l1.contains(6)) {
            System.out.println("El elemento contiene");
        } else {
            System.out.println("El elemento no existe");
        }

        // Afegeix el numero 6 un altre cop a l1 al principi de la llista
        l1.add(0, 6);
        // Cerca la posicio de l'element que te el numero 9 a la llista l1
        int index = l1.indexOf(9);
        System.out.println(index);
        // A l1, substitueix l'element a la posició 1 per el valor 5
        l1.set(0, 5);
        // A l1, insereix a la posició 2 l'element 4
        l1.set(1, 4);
        // Imprimeix la llista l1
        for (Integer i : l1) {
            System.out.println(i);
        }

        // Converteix l1 a array i imprimeix-ho
        int[] array = new int[l1.size()];
        for (int i = 0; i < l1.size(); i++) {
            array[i] = l1.get(i);
        }
    }

    public static void iterators() {
        // Crea llista d'enters anomenada "l1"
        List<Integer> l1 = new ArrayList<>();

        // Afegeix a l1 els elements 10, 20, 50 i 90
        l1.add(10);
        l1.add(20);
        l1.add(50);
        l1.add(90);

        // Treu Iterator (it)
        Iterator<Integer> it = l1.iterator();

        // Mentre hi hagi element següent, imprimeix l'element
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Torna a crear l'objecte iterator i has de recórrer la llista, però has d'esborrar l'element "50"
        it = l1.iterator(); // Re-creating iterator
        while (it.hasNext()) {
            Integer current = it.next();
            if (current == 50) {
                it.remove(); // Removing the element "50"
            }
        }

        // Imprimeix la llista
        System.out.println("Llista després de treure 50: " + l1);

        // Crea un ListIterator de la llista l1 (anomenat "li")
        ListIterator<Integer> li = l1.listIterator();

        // Avança l'iterador fins al final de la llista
        while (li.hasNext()) {
            li.next();
        }

        // Recorre la llista al reves amb l'iterador, imprimint els elements
        System.out.println("Llista en ordre invers amb ListIterator:");
        while (li.hasPrevious()) {
            System.out.println(li.previous());
        }

        // Torna a recorrer la llista amb l'iterador, però aquest cop imprimeix també l'index de l'element
        System.out.println("Llista amb índexs usant ListIterator:");
        li = l1.listIterator(); // Reset the ListIterator
        while (li.hasNext()) {
            int index = li.nextIndex();
            Integer current = li.next();
            System.out.println("Index: " + index + " -> Element: " + current);
        }
    }


    static void cues() {
        // Declara una cua (anomenada "cua") com una LinkedList
        Queue<Integer> cua = new LinkedList<>();
        // Afegeix els elements 12, 14 i 99 a la cua
        cua.add(12);
        cua.add(14);
        cua.add(99);
        // Mostra el primer element (sense treurer-lo) de la cúa i imprimeix-ho
        int first = cua.peek();
        switch (first) {}
        // Treu el primer element de la cúa
        int sacado = cua.peek();
        System.out.println(sacado);
        // Imprimeix la cúa
        System.out.println(cua);
        // Declara una cúa de prioritat anomenada "cuaPrioritat"

        // Afegeix els elements 5, 2, -1, 9 i 7

        // Imprimeix la cúa

        // Fes un bucle que vagi traient cada element i l'imprimeixi de la cúa de prioritat, mentre en quedin

    }
}
/*
    static void piles() {
        // Declara una pila (stack) com una LinkedList

        // Push a la pila dels valors 15, 56, 21 i -5

        // Imprimeix la pila

        // Imprimeix el valor de damunt la pila, sense treurer-lo

        // Treu i imprimeix els valors de la pila

    }

    static void conjunts() {
        // Declara un conjunt d'enters anomenat "set"

        // Afegeix els elements 14, 6 i 3

        // Imprimeix el conjunt

        // Afegeix l'element 6 un altre cop

        // Imprimeix el conjunt


        // Construeix un conjunt de caràcters anomenat set2 (Usa la class Character, no char)
        // i introdueix totes les lletres de la paraula "ESTERNOCLEIDOMASTOIDEO"
        // Després, imprimeix el conjunt


        // Empra un iterador (it) per recórrer tot el conjunt de caràcters anterior i imprimeix element a element

    }

    static void mapes() {
        // Construeix un mapa (map) que associi un String amb un altre String

        // Introdueix el parell: "RENAULT" - "CLIO"

        // Introdueix el parell: "VOLKSWAGEN" - "GOLF"

        // Introdueix el parell: "PEUGEOT" - "308"

        // Introdueix el parell: "HONDA" - "CIVIC"

        // Introdueix el parell: "PEUGEOT" - "RCZ"

        // Imprimeix el mapa


        // Treu el conjunt de claus del mapa (variable kset)

        // Imprimeix aquest conjunt

        // Treu el valor de la clau "PEUGEOT" i imprimeix-ho

        // Mitjançant un iterador, imprimeix tots els parells clau-valor del mapa


        // Empra un mapa que associi un caràcter a un número enter per dur el compte
        // de quantes vegades surt cada lletra a la paraula "ESTERNOCLEIDOMASTOIDEO"


    }
}
*/
