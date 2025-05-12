import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 유클리드 호제법 (재귀 방식)
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))
                ) {
            // 입력 받기
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            
            // 최대공약수, 최소공배수 구하기
            int gcd = gcd(a, b);
            int lcm = a * b / gcd;
            
            // 정답 출력
            bufferedWriter.write(gcd + "\n" + lcm);
        }
    }
}
