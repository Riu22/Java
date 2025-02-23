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
            System.out.println("1. Dragon 🐉\n2. Caballero ⚔️\n3. Mago 🔮\n4. Asesino 🔯");
            clase = sc.nextLine();
        } while (!clase.equalsIgnoreCase("Dragon")
                && !clase.equalsIgnoreCase("Caballero")
                && !clase.equalsIgnoreCase("Mago")
                && !clase.equalsIgnoreCase("Asesino"));

        Jugador jugador = new Jugador(clase);
        jugador.mostrarClase();
        jugador.mostrarAtributos();

        System.out.println("\n📜 ¿Qué modo quieres jugar?");
        System.out.println("1. Modo Libre (combate infinito)");
        System.out.println("2. Modo Historia (Estilo Dark Souls)");

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
            int espacioEntreCajas = 30;
            while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
                mostrarEstado(jugador, enemigo, espacioEntreCajas);
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

    public static void jugadorTurno(Scanner sc, Jugador jugador, Enemigo enemigo) {
        int espacioEntreCajas = 30;
        mostrarEstado(jugador, enemigo, espacioEntreCajas);
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

    public static Enemigo crearEnemigoContrincante(Jugador jugador) {
        String claseJugador = jugador.getClase();
        String claseEnemigo;

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

        return new Enemigo(claseEnemigo, jugador.getVida() + 50, jugador.getATK() + 20, jugador.getDEF() + 10, jugador.getVATK() + 5, jugador.getLVL() + 1);
    }

    private static void mostrarEstado(Jugador jugador, Enemigo enemigo, int extraSpace) {
        String[] graficoJugador = jugador.mostrarClase().split("\n");
        String[] graficoEnemigo = enemigo.mostrar(jugador).split("\n");

        int maxLength = Math.max(graficoJugador.length, graficoEnemigo.length);
        int maxWidth = 0;

        for (int i = 0; i < maxLength; i++) {
            String lineaJugador = i < graficoJugador.length ? graficoJugador[i] : " ".repeat(30);
            String lineaEnemigo = i < graficoEnemigo.length ? graficoEnemigo[i] : " ".repeat(30);
            int combinedLength = lineaJugador.length() + extraSpace + lineaEnemigo.length();
            maxWidth = Math.max(maxWidth, combinedLength);
        }

        String batallaText = "BATALLA";
        String headerFooter = "=".repeat(maxWidth);

        System.out.println("\n" + headerFooter);
        System.out.println(batallaText + " ".repeat(maxWidth - batallaText.length()));
        System.out.println(headerFooter);

        String[] cajaJugador = generarCaja("JUGADOR", jugador.getClase(), jugador.getVida(), jugador.getATK(), jugador.getDEF(), jugador.getVATK()).split("\n");
        String[] cajaEnemigo = generarCaja("ENEMIGO", enemigo.getClase(), enemigo.getVida(), enemigo.getATK(), enemigo.getDEF(), enemigo.getVATK()).split("\n");

        for (int i = 0; i < cajaJugador.length; i++) {
            System.out.println(cajaJugador[i] + " ".repeat(extraSpace) + cajaEnemigo[i]);
        }

        System.out.println();

        for (int i = 0; i < maxLength; i++) {
            String lineaJugador = i < graficoJugador.length ? graficoJugador[i] : " ".repeat(30);
            String lineaEnemigo = i < graficoEnemigo.length ? graficoEnemigo[i] : " ".repeat(30);

            System.out.println(lineaJugador + " ".repeat(extraSpace) + lineaEnemigo);
        }

        System.out.println(headerFooter);
    }

    private static String generarCaja(String titulo, String clase, int vida, int ATK, int DEF, int VATK) {
        return String.format(
                "   ╔════════════════════════════════╗\n" +
                        "   ║ %-30s ║\n" +
                        "   ║ %-30s ║\n" +
                        "   ║ Vida:  %-22d  ║\n" +
                        "   ║ ATK:   %-22d  ║\n" +
                        "   ║ DEF:   %-22d  ║\n" +
                        "   ║ VATK:  %-22d  ║\n" +
                        "   ╚════════════════════════════════╝\n",
                formatearTexto(titulo, 30),
                formatearTexto(clase.toUpperCase(), 30),
                vida,
                ATK,
                DEF,
                VATK
        );
    }

    private static String formatearTexto(String texto, int ancho) {
        return String.format("%-" + ancho + "s", texto);
    }
}
