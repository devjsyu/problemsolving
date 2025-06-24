import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            // 입력 받기
            int N = Integer.parseInt(reader.readLine());

            int[][] arr = new int[N][2]; // x, y 순서쌍 저장할 2차원 배열

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
                arr[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
            }

            // 정렬하기
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                }
            });

            // 출력하기
            StringBuilder sb = new StringBuilder();
            for (int[] pair : arr) {
                sb.append(pair[0]).append(" ").append(pair[1]).append('\n');
            }
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
