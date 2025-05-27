import java.io.*;
import java.util.StringTokenizer;

// 소수 구하기
// 어떤 수가 소수가 아닌 합성수라면 그 수의 제곱근과 같거나 작은 약수가 반드시 존재한다.
// 그 수의 제곱근과 같거나 작은 수 중에 그 수와의 modulo 연산 결과가 0인, 즉, 나누어떨어지는 약수가 존재하는지 여부를 순회하며 확인한다.
public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();

            // for loop 순회하면서 소수인 것만 추리기
            for (int i = M; i <= N; i++) {
                if (isPrime(i)) {
                    sb.append(i).append("\n");
                }
            }

            // 정답 출력하기
            bw.write(sb.toString());
        }
    }

    // 소수 판별 메서드
    private static boolean isPrime(int num) {
        int sqrt = (int) Math.sqrt(num);

        if (num == 1) {
            return false;
        }

        if (sqrt != 1) {
            for (int i = 2; i <= sqrt; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
