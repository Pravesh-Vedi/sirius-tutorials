package questions.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class BSTAllLeafNodes {
    private static TreeNode rootNode;
    private static List<Integer> leafNodeList = new LinkedList<>();

    public static void main(String[] args) {
        int[] inputArray = {4, 3, 2, 7, 8, 1};
        for (int i = 0; i < inputArray.length - 1; i++) {
            TreeNode treeNode = new TreeNode(inputArray[i]);
            createNode(treeNode);
        }
        leafNodeList.forEach(System.out::println);
        System.out.println("Min is :: " + getMin());
    }

    private static int getMin() {
        TreeNode currentNode = rootNode;
        if (currentNode == null) {
            return -1;
        }
        TreeNode lastNode = null;
        while (currentNode != null) {
            lastNode = currentNode.left;
        }
        return lastNode.val;
    }

    private static void createNode(TreeNode treeNode) {
        if (treeNode == null) return;
        if (rootNode == null) {
            rootNode = treeNode;
        }
        if (treeNode.val > rootNode.val) {
            rootNode.right = treeNode;
        } else if (treeNode.val < rootNode.val) {
            rootNode.left = treeNode;
        } else {
            return;
        }
    }

    private static void getLeafNodes(TreeNode treeNode) {
        if (treeNode == null) return;
        if (treeNode.left == null && treeNode.right == null) {
            leafNodeList.add(treeNode.val);
        } else {
            getLeafNodes(treeNode.left);
            getLeafNodes(treeNode.right);
        }
    }
}
