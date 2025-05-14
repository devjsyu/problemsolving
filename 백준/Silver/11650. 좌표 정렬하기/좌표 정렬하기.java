import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {
    // 최악의 경우 O-N^2 시간복잡도를 갖는 Arrays.sort(Dual pivot quick sort) 대신,
    // 최악의 경우에도 O-NlogN 시간복잡도를 갖는 Collections.sort(Tim Sort)를 사용한다.
    public static void main(String[] args) throws IOException {
        // 자원 반납을 위한 try-with resource 구조
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            // 입력으로부터 변수 초기화
            int total = Integer.parseInt(br.readLine());
            LinkedList<String> strings = new LinkedList<>();
            for (int i = 0; i < total; i++) {
                strings.add(br.readLine());
            }

            // Comparator 커스텀 정렬
            Collections.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String[] s1 = o1.split(" ");
                    String[] s2 = o2.split(" ");

                    if (s1[0].equals(s2[0])) {
                        return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
                    }
                    return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
                }
            });

            // 빠른 출력을 위해 StringBuilder 활용
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < total; i++) {
                st.append(strings.pop()).append("\n");
            }

            // 출력
            bw.write(st.toString());
        }
    }
}
