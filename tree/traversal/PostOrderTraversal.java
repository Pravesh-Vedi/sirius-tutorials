package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
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

     /*   List<Integer> postOrderTraversalList = postOrderTraversal(treeNode);
        postOrderTraversalList.forEach(node -> System.out.print(node + " "));*/


        List<Integer> postOrderTraversalList_01 = postOrderTraversal_01(treeNode);
        postOrderTraversalList_01.forEach(node -> System.out.print(node + " "));

        System.out.println("\n");
        List<Integer>integerList = new ArrayList<>();
        List<Integer> postOrderTraversalList_02 = postOrderTraversal_02(treeNode,integerList);
        postOrderTraversalList_02.forEach(node -> System.out.print(node + " "));
    }

    private static List<Integer> postOrderTraversal_02(TreeNode treeNode,List<Integer>integerList) {
        if(treeNode==null){
            return integerList;
        }
        postOrderTraversal_02(treeNode.left,integerList);
        postOrderTraversal_02(treeNode.right,integerList);
        integerList.add(treeNode.val);
        return integerList;
    }

    private static List<Integer> postOrderTraversal_01(TreeNode treeNode) {
        List<Integer> postOrder = new ArrayList<>();
        if (treeNode == null) return postOrder;

        Stack<TreeNode> treeNodeStack = new Stack<>();
        while (treeNode != null || !treeNodeStack.isEmpty()) {
            if (treeNode != null) {
                treeNodeStack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                TreeNode temp = treeNodeStack.peek().right;
                if (temp == null) {
                    temp = treeNodeStack.peek();
                    treeNodeStack.pop();
                    postOrder.add(temp.val);
                    while (!treeNodeStack.isEmpty() && temp == treeNodeStack.peek().right) {
                        temp = treeNodeStack.peek();
                        treeNodeStack.pop();
                        postOrder.add(temp.val);
                    }
                } else treeNode = temp;
            }
        }
        return postOrder;

    }

    private static List<Integer> postOrderTraversal(TreeNode treeNode) {
        List<Integer> postOrderTraversalList = new ArrayList<>();
        if (treeNode == null) {
            postOrderTraversalList = new ArrayList<>();
        }
        Stack<TreeNode> treeNodeStack = new Stack<>();
        treeNodeStack.push(treeNode);
        while (!treeNodeStack.isEmpty()) {
            TreeNode current = treeNodeStack.pop();
            postOrderTraversalList.add(0, current.val);
            if (current.left != null) {
                treeNodeStack.push(current.left);
            } else if (current.right != null) {
                treeNodeStack.push(current.right);
            }
        }
        return postOrderTraversalList;
    }

}
