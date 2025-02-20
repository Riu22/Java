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

        System.out.println("\n📜 ¿Qué modo quieres jugar?");
        System.out.println("1. Modo Libre (combate infinito)");
        System.out.println("2. Modo Historia (Estilo Dark SOuls)");

        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 2) {
            Historia.jugarModoHistoria(jugador, sc);
        } else {
            jugarModoLibre(jugador, sc);
        }

        sc.close();
    }

    public static void jugarModoLibre(Jugador jugador, Scanner sc) {
        boolean seguirJugando = true;
        while (seguirJugando) {
            Enemigo enemigo = crearEnemigoContrincante(jugador);
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
                jugador.ganarExperiencia(5);
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
    }

    public static Enemigo crearEnemigoContrincante(Jugador jugador) {
        String claseJugador = jugador.getClase();
        String claseEnemigo = "";

        switch (claseJugador.toLowerCase()) {
            case "dragon":
                claseEnemigo = "asesino";
                break;
            case "caballero":
                claseEnemigo = "mago";
                break;
            case "mago":
                claseEnemigo = "dragon";
                break;
            case "asesino":
                claseEnemigo = "caballero";
                break;
            default:
                claseEnemigo = "mago";
                break;
        }

        return crearEnemigoDeClase(claseEnemigo, jugador);
    }

    public static Enemigo crearEnemigoDeClase(String clase, Jugador jugador) {
        int vida = jugador.getVida() + 50;
        int ATK = jugador.getATK() + 20;
        int DEF = jugador.getDEF() + 10;
        int VATK = jugador.getVATK() + 5;
        int LVL = jugador.getLVL() + 1;

        return new Enemigo(clase, vida, ATK, DEF, VATK, LVL);
    }

    public static void jugadorTurno(Scanner sc, Jugador jugador, Enemigo enemigo) {
        System.out.println("\n⚔️ ¿Qué quieres hacer?");
        System.out.println("1. Atacar\n2. Defender\n3. Usar Habilidad Especial");

        int opcion = sc.nextInt();
        sc.nextLine();

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
            default:
                System.out.println("❌ Opción inválida, intenta de nuevo.");
        }
    }
}
