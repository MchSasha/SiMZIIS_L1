public class Guesser {
    public static float GUESSES_PER_SECOND = 10000000;

    public static float getAverageGuessingTime(String password, String alphabet) {

        double combinations = Math.pow(alphabet.length(), password.length());

        return (float) combinations/GUESSES_PER_SECOND;
    }
}
