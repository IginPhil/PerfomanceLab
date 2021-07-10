import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {

    ArrayList<Double> doubleArrayList = new ArrayList<>();
    File file = new File("C:\\java - task1.jar.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        doubleArrayList.add(Double.valueOf(line));
      }
    }
    System.out
        .format("Перцентель: " + "%.2f%n", percentile(doubleArrayList, 90)); // Вывод перцентеля
    double medianLenght = doubleArrayList.size();
    if ((medianLenght % 2) == 0) {
      System.out.format("Медиана: %.2f%n", medianLenght / 2); // Если количество наблюдений четное
    } else {
      if ((medianLenght % 1) == 0) {
        System.out
            .format("Медиана: %.2f%n",
                +(medianLenght + 1) / 2); // Если количество наблюдений нечетное
      }
    }
    ArrayList<Double> num = doubleArrayList;
    Collections.sort(num);
    double max = Collections.max(num);
    System.out.format("Максимальное значение: %.2f%n", +max);
    double min = Collections.min(num);
    System.out.format("Минимальное  значение: %.2f%n", +min);

    double sum = 0;
    for (int i = 0; i < doubleArrayList.size(); i++) {
      sum = sum + i;
    }
    System.out.format("Среднее арифметическое чисел равно: %.2f%n", +sum / doubleArrayList.size());
  }

  public static double percentile(List<Double> latencies, double percentile) {
    Collections.sort(latencies);
    int index = (int) (percentile / 100.0 * latencies.size());
    return latencies.get(index - 1);
  }
}
