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
            // Determine if a link exists in the substring starting from currentIndex by checking whether a dot(.) exists
            int dotIndex = markdown.indexOf(".", currentIndex);
            if (dotIndex == -1) {
                break;
            }

            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", currentIndex);
            int closeParen = markdown.indexOf(")", openParen);

            String returnedStr;
            int start;
            int end;

            // When no "[" and/or "(" exists in the substring starting from currentIndex
            if (openBracket == -1 || openParen == -1) {
                // [] exists only
                if (openBracket != -1) {
                    // find out the [] containing the link
                    start = markdown.lastIndexOf("[", dotIndex);
                    end = markdown.indexOf("]", start);
                }
                // () exists only
                else if (openParen != -1) {
                    // find out the () containing the link
                    start = markdown.lastIndexOf("(", dotIndex);
                    end = markdown.indexOf(")", start);
                }
                // neither [] nor () exists and a link at the end of file
                else {
                    // find out the start index
                    int hIndex = markdown.indexOf("h", currentIndex);
                    int sIndex = markdown.indexOf("s", currentIndex);
                    if (hIndex < sIndex) {
                        start = hIndex - 1;
                    } else {
                        start = sIndex - 1;
                    }

                    end = markdown.length();
                }
            }
            // Normal condition (with both [] and ())
            else {
                start = markdown.lastIndexOf("(", dotIndex);
                end = markdown.indexOf(")", start);
            }

            // Generate a substring containing this link
            returnedStr = markdown.substring(start + 1, end);
            
            // Remove extra spaces if present
            returnedStr = returnedStr.replaceAll(" ", "");

            // Check if the string is empty
            if (returnedStr.equals("") == false) {
                toReturn.add(returnedStr);
            }

            currentIndex = end + 1;

            // // Original Code
            // int openBracket = markdown.indexOf("[", currentIndex);
            // int closeBracket = markdown.indexOf("]", openBracket);
            // int openParen = markdown.indexOf("(", closeBracket);
            // int closeParen = markdown.indexOf(")", openParen);

            // String returnedStr;
            // int start;
            // int end;
            // // Determine the checked indices
            // if (currentIndex == 0) {
            //     start = currentIndex;
            //     end = currentIndex + 1;
            // }
            // else {
            //     start = openBracket - 1;
            //     end = openBracket;
            // }

            // // Check if there is a ! before []
            // if (markdown.substring(start, end).equals("!") == false) {
            //     returnedStr = markdown.substring(openParen + 1, closeParen);

            //     // Remove extra spaces if present
            //     returnedStr = returnedStr.replaceAll(" ", "");

            //     // Check if the string is empty
            //     if (returnedStr.equals("") == false) {
            //         toReturn.add(returnedStr);
            //     }
            // }
            // currentIndex = closeParen + 1;
            
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
