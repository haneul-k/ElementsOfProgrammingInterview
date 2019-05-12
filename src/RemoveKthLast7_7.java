import java.util.List;

public class RemoveKthLast7_7 {
    //assumes the list has at least k nodes
    //advance faster node by k and when the faster node reaches the end, the slower node is at kth

    public static ListNode<Integer> removeKthLast(ListNode<Integer> list, int k) {
        ListNode<Integer> faster = list;
        ListNode<Integer> slower = list;

        for (int i = 0; i < k; i++) {
            faster = faster.next;
        }

        //case when the node to remove is the list head
        if (faster == null) {
            return slower.next;
        }

        while (faster.next != null) {
            slower = slower.next;
            faster = faster.next;
        }

        slower.next = slower.next.next;
        return list;
    }

    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>(0);
        listNode.next = new ListNode<>(1);
        listNode.next.next = new ListNode<>(2);
        listNode.next.next.next = new ListNode<>(3);
        listNode.next.next.next.next = new ListNode<>(4);
        listNode.next.next.next.next.next = new ListNode<>(5);
//
//        System.out.println(ListNode.myToString(removeKthLast(listNode, 3))); //remove 3
//        System.out.println(ListNode.myToString(removeKthLast(listNode, 1))); //remove last node
        System.out.println(ListNode.myToString(removeKthLast(listNode, 6))); //remove first node

    }

}
