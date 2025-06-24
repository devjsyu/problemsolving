import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            // 입력 받기
            int N = Integer.parseInt(reader.readLine()); // 전체 수열 개수
            StringTokenizer st = new StringTokenizer(reader.readLine()); // 입력 받은 수열을 토큰화
            int countPrimeNumber = 0; // 소수 개수 집계

            // 수열에 대해 소수 여부 메서드 적용하기
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (isPrime(num)) {
                    countPrimeNumber++;
                }
            }

            // 정답 출력하기
            System.out.println(countPrimeNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 소수 여부 판별 커스텀 메서드
    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        } else if (num == 2) {
            return true;
        } else {
            int sqrt = (int) Math.sqrt(num);
            for (int i = 2; i <= sqrt; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
