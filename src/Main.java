import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> list = new ArrayList<>();

        System.out.println("Statistics Calculator\n1) Enter Data \n2) Press Enter\n3) Finished? Press Enter");
    
        while (true) {
            String input = scanner.nextLine();
            
            if (input.contains(" ") || input.equals("")) {
                break;
            }

            double number = Double.parseDouble(input);
            list.add(number);
        }

        Statistics stats = new Statistics(list);
        
        
        System.out.println("================================");
        System.out.println("        STATISTICS REPORT        ");
        System.out.println("================================");

        System.out.println("Data:               " + stats.list);
        System.out.println("Count:              " + stats.count());
        System.out.println("Sum:                " + stats.sum());
        System.out.println("Mean:               " + stats.mean());
        System.out.println("Median:             " + stats.median());
        System.out.println("Mode:               " + stats.mode());
        System.out.println("Range:              " + stats.range());
        System.out.println("Q1:                 " + stats.q1());
        System.out.println("Q3:                 " + stats.q3());
        System.out.println("IQR:                " + stats.iqr());
        System.out.println("Standard Deviation: " + stats.standardDeviation());

        System.out.println("--------------------------------");
        System.out.println("Five Number Summary");
        System.out.println("--------------------------------");

        System.out.println("Minimum:            " + stats.list.get(0));
        System.out.println("Q1:                 " + stats.q1());
        System.out.println("Median:             " + stats.median());
        System.out.println("Q3:                 " + stats.q3());
        System.out.println("Maximum:            " + stats.list.get(stats.count() - 1));

        System.out.println("--------------------------------");
        System.out.println("Z-Scores");
        System.out.println("--------------------------------");

        for (Double[] z : stats.zScores()) {
            System.out.printf("Value: %8.2f    Z-Score: %8.2f%n", z[0], z[1]);
        }

        System.out.println("================================");
            }
}