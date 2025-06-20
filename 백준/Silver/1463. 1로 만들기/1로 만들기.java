import java.io.*;

// Dynamic Programming, Memoization
// 부분구조문제 + 최적해문제
public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(reader.readLine());

            dp = new Integer[N + 1];
            dp[0] = dp[1] = 0;

            System.out.println(recur(N));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Integer[] dp;

    private static int recur(int X) {
        // 해당 인덱스에 아직 결과값이 할당되지 않은 경우
        if (dp[X] == null) { // 명시적 초기화 없을 경우의 배열 원소의 기본 초기값
            if (X % 6 == 0) {
                dp[X] = Math.min(recur(X / 3), Math.min(recur(X / 2), recur(X - 1))) + 1;
            } else if (X % 3 == 0) {
                dp[X] = Math.min(recur(X / 3), recur(X - 1)) + 1;
            } else if (X % 2 == 0) {
                dp[X] = Math.min(recur(X / 2), recur(X - 1)) + 1;
            } else {
                dp[X] = recur(X - 1) + 1;
            }
        }
        return dp[X];
    }
}
