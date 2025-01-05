import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creating objects for InputStreamReader, OupputStreamWriter
        InputStreamReader inputStreamReader = new InputStreamReader(System.in); // byte to string from console input
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out); // OutputStreamWriter OR just OutputStream 'cause we have PrintWriter?
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        // Add BuffuredReader, BufferedWriter to speed up the job
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(printWriter);

        // Taking integer input for loop size
        int loopSize = Integer.parseInt(bufferedReader.readLine());

        // ForLoop
        for (int i = 0; i < loopSize; i++) {
            // Taking string input
            String inputString = bufferedReader.readLine();

            // Split and parse into int
            int parsedIntA = Integer.parseInt(inputString.split("\\s")[0]);
            int parsedIntB = Integer.parseInt(inputString.split("\\s")[1]);

            // Sum and convert into String
            String outputString = String.valueOf((parsedIntA + parsedIntB));

            // Write outputString
            printWriter.println(outputString);
        }
        // Input resource flush and close
        outputStreamWriter.flush(); outputStreamWriter.close(); bufferedReader.close();
        // Output resource flush and close
        printWriter.flush(); printWriter.close(); bufferedWriter.flush(); bufferedWriter.close();
    }
}
