import java.io.*;
import java.util.StringTokenizer;

// 나눗셈 연산과 모듈러 연산, 빠른 IO, 음의 정수 반올림 내림
public class Main {
    public static void main(String[] args) throws IOException {
        // IO
        // try-catch resources
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
            )
        {
            // variables
            int total = Integer.parseInt(br.readLine());
            StringTokenizer order = new StringTokenizer(br.readLine());
            String[] pack = br.readLine().split(" ");
            int tshirtPack = Integer.parseInt(pack[0]);
            int penPack = Integer.parseInt(pack[1]);
            int count = 0;

            // for-loop
            for (int i = 0; i < 6; i++) {
                count += (Integer.parseInt(order.nextToken()) - 1 + tshirtPack)/ tshirtPack;
            }

            // Print the result with StringBuilder
            StringBuilder st = new StringBuilder();
            StringBuilder result = st.append(count).append("\n").append(total / penPack).append(" ").append(total % penPack);

            bw.write(String.valueOf(result));
        }
    }
}
