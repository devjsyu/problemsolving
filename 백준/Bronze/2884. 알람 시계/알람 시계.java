import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Set format
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("H m");

        // Set base time
        LocalDateTime localDateTime = LocalDateTime.of(2024, 12, 31, 0, 0, 0);

        // Create an object for taking inputs
        Scanner scanner = new Scanner(System.in);

        // Parse a input
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");

        // Set time as input
        LocalDateTime localDateTime1 = localDateTime.plusHours(Long.parseLong(s1[0])).plusMinutes(Long.parseLong(s1[1]));

        // Minus 45 min
        LocalDateTime localDateTime2 = localDateTime1.minusMinutes(45);

        // Format a LocalDateTime object with a DateTimeFormatter object
        String format1 = localDateTime2.format(dateTimeFormatter);

        // Print the result
        System.out.println(format1);
    }
}
