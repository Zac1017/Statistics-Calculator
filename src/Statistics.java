import java.util.*;

public class Statistics {
    List<Double> unsortedList;
    List<Double> list;
    int size;
    public Statistics(List<Double> list) {
        this.unsortedList = list;
        this.list = sort();
        this.size = list.size();
    }
    public double mean(){
        double mean = 0;
        for (double point : list) {
            mean += point;
        }
        return mean / size;
    }

    public double median(){
        int middle = size / 2;

        if (size % 2 == 1) {
            return list.get(middle);
        }
        return (list.get(middle - 1) + list.get(middle)) / 2;
    }

    public double mode(){
        double topRep = 0;
        double mode = list.get(0);

        for (double point : list){
            int rep = 0;

            for (double other : list){
                if (point == other) {
                    rep++;
                }
            }

            if (rep > topRep) {
                topRep = rep;
                mode = point;
            }
        }
        
        if (topRep <= 1) {
            return Double.NaN;
        }
        return mode;
    }

    public List<Double> sort(){
      list = new ArrayList<>(unsortedList);
      list.sort(null);
      return list;
    }

    public double range(){
        return list.get(list.size() - 1) - list.get(0);
    }

    public double q1(){
        int middle = size / 2;
        List<Double> firstHalf = list.subList(0, middle);

        int halfMiddle = firstHalf.size() / 2;

        if (firstHalf.size() % 2 == 1) {
            return firstHalf.get(halfMiddle);
        }

        return (firstHalf.get(halfMiddle - 1) + firstHalf.get(halfMiddle)) / 2;
    }

    public double q3(){
        int middle = size / 2;
        List<Double> secondHalf = list.subList(middle, size);

        int halfMiddle = secondHalf.size() / 2;

        if (secondHalf.size() % 2 == 1) {
            return secondHalf.get(halfMiddle);
        }

        return (secondHalf.get(halfMiddle - 1) + secondHalf.get(halfMiddle)) / 2;
    }

    public double iqr(){
        return q3() - q1();
    }
}

/*
mean, median, mode, range, IQR, standard deviation, q1, q3, sum, count, z-scores
five number summary -> min, q1, median, q3, max
 */