import java.util.*;

public class Statistics {
    List<Double> unsortedList;
    List<Double> list;
    double size;
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
        if (size % 2 == 1) {
            return list.get(middle);
        }
        return (list.get(middle - 1) + list.get(middle)) / 2;
    }

    public double mode(){
        return 0.0;
    }

    public void sort(){
      
    }
}

/*
mean, median, mode, range, IQR, standard deviation, q1, q3, sum, count, z-scores
five number summary -> min, q1, median, q3, max
 */