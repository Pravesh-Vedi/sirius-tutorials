package questions.leetcode.tree.traversal;

import questions.leetcode.tree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    static class Tuple{
        TreeNode treeNode ;
        int row;
        int column;

        public Tuple(TreeNode treeNode, int row, int column) {
            this.treeNode = treeNode;
            this.row = row;
            this.column = column;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);

        List<List<Integer>> verticalOrderTraversalList = verticalOrderTraversal(root);
        verticalOrderTraversalList.forEach(node -> System.out.print(node + " "));
    }

    private static List<List<Integer>> verticalOrderTraversal(TreeNode treeNode) {
        List<List<Integer>> verticalOrderTraversalList = new ArrayList<>();
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>>integerTreeMap = new TreeMap<>();

        Queue<Tuple>tupleQueue  = new LinkedList<>();
        tupleQueue.offer(new Tuple(treeNode, 0,0));
        while (!tupleQueue.isEmpty()){
            Tuple tuple = tupleQueue.poll();
            TreeNode currentNode = tuple.treeNode;

            int x = tuple.row;
            int y = tuple.column;

            if(!integerTreeMap.containsKey(x)){
                integerTreeMap.put(x, new TreeMap<>());
            }
            if(!integerTreeMap.get(x).containsKey(y)){
                integerTreeMap.get(x).put(y, new PriorityQueue<>());
            }
            integerTreeMap.get(x).get(y).offer(currentNode.val);

            if(null!=currentNode.left){
                tupleQueue.offer(new Tuple(currentNode.left,x-1,y+1));
            }
            if(null!=currentNode.right){
                tupleQueue.offer(new Tuple(currentNode.right,x+1,y+1));
            }
        }

        for(TreeMap<Integer, PriorityQueue<Integer>>treeMap : integerTreeMap.values()){
            verticalOrderTraversalList.add(new ArrayList<>());
            for(PriorityQueue<Integer> priorityQueue : treeMap.values()){
                while (!priorityQueue.isEmpty()){
                    verticalOrderTraversalList.get(verticalOrderTraversalList.size()-1).add(priorityQueue.poll());
                }
            }
        }
        return verticalOrderTraversalList;
    }
}
