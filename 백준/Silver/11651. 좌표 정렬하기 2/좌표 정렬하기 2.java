import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 2차원 x, y 좌표 순서쌍 정렬하기
// 중복 없고, y, x 순으로 오름차순 정렬하기
public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 전체 개수 입력 받기
            int N = Integer.parseInt(reader.readLine());

            // 입력 받을 변수 선언
            int[][] arr = new int[N][2]; // x, y 순서쌍을 저장할 2차원 배열
            StringBuilder sb = new StringBuilder(); // 한 줄씩 읽은 문자를 임시 저장할 StringBuilder 클래스

            // x, y 순서쌍 모두 입력 받아 StringBuilder 객체에 임시 저장
            for (int i = 0; i < N; i++) {
                sb.append(reader.readLine()).append('\n');
            }

            // 임시 저장된 전체 문자열으로 StringTokenizer 클래스의 객체 초기화
            StringTokenizer st = new StringTokenizer(sb.toString()); // Delimiter가 일관적이므로 문자열파싱 대신 더 효율적인 token 활용

            // 문자열 토큰을 정수로 파싱 후 배열에 입력
            for (int i = 0; i < N; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            // 배열의 기본 sort 메서드와 Comparator를 활용하여 커스텀 정렬
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // y 축 동일한 경우 x 축 비교
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        // 그외 나머지 경우, y 축 기준 비교
                        return o1[1] - o2[1];
                    }
                }
            });

            // 출력 효율을 위해 한 번에 출력하기
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb2.append(arr[i][0]).append(' ').append(arr[i][1]).append('\n');
            }
            writer.write(sb2.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
