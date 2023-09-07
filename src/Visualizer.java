import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Visualizer {
    public static final String VISUALIZATION_CHAR = "#";

    public static String getCharFrequencyDistributionVisualization(String string) {
        StringBuilder result = new StringBuilder();

        Map<Character, Integer> charFrequencyMap = getCharFrequencyMap(string);

        for (Character character : charFrequencyMap.keySet()) {
            StringBuilder certainCharFrequencyVisualization = new StringBuilder().append(character).append(' ');

            int frequency = charFrequencyMap.get(character);
            certainCharFrequencyVisualization
                    .append(VISUALIZATION_CHAR.repeat(frequency))
                    .append('\n');

            result.append(certainCharFrequencyVisualization);
        }

        return result.toString();
    }

    private static Map<Character, Integer> getCharFrequencyMap(String string) {

        return string.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(
                        Function.identity(),
                        ch -> 1,
                        Integer::sum
                ));
    }

}
