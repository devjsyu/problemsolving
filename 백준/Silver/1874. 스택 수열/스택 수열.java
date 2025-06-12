import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 받기
            int n = Integer.parseInt(reader.readLine());

            Deque<Integer> stack = new ArrayDeque<>(); // 스택
            StringBuilder sb = new StringBuilder(); // 중간 연산과정 저장
            int prev = 0; // 직전 숫자 저장

            // n번 반복
            for (int i = 0; i < n; i++) {
                int curr = Integer.parseInt(reader.readLine()); // 현재 숫자

                Optional<Integer> top = Optional.ofNullable(stack.peek()); // 스택 가장 위 원소
                // 조기 종결 조건 검사
                if (top.isPresent() && curr < prev && curr != top.get()) {
                    System.out.println("NO");
                    return;
                }

                // curr > prev인 경우
                if (curr > prev) {
                    for (int j = prev + 1; j <= curr; j++) {
                        stack.push(j);
                        sb.append('+').append('\n');
                    }
                }
                // curr > prev인 경우와 curr < prev인 경우 모두 포함
                stack.pop();
                sb.append('-').append('\n');
                prev = prev > curr ? prev : curr; // 다음 차례로 넘어가기 전, 현재 요소가 직전 요소보다 더 클 경우, 직전 요소 변수에 저장
            }

            // 정답 출력하기
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
