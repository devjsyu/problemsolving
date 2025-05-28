import java.util.Scanner;

// 불필요한 반복 재귀 호출 대신 반복문 활용
// Dynamic Programming (Bottom up Tabulation)
// 반복문으로 작은 문제부터 계산하며 2차원 배열 미리 완성시키고 입력값에 따라 참조 후 정답 출력하기
public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[15][15];

        for (int i = 1; i <= 14; i++) {
            arr[0][i] = i;
            arr[i][1] = 1;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14 ; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        for (int i = 0; i < total; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(arr[k][n]);
        }
    }
}
