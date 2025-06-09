import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int total = Integer.parseInt(br.readLine());
            int[] arr = new int[total];

            for (int i = 0; i < total; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(arr);

            StringBuilder st = new StringBuilder();
            for (int i = 0; i < total; i++) {
                st.append(arr[i]).append('\n');
            }

            bw.write(st.toString());
        }
    }
}
