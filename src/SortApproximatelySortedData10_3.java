import java.util.*;

public class SortApproximatelySortedData10_3 {

    public static List<Integer> sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k+1);

        while (sequence.hasNext()) {
            priorityQueue.add(sequence.next());
            if (priorityQueue.size() > k) {
                sortedList.add(priorityQueue.poll());
            }
        }

        while (!priorityQueue.isEmpty()) {
            sortedList.add(priorityQueue.poll());
        }

        return sortedList;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {3,-1,2,6,4,5,8};
        List<Integer> list = Arrays.asList(array);
        System.out.println(sortApproximatelySortedData(list.iterator(), 3));

        Integer[] arrayTwo = new Integer[] {3,-1,2};
        List<Integer> listTwo = Arrays.asList(arrayTwo);
        System.out.println(sortApproximatelySortedData(listTwo.iterator(), 3));
    }
}
