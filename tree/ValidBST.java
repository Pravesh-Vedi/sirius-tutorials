package questions.leetcode.tree;

public class ValidBST {
    public static void main(String[] args) {

    }

    public boolean isValidBST(TreeNode treeNode){
      return validateBST(treeNode, null,null);
    }

    private boolean validateBST(TreeNode treeNode, Integer max, Integer min) {
        if(treeNode ==null){
            return true;
        }else if(max!=null && treeNode.val>=max || min!=null && treeNode.val<=min){
            return false;
        }else{
            return validateBST(treeNode.left, treeNode.val, min) && validateBST(treeNode.right, max, treeNode.val);
        }
    }
}
