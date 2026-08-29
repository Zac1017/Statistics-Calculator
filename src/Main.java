import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> list = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            
            if (input.contains(" ")) {
                break;
            }

            double number = Double.parseDouble(input);
            list.add(number);
        }

        Statistics stats = new Statistics(list);
        System.out.println(stats.median());
    }
}