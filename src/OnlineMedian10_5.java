import java.util.*;

public class OnlineMedian10_5 {

    public static List<Double> onlineMedian(Iterator<Integer> iterator) {
        final int INITIAL_CAPACITY = 16;
        PriorityQueue<Integer> lowerHalf = new PriorityQueue<>(INITIAL_CAPACITY, Collections.reverseOrder()); //this is maxheap
        PriorityQueue<Integer> upperHalf = new PriorityQueue<>(INITIAL_CAPACITY); //this is minheap
        List<Double> medians = new ArrayList<>();

        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (!upperHalf.isEmpty() && upperHalf.peek() < val) {
                upperHalf.add(val);
            } else {
                lowerHalf.add(val);
            }

            if (lowerHalf.size() - upperHalf.size() > 1) { //lowerhalf and upperhalf not equally divided
                upperHalf.add(lowerHalf.poll());
            } else if (upperHalf.size() > lowerHalf.size()) {
                lowerHalf.add(upperHalf.poll());
            }
            double median = (lowerHalf.size() > upperHalf.size() ? (double)lowerHalf.peek() : (double)((upperHalf.peek() + lowerHalf.peek())) / 2);
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
