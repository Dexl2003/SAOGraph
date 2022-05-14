import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class XYLineChartExample extends JFrame {
    private static final long serialVersionUID = 6294689542092367723L;

    public XYLineChartExample(String title) {
        super(title);

        // Create dataset
        XYDataset dataset = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Отношение размера массива к времени его сортировки",
                "Размер массива",
                "Время в нс",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        // Create Panel
        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }


    public static long[] graf = new long[5];
    public static long[] ticket = new long[5];

    //Enter data
    public static void data () {
        SortArrays sort = new SortArrays();
        System.out.println("Enter the number of array elements");
        Scanner in = new Scanner(System.in);


        for (int i = 0; i < 5; i++) {
            int size = in.nextInt();
            graf[i] = size;
            ticket[i] = sort.genArray(graf[i]);
        }

        System.out.println(Arrays.toString(graf));
        System.out.println(Arrays.toString(ticket));

    }


    private XYDataset createDataset() {
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries series = new XYSeries("");

        for (int i = 0; i < graf.length; i++) {
            series.add(graf[i],ticket[i]);
        }
        //Add series to dataset
        dataset.addSeries(series);

        return dataset;
    }

    public static void main(String[] args) {

        data();

        SwingUtilities.invokeLater(() -> {
            XYLineChartExample example = new XYLineChartExample("XY Chart Example | BORAJI.COM");
            example.setSize(800, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });


    }
}
