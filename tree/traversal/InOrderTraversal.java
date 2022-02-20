package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
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

        List<Integer> inOrderTraversalList = inOrderTraversal(treeNode);
        inOrderTraversalList.forEach(node -> System.out.print(node + " "));
    }

    private static List<Integer> inOrderTraversal(TreeNode treeNode) {
        List<Integer> inOrderTraversalList = new ArrayList<>();
        if (treeNode == null) {
            inOrderTraversalList = new ArrayList<>();
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (true) {
            if (null != treeNode) {
                treeNodeStack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                if (treeNodeStack.isEmpty()) {
                    break;
                }
                treeNode = treeNodeStack.pop();
                inOrderTraversalList.add(treeNode.val);
                treeNode = treeNode.right;
            }
        }
        return inOrderTraversalList;
    }
}
