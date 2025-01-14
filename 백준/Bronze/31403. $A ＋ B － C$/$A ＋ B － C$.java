import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create an object for taking inputs
        Scanner scanner = new Scanner(System.in);

        // Assign variables for input taken
        int inputA = scanner.nextInt();
        int inputB = scanner.nextInt();
        int inputC = scanner.nextInt();

        // case 1. NUMBER
        System.out.println(inputA + inputB - inputC);

        // case 2. STRING
        String sumAB = String.valueOf(inputA) + String.valueOf(inputB);
        System.out.println(Integer.parseInt(sumAB) - inputC);
    }
}
