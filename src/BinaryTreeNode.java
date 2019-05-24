public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left, right, parent;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public String toString() {
        return data + " - " +
                (this.left == null ? "null" : this.left.toString()) + " - " +
                (this.right == null ? "null" : this.right.toString());
    }
}
