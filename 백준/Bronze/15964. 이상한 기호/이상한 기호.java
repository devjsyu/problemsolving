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
            String input = br.readLine();
            int index = input.indexOf(" ");
            int A = Integer.parseInt(input.substring(0, index));
            int B = Integer.parseInt(input.substring(index+1));

            // Check range
            if (A > 1000 || B > 1000) {
                throw new IllegalArgumentException("Invalid input err!");
            }

            // Call new operation method
            int result = newOperator(A, B);

            // Print the result
            System.out.println(result);

        } catch (IOException | NumberFormatException e1) {
            System.out.println("Wrong range for input number! The input must be less than 1,000");
        }
    }
    private static int newOperator(int A, int B) {
        return (A+B)*(A-B);
    }
}
