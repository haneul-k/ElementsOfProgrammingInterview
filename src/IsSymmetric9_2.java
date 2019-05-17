public class IsSymmetric9_2 {

    public static boolean isSymmetric(BinaryTreeNode<Integer> root) {
        return isSymmetricHelp(root.left, root.right);
    }

    public static boolean isSymmetricHelp(BinaryTreeNode<Integer> nodeOne, BinaryTreeNode<Integer> nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        }

        if (nodeOne == null ^ nodeTwo == null) {
            return false;
        }

        if (nodeOne.data != nodeTwo.data) {
            return false;
        }

        return isSymmetricHelp(nodeOne.left, nodeTwo.right) && isSymmetricHelp(nodeOne.right, nodeTwo.left);
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(6);
        root.right = new BinaryTreeNode<>(6);
        root.left.right = new BinaryTreeNode<>(2);
        root.left.right.right = new BinaryTreeNode<>(3);
        root.right.left = new BinaryTreeNode<>(2);
        root.right.left.left = new BinaryTreeNode<>(1);
        System.out.println(isSymmetric(root));
    }

}
