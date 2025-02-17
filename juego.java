import java.util.Scanner;

class Jugador {
    private String clase;
    private int vida;
    private int ATK;
    private int DEF;
    private int VATK;
    private int LVL;

    public Jugador(String clase) {
        this.clase = clase.toLowerCase();
        inicializarAtributos();
    }
    private void inicializarAtributos() {
        switch (clase) {
            case "dragon":
                vida = 200;
                ATK = 150;
                DEF = 100;
                VATK = 50;
                LVL = 0;
                break;
            case "caballero":
                vida = 180;
                ATK = 100;
                DEF = 120;
                VATK = 60;
                LVL = 0;
                break;
            case "mago":
                vida = 120;
                ATK = 120;
                DEF = 80;
                VATK = 80;
                LVL = 0;
                break;
            case "asesino":
                vida = 150;
                ATK = 130;
                DEF = 70;
                VATK = 100;
                LVL = 0;
                break;
            default:
                vida = 0;
                ATK = 0;
                DEF = 0;
                VATK = 0;
                LVL = 0;
                break;
        }
    }

    public void mostrarAtributos() {
        System.out.println("Atributos del " + clase + ":");
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ATK);
        System.out.println("Defensa: " + DEF);
        System.out.println("Velocidad de ataque: " + VATK);
    }

    public void mostrarClase() {
        switch (clase.toLowerCase()) {
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
            default:
                System.out.println("Esa clase no existe. Inténtalo de nuevo.");
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
                "  (3|\\    _/|/'   _| |  \n" +
                "   ||/,-''  | >-'' _,\\\\ \n" +
                "   ||'      ==\\ ,-'  ,' \n" +
                "   ||       |  V \\ ,|   \n" +
                "   ||       |    |` |   \n" +
                "   ||       |    |   \\  \n" +
                "   ||       |    \\    \\ \n" +
                "   ||       |     |    \\\n" +
                "   ||       |      \\_,-'\n" +
                "   ||       |___,,--\")_\\\n" +
                "   ||         |_|   ccc/\n" +
                "   ||        ccc/       \n" +
                "   ||                hjm");
    }

    private void asesinoGrafics() {
        System.out.println("        (\\_/)  \n" +
                "        (o.o)\uD83D\uDD2A  \n" +
                "        (> \uD83C\uDFF9  \n" +
                "       /| |  \n" +
                "      / | |  \n" +
                "     (_| |_)  \n");
    }
}

public class juego {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cómo te llamas?");
        String nombre = sc.nextLine();

        System.out.println("Bienvenido " + nombre + ", ¿Qué eres?");
        System.out.println("Dragon, Caballero, Mago o Asesino?");
        String clase = sc.nextLine();
        Jugador jugador = new Jugador(clase);
        jugador.mostrarClase();
        jugador.mostrarAtributos();

        sc.close();
    }
}
