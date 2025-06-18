import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력 받기
            int T = Integer.parseInt(reader.readLine());

            // 효율적인 출력을 위한 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for (int i = 0; i < T; i++) {
                int n = Integer.parseInt(reader.readLine());
                fibonacci(n);
                sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
            }

            // 더 빠른 출력을 위해 결과값을 모두 StringBuilder 객체에 저장 후 한 번만 출력한다.
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Memoization 활용을 위한 배열 생성
    private static Integer[][] dp = new Integer[41][2];

    private static Integer[] fibonacci(int n) {
        if (dp[n][0] == null || dp[n][1] == null) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }

        return dp[n];
    }
}
