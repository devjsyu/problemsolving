import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an object for taking inputs
        Scanner scanner = new Scanner(System.in);

        // Declare an array to store inputs
        int[] inputs = new int[9];

        // Assign variables to store the index and the largest number
        int largestNumber = 0;
        int largestIndex = 0;

        // for loop to find out the largest number
        for (int i = 0; i < 9; i++) {
            inputs[i] = scanner.nextInt();
            if (largestNumber < inputs[i]) {
                largestNumber = inputs[i];
                largestIndex = i;
            }
        }

        // Prints the results
        System.out.printf("%d\n%d", largestNumber, largestIndex + 1);
    }
}
