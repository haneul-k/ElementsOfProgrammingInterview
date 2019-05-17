public class LCA9_4 {

    public static BinaryTreeNode<Integer> LCA(BinaryTreeNode<Integer> treeOne, BinaryTreeNode<Integer> treeTwo) {
        //first get the distance from the root
        int treeOneHeight = getHeight(treeOne);
        int treeTwoHeight = getHeight(treeTwo);

        BinaryTreeNode<Integer> shorter = treeOneHeight < treeTwoHeight ? treeOne : treeTwo;
        BinaryTreeNode<Integer> longer = treeOneHeight < treeTwoHeight ? treeTwo : treeOne;

        int difference = Math.abs(treeOneHeight - treeTwoHeight);
        for (int i = 0; i < difference; i++) {
            longer = longer.parent;
        }

        while (longer != shorter) {
            longer = longer.parent;
            shorter = shorter.parent;
        }

        return longer;
    }

    public static int getHeight(BinaryTreeNode<Integer> tree) {
        int count = 0;
        while (tree != null) {
            count++;
            tree = tree.parent;
        }

        return count;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(1);
        node.left = new BinaryTreeNode<>(2);
        node.left.parent = node;
        node.right = new BinaryTreeNode<>(3);
        node.right.parent = node;
        node.right.left = new BinaryTreeNode<>(4);
        node.right.left.parent = node.right;
        node.right.right = new BinaryTreeNode<>(5);
        node.right.right.parent = node.right;
        node.right.left.left = new BinaryTreeNode<>(6);
        node.right.left.left.parent = node.right.left;

        System.out.println(LCA(node.right.left.left, node.right.right).data);
    }
}
