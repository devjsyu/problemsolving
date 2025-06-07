import java.util.Scanner;

// Dynamic Programming
// 부분구조 및 최적합 특징이 있기 때문에 동적계획법 Memoization을 이용할 수 있다.
// Bottom up Tabulation Memoization
public class Main {
    public static void main(String[] args) {
        // 입력 받기
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();

        // (k, n)의 값을 2차원 배열에 미리 저장하기
        // 2차원 배열 선언
        int[][] arr = new int[15][15];

        // 0층 (초기값)
        for (int i = 0; i < 15; i++) {
            arr[0][i] = i;
        }

        // 점화식
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15 ; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        // 차례대로 매개변수 입력 받아 해당 인덱스의 2차원 배열 값 출력하기
        for (int i = 0; i < total; i++) {
            int k = in.nextInt();
            int n = in.nextInt();
            System.out.println(arr[k][n]);
        }
    }
}
