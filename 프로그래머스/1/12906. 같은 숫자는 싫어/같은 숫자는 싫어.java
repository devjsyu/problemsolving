import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        int[] answer = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) { // 먼저 들어간 자료가 나중에 나옴 LIFO(Last In First Out) 구조이므로 reverse해서 추가해줘야 함
            answer[i] = stack.pop();
        }
        return answer;
    }
}