package server;

import java.security.SecureRandom;

public class methods {
    public String rfc (String nombre, String apellidoP, String apellidoM, int año, String mes, int dia) {
        String añoS = Integer.toString(año);
        String diaS = Integer.toString(dia);

        String letraNom = nombre.substring(0,1);
        String letraApeP = apellidoP.substring(0,2);
        String letraApeM = apellidoM.substring(0,1);
        String numAño = añoS.substring(2,4);

        String randomXD = methods.generateRandomString(3);

        String rfcT = letraApeP+letraApeM+letraNom+numAño+mes+diaS+randomXD;

        return rfcT.toUpperCase();
    }

    public static String generateRandomString(int length) {
        // Puede personalizar los personajes que desea agregar a
        // las cadenas al azar
        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        String NUMBER = "0123456789";

        String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
        SecureRandom random = new SecureRandom();

        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // 0-62 (exclusive), retornos aleatorios 0-61
            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

            sb.append(rndChar);
        }

        return sb.toString();
    }

}




