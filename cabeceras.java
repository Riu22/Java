import java.util.Scanner;

public class cabeceras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese la cabecera IP (en formato binario o hexadecimal): ");
        String inputHeader = scanner.nextLine();

        if (inputHeader.matches("[01]+")) {
            inputHeader = binarioAHexadecimal(inputHeader);
            System.out.println("Entrada en formato binario convertida a hexadecimal: " + inputHeader);
        } else if (!inputHeader.matches("[0-9a-fA-F]+")) {
            System.out.println("Formato no válido. Asegúrese de que la entrada sea binaria o hexadecimal.");
            return;
        }

        if (inputHeader.length() % 2 != 0) {
            System.out.println("Cabecera IP no válida. Asegúrese de que esté en formato hexadecimal.");
            return;
        }

        byte[] bytes = hexStringToByteArray(inputHeader);

        if (bytes.length < 20) {
            System.out.println("La cabecera IP es demasiado corta para ser válida.");
            return;
        }

        mostrarVersion(bytes);
        mostrarLongitudCabecera(bytes);
        mostrarTipoServicio(bytes);
        mostrarLongitudTotal(bytes);
        mostrarIdentificacion(bytes);
        mostrarBanderasYDesplazamiento(bytes);
        mostrarTiempoVida(bytes);
        mostrarProtocolo(bytes);
        mostrarSumaVerificacion(bytes);
        mostrarIPOrigen(bytes);
        mostrarIPDestino(bytes);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static String binarioAHexadecimal(String binario) {
        while (binario.length() % 8 != 0) {
            binario = "0" + binario;
        }

        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < binario.length(); i += 8) {
            String byteStr = binario.substring(i, i + 8);
            int byteVal = Integer.parseInt(byteStr, 2);
            hexString.append(String.format("%02X", byteVal));
        }
        return hexString.toString();
    }

    public static void mostrarVersion(byte[] bytes) {
        int version = (bytes[0] >> 4) & 0x0F;
        System.out.println("Versión: IPv" + version);
    }

    public static void mostrarLongitudCabecera(byte[] bytes) {
        int ihl = bytes[0] & 0x0F;
        System.out.println("Longitud de la cabecera: " + ihl * 4 + " bytes");
    }

    public static void mostrarTipoServicio(byte[] bytes) {
        int tos = bytes[1] & 0xFF;
        System.out.println("Tipo de servicio: " + Integer.toHexString(tos));
    }

    public static void mostrarLongitudTotal(byte[] bytes) {
        int totalLength = ((bytes[2] & 0xFF) << 8) | (bytes[3] & 0xFF);
        System.out.println("Longitud total: " + totalLength + " bytes");
    }

    public static void mostrarIdentificacion(byte[] bytes) {
        int identification = ((bytes[4] & 0xFF) << 8) | (bytes[5] & 0xFF);
        System.out.println("Identificación: " + identification);
    }

    public static void mostrarBanderasYDesplazamiento(byte[] bytes) {
        int flagsAndOffset = ((bytes[6] & 0xFF) << 8) | (bytes[7] & 0xFF);
        int flags = (flagsAndOffset >> 13) & 0x07;
        int fragmentOffset = flagsAndOffset & 0x1FFF;
        System.out.println("Banderas: " + flags);
        System.out.println("Desplazamiento de fragmento: " + fragmentOffset);
    }

    public static void mostrarTiempoVida(byte[] bytes) {
        int ttl = bytes[8] & 0xFF;
        System.out.println("Tiempo de vida: " + ttl);
    }

    public static void mostrarProtocolo(byte[] bytes) {
        int protocol = bytes[9] & 0xFF;
        System.out.println("Protocolo: " + protocol);
    }

    public static void mostrarSumaVerificacion(byte[] bytes) {
        int checksum = ((bytes[10] & 0xFF) << 8) | (bytes[11] & 0xFF);
        System.out.println("Suma de verificación: " + Integer.toHexString(checksum));
    }

    public static void mostrarIPOrigen(byte[] bytes) {
        String sourceIP = String.format("%d.%d.%d.%d", bytes[12] & 0xFF, bytes[13] & 0xFF, bytes[14] & 0xFF, bytes[15] & 0xFF);
        System.out.println("Dirección IP de origen: " + sourceIP);
    }

    public static void mostrarIPDestino(byte[] bytes) {
        String destIP = String.format("%d.%d.%d.%d", bytes[16] & 0xFF, bytes[17] & 0xFF, bytes[18] & 0xFF, bytes[19] & 0xFF);
        System.out.println("Dirección IP de destino: " + destIP);
    }
}
