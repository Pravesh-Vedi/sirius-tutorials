package questions.leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class MinCostTravel {
    int []costArray;
    int []memo;
    Set<Integer>integerSet = new HashSet<>();

    public static void main(String[] args) {
    }

    public int minCost(int []costArray,int []days){
        this.costArray = costArray;
        this.memo = new int[days[days.length-1]];
        for(int day: days){
            integerSet.add(day);
        }
        return dp(days[days.length-1]);
    }

    public int dp(int num){
        if(num<0){
            return 0;
        }
        if(memo[num-1]!=0){
            return memo[num-1];
        }
        int result;
        if(integerSet.contains(num)){
            int oneDay = dp(num-1)+costArray[0];
            int sevenDay = dp(num-7)+costArray[1];
            int thirtyDay = dp(num-30)+costArray[2];
            result = Math.min(oneDay,Math.min(sevenDay,thirtyDay));
        }else{
            result=dp(num-1);
        }
        return memo[num-1]=result;
    }
}
