package questions.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Need to fix
 **/
public class WidthOfBinaryTree {
    static class Tuple {
        TreeNode treeNode;
        int number;

        public Tuple(TreeNode treeNode, int number) {
            this.treeNode = treeNode;
            this.number = number;
        }

        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(3);
            root.left.left = new TreeNode(5);
            root.left.left.left = new TreeNode(7);
            root.right = new TreeNode(2);
            root.right.right = new TreeNode(4);
            root.right.right.right = new TreeNode(6);

            int maxWidth = widthOfBinaryTree(root);
            System.out.println("Max Width is ; " + maxWidth);
        }

        private static int widthOfBinaryTree(TreeNode treeNode) {
            if (treeNode == null) {
                return 0;
            }
            int result = 0;
            Queue<Tuple> tupleQueue = new LinkedList<>();
            tupleQueue.offer(new Tuple(treeNode, 0));
            while (!tupleQueue.isEmpty()) {
                int size = tupleQueue.size();
                int min = tupleQueue.peek().number;    //to make the id starting from zero
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    assert tupleQueue.peek() != null;
                    int currentId = tupleQueue.peek().number - min;
                    TreeNode currentNode = tupleQueue.peek().treeNode;
                    tupleQueue.poll();
                    if (i == 0) first = currentId;
                    if (currentNode.left != null)
                        tupleQueue.offer(new Tuple(currentNode.left, currentId * 2 + 1));
                    if (currentNode.right != null)
                        tupleQueue.offer(new Tuple(currentNode.right, currentId * 2 + 2));
                }
                result = Math.max(result, last - first + 1);
            }
            return result;
        }
    }
}
