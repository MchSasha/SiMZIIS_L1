import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GuessingTimePlot extends JFrame {
    public static final int SECONDS_TO_YEARS = 60 * 60 * 24 * 365;
    public static final String TITLE = "Average password guessing time";


    public GuessingTimePlot(int maxPasswordLength) {
        super(TITLE);

        // Create a dataset
        XYSeries series = new XYSeries("Среднее время подбора пароля");
        for (int x = 1; x <= maxPasswordLength; x++) {
            series.add(x, Guesser.getAverageGuessingTime(
                    Generator.generateString(x),
                    Generator.ALPHABET) / SECONDS_TO_YEARS); // Add your own data here
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create a chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Зависимость среднего времени подбора пароля от его длины", // Chart title
                "Длина пароля", // X-axis label
                "Среднее время подбора, года", // Y-axis label
                dataset, // Dataset
                PlotOrientation.VERTICAL,
                true, // Show legend
                true, // Use tooltips
                false // Configure chart to generate URLs?
        );

        // Customize the plot area (optional)
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        plot.setRenderer(renderer);

        // Set the X-axis to display integer values only
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // Create a JPanel to hold the chart
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(800, 600));
        setContentPane(chartPanel);

        // Handle window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
