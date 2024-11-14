package Lab5;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Пример данных (взяты из предыдущего теста)
        int[] sizes = {10, 100, 1000, 10000, 100000};
        double[] addTimes = {21200, 3312, 785, 437, 273};  // Примерные данные для добавления
        double[] removeTimes = {13200, 2470, 1265, 1332, 4822};  // Примерные данные для удаления

        // Создание датасета
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < sizes.length; i++) {
            dataset.addValue(addTimes[i], "Add Time", String.valueOf(sizes[i]));
            dataset.addValue(removeTimes[i], "Remove Time", String.valueOf(sizes[i]));
        }

        // Создание графика
        // Создание графика
        JFreeChart chart = ChartFactory.createLineChart(
                "Time vs. Number of Elements",  // Заголовок
                "Number of Elements",  // Ось X
                "Time (ns)",  // Ось Y
                dataset,  // Данные
                PlotOrientation.VERTICAL,  // Ориентация графика
                true,  // Показывать легенду
                true,  // Показывать подсказки
                false  // Без URL
        );
        // Отображение графика
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}

