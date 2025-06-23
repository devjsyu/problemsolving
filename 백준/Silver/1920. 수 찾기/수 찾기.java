import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numA = Integer.parseInt(br.readLine());
            StringTokenizer stA = new StringTokenizer(br.readLine());
            int numM = Integer.parseInt(br.readLine());
            StringTokenizer stM = new StringTokenizer(br.readLine());

            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < numA; i++) {
                set.add(stA.nextToken());
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numM - 1; i++) {
                if (set.contains(stM.nextToken())) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }

            if (set.contains(stM.nextToken())) {
                sb.append("1");
            } else {
                sb.append("0");
            }

            bw.write(sb.toString());
        }
    }
}
