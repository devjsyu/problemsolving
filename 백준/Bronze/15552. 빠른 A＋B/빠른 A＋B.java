import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // try-with-resources for auto close
        try (
            // Creating an object for InputStreamReader, OupputStreamWriter
            InputStreamReader inputStreamReader = new InputStreamReader(System.in); // byte to string from console input
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);

            // Add BuffuredReader, PrintWriter(BufferedWriter) to speed up the job
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter)
        ) {
            // Taking integer input for loop size
            int loopSize = Integer.parseInt(bufferedReader.readLine());

            // ForLoop
            for (int i = 0; i < loopSize; i++) {
                // Taking string input
                String inputString = bufferedReader.readLine();

                // Split and sum
                String[] splitString = inputString.split("\\s");
                int parsedIntA = Integer.parseInt(splitString[0]);
                int parsedIntB = Integer.parseInt(splitString[1]);
                int output = parsedIntA + parsedIntB;

                // Write output
                printWriter.println(output);
            }
            // Output resource flush
            printWriter.flush();
        }
    }
}