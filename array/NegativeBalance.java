package questions.leetcode.array;

import java.util.*;
import java.util.stream.Collectors;

public class NegativeBalance {
    public static void main(String[] args) {
        List<List<String>> debtsList = new ArrayList<>();

        List<String> user_01 = new ArrayList<>();
        user_01.add("Alex");
        user_01.add("Blake");
        user_01.add("5");
        debtsList.add(user_01);

        List<String> user_02 = new ArrayList<>();
        user_02.add("Blake");
        user_02.add("Alex");
        user_02.add("3");
        debtsList.add(user_02);

        List<String> user_03 = new ArrayList<>();
        user_03.add("Casey");
        user_03.add("Alex");
        user_03.add("7");
        debtsList.add(user_03);

        List<String> user_04 = new ArrayList<>();
        user_04.add("Casey");
        user_04.add("Alex");
        user_04.add("4");
        debtsList.add(user_04);

        List<String> user_05 = new ArrayList<>();
        user_05.add("Casey");
        user_05.add("Alex");
        user_05.add("2");
        debtsList.add(user_05);

        List<String> userList = smallestNegativeBalance(debtsList);
        userList.forEach(userDetail -> System.out.println(userDetail + " "));
    }

    private static List<String> smallestNegativeBalance(List<List<String>> debtsList) {
        HashMap<String, Integer> debtMap = new HashMap<>();    // name -> balance
        for(List<String>userDetails : debtsList){
            debtMap.put(userDetails.get(0),debtMap.getOrDefault(userDetails.get(0),0)-Integer.parseInt(userDetails.get(2)));
            debtMap.put(userDetails.get(1),debtMap.getOrDefault(userDetails.get(1),0)+Integer.parseInt(userDetails.get(2)));
        }
        int minimum = Collections.min(debtMap.values());
        debtMap.entrySet().stream().filter(item->item.getValue()==minimum).collect(Collectors.toList()).forEach(item->System.out.print(item+" "));
        List<String>userList = new ArrayList<>();

        if(minimum>=0){
            return userList;
        }
        for(Map.Entry<String,Integer>entry : debtMap.entrySet()){
            if(entry.getValue()==minimum){
                userList.add(entry.getKey());
            }
        }
        Collections.sort(userList);
        return userList;
    }
}
