import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Main.java");
        Map<String, TreeSet<Integer>> map = new HashMap<>();

        try (Scanner scanner = new Scanner(file)) {
            int count = 0;
            while(scanner.hasNextLine()) {
                String currentLine = scanner.nextLine();
                Scanner in = new Scanner(currentLine);
                count++;
                in.useDelimiter("[^A-Za-z0-9_]+");
                ArrayList<String> tokens = new ArrayList<>();
                while (in.hasNext()) {
                    tokens.add(in.next());
                }
                //System.out.printf(count + "\t" + currentLine + "\n");
                //System.out.println(tokens);
                for(String token : tokens) {
                    if (!map.containsKey(token)) {
                        map.put(token, new TreeSet<>());
                        map.get(token).add(count);
                    }
                    else {
                        map.get(token).add(count);
                    }
                }
            }
            for (Entry<String, TreeSet<Integer>> identifier : map.entrySet()) {
                String currentLine = "";
                TreeSet<Integer> set = identifier.getValue();
                System.out.println("Identifier: " + identifier.getKey());
                System.out.println("Lines Occurred:");
                for(int line : set) {
                    Scanner lines = new Scanner(file);
                    System.out.printf(line + "\t");
                    for (int i = 0; i < line; i++) {
                        currentLine = lines.nextLine();
                    }
                    System.out.println(currentLine);
                    lines.close();
                }
                System.out.println();
            }
        }

    }
}
