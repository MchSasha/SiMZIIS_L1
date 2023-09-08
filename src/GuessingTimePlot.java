import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
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
    public GuessingTimePlot(String title) {
        super(title);

        // Create a dataset
        XYSeries series = new XYSeries("Data Series");
        for (int x = 1; x < 20; x++) {
            //series.add(x, Guesser.getAverageGuessingTime(Generator.generateString(x), Generator.ALPHABET)); // Add your own data here
        }
        XYSeriesCollection dataset = new XYSeriesCollection(series);

        // Create a chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "XY Plot Example", // Chart title
                "X Axis", // X-axis label
                "Y Axis", // Y-axis label
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
