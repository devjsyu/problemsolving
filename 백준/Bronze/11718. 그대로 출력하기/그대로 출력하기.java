import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (
            // Input string is already trimmed
            // BufferedClass
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out))
        ) {
            // UNIX, Windows, Mac
            String newLine = System.getProperty("line.separator");

            // Limit max loop size
            for (int i = 0; i < 100; i++) {
                String string = br.readLine();
                // break condition
                if (string != null) {
                    if (string.isBlank()) {
                        break;
                    }
                    pw.print(string + newLine);
                }
            }

            // Flush the buffer
            pw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
