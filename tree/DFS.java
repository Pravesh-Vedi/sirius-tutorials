package questions.leetcode.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        dfsPrintNodes(treeNode);
    }

    private static void dfsPrintNodes(TreeNode root) {
        Stack<TreeNode>integerStack = new Stack<>();
        Set<TreeNode>seenNodesHasSet = new HashSet<>();

        integerStack.push(root);
        while(!integerStack.isEmpty()){
            TreeNode currentNode = integerStack.pop();
            if(!seenNodesHasSet.contains(currentNode)){
                seenNodesHasSet.add(currentNode);
                System.out.println("Node is :: " +currentNode);
            }
           /*for(TreeNode adjacent :currentNode.adjacentNodes ){
                if(!seenNodesHasSet.contains(adjacent)){
                    integerStack.push(adjacent);
                }
             }*/
        }
    }
}
