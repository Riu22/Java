package Juego;

import java.util.Scanner;

public class Historia {
    public static void jugarModoHistoria(Jugador jugador, Scanner sc) {
        System.out.println("\n🌑 Un mundo olvidado te espera...");
        System.out.println("Te despiertas en las ruinas de un reino caído. Ecos de batallas antiguas resuenan en el viento.");
        System.out.println("Una voz susurra: \"Solo los dignos recuerdan su propósito...\"\n");

        // 🔥 Primer combate (derrota asegurada)
        System.out.println("\n⚔️ Un Caballero Caído aparece ante ti...");
        Enemigo caballeroCaido = getEnemigoSegunClase(jugador, 100);
        caballeroCaido.aumentarAtributos(200, 50, 30, 20); // Hacemos al enemigo muy fuerte para asegurar la derrota.

        System.out.println("\n💀 En tu estado actual, no tienes oportunidad...");
        batallaDerrota(jugador, caballeroCaido);

        // 📖 Narrativa después de perder
        System.out.println("\n🌙 Oscuridad... Sientes que caes en un abismo sin fin.");
        System.out.println("...");
        System.out.println("⛺ Despiertas en una humilde aldea. Un anciano te observa.");
        System.out.println("\"Has visto la verdad... El Rey Maldito no permitirá que nadie desafíe su reinado.\"");
        System.out.println("\"Si realmente deseas luchar, necesitarás más poder. Encuentra la llama olvidada.\"");
        System.out.println("\n🔥 ¡Has obtenido un aumento de poder!");
        jugador.ganarExperiencia(100); // El jugador gana experiencia para fortalecerse.
        jugador.setvida(jugador.getVida() + 50); // Recupera 50 de vida
        System.out.println("\n💖 Un poder oculto te sana. Has recuperado algo de vida.");

        // ⚔️ Segundo combate
        if (!batallaHistoria(jugador, sc, "Hechicero del Abismo", getEnemigoSegunClase(jugador, 2))) return;

        // ⚔️ Jefe final
        if (!batallaHistoria(jugador, sc, "Rey Maldito", getEnemigoSegunClase(jugador, 3))) return;

        // 🎭 Final del juego
        System.out.println("\n👑 Has vencido al Rey Maldito. Su corona se quiebra y un nuevo ciclo comienza...");
        System.out.println("¿Eres el héroe del renacer... o solo un nuevo tirano?");
        System.out.println("🎭 Fin del modo historia.");
    }

    // 🔥 Método para el primer combate que el jugador debe perder
    private static void batallaDerrota(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n⚔️ " + enemigo.getClase() + " es demasiado poderoso...");

        while (jugador.getVida() > 0) {
            Juego.jugadorTurno(new Scanner(System.in), jugador, enemigo);
            if (jugador.getVida() > 0) {
                enemigo.atacar(jugador);
                if (jugador.getVida() > 0) {
                    jugador.setvida(0);
                }
            }
        }

        System.out.println("\n💀 Has sido derrotado sin remedio...");
        System.out.println("Tu cuerpo cae al suelo... y la oscuridad te envuelve.");
    }

    // 🔄 Método normal para las batallas del modo historia
    private static boolean batallaHistoria(Jugador jugador, Scanner sc, String nombreEnemigo, Enemigo enemigo) {
        System.out.println("\n⚔️ " + nombreEnemigo + " aparece ante ti...");
        enemigo.mostrarAtributos();

        while (jugador.getVida() > 0 && enemigo.getVida() > 0) {
            Juego.jugadorTurno(sc, jugador, enemigo);
            if (enemigo.getVida() > 0) {
                enemigo.atacar(jugador);
            }
        }

        if (jugador.getVida() > 0) {
            System.out.println("\n✨ " + nombreEnemigo + " ha sido derrotado.");
            jugador.ganarExperiencia(50 * enemigo.getLVL());
            jugador.mostrarAtributos();
            return true;
        } else {
            System.out.println("\n💀 Has sido derrotado por " + nombreEnemigo + ". El ciclo continúa...");
            System.out.println("🕯️ Fin del modo historia.");
            return false;
        }
    }

    // 📜 Generador de enemigos basado en la clase del jugador
    private static Enemigo getEnemigoSegunClase(Jugador jugador, int nivel) {
        String claseEnemigo;
        switch (jugador.getClase().toLowerCase()) {
            case "dragon": claseEnemigo = "asesino"; break;
            case "caballero": claseEnemigo = "mago"; break;
            case "mago": claseEnemigo = "dragon"; break;
            case "asesino": claseEnemigo = "caballero"; break;
            default: claseEnemigo = "mago";
        }
        return new Enemigo(claseEnemigo, 100 + (nivel * 50), 20 + (nivel * 10), 15 + (nivel * 5), 10 + (nivel * 5), nivel);
    }
}
