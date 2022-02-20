package questions.leetcode.tree;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        bfsPrintNodes(treeNode);
    }

    private static void bfsPrintNodes(TreeNode root) {
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Set<TreeNode> seenNodesHasSet = new HashSet<>();

        treeNodeQueue.add(root);
        while(!treeNodeQueue.isEmpty()){
            TreeNode currentNode = treeNodeQueue.poll();
            if(!seenNodesHasSet.contains(currentNode)){
                seenNodesHasSet.add(currentNode);
                System.out.println("Node is :: " +currentNode);
            }
           /*for(TreeNode adjacent :currentNode.adjacentNodes ){
                if(!seenNodesHasSet.contains(adjacent)){
                    treeNodeQueue.add(adjacent);
                }
             }*/
        }
    }
}
