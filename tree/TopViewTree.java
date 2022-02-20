package questions.leetcode.tree;

import java.util.*;

/**
 * Need to fix
 **/
public class TopViewTree {
    static class Tuple {
        TreeNode treeNode;
        int number;
        int hd;

        public Tuple(TreeNode treeNode, int number) {
            this.treeNode = treeNode;
            this.number = number;
            this.hd = 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        List<Integer> integerList = topViewTree(root);
        integerList.forEach(node -> System.out.print(node + " "));
    }

    private static List<Integer> topViewTree(TreeNode treeNode) {
        List<Integer> integerList = new ArrayList<>();
        if (treeNode == null) return integerList;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> tupleQueue = new LinkedList<>();
        tupleQueue.add(new Tuple(treeNode, 0));
        while (!tupleQueue.isEmpty()) {
            Tuple currentTuple = tupleQueue.remove();
            int hd = currentTuple.hd;
            TreeNode temp = currentTuple.treeNode;
            map.computeIfAbsent(hd, k -> temp.val);
            if (temp.left != null) {
                tupleQueue.add(new Tuple(temp.left, hd - 1));
            }
            if (temp.right != null) {
                tupleQueue.add(new Tuple(temp.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            integerList.add(entry.getValue());
        }
        return integerList;
    }
}
