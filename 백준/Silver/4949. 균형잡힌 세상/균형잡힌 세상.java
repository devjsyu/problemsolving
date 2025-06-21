import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // try with resources for auto closable I/O stream
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 변수 선언
            String line = "";
            StringBuilder result = new StringBuilder();

            // 반복문
            while (true) {
                // 입력 받기
                line = reader.readLine();
                // 조건문
                if (line.equals(".")) {
                    break;
                }
                // 결과 저장하기
                result.append(isBalanced(line)).append('\n');
            }

            // 결과 한 번에 출력 하기
            writer.write(result.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 커스텀 메서드
    private static String isBalanced(String line) {
        Deque<Character> stack = new LinkedList<>();
        char[] arr = line.toCharArray();

        for (char c : arr) {
            // 조기 종결
            if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return "no";
                }
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return "no";
                }
            } else if (c == '[' || c == '(') {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }
}
