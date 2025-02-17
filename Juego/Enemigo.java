package Juego;

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

    public void mostrarAtributos() {
        System.out.println("\n👹 Atributos del enemigo (" + clase + "):");
        System.out.println("💖 Vida: " + vida);
        System.out.println("⚔️ Ataque: " + ATK);
        System.out.println("🛡️ Defensa: " + DEF);
        System.out.println("⚡ Velocidad de ataque: " + VATK);
    }

    public void atacar(Jugador jugador) {
        int dano = this.ATK - jugador.getDEF();
        if (dano < 0) dano = 5;  // Asegurar que al menos hace algo de daño
        jugador.recibirDano(dano);
        System.out.println("\n💀 ¡El enemigo te atacó con " + dano + " de daño!");
    }

    public void recibirDano(int dano) {
        this.vida -= dano;
        System.out.println("\n🩸 El " + clase + " ha recibido " + dano + " de daño. Vida restante: " + this.vida);
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
