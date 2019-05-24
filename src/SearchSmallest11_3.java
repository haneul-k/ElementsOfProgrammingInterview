import java.util.Arrays;
import java.util.List;

public class SearchSmallest11_3 {
    public static int searchSmallest(List<Integer> list) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            //found the smallest
            if (list.get(mid) < list.get((mid+1) % list.size()) && list.get(mid) < list.get(mid-1 >= 0 ? mid-1 : mid-1+list.size())) {
                return mid;
            }

            if (list.get(mid) < list.get(end)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {6,7,8,9,1,2,3,4,5};
        Integer[] arrayTwo = new Integer[] {1,2,3,4,5,6,7,8,9};
        Integer[] arrayThree = new Integer[] {9,1,2,3,4,5};
        Integer[] arrayFour = new Integer[] {2,3,4,5,6,1};

        System.out.println(searchSmallest(Arrays.asList(array)));
        System.out.println(searchSmallest(Arrays.asList(arrayTwo)));
        System.out.println(searchSmallest(Arrays.asList(arrayThree)));
        System.out.println(searchSmallest(Arrays.asList(arrayFour)));
    }
}
