import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int i;
        int j;
        int k;

        List<Integer> myList = new ArrayList<>();
        List<Integer> myAnswer = new ArrayList<>();
        for (int[] command : commands) {
            i = command[0]-1;
            j = command[1]-1;
            k = command[2]-1;

            for (int l = i; l <= j; l++) {
                myList.add(array[l]);
            }
            Collections.sort(myList);
            System.out.println(myList);
            Integer[] sortedArray = myList.toArray(new Integer[myList.size()]);
            System.out.println(sortedArray[k]);
            myAnswer.add(sortedArray[k]);
            myList.clear();
        }
        int[] answer = myAnswer.stream().mapToInt(Integer::intValue).toArray();
        return answer;

    }
}