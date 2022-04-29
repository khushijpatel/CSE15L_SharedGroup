//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            String returnedStr;
            int start;
            int end;

            // Determine the checked indices
            if (currentIndex == 0) {
                start = currentIndex;
                end = currentIndex + 1;
                
            } else {
                start = openBracket - 1;
                end = openBracket;
            }

            // Check if there is a ! before []
            if (markdown.substring(start, end).equals("!") == false) {
                returnedStr = markdown.substring(openParen + 1, closeParen);

                // Remove extra spaces if present
                returnedStr = returnedStr.replaceAll(" ", "");

                // Check if the string is empty
                if (returnedStr.equals("") == false) {
                    toReturn.add(returnedStr);
                }
            }

            currentIndex = closeParen + 1;
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
