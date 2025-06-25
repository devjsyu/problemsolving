import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력 받기
            int n = Integer.parseInt(reader.readLine()); // 전체 개수

            // 스택 객체 생성
            Stack<Integer> stack = new Stack<>();

            // 정답 출력을 위한 StringBuilder 객체 생
            StringBuilder sb = new StringBuilder();

            // 수열에 대해 알고리즘 적용하기
            int sequence = 0;
            for (int i = 0; i < n; i++) {
                // 수 입력 받기
                int num = Integer.parseInt(reader.readLine());

                if (sequence < num) {
                    for (int j = sequence; j < num; j++) {
                        stack.push(++sequence);
                        sb.append('+').append('\n');
                    }
                } else if (stack.peek() != num) {
                    writer.write("NO");
                    return; // 조기 반환
                }
                // 공통
                stack.pop();
                sb.append('-').append('\n');
            }

            // 정답 출력하기
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
