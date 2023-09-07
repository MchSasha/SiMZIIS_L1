import java.util.Random;

public class Generator {
    public static final String ALPHABET_LATIN_LOWER = "abcdifghijklmnopqrstuvwxyz";
    public static final String ALPHABET_NUMBERS = "0123456789";

    public static final String ALPHABET = ALPHABET_LATIN_LOWER + ALPHABET_NUMBERS;

    public static String generateString(int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randIndex = random.nextInt(0, ALPHABET.length());

            result.append(ALPHABET.charAt(randIndex));
        }

        return result.toString();
    }
}


/*
* генерация строки с заданной пользователем длиной, состоящей из символов алфавита
*  в соответствии с вариантом задания (использовать функции rand( ), srand( ) и
*  инициализацию от таймера);
*
*6) Латиница, строчные и арабские цифры.
*
* */