package questions.leetcode.tree;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length ==0){
            return  null;
        }
        return constructSortedBSTFromArray(nums, 0, nums.length-1);
    }

    private TreeNode constructSortedBSTFromArray(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = left + (right-left)/2;

        TreeNode currentNode = new TreeNode(nums[mid]);
        currentNode.left = constructSortedBSTFromArray(nums,left,mid-1);
        currentNode.right = constructSortedBSTFromArray(nums, mid+1, right);
        return currentNode;
    }
}
