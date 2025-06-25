import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);

            int num = 0;
            while (stringTokenizer.hasMoreTokens()) {
                stringTokenizer.nextToken();
                num++;
            }

            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
