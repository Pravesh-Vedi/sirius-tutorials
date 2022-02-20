package questions.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class RightView {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.left.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        List<Integer> rightViewList = new ArrayList<>();
        rightViewTree(treeNode,rightViewList,0);
        rightViewList.forEach(node -> System.out.print(node + " "));
    }

    private static void  rightViewTree(TreeNode treeNode,List<Integer> integerList, int currDepth) {
        if(treeNode == null){
            return;
        }
        if(currDepth == integerList.size()){
            integerList.add(treeNode.val);
        }

        rightViewTree(treeNode.right, integerList, currDepth + 1);
        rightViewTree(treeNode.left, integerList, currDepth + 1);
    }
}
