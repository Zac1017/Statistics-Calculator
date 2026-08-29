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

        List<Double> secondHalf;

        if (size % 2 == 1) {
            secondHalf = list.subList(middle + 1, size);
        } else {
            secondHalf = list.subList(middle, size);
        }

        int halfMiddle = secondHalf.size() / 2;

        if (secondHalf.size() % 2 == 1) {
            return secondHalf.get(halfMiddle);
        }

        return (secondHalf.get(halfMiddle - 1) + secondHalf.get(halfMiddle)) / 2;
    }

    public double iqr(){
        return q3() - q1();
    }

    //Uses Bessel's Correction (n-1) in the denom
    public double standardDeviation(){
        double mean = mean();
        double sumSquareDifference = 0;
        for (double point : list){
            sumSquareDifference += Math.pow(point - mean, 2);
        }

        return Math.sqrt(sumSquareDifference / (size - 1));
    }

    public double sum(){
        double sum = 0;
        for (double point : list){
            sum += point;
        }
        return sum;
    }

    public List<Double[]> zScores(){
        double sd = standardDeviation();
        double mean = mean();
        List<Double[]> listZ = new ArrayList<>();

        for (double point : list){
            listZ.add(new Double[] {point, (point - mean) / sd});
        }

        return listZ;
    }

    public int count(){
        return size;
    }
  
}
/*
mean, median, mode, range, IQR, standard deviation, q1, q3, sum, count, z-scores
five number summary -> min, q1, median, q3, max
 */