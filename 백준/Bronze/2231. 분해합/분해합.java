import java.util.Scanner;

// bruteforce
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int length = line.length();
        int N = Integer.parseInt(line);
        int result = 0;

        for (int i = N - (length * 9); i < N; i++) {
            int number = i;
            int sum = 0;

            // 될 때까지
            while (number != 0) { // 1의 자리가 될 때까지 loop
                sum += number % 10; // "현재 loop" 기준 1의 자리 수
                number /= 10; // "다음 loop"를 위해 10으로 나눠, 10의 자리를 1의 자리로 갱신
            }

            // 조건 만족하면 무조건 최소값이므로 return
            if (sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
