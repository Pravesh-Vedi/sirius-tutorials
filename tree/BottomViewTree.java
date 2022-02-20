package questions.leetcode.tree;

import java.util.*;

public class BottomViewTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        List<Integer> integerList = bottomViewTree(root);
        integerList.forEach(node -> System.out.print(node + " "));
    }

    private static List<Integer> bottomViewTree(TreeNode treeNode ) {
        List<Integer>integerList  = new ArrayList<>();
        Map<Integer, Integer>integerMap = new HashMap<>();
        Queue<TreeNode>integerQueue = new LinkedList<>();

        treeNode.hd = 0;
        integerQueue.add(treeNode);
        while (!integerQueue.isEmpty()){
            TreeNode currentNode = integerQueue.poll();
            int hd = currentNode.hd;
            integerMap.put(hd, currentNode.val);
            if(currentNode.left!=null){
                currentNode.left.hd = hd-1;
                integerQueue.add(currentNode.left);
            }if(currentNode.right!=null){
                currentNode.right.hd = hd + 1;
                integerQueue.add(currentNode.right);
            }
        }
        for(Map.Entry<Integer, Integer>entry :integerMap.entrySet()){
            integerList.add(entry.getValue());
        }
        return integerList;
    }
}
