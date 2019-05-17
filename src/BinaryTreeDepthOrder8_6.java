import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeDepthOrder8_6 {

    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> treeWaitlist = new LinkedList<>();
        treeWaitlist.add(tree);

        int bound = 1;
        int count = 0;
        int missing = 0; //count missing children - this is for the case when the tree is not weighted equally

        while(!treeWaitlist.isEmpty()) {
            BinaryTreeNode<Integer> node = treeWaitlist.poll();
            tempList.add(node.data);
            if (node.left != null) {
                treeWaitlist.add(node.left);
            } else {
                missing++;
            }
            if (node.right != null) {
                treeWaitlist.add(node.right);
            } else {
                missing++;
            }
            count++;
            if (count == bound) {
                bound *= 2 - missing;
                count = 0; //reset count
                missing = 0; //reset missing
                res.add(tempList);
                tempList = new ArrayList<>(); //reset tempList
            }
        }

        //add last tempList to the result
        if (!tempList.isEmpty()) {
            res.add(tempList);
        }

        return res;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> treeNode = new BinaryTreeNode<>(1);
        treeNode.left = new BinaryTreeNode<>(2);
//        treeNode.right = new BinaryTreeNode<>(3);
        treeNode.left.left = new BinaryTreeNode<>(4);
//        treeNode.left.right = new BinaryTreeNode<>(5);
//        treeNode.right.left = new BinaryTreeNode<>(6);
//        treeNode.right.right = new BinaryTreeNode<>(7);
        treeNode.left.left.left = new BinaryTreeNode<>(8);
        treeNode.left.left.right = new BinaryTreeNode<>(9);

        List<List<Integer>> res = binaryTreeDepthOrder(treeNode);
        System.out.println(res.toString());
    }
}
