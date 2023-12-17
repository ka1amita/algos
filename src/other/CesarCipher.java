package src.other;

public class CesarCipher {
    public static void main(String[] args) {
        String message = "Itaa bt hdbtiwxcv xcitgthixcv pqdji rxewtgh.";
        int secret = 0;
        String secretMessage = getCesarCipher(message, secret);
        System.out.print(secretMessage);
        System.out.println(-27 % 26);
    }

    private static String getCesarCipher(String message, int secret) {
        // int minCode = (int) 'A';
        // int maxCode = (int) 'Z';
        // int span = maxCode - minCode + 1;
        int span = 26;
        String secretMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char secretLetter;
            char letter = message.charAt(i);
            if (Character.isLetter(letter)) {
                if (Character.isUpperCase(letter)) {
                    int secretLetterCode = ( letter - 'A' + ( secret % span + span ) ) % span + 'A';
                    secretLetter = (char) secretLetterCode;
                } else {
                    int secretLetterCode = ( letter - 'a' + ( secret % span + span ) ) % span + 'a';
                    secretLetter = (char) secretLetterCode;
                }
                secretMessage += secretLetter;
            } else {
                secretMessage += letter;
            }
        }
        return secretMessage;
    }
}
