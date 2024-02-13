import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Main.java");
        Map<String, TreeSet<Integer>> map = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            // Create count
            int count = 0;
            // Loop until it reaches the end of the file
            while(scanner.hasNextLine()) {
                // Get the current line
                String currentLine = scanner.nextLine();
                // Create scanner for the current line
                Scanner in = new Scanner(currentLine);
                // Increase the count
                count++;
                // Delimiter
                in.useDelimiter("[^A-Za-z0-9_]+");
                // Create stack for tokens
                ArrayList<String> tokens = new ArrayList<>();
                // loop until it reaches the end of the line
                while (in.hasNext()) {
                    // Add the identifier to the token stack
                    tokens.add(in.next());
                }
                //System.out.printf(count + "\t" + currentLine + "\n");
                //System.out.println(tokens);
                // Add identifiers to map
                for(String token : tokens) {
                    // If the identifier isn't already in the map
                    if (!map.containsKey(token)) {
                        // Add the identifier to the map
                        map.put(token, new TreeSet<>());
                        // Add the line it was found in to the identifier's stack
                        map.get(token).add(count);
                    }
                    else {
                        // Add the line it was found in to the identifier's stack
                        map.get(token).add(count);
                    }
                }
            }
            // Display the tokens in the map
            for (Entry<String, TreeSet<Integer>> identifier : map.entrySet()) {
                String currentLine = "";
                // Get the current identifier's stack
                TreeSet<Integer> set = identifier.getValue();
                // Display the current identifier
                System.out.println("Identifier: " + identifier.getKey());
                System.out.println("Lines Occurred:");
                // Display the lines the identifier is found in
                for(int line : set) {
                    // Create new scanner
                    Scanner lines = new Scanner(file);
                    // Print out the line number
                    System.out.printf(line + "\t");
                    // Scan through the file until it reaches the line
                    for (int i = 0; i < line; i++) {
                        currentLine = lines.nextLine();
                    }
                    // Print out the line
                    System.out.println(currentLine);
                    // Close the scanner
                    lines.close();
                }
                System.out.println();
            }
        }

    }
}
