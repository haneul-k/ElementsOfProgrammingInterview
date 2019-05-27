import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Driver {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //add first vals to the priority queue
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        System.out.println(priorityQueue.poll());
    }
}
