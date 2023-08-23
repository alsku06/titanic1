import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object for reading input from the user
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter the file name
        System.out.print("Enter the file name: ");
        String fileName = input.nextLine();

        // Prompt the user to enter the range (e.g. 10-28)
        System.out.print("Enter the range (e.g. 10-28): ");
        String range = input.nextLine();

        // Parse the start and end of the range from the input string
        int start = Integer.parseInt(range.split("-")[0]);
        int end = Integer.parseInt(range.split("-")[1]);

        // Try to open and read the file
        try {
            Scanner fileInput = new Scanner(new File(fileName));

            // Read each line of the file
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();

                // Split the line into words
                for (String word : line.split(" ")) {
                    // Try to parse the word as an integer
                    try {
                        int num = Integer.parseInt(word);

                        // If the number is within the range, print the line
                        if (num >= start && num <= end) {
                            System.out.println(line);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        // If the word is not a number, do nothing
                    }
                }
            }

            // Close the file when we're done reading it
            fileInput.close();
        } catch (FileNotFoundException e) {
            // If the file is not found, print an error message
            System.out.println("File not found.");
        }
    }
}
