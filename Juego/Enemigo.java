package Juego;

import java.util.Random;

public class Enemigo {
    private String clase;
    private int vida;
    private int ATK;
    private int DEF;
    private int VATK;
    private int LVL;

    public Enemigo(String clase, int vida, int ATK, int DEF, int VATK, int LVL) {
        this.clase = clase;
        this.vida = vida;
        this.ATK = ATK;
        this.DEF = DEF;
        this.VATK = VATK;
        this.LVL = LVL;
    }
    public void aumentarAtributos(int vidaExtra, int ataqueExtra, int defensaExtra, int velocidadExtra) {
        this.vida += vidaExtra;
        this.ATK += ataqueExtra;
        this.DEF += defensaExtra;
        this.VATK += velocidadExtra;
    }

    public void mejorarAtributos(int nivelJugador) {
        double factorCrecimiento = 1 + (nivelJugador * 0.1); // Crecimiento progresivo
        this.vida = (int) (this.vida * factorCrecimiento);
        this.ATK = (int) (this.ATK * factorCrecimiento);
        this.DEF = (int) (this.DEF * (factorCrecimiento - 0.05));
        this.VATK = (int) (this.VATK * (factorCrecimiento - 0.02));
        this.LVL = nivelJugador;
        System.out.println("⚠️ Un nuevo enemigo ha aparecido con más fuerza debido a tu progreso!");
    }

    public void mostrarAtributos() {
        System.out.println("\n\uD83D\uDC79 Atributos del enemigo (" + clase + "):");
        System.out.println("\uD83D\uDC96 Vida: " + vida);
        System.out.println("⚔️ Ataque: " + ATK);
        System.out.println("\uD83D\uDEE1️ Defensa: " + DEF);
        System.out.println("⚡ Velocidad de ataque: " + VATK);
        System.out.println("⭐ Nivel: " + LVL);
    }

    public void atacar(Jugador jugador) {
        int dano = this.ATK - jugador.getDEF();
        if (dano < 0) dano = 5;  // Asegurar que al menos hace algo de daño
        jugador.recibirDano(dano);
        System.out.println("\n\uD83D\uDC80 ¡El enemigo te atacó con " + dano + " de daño!");
    }

    public void recibirDano(int dano) {
        this.vida -= dano;
        System.out.println("\n\uD83E\uDE78 El " + clase + " ha recibido " + dano + " de daño. Vida restante: " + this.vida);
    }

    public int getVida() {
        return this.vida;
    }

    public int getATK(){return this.ATK;}

    public int getDEF() {
        return this.DEF;
    }

    public int getVATK() {
        return this.VATK;
    }

    public int getLVL() {
        return this.LVL;
    }

    public String getClase() {
        return this.clase;
    }


    public static class  Asesino extends Enemigo {
        public Asesino(int nivel) {
            super("Asesino", 150, 130, 70, 100, nivel);  // Se inicializan con atributos específicos de Asesino
        }
    }

    public static class Mago extends Enemigo {
        public Mago(int nivel) {
            super("Mago", 120, 120, 80, 80, nivel);  // Se inicializan con atributos específicos de Mago
        }
    }

    public static class Dragon extends Enemigo {
        public Dragon(int nivel) {
            super("Dragon", 200, 150, 100, 50, nivel);  // Se inicializan con atributos específicos de Dragón
        }
    }

    public static class Caballero extends Enemigo {
        public Caballero(int nivel) {
            super("Caballero", 180, 100, 120, 60, nivel);  // Se inicializan con atributos específicos de Caballero
        }
    }
}
