import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for the first variable
        int size = scanner.nextInt();
        scanner.nextLine(); // Take away '/n' from the remnant buffer

        // Taking input for the second variable
        String inputString = scanner.nextLine();

        // Convert the string into char array
        char[] charArray = inputString.toCharArray();

        // Declare a variable for sum
        int sum = 0;

        // for loop
        for (int i = 0; i < size; i++) {
            sum += (charArray[i] - '0'); // subtract '0' to convert char number as int
        }

        // Prints the result
        System.out.println(sum);
    }
}
