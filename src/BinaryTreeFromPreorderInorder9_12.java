import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderInorder9_12 {
    static Map<Character, Integer> inorderIndex = new HashMap<>();
    static int preorderIndex;
    public static BinaryTreeNode<Character> binaryTreeFromPreorderInorder(char[] preorder, char[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        preorderIndex = 0;
        return drawTree(preorder, 0, preorder.length - 1);
    }

    public static BinaryTreeNode<Character> drawTree(char[] preorder, int start, int end) {
        BinaryTreeNode<Character> root = new BinaryTreeNode<>(preorder[preorderIndex]);
        int rootIndex = inorderIndex.get(preorder[preorderIndex++]);

        if (preorderIndex == preorder.length) {
            return root;
        }

        root.left = start > rootIndex - 1 ? null : drawTree(preorder, start, rootIndex - 1);
        root.right = rootIndex + 1 > end ? null : drawTree(preorder, rootIndex + 1, end);

        return root;
    }

    public static void main(String[] args) {
        char[] preorder = new char[] {'H', 'B', 'F', 'E', 'A', 'C', 'D', 'G', 'I'};
        char[] inorder = new char[] {'F', 'B', 'A', 'E', 'H', 'C', 'D', 'I', 'G'};

        System.out.println(binaryTreeFromPreorderInorder(preorder, inorder));
    }
}
