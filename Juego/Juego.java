package Juego;

import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String clase;
        System.out.println("¿Cómo te llamas?");
        String nombre = sc.nextLine();

        do {
            System.out.println("Bienvenido " + nombre + ", ¿Qué clase quieres ser?");
            System.out.println("1. Dragon 🐉\n2. Caballero ⚔️\n3. Mago 🔮\n4. Asesino 🗡️");
            clase = sc.nextLine();
        } while (!clase.equalsIgnoreCase("Dragon")
                && !clase.equalsIgnoreCase("Caballero")
                && !clase.equalsIgnoreCase("Mago")
                && !clase.equalsIgnoreCase("Asesino"));

        // Crear el jugador
        Jugador jugador = new Jugador(clase);
        jugador.mostrarClase();
        jugador.mostrarAtributos();

        boolean seguirJugando = true;
        while (seguirJugando) {
            Enemigo enemigo = crearEnemigoDeMismaClase(clase, jugador);
            System.out.println("\n👹 ¡Un " + enemigo.getClase() + " enemigo ha aparecido!");
            enemigo.mostrarAtributos();

            while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
                if (jugador.getVATK() >= enemigo.getVATK()) {
                    jugadorTurno(sc, jugador, enemigo);
                    if (enemigo.getVida() > 0) {
                        enemigo.atacar(jugador);
                    }
                } else {
                    enemigo.atacar(jugador);
                    if (jugador.getVida() > 0) {
                        jugadorTurno(sc, jugador, enemigo);
                    }
                }
            }

            if (jugador.getVida() > 0) {
                System.out.println("\n🎉 ¡Has derrotado al enemigo!");
                jugador.ganarExperiencia(20); // Puntos que gana por victoria
                jugador.mostrarAtributos();
                System.out.println("¿Quieres seguir luchando? (si/no)");
                String respuesta = sc.next();
                if (!respuesta.equalsIgnoreCase("si")) {
                    seguirJugando = false;
                }
            } else {
                System.out.println("\n💀 Has sido derrotado... Fin del juego.");
                seguirJugando = false;
            }
        }
        sc.close();
    }

    public static Enemigo crearEnemigoDeMismaClase(String clase, Jugador jugador) {
        int vida = jugador.getVida();
        int ATK = jugador.getATK();
        int DEF = jugador.getDEF();
        int VATK = jugador.getVATK();
        int LVL = jugador.getLVL();
        return new Enemigo(clase, vida, ATK, DEF, VATK, LVL);
    }

    private static void jugadorTurno(Scanner sc, Jugador jugador, Enemigo enemigo) {
        System.out.println("\n⚔️ ¿Qué quieres hacer?");
        System.out.println("1. Atacar\n2. Defender\n3. Usar Habilidad Especial");

        int opcion = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                opcion = sc.nextInt();
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("❌ Entrada no válida. Por favor ingresa un número.");
                sc.nextLine();
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
