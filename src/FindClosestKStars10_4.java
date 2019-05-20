import java.util.*;

public class FindClosestKStars10_4 {

    public static List<Star> findClosestKStars(Iterator<Star> stars, int k) {
        PriorityQueue<Star> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder()); //set initial capacity to k

        while (stars.hasNext()) {
            Star currStar = stars.next();
            if (maxHeap.size() >= k) {
                if (maxHeap.peek().getDistance() >= currStar.getDistance()) {
                    maxHeap.poll();
                    maxHeap.add(currStar);
                }
            } else {
                maxHeap.add(currStar);
            }

        }

        return new ArrayList<>(maxHeap);
    }

    public static void main(String[] args) {
        Star starOne = new Star(1,2,3);
        Star starTwo = new Star(0,5,4);
        Star starThree = new Star(5,1,2);
        Star starFour = new Star(1,2,2);
        Star starFive = new Star(8,1,2);
        Star starSix = new Star(5,5,5);

        List<Star> stars = new ArrayList<>();
        stars.add(starOne);
        stars.add(starTwo);
        stars.add(starThree);
        stars.add(starFour);
        stars.add(starFive);
        stars.add(starSix);

        System.out.println(findClosestKStars(stars.iterator(), 3).toString());
    }
}
