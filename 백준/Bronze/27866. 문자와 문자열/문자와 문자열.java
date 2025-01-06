import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);

        // Assign variables
        String string = scanner.nextLine();
        int index = scanner.nextInt() - 1;

        // Prints charAt
        System.out.println(string.charAt(index));
    }
}
