package Juego;

import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String clase;
    private int vida;
    private int ATK;
    private int DEF;
    private int VATK;
    private int LVL;
    private boolean defensaActiva = false;
    private int experiencia = 0;

    public void setvida(int vida) {
        this.vida = vida;
    }

    public Jugador(String clase) {
        this.clase = clase.toLowerCase();
        inicializarAtributos();
    }

    private void inicializarAtributos() {
        switch (clase) {
            case "dragon":
                vida = 200; ATK = 150; DEF = 100; VATK = 50; LVL = 1;
                break;
            case "caballero":
                vida = 180; ATK = 100; DEF = 120; VATK = 60; LVL = 1;
                break;
            case "mago":
                vida = 120; ATK = 120; DEF = 80; VATK = 80; LVL = 1;
                break;
            case "asesino":
                vida = 150; ATK = 130; DEF = 70; VATK = 100; LVL = 1;
                break;
            default:
                vida = 0; ATK = 0; DEF = 0; VATK = 0; LVL = 1;
                break;
        }
    }

    public void mostrarAtributos() {
        System.out.println("\n🔹 Atributos del " + clase + ":");
        System.out.println("💖 Vida: " + vida);
        System.out.println("⚔️ Ataque: " + ATK);
        System.out.println("🛡️ Defensa: " + DEF);
        System.out.println("⚡ Velocidad de ataque: " + VATK);
        System.out.println("⭐ Nivel: " + LVL);
    }

    public void atacar(Enemigo enemigo) {
        int dano = this.ATK - enemigo.getDEF();
        if (dano < 0) dano = 5;  // Asegurar que al menos hace algo de daño
        enemigo.recibirDano(dano);
        System.out.println("\n⚔️ ¡Atacaste al enemigo y le hiciste " + dano + " de daño!");
    }

    public void defender() {
        this.DEF += 15;  // Aumentar defensa
        this.defensaActiva = true;  // Reducir daño en el siguiente turno
        System.out.println("\n🛡️ ¡Has aumentado tu defensa! Reducirás el daño del próximo ataque enemigo.");
    }

    public void recibirDano(int dano) {
        if (defensaActiva) {
            dano /= 2;
            defensaActiva = false;
        }

        this.vida -= dano;
        System.out.println("\n💥 ¡Recibiste " + dano + " de daño! Vida restante: " + this.vida);
    }

    public void subirNivel() {
        this.LVL++;
        this.vida += 30;
        this.ATK += 10;
        this.DEF += 5;

        // Restablecer la vida al nuevo valor máximo
        int vidaMaxima = 0;
        switch (clase) {
            case "dragon":
                vidaMaxima = 200 + (30 * (LVL - 1)); // Incrementa según el nivel
                break;
            case "caballero":
                vidaMaxima = 180 + (30 * (LVL - 1));
                break;
            case "mago":
                vidaMaxima = 120 + (30 * (LVL - 1));
                break;
            case "asesino":
                vidaMaxima = 150 + (30 * (LVL - 1));
                break;
        }

        this.vida = vidaMaxima;
        System.out.println("\n🔥 ¡Has subido de nivel! Ahora eres nivel " + LVL);
    }


    private int subir = 10;

    public void ganarExperiencia(int cantidad) {
        experiencia += cantidad;
        System.out.println("\n🎯 ¡Ganaste " + cantidad + " de experiencia!");
        do {
            if (experiencia >= subir) {
                experiencia -= subir;
                subirNivel();
                mejorarAtributo();
                subir *= 2;
            }
        }while (experiencia >= subir);
    }

    public void habilidadEspecial(Enemigo enemigo) {
        Random rand = new Random();
        int danoExtra = rand.nextInt(40) + 20;  // Daño entre 20 y 60

        // Habilidad especial del Mago (Curación o Daño extra)
        if (clase.equals("mago")) {
            if (rand.nextBoolean()) {
                // Curación
                this.vida += 30;
                System.out.println("\n🔮 ¡Usaste tu habilidad especial y te curaste 30 de vida! Vida actual: " + this.vida);
            } else {
                // Daño extra
                enemigo.recibirDano(danoExtra);
                System.out.println("\n🔮 ¡Usaste tu habilidad especial y causaste " + danoExtra + " de daño!");
            }
        }
    }

    public void mejorarAtributo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n✨ ¡Puedes mejorar un atributo!");
        System.out.println("1. Aumentar Vida (+20)");
        System.out.println("2. Aumentar Ataque (+10)");
        System.out.println("3. Aumentar Defensa (+5)");
        System.out.println("4. Aumentar Velocidad de Ataque (+5)");

        int opcion = 0;
        while (opcion < 1 || opcion > 4) {
            try {
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
            } catch (Exception e) {
                System.out.println("❌ Entrada no válida. Ingresa un número del 1 al 4.");
                sc.nextLine();
            }
        }

        switch (opcion) {
            case 1:
                vida += 20;
                System.out.println("💖 Has aumentado tu Vida.");
                break;
            case 2:
                ATK += 10;
                System.out.println("⚔️ Has aumentado tu Ataque.");
                break;
            case 3:
                DEF += 5;
                System.out.println("🛡️ Has aumentado tu Defensa.");
                break;
            case 4:
                VATK += 5;
                System.out.println("⚡ Has aumentado tu Velocidad de Ataque.");
                break;
        }
    }

    public void mostrarClase() {
        switch (clase) {
            case "dragon":
                dragonGrafics();
                System.out.println("¡Has elegido ser un poderoso dragón! 🐉");
                break;
            case "caballero":
                caballeroGrafics();
                System.out.println("¡Has elegido ser un valiente caballero! ⚔️");
                break;
            case "mago":
                magoGrafics();
                System.out.println("¡Has elegido ser un sabio mago! 🔮");
                break;
            case "asesino":
                asesinoGrafics();
                System.out.println("¡Has elegido ser un sigiloso asesino! 🗡️");
                break;
        }
    }

    private void caballeroGrafics() {
        System.out.println(
                "                /'\n" +
                        "                ||\n" +
                        "                ||      ** *\n" +
                        "                ||      __X_\n" +
                        "                ||     ( ___\\\n" +
                        "     ||     |:  \\\\\n" +
                        "    ><><  ___)..:/_#__,\n" +
                        "                (X|) (|+(____)+\\ _)\n" +
                        "        o|_\\/>> + + + << \\\n" +
                        "       |:\\/|+ + + +| \\_\\<\n" +
                        "       \\./  XXXXXX.  (o_)_\n" +
                        "                /+ + + |   \\:|\n" +
                        "          /+ +/+ +|  -/->>>----.\n" +
                        "         /+ +|+ /XX /   _--,  _ \\\n" +
                        "        \\+ + + /  |X   (,\\- \\/_ ,\n" +
                        "        /\\+ + /\\  |X \\    /,//_/\n" +
                        "        +_+_+_( )o_)X  \\  (( ///\n" +
                        "                (_o(  /__/ X   \\  \\\\\n" +
                        "         \\_|  |_/  X    \\ ///\n" +
                        "         \\_| >(_/        \\,/\n" +
                        "    ,////__o\\ /__////,    V    b'ger"
        );
    }

    private void dragonGrafics() {
        System.out.println("                    /     \\\n" +
                "                   ((     ))\n" +
                "               ===  \\\\_v_//  ===\n" +
                "                 ====)_^_(====\n" +
                "                 ===/ O O \\===\n" +
                "                 = | /_ _\\ | =\n" +
                "                =   \\/_ _\\/   =\n" +
                "                     \\_ _/\n" +
                "                     (o_o)\n" +
                "                      VwV");
    }

    private void magoGrafics() {
        System.out.println("              _,._      \n" +
                "  .||,       /_ _\\\\     \n" +
                " \\.`',/      |'L'| |    \n" +
                " = ,. =      | -,| L    \n" +
                " / || \\    ,-'\\\"/,'`.   \n" +
                "   ||     ,'   `,,. `.  \n" +
                "   ,|____,' , ,;' \\| |  \n" +
                "  (3|\\    _/|/'   _| |  \n");
    }

    private void asesinoGrafics() {
        System.out.println("        (\\_/)  \n" +
                "        (o.o)\uD83D\uDD2A  \n" +
                "        (> \uD83C\uDFF9  \n" +
                "       /| |  \n" +
                "      / | |  \n" +
                "     (_| |_)  \n");
    }

    // Métodos Getters
    public int getATK() {
        return this.ATK;
    }

    public int getVida() {
        return this.vida;
    }

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
}
