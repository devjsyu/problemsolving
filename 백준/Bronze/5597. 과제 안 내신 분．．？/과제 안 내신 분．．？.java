import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try (
            // BufferedReader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))
            ) {
            // Assign variables
            int totalStudent = 30;
            int submittedStudent = 28;

            // Create list of every student number
            LinkedList<String> studentList = new LinkedList<>();
            for (int i = 0; i < totalStudent; i++) {
                studentList.add(String.valueOf(i + 1));
            }

            // StringBuilder to get a whole string faster
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < submittedStudent; i++) {
                stringBuilder.append(bufferedReader.readLine()).append(" ");
            }

            // StringTokenizer to split the string
            StringTokenizer stringTokenizer = new StringTokenizer(stringBuilder.toString());

            // Delete elements when matched with tokens
            for (int i = 0; i < submittedStudent; i++) {
                studentList.remove(stringTokenizer.nextToken());
            }

            // Prints remainder of the list
            System.out.println(studentList.get(0) + "\n" + studentList.get(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
