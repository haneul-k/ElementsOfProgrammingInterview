public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode(T data) {
        this.data = data;
        this.next = null;
    }

    public static String myToString(ListNode a) {
        StringBuilder stringBuilder = new StringBuilder();
        while(a != null) {
            stringBuilder.append(a.data);
            stringBuilder.append("->");
            a = a.next;
        }

        stringBuilder.append("null");
        return stringBuilder.toString();
    }

}
