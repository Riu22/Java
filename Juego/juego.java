package Juego;

import java.util.Scanner;

public class juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String clase;
        System.out.println("¿Cómo te llamas?");
        String nombre = sc.nextLine();
        do {
            System.out.println("Bienvenido " + nombre + ", ¿Qué clase quieres ser?");
            System.out.println("1. Dragon 🐉\n2. Caballero ⚔️\n3. Mago 🔮\n4. Asesino 🗡️");
            clase = sc.nextLine();
        }while (!clase.equals("Dragon")||!clase.equals("caballero")||!clase.equals("mago")||!clase.equals("asesino"));
        // Crear el jugador
        Jugador jugador = new Jugador(clase);
        jugador.mostrarClase();
        jugador.mostrarAtributos();

        // Crear enemigo aleatorio con la misma clase
        Enemigo enemigo = crearEnemigoDeMismaClase(clase, jugador);

        System.out.println("\n👹 ¡Un " + enemigo.getClase() + " enemigo ha aparecido!");
        enemigo.mostrarAtributos();

        // Bucle del juego
        while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
            // Decidir quién ataca primero basado en la velocidad de ataque
            if (jugador.getVATK() >= enemigo.getVATK()) {
                // El jugador ataca primero
                jugadorTurno(sc, jugador, enemigo);
                if (enemigo.getVida() > 0) {
                    enemigo.atacar(jugador);  // Si el enemigo sigue vivo, ataca
                }
            } else {
                // El enemigo ataca primero
                enemigo.atacar(jugador);
                if (jugador.getVida() > 0) {
                    jugadorTurno(sc, jugador, enemigo);  // Si el jugador sigue vivo, puede actuar
                }
            }
        }

        // Verificar quién ganó
        if (jugador.getVida() > 0) {
            System.out.println("\n🎉 ¡Has derrotado al enemigo!");
        } else {
            System.out.println("\n💀 Has sido derrotado... Fin del juego.");
        }

        sc.close();
    }

    public static Enemigo crearEnemigoDeMismaClase(String clase, Jugador jugador) {
        // Los mismos atributos del jugador, pero para el enemigo
        int vida = jugador.getVida();
        int ATK = jugador.getATK();
        int DEF = jugador.getDEF();
        int VATK = jugador.getVATK();
        int LVL = jugador.getLVL();

        return new Enemigo(clase, vida, ATK, DEF, VATK, LVL);
    }

    private static void jugadorTurno(Scanner sc, Jugador jugador, Enemigo enemigo) {
        System.out.println("\n⚔️ ¿Qué quieres hacer?");
        System.out.println("1. Atacar");
        System.out.println("2. Defender");
        System.out.println("3. Usar Habilidad Especial");
        System.out.println("4. Subir de Nivel (si tienes suficiente experiencia)");

        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                opcion = sc.nextInt();
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("❌ Entrada no válida. Por favor ingresa un número.");
                sc.nextLine(); // Limpiar el buffer
            }
        }

        switch (opcion) {
            case 1:
                jugador.atacar(enemigo);
                break;
            case 2:
                jugador.defender();
                break;
            case 3:
                jugador.habilidadEspecial(enemigo);
                break;
            case 4:
                jugador.subirNivel();
                break;
            default:
                System.out.println("❌ Opción inválida, intenta de nuevo.");
        }
    }
}
