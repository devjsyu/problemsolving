import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // try-with resources for auto closing
        try (
                // Instantiate buffered IO class
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out)))
        {
            int size = Integer.parseInt(bufferedReader.readLine());

            // StringBuilder to store results
            StringBuilder stringBuilder = new StringBuilder();

            // for loop
            for (int i = 0; i < size; i++) {
                String s = bufferedReader.readLine();
                for (int j = 2, n = s.length(); j < n; j++) {
                    String repeatedString = String.valueOf(s.charAt(j)).repeat(Character.getNumericValue(s.charAt(0)));
                    stringBuilder.append(repeatedString);
                }
                stringBuilder.append("\n");
            }

            // Printing the results all at once
            printWriter.println(stringBuilder);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
