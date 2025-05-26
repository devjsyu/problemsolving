import java.util.Scanner;

// Brute-force
// 8x8이 될 수 있는 경우의 수는 첫번째 칸 기준으로 산정하여 가로 x 세로
// 첫번째 값에 대해서 계속 반전
// 모든 경우의 수에 대해 흑백 색깔 수정 횟수 집계 후 최소값 도출
public class Main {
    private static boolean[][] arr; // 전체 배열 선언하기
    private static int min = 64; // 만약 8x8 모두 다 흑백 색깔 수정해야 할 경우의 수정 횟수

    public static void main(String[] args) {
        // 입력 받기
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine(); // buffer 속 남아있는 개행문자 없애기
        arr = new boolean[row][col]; // 전체 배열 생성하기

        // 입력 받은 값을 통해 전체 배열 초기화 하기
        for (int i = 0; i < row; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < col; j++) {
                if (line.charAt(j) == 'W') {
                    arr[i][j] = true;
                } else {
                    arr[i][j] = false;
                }
            }
        }

        // 모든 경우의 수에 대해 사용자정의 함수 적용하여 횟수 도출하기
        // 이중 for-loop : 각각 가로와 세로에 대해
        for (int i = 0; i < row - 7; i++) {
            for (int j = 0; j < col - 7; j++) {
                find(i, j);
            }
        }

        // 모든 경우의 수를 순회한 이후 최종 최소값 출력하기
        System.out.println(min);
    }

    // 사용자정의 함수
    private static void find(int x, int y) {
        // 변수 초기화
        int endRow = x + 8;
        int endCol = y + 8;
        boolean TF = arr[x][y];
        int count = 0;

        // 확인해야 할 좌표에 대해 흑백 기준 부합 여부에 따라 count 가산
        for (int i = x; i < endRow; i++) {
            for (int j = y; j < endCol; j++) {
                if (arr[i][j] != TF) {
                    count++;
                }
                TF = !TF; // 다음 차례 반전하기
            }
            TF = !TF; // 다음 차례 반전하기
        }

        // 첫번째 좌표 색깔대로 했을 경우와 첫번째 좌표의 반대 색깔대로 했을 경우 중 작은 값 도출하기
        count = Math.min(count, 64-count);

        // 도출된 횟수에 대해 대소 비교를 통해 최소값 갱신하기
        min = Math.min(min, count);
    }
}
