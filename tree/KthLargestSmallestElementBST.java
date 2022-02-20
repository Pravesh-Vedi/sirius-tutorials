package questions.leetcode.tree;

public class KthLargestSmallestElementBST {
    public static void main(String[] args) {
        int[] inputArray = {10, 40, 45, 20, 25, 30, 50};
        int k = 2;
        TreeNode treeNode = null;
        for (int j : inputArray) {
            treeNode = insertIntoBST(treeNode, j);
        }
        TreeNode kthLargestNode = kthLargestNode(treeNode, new int[]{k});
        if(kthLargestNode == null){
            System.out.println("Invalid Input :: Largest Element :: ");
        }else{
            System.out.println("Kth Largest Element :: " +kthLargestNode.val);
        }
        TreeNode kthSmallestNode = kthSmallestNode(treeNode, new int[]{k});
        if(kthSmallestNode == null){
            System.out.println("Invalid Input :: Smallest Element :: ");
        }else{
            System.out.println("Kth Smallest Element :: " +kthSmallestNode.val);
        }
    }

    private static TreeNode kthSmallestNode(TreeNode treeNode, int[] valueArray) {
        if(treeNode==null) {
            return null;
        }

        TreeNode left=kthSmallestNode(treeNode.left,valueArray);
        if(left!=null) {
            return left;
        }
        valueArray[0]--;
        if(valueArray[0]==0) {
            return treeNode;
        }
        return kthSmallestNode(treeNode.right,valueArray);
    }

    private static TreeNode kthLargestNode(TreeNode treeNode, int[] valueArray) {
        if(treeNode ==null){
            return null;
        }
        TreeNode right=kthLargestNode(treeNode.right,valueArray);
        if(right!=null) {
            return right;
        }
        valueArray[0]--;

        if(valueArray[0]==0) {
            return treeNode;
        }
        return kthLargestNode(treeNode.left,valueArray);
    }

    private static TreeNode insertIntoBST(TreeNode treeNode, int value) {
        if (treeNode == null) {
            return new TreeNode(value);
        }
        if (value < treeNode.val) {
            treeNode.left = insertIntoBST(treeNode.left, value);
        } else {
            treeNode.right = insertIntoBST(treeNode.right, value);
        }
        return treeNode;
    }
}
