import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 받기
            // 전체 개수
            int total = Integer.parseInt(reader.readLine());

            // 변수 선언
            int sum = 0;
            int median = Integer.MAX_VALUE;
            int mode = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int count = 0;
            int modeMax = 0; // 최빈값 찾기
            boolean isMode1st = false; // 가장 작은 최빈값과 구분하기 위한 플래그

            // 입력 받은 수열을 저장할 배열 선언
            int[] arr = new int[total];

            // 계수정렬의 아이디어 활용 (정렬까지는 불필요)
            // min부터 max까지 각 인덱스에 각 값에 대한 빈도수를 저장하는 배열 만들기
            // min을 0번째 인덱스로 하면 중간과정이 복잡해지니 공간복잡도를 다소 희생해서 전체 수 범위(-4,000 ~ 4,000)를 가진 배열을 생성한다
            int[] counting = new int[8001];

            // 2개 배열 값 할당 및 변수 할당 반복문
            for (int i = 0; i < total; i++) {
                // 배열에 입력 받은 수 저장
                arr[i] = Integer.parseInt(reader.readLine());

                // 기준 배열의 값마다 해당 값 인덱스에 개수 집계하기
                // 배열 인덱스에 음수가 올 수 없기 때문에 인덱스에 임의의 조정을 한다
                counting[arr[i] + 4000]++;

                // 누적합 계산
                sum += arr[i];

                // max, min 업데이트
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }

            // 계수정렬의 아이디어 활용하여 중앙값과 최빈값 구하기
            for (int i = min + 4000; i <= max + 4000 ; i++) {
                // 중앙값
                // 개수 누적합이 전체 개수 중 중간보다 작을 때
                if (count < (total + 1) / 2) {
                    count += counting[i]; // 개수 누적하여 더하기
                    median = i - 4000; // 매번 median 갱신
                }

                // 최빈값
                // 기준 배열의 값마다 인덱스의 값을 증가시킨 배열에서 값은 집계값, 가장 큰 값이 최빈값이 된다
                if (modeMax < counting[i]) {
                    modeMax = counting[i];
                    mode = i - 4000;
                    isMode1st = true;
                } else if (modeMax == counting[i] && isMode1st == true) {
                    mode = i - 4000;
                    isMode1st = false;
                }
            }

            // 산술평균 출력
            int average = Math.round((float) sum / total);
            System.out.println(average);

            // 중앙값 출력
            System.out.println(median);

            // 최빈값 출력
            System.out.println(mode);

            // 범위 출력
            int range = Math.abs(max - min);
            System.out.println(range);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
