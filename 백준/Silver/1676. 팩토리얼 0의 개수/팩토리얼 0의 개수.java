import java.util.Scanner;

// N!이 10으로 몇 배수인지 구하는 문제
// 최대 N의 M 제곱이기 때문에 그대로 연산하지 않고, 각 요소에 대해 10으로 나눌 수 있는지 여부를 집계하는 방식으로 우회
// 10을 소인수분해 하면 2와 5가 나오기 때문에 각 요소에 대해 각각 2와 5로 몇 번 나눌 수 있는지 집계해서 합산하기
public class Main {
    public static void main(String[] args) {
        // 입력 받기
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        // 변수 초기화
        int div2 = 0;
        int div5 = 0;
        int div10 = 0;

        // 반복문
        for (int i = N; i > 0; i--) {
            int temp = i; // 임시 변수 temp에 i 값 복사

            // 먼저 10으로 몇 번 나눌 수 있는지 확인 후 합산
            while (temp % 10 == 0) {
                div10++;
                temp /= 10;
            }
            // 이후 각각 2와 5로 몇 번 나눌 수 있는지 누적 집계
            while (temp % 2 == 0) {
                div2++;
                temp /= 2;
            }

            while (temp % 5 == 0) {
                div5++;
                temp /= 5;
            }
        }

        // 각 집계 간 차의 절대값
        int count0 = Math.min(div2, div5) + div10;

        // 0의 개수 (소인수분해 후 2와 5의 개수 중 최소값)
        System.out.println(count0);
    }
}
