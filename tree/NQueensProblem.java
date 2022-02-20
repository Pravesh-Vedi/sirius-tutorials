package questions.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class NQueensProblem {
    public static void main(String[] args) {
        List<List<Integer>>queenChoiceResults = nQueens(20);
    }

    private static List<List<Integer>> nQueens(int number) {
        List<List<Integer>>queenChoiceResults = new ArrayList<>();
        solveNQueensProblem(number,0,new ArrayList<Integer>(),queenChoiceResults);
        return queenChoiceResults;
    }

    private static void solveNQueensProblem(int number, int row, List<Integer> columnPlacements,
                                            List<List<Integer>> queenChoiceResults) {
        if(row==number){
            queenChoiceResults.add(new ArrayList<>(columnPlacements));//our goal
        }else{
            for (int column =0; column<number;column++){
                columnPlacements.add(column);//our choice
                if(isValid(columnPlacements)){//our constraints
                    solveNQueensProblem(number,row+1,columnPlacements,queenChoiceResults);//our constraints
                }
                columnPlacements.remove(columnPlacements.size()-1);//Undo our choice
            }
        }
    }

    private static boolean isValid(List<Integer> columnPlacements) {
        int rowId = columnPlacements.size()-1;
        for(int i = 0;i<rowId;i++){
            int diff = Math.abs(columnPlacements.get(i)-columnPlacements.get(rowId));
            if(diff==0 || diff==rowId-1){
                return false;
            }
        }
        return true;
    }
}
