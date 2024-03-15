import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
                Set<Integer> myList = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i != j) {
                    myList.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        List<Integer> myConvertedList = new ArrayList<>(myList);
        Collections.sort(myConvertedList);

        int[] answer = new int[myConvertedList.size()];
        for (int i = 0; i < myConvertedList.size(); i++) {
            answer[i] = myConvertedList.get(i);
        }
        return answer;
    }
}