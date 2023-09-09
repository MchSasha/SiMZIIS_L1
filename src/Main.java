import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String s = Generator.generateString(10);

        System.out.println("Сгенерированный пароль длины "+ s.length() + " -- " + s + '\n');

        System.out.println("Визуализация частотного распределения\n" + Visualizer.getCharFrequencyDistributionVisualization(s));

        System.out.println("Среднее время подбора пароля в секундах при "+ Guesser.GUESSES_PER_SECOND +
                " переборов в секунду  -- " + Guesser.getAverageGuessingTime(s, Generator.ALPHABET));


        SwingUtilities.invokeLater(() -> {
            JFrame frame = new GuessingTimePlot(10);
            frame.pack();
            frame.setVisible(true);
        });
    }
}

