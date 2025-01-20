import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // try-with resources for auto closing
        try (
                // Instantiate buffered IO class
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(System.out))) {

            // Take the input as a size
            int inputSize = Integer.parseInt(bufferedReader.readLine());
            StringBuilder stringBuilder = new StringBuilder();

            // for loop
            for (int i = 0; i < inputSize; i++) {
                String string = bufferedReader.readLine();
                String[] strings = string.split(" ");
                int roomNumber = Integer.parseInt(strings[2]) / Integer.parseInt(strings[0]);
                int floorNumber = Integer.parseInt(strings[2]) % Integer.parseInt(strings[0]);

                // Adjust the case when remainder is zero
                if (floorNumber == 0) {
                    floorNumber = Integer.parseInt(strings[0]);
                    roomNumber--;
                }

                // Add formatted string to StringBuilder
                stringBuilder.append(floorNumber).append(String.format("%02d", roomNumber + 1)).append("\n");
            }

            // Prints the results all at once
            printWriter.println(stringBuilder);
        } catch (IOException e) {
            throw new IOException(e);
        }
    }
}
