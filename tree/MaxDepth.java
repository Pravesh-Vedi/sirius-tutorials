package questions.leetcode.tree;

public class MaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        System.out.println("Max Depth :: " +maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftSubTree = maxDepth(root.left);
        int rightSubTree = maxDepth(root.right);

        return Math.max(leftSubTree, rightSubTree)+1;
    }
}
