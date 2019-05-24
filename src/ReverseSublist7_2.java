public class ReverseSublist7_2 {
    //Given a singly linked list and two indices a,b, reverse the sublist from [a,b] of the given list.
    //Note that the index starts at 1
    //example. 11->3->5->7->2 [2,4]
    //         11->7->5->3->2

    public static ListNode<Integer> reverseSublist(ListNode<Integer> list, int start, int end) {
        ListNode<Integer> dummyHead = new ListNode<>(0);
        dummyHead.next = list;
        ListNode<Integer> currNode = dummyHead;

        for (int i = 1; i < start; i++) {
            currNode = currNode.next;
        }

        ListNode<Integer> baseNode = currNode;
        currNode = currNode.next; //currNode is now the "start" node
        while (start++ < end) {
            ListNode<Integer> startNode = currNode.next;
            ListNode<Integer> endNode = currNode.next.next;
            currNode.next.next = baseNode.next;
            baseNode.next = startNode;
            currNode.next = endNode;
        }

        return dummyHead.next;
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
