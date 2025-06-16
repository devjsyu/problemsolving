import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // 입력 받기
            // 전체 개수
            int total = Integer.parseInt(reader.readLine());
            // 입력 받은 수열을 배열에 저장
            int[] arr = new int[total];
            for (int i = 0; i < total; i++) {
                arr[i] = Integer.parseInt(reader.readLine());
            }

            // 산술평균 출력
            int sum = 0;
            for (int i = 0; i < total; i++) {
                sum += arr[i];
            }
            int average = Math.round((float) sum / total);
            System.out.println(average);

            // 중앙값 출력
            Arrays.sort(arr);
            int median = arr[total / 2];
            System.out.println(median);

            // 최빈값 출력
            // 계수정렬의 아이디어 활용
            // min부터 max까지 각 인덱스에 각 값에 대한 빈도수를 저장하는 배열 만들기
            // min을 0번째 인덱스로 하면 중간과정이 복잡해지니 공간복잡도를 다소 희생해서 전체 수 범위(-4,000 ~ 4,000)를 가진 배열을 생성한다
            int mode = 0;
            int min = arr[0];
            int max = arr[total - 1];
            int[] counting = new int[8001];

            // 기준 배열의 값마다 해당 값 인덱스에 개수 집계하기
            // 배열 인덱스에 음수가 올 수 없기 때문에 인덱스에 임의의 조정을 한다
            for (int i = 0; i < total; i++) {
                counting[arr[i] + 4000]++;
            }

            // 최빈값 찾기
            int mode1st = 0;
            // 최빈값이 여러 개 있을 때, 두 번째로 작은 최빈값을 출력하기
            int mode2nd = 0;
            // 가장 작은 최빈값과 구분하기 위한 플래그
            boolean isMode1st = false;

            // 기준 배열의 값마다 인덱스의 값을 증가시킨 배열에서 값은 집계값, 가장 큰 값이 최빈값이 된다
            for (int i = min + 4000; i <= max + 4000 ; i++) {
                if (mode1st < counting[i]) {
                    mode1st = counting[i];
                    mode = i - 4000;
                    isMode1st = true;
                } else if (mode1st == counting[i] && isMode1st == true) {
                    mode2nd = counting[i];
                    mode = i - 4000;
                    isMode1st = false;
                }
            }

            System.out.println(mode);

            // 범위 출력
            int range = Math.abs(arr[total - 1] - arr[0]);
            System.out.println(range);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
