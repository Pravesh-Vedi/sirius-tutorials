package questions.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        List<Integer> integerList = new ArrayList<>();
        rootToNodePath(root, integerList, 7);
        integerList.forEach(node -> System.out.print(node + " "));


    }

    private static boolean rootToNodePath(TreeNode treeNode, List<Integer> integerList, int nodePath) {
        if (treeNode == null) {
            return false;
        }
        integerList.add(treeNode.val);
        if (treeNode.val == nodePath) {
            return true;
        }
        if (rootToNodePath(treeNode.left, integerList, nodePath)
                || rootToNodePath(treeNode.right, integerList, nodePath)) {
            return true;
        }
        integerList.remove(integerList.size() - 1);
        return false;
    }
}
