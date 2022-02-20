package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(8);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.right.right.left = new TreeNode(9);
        treeNode.right.right.right = new TreeNode(10);

        List<List<Integer>> levelOrderTraversalList = levelOrder(treeNode);
        levelOrderTraversalList.forEach(node -> System.out.print(node + " "));
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> integerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.remove();
                integerList.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.add(treeNode.right);
                }
            }
            resultList.add(integerList);
        }
        return resultList;
    }
}
