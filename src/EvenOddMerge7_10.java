public class EvenOddMerge7_10 {

    public static ListNode<Integer> evenOddMerge(ListNode<Integer> list) {
        //check for single node list
        if (list == null || list.next == null) {
            return list;
        }

        ListNode<Integer> iterHead = list, oddHead = list.next, oddLast = list.next;
        while (oddLast != null && oddLast.next != null) {
            iterHead.next = oddLast.next;
            oddLast.next = iterHead.next.next;
            iterHead.next.next = oddHead;

            //advance oddLast and iterHead
            oddLast = oddLast.next;
            iterHead = iterHead.next;
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>(0);
        listNode.next = new ListNode<>(1);
        listNode.next.next = new ListNode<>(2);
        listNode.next.next.next = new ListNode<>(3);
        listNode.next.next.next.next = new ListNode<>(4);
        listNode.next.next.next.next.next = new ListNode<>(5);
        listNode.next.next.next.next.next.next = new ListNode<>(6);
        listNode.next.next.next.next.next.next.next = new ListNode<>(7);

        System.out.println(ListNode.myToString(evenOddMerge(listNode)));
    }
}
