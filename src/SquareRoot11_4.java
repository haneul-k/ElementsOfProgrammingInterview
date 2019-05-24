public class SquareRoot11_4 {

    public static int squareRoot(int k) {
        int start = 0, end = k;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid <= k && (mid + 1) * (mid + 1) > k) {
                return mid;
            } else if (mid * mid > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(16));
        System.out.println(squareRoot(300));
        System.out.println(squareRoot(1));
    }
}
