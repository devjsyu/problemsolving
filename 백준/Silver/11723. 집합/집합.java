import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 입력 받기
            // 수행해야 하는 연산의 수 M (1 ≤ M ≤ 3,000,000)
            int M = Integer.parseInt(reader.readLine());

            // 집합 구현을 위한 HashSet 객체 생성
            HashSet<Integer> set = new HashSet<>();

            // 효율적인 출력을 위한 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // {1, 2, ..., 20} 객체 생성
            LinkedList<Integer> list = new LinkedList<>();
            int num = 1;
            for (int i = 0; i < 20; i++) {
                list.add(num++);
            }

            // for-loop 연산 반복문
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());

                // switch 연산
                switch (st.nextToken()) {
                    // add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
                    case "add" :
                        set.add(Integer.parseInt(st.nextToken()));
                        break;

                    // remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
                    case "remove" :
                        set.remove(Integer.parseInt(st.nextToken()));
                        break;

                    // check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
                    case "check" :
                        if (set.contains(Integer.parseInt(st.nextToken()))) {
                            sb.append("1").append("\n");
                        } else {
                            sb.append("0").append("\n");
                        }
                        break;

                    // toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
                    case "toggle" :
                        int x = Integer.parseInt(st.nextToken());
                        if (set.contains(x)) {
                            set.remove(x);
                        } else {
                            set.add(x);
                        }
                        break;

                    // all: S를 {1, 2, ..., 20} 으로 바꾼다.
                    case "all" :
                        set.addAll(list);

                        break;

                    // empty: S를 공집합으로 바꾼다.
                    case "empty" :
                        set.clear();
                        break;
                }
            }

            // check 연산이 주어질때마다, 결과를 출력한다.
            // 더 빠른 출력을 위해 check 연산 결과값을 모두 StringBuilder 객체에 저장 후 한 번만 출력한다.
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
