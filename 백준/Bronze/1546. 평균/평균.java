import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int total = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int largest = 0;
            int temp = 0;
            int sum = 0;

            for (int i = 0; i < total; i++) {
                temp = Integer.parseInt(st.nextToken());
                sum += temp;
                if (temp > largest) {
                    largest = temp;
                }
            }

            double result = (double) sum / largest * 100 / total;

            bw.write(String.valueOf(result));
        }
    }
}
