package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.*;

public class PreOrderTraversal {
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

       /* List<Integer> preOrderTraversalList = preOrderTraversal(treeNode);
        preOrderTraversalList.forEach(node -> System.out.print(node + " "));*/

        System.out.println("");

        List<Integer> preOrderTraversalList_01 = preOrderTraversal_01(treeNode);
        preOrderTraversalList_01.forEach(node -> System.out.println(node + " "));
    }

    private static List<Integer> preOrderTraversal_01(TreeNode treeNode) {
        List<Integer> preOrderTraversalList = new ArrayList<>();
        if (treeNode == null) {
            preOrderTraversalList = new ArrayList<>();
        }
        Stack<TreeNode> treeNodeStack = new Stack < > ();
        treeNodeStack.push(treeNode);

        while (!treeNodeStack.isEmpty()) {
            treeNode = treeNodeStack.pop();
            preOrderTraversalList.add(treeNode.val);
            if (treeNode.left != null)
                treeNodeStack.push(treeNode.left);
            if (treeNode.right != null)
                treeNodeStack.push(treeNode.right);
        }
        return preOrderTraversalList;
    }

    private static List<Integer> preOrderTraversal(TreeNode treeNode) {
        List<Integer> preOrderTraversalList = new ArrayList<>();
        Deque<TreeNode> preOrderTraversalQueue = new LinkedList<>();
        preOrderTraversalQueue.addFirst(treeNode);
        while (!preOrderTraversalQueue.isEmpty()) {
            treeNode = preOrderTraversalQueue.pollFirst();
            //System.out.print(treeNode.val + " ");
            preOrderTraversalList.add(treeNode.val);
            if (treeNode.left != null) {
                preOrderTraversalQueue.addFirst(treeNode.left);
            }
            if (treeNode.right != null) {
                preOrderTraversalQueue.addFirst(treeNode.right);
            }
        }
        return preOrderTraversalList;
    }
}
