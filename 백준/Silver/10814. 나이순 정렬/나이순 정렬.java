import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // try-resources for auto closable
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)))
        {
            // variables from input
            int total = Integer.parseInt(br.readLine());
            String[][] arr = new String[total][2];
            for (int i = 0; i < total; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                arr[i][0] = stringTokenizer.nextToken(); // age
                arr[i][1] = stringTokenizer.nextToken(); // name
            }

            // custom sorting with Comparator
            Arrays.sort(arr, new Comparator<String[]>() {
                // sorting on age
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
            });

            // print the result
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < total; i++) {
                stringBuilder.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
            }

            bw.write(stringBuilder.toString());
        }
    }
}
