import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        // try-with-resources for auto close
        try (
                                // BufferedReader object for faster input
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
                ) {
            // Assign variables
            String[] inputArray = br.readLine().split(" ");
            long A = Long.parseLong(inputArray[0]);
            long B = Long.parseLong(inputArray[1]);

            // Call new operation method
                long result = newOperator(A, B);

            // Print the result
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // A@B operation method
    private static long newOperator(long A, long B) {
        return (A+B)*(A-B);
    }
}
