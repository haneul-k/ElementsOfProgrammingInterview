public class ReverseSublist7_2 {
    //Given a singly linked list and two indices a,b, reverse the sublist from [a,b] of the given list.
    //Note that the index starts at 1
    //example. 11->3->5->7->2 [2,4]
    //         11->7->5->3->2

    public static ListNode<Integer> reverseSublist(ListNode<Integer> list, int start, int end) {
        int i = 1;
        ListNode<Integer> dummyhead = new ListNode<>(0);
        dummyhead.next = list;
        ListNode<Integer> currNode = dummyhead;

        while (i < start) {
            currNode = currNode.next;
            i++;
        }

        ListNode<Integer> listHead = currNode;
        ListNode<Integer> temp;
        ListNode<Integer> listIterator = currNode.next;
        while (start < end) {
            temp = listIterator.next;
            listIterator.next = temp.next;
            temp.next = listHead.next;
            listHead.next = temp;
            start++;
        }

        return dummyhead.next;
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>(1);
        listNode.next = new ListNode<>(2);
        listNode.next.next = new ListNode<>(3);
        listNode.next.next.next = new ListNode<>(4);
        listNode.next.next.next.next = new ListNode<>(5);
        listNode.next.next.next.next.next = new ListNode<>(6);
        listNode.next.next.next.next.next.next = new ListNode<>(7);

        System.out.println(ListNode.myToString(reverseSublist(listNode, 2,4)));
    }
}
