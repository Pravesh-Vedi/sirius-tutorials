package questions.leetcode.tree;

public class BinarySearchTree {
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

        TreeNode searchedNode = searchBST(treeNode, 8);
        System.out.println("Searched Node found :: " + searchedNode);
    }

    public static TreeNode searchBST(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == value) {
            return treeNode;
        }
        if (value < treeNode.val) {
            return searchBST(treeNode.left, value);
        } else {
            return searchBST(treeNode.right, value);
        }
    }
}
