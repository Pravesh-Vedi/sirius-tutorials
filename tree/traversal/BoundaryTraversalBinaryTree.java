package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class BoundaryTraversalBinaryTree {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        List<Integer> integerList = new LinkedList<>();
        boundaryTraversalBinaryTree(root, integerList);
        integerList.forEach(node -> System.out.print(node + " "));
    }

    private static void boundaryTraversalBinaryTree(TreeNode treeNode, List<Integer> integerList) {
        if (!isLeaf(treeNode)) {
            integerList.add(treeNode.val);
            addLeftBoundary(treeNode, integerList);
            addLeaves(treeNode, integerList);
            addRightBoundary(treeNode, integerList);
        }
    }

    private static boolean isLeaf(TreeNode treeNode) {
        return (treeNode.left == null) && (treeNode.right == null);
    }

    private static void addLeaves(TreeNode treeNode, List<Integer> integerList) {
        if (isLeaf(treeNode)) {
            integerList.add(treeNode.val);
            return;
        }
        if (treeNode.left != null) {
            addLeaves(treeNode.left, integerList);
        }
        if (treeNode.right != null) {
            addLeaves(treeNode.right, integerList);
        }
    }

    private static void addLeftBoundary(TreeNode treeNode, List<Integer> integerList) {
        TreeNode currentNode = treeNode.left;
        while (currentNode != null) {
            if (!isLeaf(currentNode)) {
                integerList.add(currentNode.val);
            }
            if (currentNode.left != null) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
    }

    private static void addRightBoundary(TreeNode treeNode, List<Integer> integerList) {
        TreeNode currentNode = treeNode.right;
        List<Integer> tmpList = new LinkedList<>();
        while (currentNode != null) {
            if (!isLeaf(currentNode)) {
                tmpList.add(currentNode.val);
            }
            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        for (int i = tmpList.size() - 1; i >= 0; i--) {
            integerList.add(tmpList.get(i));
        }
    }

}
