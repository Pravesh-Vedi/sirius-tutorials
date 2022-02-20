package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTreeNodes {
    public static void main(String args[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(8);

        List<List<Integer>> integerList = new LinkedList<>();
        zigZagTraversalUsingQueue(root, integerList);
        integerList.forEach(node -> System.out.print(node + " "));
    }

    private static void zigZagTraversalUsingQueue(TreeNode root, List<List<Integer>> integerList) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<TreeNode>();
        if (root == null) {
            return;
        }
        treeNodeQueue.add(root);
        boolean zigZag = false;
        while (!treeNodeQueue.isEmpty()) {
            int levelSize = treeNodeQueue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode treeNode = treeNodeQueue.remove();
                assert treeNode != null;
                if(zigZag){
                    levelList.add(0, treeNode.val);
                }else{
                    levelList.add(treeNode.val);
                }
                if (treeNode.left != null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            zigZag = !zigZag;
            integerList.add(levelList);
        }
    }
}
