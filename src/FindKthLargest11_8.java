import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FindKthLargest11_8 {
    public static int findKthLargest(List<Integer> list,  int k) {
        return findKthLargestHelp(list, k, 0, list.size()-1);
    }

    public static int findKthLargestHelp(List<Integer> list, int k, int start, int end) {
        Random random = new Random();

        while (start <= end) {
            int range = end - start + 1;
            int randomIndex = random.nextInt(range) + start;

            //switch random index's value with the end index's value
            int temp = list.get(end);
            list.set(end, list.get(randomIndex));
            list.set(randomIndex, temp);

            int pointer = start - 1;
            int pivot = list.get(end);
            for (int i = start; i < end; i++) {
                if (list.get(i) <= pivot) {
                    pointer++; //increment the pointer
                    temp = list.get(i);
                    //switch pointer and the currIndex
                    list.set(i, list.get(pointer));
                    list.set(pointer, temp);
                }
            }
            pointer++;
            list.set(end, list.get(pointer));
            list.set(pointer, pivot);
            int rank = end - pointer + 1;
            if (rank == k) { //the pivot is at kth largest so done
                return list.get(pointer);
            } else if (rank > k) {
                start = pointer + 1;
            } else {
                end = pointer - 1;
                k -= rank;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {3,2,1,5,4};
        List<Integer> list = Arrays.asList(array);

        System.out.println(findKthLargest(list, 1));
    }
}
