import java.util.*;

public class OnlineMedian10_5 {

    public static List<Double> onlineMedian(Iterator<Integer> iterator) {
        final int INITIAL_CAPACITY = 16;
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(INITIAL_CAPACITY, Collections.reverseOrder());
        PriorityQueue<Integer> upperHalf = new PriorityQueue<>(INITIAL_CAPACITY);
        List<Double> medians = new ArrayList<>();

        //first insert to upperhalf, then mvoe to lower half if necessary
        while (iterator.hasNext()) {
            upperHalf.add(iterator.next());
            if (upperHalf.size() - 1 > lowerHalf.size()) { //up to one element more in the upper half
                lowerHalf.add(upperHalf.poll()); //move the min to the lower half
            }

            double median = 0;
            if (upperHalf.size() == lowerHalf.size()) { //even number of elements, so median is the average of two elements
                median = ((double) upperHalf.peek() + (double) lowerHalf.peek()) / 2.0;
            } else {
                median = upperHalf.peek();
            }
            medians.add(median);
        }

        return medians;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,0,3,5,2,0,1};
        List<Integer> list = Arrays.asList(array);
        System.out.println(onlineMedian(list.iterator()));
    }
}
