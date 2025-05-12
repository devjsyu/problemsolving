import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNum = scanner.nextInt();
        scanner.nextLine();
        String[] numArray = scanner.nextLine().split(" ");
        int count = 0;

        for (int i = 0; i < totalNum; i++) {
            if (isPrime(Integer.parseInt(numArray[i]))) {
                count++;
            }
        }

        System.out.println(count);
    }

    // 제곱근을 활용한 소수 판별 메서드 : 소수가 아니라면 최소 2개의 약수를 갖는데, 그 중 약수 1개는 항상 제곱근보다 작거나 같다.
    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        double sqrt = Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}