package Juego;

import java.util.Random;

public class pantalla {
    private static void mostrarEstado(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n=================== BATALLA ===================");

        // Secciones de estadisticas y arte ASCII para el Jugador y el Enemigo lado a lado
        String jugadorArte = obtenerArteASCII(jugador.getClase());
        String enemigoArte = obtenerArteASCII(enemigo.getClase());

        // Línea superior de la batalla
        System.out.print("╔════════════════════════════════╗   ╔════════════════════════════════╗\n");
        System.out.print("║          JUGADOR               ║   ║          ENEMIGO               ║\n");
        System.out.print("║ " + jugadorArte + "  " + jugador.getClase().toUpperCase() + "  ║   ║ " + enemigoArte + "  " + enemigo.getClase().toUpperCase() + "  ║\n");
        System.out.print("║ Vida: " + jugador.getVida() + generarEspacios(6) + "║   ║ Vida: " + enemigo.getVida() + generarEspacios(5) + "║\n");
        System.out.print("║ ATK: " + jugador.getATK() + generarEspacios(7) + "║   ║ ATK: " + enemigo.getATK() + generarEspacios(7) + "║\n");
        System.out.print("║ DEF: " + jugador.getDEF() + generarEspacios(6) + "║   ║ DEF: " + enemigo.getDEF() + generarEspacios(6) + "║\n");
        System.out.print("║ VATK: " + jugador.getVATK() + generarEspacios(5) + "║   ║ VATK: " + enemigo.getVATK() + generarEspacios(5) + "║\n");

        // Línea inferior de la batalla
        System.out.print("╚════════════════════════════════╝   ╚════════════════════════════════╝\n");

        System.out.println("==============================================");
    }


    private static String generarEspacios(int cantidad) {
        return " ".repeat(Math.max(0, cantidad));
    }

    private static String obtenerArteASCII(String clase) {
        return switch (clase.toLowerCase()) {
            case "asesino" -> "(\uD83E\uDDD9)";
            case "mago" -> "(\uD83E\uDDD9‍♂️)";
            case "dragon" -> "(\uD83D\uDC09)";
            case "caballero" -> "(\uD83E\uDD35‍♂️)";
            default -> "(???)";
        };
    }
}
