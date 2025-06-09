import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 받기
            int total = Integer.parseInt(br.readLine());

            // 스택 생성
            Stack<Integer> stack = new Stack<>();

            // 0이면 이전 원소 지우고, 아니라면 원소 추가하기 반복문
            for (int i = 0; i < total; i++) {
                int num = Integer.parseInt(br.readLine());

                if (num == 0) {
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }

            // 스택의 모든 원소 합 구하기
            int sum = 0;
            for (Integer i : stack) {
                sum += i;
            }

            // 정답 출력
            System.out.println(sum);
        }
    }

}
