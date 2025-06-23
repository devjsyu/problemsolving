import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            // 입력 받기
            int total = Integer.parseInt(br.readLine());
            String[] strings = new String[total];
            for (int i = 0; i < total; i++) {
                strings[i] = br.readLine();
            }

            // Comparator 클래스의 compare 메서드를 오버라이딩 하여 커스텀 정렬 구현하기
            Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    // 단어 길이가 같을 경우 사전순 정렬
                    if (o1.length() == o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o1.length() - o2.length();
                }
            });

            // 중복 제외하고 출력하기
            // 한 번에 출력하기 위한 StringBuilder
            StringBuilder st = new StringBuilder();
            for (int i = 0; i < total; i++) {
                if (i > 0 && strings[i].equals(strings[i-1])) {
                    continue;
                }
                st.append(strings[i]).append("\n");
            }
            bw.write(st.toString());
        }
    }
}
