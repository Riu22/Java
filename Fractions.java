
public class Fractions {
    /**
     * Array que conté les paraules per als números del 0 al 19 en català.
     * Utilitzat per a convertir números petits en paraules.
     */
    private static final String[] UNITS = {
            "", "un", "dos", "tres", "quatre", "cinc", "sis", "set", "vuit", "nou",
            "deu", "onze", "dotze", "tretze", "catorze", "quinze", "setze",
            "disset", "divuit", "dinou"
    };

    /**
     * Array que conté les paraules per a les desenes en català.
     * Utilitzat per a convertir números entre 10 i 99.
     */
    private static final String[] TENS = {
            "", "deu", "vint", "trenta", "quaranta", "cinquanta",
            "seixanta", "setanta", "vuitanta", "noranta"
    };

    /**
     * Array que conté les formes ordinals singulars per a denominadors petits.
     * Utilitzat per a fraccions com 1/2 ("mig").
     */
    private static final String[] singular = {
            "mig", "terç", "quart", "cinquè", "sisè", "setè", "vuitè", "novè",
            "dècim", "onzè", "dotzè", "tretzè", "catorzè", "quinzè", "setzè",
            "dissetè", "divuitè", "dinovè"
    };

    /**
     * Array que conté les formes ordinals plurals per a denominadors petits.
     * Utilitzat per a fraccions com 2/3 ("terços").
     */
    private static final String[] pluralForms = {
            "migs", "terços", "quarts", "cinquens", "sisens", "setens", "vuitens",
            "novens", "dècims", "onzens", "dotzens", "tretzens", "catorzens",
            "quinzens", "setzens", "dissetens", "divuitens", "dinovens"
    };

    /**
     * Converteix una cadena que representa una fracció a paraules en català.
     * @param fraction La cadena de la fracció (ex: "1/2").
     * @return La representació en paraules o "No vàlid" si és invàlida.
     */
    public static String toWords(String fraction) {
        // Comprovem si la cadena és nul·la o no és una fracció vàlida
        if (fraction == null || !fraction.matches("\\d+/\\d+")) return "No vàlid";
        
        String[] parts = fraction.split("/");  // Dividim la cadena en numerador i denominador
        int numerator = Integer.parseInt(parts[0]);  // Convertim el numerador a enter
        int denominator = Integer.parseInt(parts[1]);  // Convertim el denominador a enter
        
        if (denominator == 0) return "No vàlid";  // Comprovem divisió per zero
        if (numerator == 0) return "Zero";  // Cas especial per a numerador zero
        return processFraction(numerator, denominator);  // Cridem el mètode principal
    }

    /**
     * Processa una fracció i la converteix a paraules.
     * @param num El numerador.
     * @param den El denominador.
     * @return La representació en paraules, capitalitzada.
     */
    public static String processFraction(int num, int den) {
        StringBuilder result = new StringBuilder();  // Utilitzem StringBuilder per construir el resultat
        
        if (num >= den && den != 1) {  // Si és una fracció impropia
            int whole = num / den;  // Calcula la part entera
            int remainder = num % den;  // Calcula el residu
            result.append(numberToWords(whole));  // Afegeix la part entera en paraules
            if (remainder > 0) {  // Si hi ha residu, processa la fracció restant
                result.append(", ").append(processFraction(remainder, den).toLowerCase());
            }
            return capitalize(result.toString());  // Retorna el resultat capitalitzat
        }
        
        String numtxt = numberToWords(num);  // Converteix el numerador a paraules
        String denomtxt = getDenominator(den, num > 1);  // Obté el denominador en forma ordinal
        if (num == 1 && denomtxt.startsWith("un ")) {  // Cas especial per a "un" + ordinal
            return capitalize(denomtxt);
        }
        return capitalize(numtxt + " " + denomtxt);  // Combina i capitalitza
    }

    /**
     * Obté la representació en paraules del denominador.
     * @param den El denominador.
     * @param plural Indica si ha de ser en plural.
     * @return La cadena del denominador en paraules.
     */
    public static String getDenominator(int den, boolean plural) {
        if (den < 2) return "";  // Cas base per a denominadors invàlids
        if (den <= 19) return plural ? pluralForms[den - 2] : singular[den - 2];  // Utilitza arrays per a valors petits
        
        if (den == 1000) return plural ? "mil·lèsims" : "mil·lèsim";
        if (den == 1000000) return plural ? "milionèsims" : "milionèsim";
        if (den % 1000000 == 0) {  // Cas per a múltiples de 1.000.000
            int milio = den / 1000000;
            return plural ? numberToWords(milio) + " milionèsims" : numberToWords(milio) + " milionèsim";
        }
        if (den == 1001000) return plural ? "un milió mil·lèsims" : "un milió mil·lèsim";
        if (den % 1000 == 0) {  // Cas per a múltiples de 1.000
            int mil = den / 1000;
            return plural ? numberToWords(mil) + " mil·lèsims" : numberToWords(mil) + " mil·lèsim";
        }
        return getOrdinalForDen(den, plural);  // Crida al mètode per a casos generals
    }

    /**
     * Genera la forma ordinal per a denominadors grans.
     * @param n El número a convertir.
     * @param plural Indica si ha de ser en plural.
     * @return La cadena ordinal.
     */
    private static String getOrdinalForDen(int n, boolean plural) {
        if (n > 1000000 && n % 1000000 == 1) {  // Cas especial per a nombres com 1.000.001
            int millions = n / 1000000;
            String millionsPart = (millions == 1) ? "milió" : numberToWords(millions) + " milió";
            if (plural) return millionsPart + " unens";
            else return millionsPart + " unè";
        }
        
        String pre = numberToWords(n);  // Converteix el número a paraules
        if (pre.endsWith("a")) pre = pre.substring(0, pre.length() - 1);  // Ajust gramatical
        if (n != 9 && n != 19 && pre.endsWith("nou")) {
            pre = pre.substring(0, pre.length() - 3) + "nov";  // Ajust per a "nou"
        }
        if (pre.endsWith("cinc")) {
            pre = pre.substring(0, pre.length() - 4) + "cinqu";  // Ajust per a "cinc"
        }
        
        if (plural) {
            if (pre.endsWith("e") && !pre.endsWith("ue")) {
                pre = pre.substring(0, pre.length() - 1);  // Elimina "e" per a plurals
            }
            if (n % 10 == 0) {
                if (pre.endsWith("deu")) return pre.substring(0, pre.length() - 3) + "dècims";
            }
            return pre + "ens";  // Afegeix sufix plural
        } else {
            if (n % 10 == 0) {
                if (pre.endsWith("deu")) return pre.substring(0, pre.length() - 3) + "dècim";
            }
            if (n % 100 == 0) {
                if (pre.endsWith("cents")) return pre + "èsim";
                if (pre.endsWith("cent"))  return pre + "èsim";
                if (pre.endsWith("mil"))   return pre + "lèsim";
                if (pre.endsWith("milió")) return pre.substring(0, pre.length() - 1) + "onèsim";
                return pre + "èsim";  // Afegeix sufix singular per a centenes
            }
            return pre + "è";  // Afegeix sufix singular general
        }
    }

    /**
     * Converteix un número enter a paraules en català.
     * @param num El número a convertir.
     * @return La representació en paraules.
     */
    public static String numberToWords(int num) {
        if (num == 0) return "zero";  // Cas base
        if (num < 20) return UNITS[num];  // Utilitza array UNITS
        if (num < 100) {
            int t = num / 10;  // Calcula la desena
            int u = num % 10;  // Calcula la unitat
            if (u == 0) return TENS[t];
            String sep = (t == 2) ? "-i-" : "-";  // Separador especial per a "vint"
            return TENS[t] + sep + UNITS[u];
        }
        if (num < 1000) {
            int c = num / 100;  // Calcula la centena
            int r = num % 100;
            String res = (c == 1 ? "cent" : UNITS[c] + "-cents");
            if (r > 0) res += " " + numberToWords(r);  // Recursió per al resta
            return res;
        }
        if (num < 1000000) {
            int mil = num / 1000;
            int r = num % 1000;
            String res = (mil == 1 ? "mil" : numberToWords(mil) + " mil");
            if (r > 0) res += " " + numberToWords(r);
            return res;
        }
        int mil = num / 1000000;
        int r = num % 1000000;
        String res = (mil == 1 ? "un milió" : numberToWords(mil) + " milions");
        if (r > 0) res += " " + numberToWords(r);
        return res;
    }

    /**
     * Capitalitza la primera lletra d'una cadena.
     * @param s La cadena a capitalitzar.
     * @return La cadena capitalitzada.
     */
    public static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;  // Comprovació de validesa
        return s.substring(0, 1).toUpperCase() + s.substring(1);  // Capitalitza la primera lletra
    }
}
