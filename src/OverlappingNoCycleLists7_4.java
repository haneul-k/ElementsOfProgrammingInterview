public class OverlappingNoCycleLists7_4 {

    public static ListNode<Integer> overlappingNoCycleLists(ListNode<Integer> first, ListNode<Integer> second) {
        //get the length of the nodes
        int firstLength = 0, secondLength = 0;

        ListNode<Integer> firstHead = first, secondHead = second;
        while (first != null) {
            first = first.next;
            firstLength++;
        }

        while (second != null) {
            second = second.next;
            secondLength++;
        }

        //determine which list is shorter and longer
        ListNode<Integer> longerNode = firstLength > secondLength ? firstHead : secondHead;
        ListNode<Integer> shorterNode = longerNode == firstHead ? secondHead : firstHead;

        int longerLength = firstLength > secondLength ? firstLength : secondLength;
        int shorterLength = longerLength == firstLength ? secondLength : firstLength;

        //advance longer length
        while (longerLength > shorterLength) {
            longerNode = longerNode.next;
            longerLength--;
        }

        while (longerNode != null) {
            if (longerNode == shorterNode) {
                return longerNode;
            }
            longerNode = longerNode.next;
            shorterNode = shorterNode.next;
        }

        return null;
    }


    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode(0);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);

        ListNode<Integer> l2 = new ListNode<>(5);
        l2.next = new ListNode<>(6);
        l2.next.next = l1.next.next.next;

        System.out.println(overlappingNoCycleLists(l1, l2).data);
    }
}
