public class MergeTwoSortedLists7_1 {

    public static ListNode<Integer> mergeTwoSortedLists(ListNode<Integer> first, ListNode<Integer> second) {
        ListNode dummyHead = new ListNode(0);
        ListNode returnHead = dummyHead;

        while (first != null && second != null) {
            if (first.data < second.data) {
                dummyHead.next = first;
                first = first.next;
            } else {
                dummyHead.next = second;
                second = second.next;
            }
            dummyHead = dummyHead.next;
        }

        dummyHead.next = first != null ? first : second;
        return returnHead.next;
    }


    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(1);
        l1.next = new ListNode<>(2);
        l1.next.next = new ListNode<>(5);
        l1.next.next.next = new ListNode<>(7);

        ListNode l2 = new ListNode<>(3);
        l2.next = new ListNode<>(11);

        System.out.println(ListNode.myToString(mergeTwoSortedLists(l1, l2)));

    }
}
