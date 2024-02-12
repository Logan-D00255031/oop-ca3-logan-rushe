import java.util.ArrayDeque;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        // Create string for HTML tags
        String htmlTags = "<p> <ul> <li> </li> </u> <a> </p>";
        // Display the tags
        System.out.println(htmlTags);
        // Create a scanner for the HTML tags
        Scanner in = new Scanner(htmlTags);
        // Create Stack
        ArrayDeque<String> tags = new ArrayDeque<>();

        while (in.hasNext()) {
            // Get next tag
            String tag = in.next();
            // remove < > from tag
            tag = tag.substring(1, tag.length() - 1);
            //System.out.println(tag);
            // Check if it's a closing tag
            if(tag.charAt(0) == '/') {
                // Look at current tag on top of the stack
                String currentTag = tags.peek();
                // Check if the closing tag is the same tag as the open tag of the current tag on top of the stack
                if(tag.substring(1).equals(currentTag)) {
                    // Remove the tag on top of the stack
                    tags.remove();
                }
                else {
                    // Display error
                    System.out.println("The Tag '" + tag.substring(1) + "' is not the current open tag or does not exist");
                }
            } // Not a closing tag
            else {
                // Push the tag to the stack
                tags.push(tag);
            }
            //System.out.println(tags);
        }
        // If the stack is not empty
        if(!tags.isEmpty()) {
            // Display the open tags
            System.out.printf("Tag(s) not closed: " + tags);
        }

    }
}
