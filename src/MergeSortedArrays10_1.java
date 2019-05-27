import java.util.*;

public class MergeSortedArrays10_1 {

    public static class ArrayEntry {
        int val;
        List<Integer> array;

        public ArrayEntry(int val, List<Integer> array) {
            this.val = val;
            this.array = array;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public List<Integer> getArray() {
            return array;
        }

        public void setArray(List<Integer> array) {
            this.array = array;
        }
    }

    public static List<Integer> mergeSortedArrays(List<List<Integer>> lists) {
        Map<List<Integer>, Integer> map = new HashMap<>(); //store <list, currIndex> pair
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<ArrayEntry> priorityQueue = new PriorityQueue<>(lists.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });

        for (List<Integer> list : lists) {
            map.put(list, 0);
            ArrayEntry arrayEntry = new ArrayEntry(list.get(0), list);
            priorityQueue.add(arrayEntry); //add to the priority queue
        }

        while (!priorityQueue.isEmpty()) {
            ArrayEntry arrayEntry = priorityQueue.poll(); //entry with the minimum val
            sortedList.add(arrayEntry.val);
            List<Integer> currList = arrayEntry.getArray();
            map.put(currList, map.get(currList) + 1); //increment currIndex for the list
            if (map.get(currList) > currList.size() - 1) { //if there is no more element in the currList (has reached the end)
                continue;
            }

            int val = currList.get(map.get(currList)); //get val at currIndex on the list
            ArrayEntry entry = new ArrayEntry(val, currList);
            priorityQueue.add(entry);
        }

        return sortedList;
    }

    public static void main(String[] args) {
        Integer[] arrayOne = new Integer[] {3,5,7};
        Integer[] arrayTwo = new Integer[] {0,6};
        Integer[] arrayThree = new Integer[] {0,6,28};

        List<Integer> listOne = Arrays.asList(arrayOne);
        List<Integer> listTwo = Arrays.asList(arrayTwo);
        List<Integer> listThree = Arrays.asList(arrayThree);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(listOne);
        lists.add(listTwo);
        lists.add(listThree);

        System.out.println(mergeSortedArrays(lists));
    }
}
