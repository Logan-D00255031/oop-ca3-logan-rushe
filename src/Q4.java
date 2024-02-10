import java.util.ArrayDeque;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        String htmlTags = "<p> <ul> <li> </li> </u> <a> </p>";
        System.out.println(htmlTags);
        Scanner in = new Scanner(htmlTags);
        ArrayDeque<String> tags = new ArrayDeque<>();

        while (in.hasNext()) {
            // Get next tag
            String tag = in.next();
            // remove < > from tag
            tag = tag.substring(1, tag.length() - 1);
            //System.out.println(tag);
            // Check if it's a closing tag
            if(tag.charAt(0) == '/') {
                String currentTag = tags.peek();
                // Check if last tag is not the opening of the new tag
                if(tag.substring(1).equals(currentTag)) {
                    tags.remove();
                }
                else {
                    System.out.println("The Tag '" + tag.substring(1) + "' is not the current open tag or does not exist");
                }
            }
            else {
                tags.push(tag);
            }
            //System.out.println(tags);
        }
        if(!tags.isEmpty()) {
            System.out.printf("Tag(s) not closed: " + tags);
        }

    }
}
