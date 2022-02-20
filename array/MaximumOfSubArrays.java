package questions.leetcode.array;

import java.util.*;

public class MaximumOfSubArrays {
    public static void main(String[] args) {
        List<Integer>integerList =  Arrays.asList(2, 3, 1, 4, 5, 1, 5);
        getMaximumOfSubArrays(integerList,3).forEach(System.out::print);
    }

    public static List<Integer>  getMaximumOfSubArrays(List<Integer> integerList, int k) {
        Deque<Integer> window = new LinkedList<>();

        //    Initialise a ArrayList to store the maximum element of subarrays.
        List<Integer> resultList = new ArrayList<Integer>(integerList.size() - k + 1);

        //    Initialise the deque with first 'k' - 1 elements.
        for (int i = 0; i < k - 1; i++)
        {

            //    For every element, the previous smaller elements are of no use so remove them from the window.
            while (!window.isEmpty() && integerList.get(window.getLast()) < integerList.get(i))
            {
                window.pollLast();
            }

            //    Add new element at rear of queue.
            window.addLast(i);
        }

        //    For rest of the elements from nums[k] to nums[n-1]
        for (int i = k - 1; i < integerList.size(); i++)
        {
            //    The element at the front of the queue is the largest element of previous window, so add it to the result.
            if (!window.isEmpty() && window.getFirst() <= i - k)
            {
                window.pollFirst();
            }

            //    Remove the last element if it is smaller than the current element.
            while (!window.isEmpty() && integerList.get(window.getLast()) < integerList.get(i))
            {
                window.pollLast();
            }

            //    Insert the index of current element at the back of the deque.
            window.addLast(i);

            //    Get the maximum of the current window i.e. maximum of subarray [i-k+1, i].
            resultList.add( integerList.get(window.getFirst()));
        }

        return resultList;
    }
}
