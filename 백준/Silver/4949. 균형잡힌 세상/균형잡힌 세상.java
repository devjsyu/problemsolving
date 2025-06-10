import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 결과값 받을 StringBuilder 생성
            StringBuilder sb = new StringBuilder();

            // 온점만 있는 경우가 나올 때까지 반복
            while (true) {
                // 입력 받기
                String line = br.readLine();
                if (line.equals(".")) {
                    break;
                }

                sb.append(isBalanced(line)).append('\n');
            }

            // 여러 줄 결과값 한 번에 출력하기
            bw.write(sb.toString());
        }
    }

    // 균형잡힌 문자열인지 여부 판별 메서드
    private static String isBalanced(String line) {
        char[] charArray = line.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (charArray[i] != '.') {
            char c = charArray[i];
            switch (c) {
                case '(' : stack.push(c); break;
                case '[' : stack.push(c); break;
                case ')' :
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return "no";
                    }
                    stack.pop();
                    break;
                case ']' :
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return "no";
                    }
                    stack.pop();
                    break;
            }
            i++;
        }

        // 균형
        if (stack.isEmpty()) {
            return "yes";
        } else {
            // 스택에 잔여 원소가 있는 경우 (불균형)
            return "no";
        }
    }
}
