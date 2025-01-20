import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Taking input
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine(); // reset new line

        // StringBuilder to store results
        StringBuilder stringBuilder = new StringBuilder();

        // for loop
        for (int i = 0; i < size; i++) {
            String s = scanner.nextLine();
            for (int j = 2, n = s.length(); j < n; j++) {
                String repeatedString = String.valueOf(s.charAt(j)).repeat(Character.getNumericValue(s.charAt(0)));
                stringBuilder.append(repeatedString);
            }
            stringBuilder.append("\n");
        }

        // Printing the results all at once
        System.out.println(stringBuilder);
    }
}
