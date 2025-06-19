import java.io.*;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            // 1. 입력 받기
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 2. 해시셋 객체 생성 및 값 할당
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(reader.readLine());
            }

            // 효율적인 출력을 위해 StringBuilder 객체 생성
            StringBuilder sb = new StringBuilder();

            // 조건 충족하는 경우의 수 저장할 변수 선언
            int num = 0;
            // 조건 충족하는 문자열 저장할 콜렉션 객체 선언
            LinkedList<String> list = new LinkedList<>();

            // 3. 해시함수로 존재 여부 판별
            for (int i = 0; i < M; i++) {
                String name = reader.readLine();
                if (set.contains(name)) {
                    list.add(name);
                    num++;
                }
            }

            // 4. 사전순으로 정렬
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            // 5. 출력
            sb.append(num).append("\n");
            for (String name : list) {
                sb.append(name).append("\n");
            }
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
