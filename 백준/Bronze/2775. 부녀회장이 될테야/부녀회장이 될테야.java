import java.util.Scanner;

// 재귀를 이용하여 하위 문제로 쪼개가며 해결하기
// 최적부분구조이지만 중복부분문제가 아니기 때문에 효율적으로 Dynamic Programming, Memoization을 사용할 수 없다
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        for (int i = 0; i < total; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(peopleCount(k, n));
        }
    }

    private static int peopleCount(int k, int n) {
        if (n == 1) return 1;
        if (k == 1) return n * (n + 1) / 2;
        return peopleCount(k, n - 1) + peopleCount(k - 1, n);
    }
}
