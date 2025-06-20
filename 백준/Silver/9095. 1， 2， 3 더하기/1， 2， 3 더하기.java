import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력 받기
            int n = Integer.parseInt(reader.readLine());

            // Bottom up tabulation
            // 기저 조
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= 10; i++) {
                recursive(i);
            }

            // 정답 출력 하기
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(reader.readLine());
                int result = dp[num];
                sb.append(result).append('\n');
            }
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 재귀 호출
    private static int recursive(int num) {
        if (dp[num] == null) {
            if (num > 3) {
                dp[num] = dp[num - 1] + dp[num - 2] + dp[num - 3];
            }
        }

        return dp[num];
    }

    // DP table
    private static Integer[] dp = new Integer[11];
}
