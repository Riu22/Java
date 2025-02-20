package Juego;

import java.util.Random;
import java.util.Scanner;

public class Historia {
    public static void jugarModoHistoria(Jugador jugador, Scanner sc) {
        System.out.println("\n🌑 Un mundo olvidado te espera...");
        System.out.println("Te despiertas en las ruinas de un reino caído. Ecos de batallas antiguas resuenan en el viento.");
        System.out.println("El cielo está oscurecido, como si la esperanza misma hubiera abandonado este lugar.");
        System.out.println("Una voz susurra: \"Solo los dignos recuerdan su propósito...\"\n");

        // 🔥 Primer combate (derrota asegurada)
        System.out.println("\n⚔️ Un Caballero Caído aparece ante ti...");
        Enemigo caballeroCaido = getEnemigoAleatorio(100);  // El enemigo ahora tiene clase aleatoria
        caballeroCaido.aumentarAtributos(200, 50, 30, 20); // Hacemos al enemigo muy fuerte para asegurar la derrota.

        System.out.println("\n💀 En tu estado actual, no tienes oportunidad...");
        batallaDerrota(jugador, caballeroCaido);

        // 📖 Narrativa después de perder
        System.out.println("\n🌙 Oscuridad... Sientes que caes en un abismo sin fin.");
        System.out.println("...");
        System.out.println("⛺ Despiertas en una humilde aldea, rodeado de naturaleza. Un anciano te observa desde una silla de madera.");
        System.out.println("\"Has visto la verdad... El Rey Maldito no permitirá que nadie desafíe su reinado.\"");
        System.out.println("\"Si realmente deseas luchar, necesitarás más poder. Encuentra la llama olvidada, solo ella podrá restaurar tu fuerza.\"");
        System.out.println("El anciano te entrega un medallón. \"Este será tu guía en el camino, pero debes ser sabio con tus elecciones...\"");
        System.out.println("\n🔥 ¡Has obtenido un aumento de poder!");
        jugador.ganarExperiencia(100); // El jugador gana experiencia para fortalecerse.
        jugador.setvida(jugador.getVida() + 50); // Recupera 50 de vida
        System.out.println("\n💖 El medallón brilla y un poder oculto te sana. Has recuperado algo de vida.");

        // ⚔️ Segundo combate
        if (!batallaHistoria(jugador, sc, "Hechicero del Abismo", getEnemigoAleatorio(2))) return;

        // 🏞️ Exploración en la búsqueda de la llama olvidada
        System.out.println("\n🌿 Sigues el sendero marcado por el medallón. El bosque se vuelve más oscuro y misterioso.");
        System.out.println("Un crujido de ramas te hace voltear. Un extraño ser aparece en tu camino...");
        System.out.println("Es un guardián del bosque que te desafía a una prueba de sabiduría.");
        System.out.println("\"¿Qué harás?\"");
        System.out.println("1. Aceptar la prueba.");
        System.out.println("2. Atacar al guardián.");
        System.out.println("Elige sabiamente.");

        int opcion = obtenerOpcion(sc);
        if (opcion == 1) {
            System.out.println("\n💡 Aceptas la prueba de sabiduría del guardián. Tras responder correctamente, te ofrece un nuevo poder.");
            jugador.ganarExperiencia(50);
            jugador.setvida(jugador.getVida() + 30); // Incremento de vida
            System.out.println("\n💖 El guardián te da un elixir que mejora tus habilidades.");
        } else {
            System.out.println("\n⚔️ Decides luchar contra el guardián. Tras un arduo combate, lo derrotas.");
            jugador.ganarExperiencia(100);
        }

        // ⚔️ Jefe final
        if (!batallaHistoria(jugador, sc, "Rey Maldito", getEnemigoAleatorio(3))) return;

        // 🎭 Final del juego
        System.out.println("\n👑 Has vencido al Rey Maldito. Su corona se quiebra y el reino comienza a sanar.");
        System.out.println("Pero la pregunta permanece: ¿Eres el héroe del renacer... o solo un nuevo tirano?");
        System.out.println("🎭 Fin del modo historia.");
    }

    // 🔥 Método para el primer combate que el jugador debe perder
    private static void batallaDerrota(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n⚔️ " + enemigo.getClase() + " es demasiado poderoso...");
        System.out.println("Tu corazón late rápidamente. Sabes que este será un combate desigual.");
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
        System.out.println("Sin embargo, antes de perder el conocimiento, ves una luz brillante al horizonte...");
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

    private static Enemigo getEnemigoAleatorio(int nivel) {
        Random rand = new Random();
        int claseIndex = rand.nextInt(4); // Suponiendo que hay 4 clases diferentes

        Enemigo enemigo;

        switch (claseIndex) {
            case 0:
                enemigo = new Enemigo.Asesino(nivel);
                break;
            case 1:
                enemigo = new Enemigo.Mago(nivel);
                break;
            case 2:
                enemigo = new Enemigo.Dragon(nivel);
                break;
            case 3:
                enemigo = new Enemigo.Caballero(nivel);
                break;
            default:
                enemigo = new Enemigo.Mago(nivel);
                break;
        }

        enemigo.mejorarAtributos(nivel); // Mejorar atributos según nivel

        return enemigo;
    }




    // 📜 Método para obtener la opción del jugador en decisiones
    private static int obtenerOpcion(Scanner sc) {
        int opcion = 0;
        while (opcion < 1 || opcion > 2) {
            try {
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Entrada no válida. Ingresa un número del 1 al 2.");
                sc.nextLine();
            }
        }
        return opcion;
    }
}
