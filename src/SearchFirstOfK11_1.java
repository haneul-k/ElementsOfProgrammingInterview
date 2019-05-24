import java.util.Arrays;
import java.util.List;

public class SearchFirstOfK11_1 {

    public static int searchFirstOfK(List<Integer> list, int val) {
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2; //to prevent overflow
            if (list.get(mid) == val) {
                if (mid == 0 || list.get(mid-1) != val) { //is the leftmost value that is equal to val
                    return mid;
                } else {
                    end = mid - 1;
                }
            } else if (list.get(mid-1) < val) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[] {-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(searchFirstOfK(Arrays.asList(array), 108));
        System.out.println(searchFirstOfK(Arrays.asList(array), 285));
    }
}
