import java.util.Stack;

class Solution {
    // 올바른 괄호 문자열인지 확인하는 함수
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 열린 괄호는 스택에 넣는다
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                // 스택이 비었거나 짝이 맞지 않으면 false
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        // 모든 괄호가 짝이 맞고 스택이 비어 있으면 true
        return stack.isEmpty();
    }

    // 주어진 문자열을 왼쪽으로 x만큼 회전시키는 함수
    public String rotate(String s, int x) {
        return s.substring(x) + s.substring(0, x);
    }

    public int solution(String s) {
        int answer = 0;
        int len = s.length();

        // 문자열을 0부터 len-1까지 회전시킨 모든 경우 확인
        for (int i = 0; i < len; i++) {
            // i칸만큼 회전한 문자열을 얻는다
            String rotated = rotate(s, i);
            // 회전한 문자열이 올바른 괄호 문자열인지 확인
            if (isValid(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
}
