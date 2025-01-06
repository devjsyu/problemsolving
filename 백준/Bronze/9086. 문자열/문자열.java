import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // try-with-resources for auto close
        try (
                // BufferedReader for faster input
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Taking input
            int inputSize = Integer.parseInt(br.readLine());

            // Declare a variable outside the for-loop
            String inputString;

            // for loop
            for (int i = 0; i < inputSize; i++) {
                // Taking input
                inputString = br.readLine();
                System.out.print(inputString.charAt(0)); // first index
                System.out.println(inputString.charAt(inputString.length() - 1)); // last index
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
