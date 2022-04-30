import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void checkTestFile() throws IOException {
        // test-file.md
        Path file = Path.of("C:\\Users\\Jeffrey Chen\\Documents\\GitHub\\CSE15L_SharedGroup\\test-file.md");
        String content = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>() {
            {
                add("https://something.com");
                add("some-thing.html");
            }
        };

        assertEquals(true, links.equals(result));
    }

    @Test
    public void checkTest2() throws IOException {
        // test2.md
        Path file = Path.of("C:\\Users\\Jeffrey Chen\\Documents\\GitHub\\CSE15L_SharedGroup\\test2.md");
        String content = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>(
            Arrays.asList("some-thing.html", "https://google.com",
                "some-thing.html", "https://google.com",
                "some-thing.html", "https://google.com")
        );

        assertEquals(true, links.equals(result));
    }

    @Test
    public void checkTest3() throws IOException {
        // test3.md
        Path file = Path.of("C:\\Users\\Jeffrey Chen\\Documents\\GitHub\\CSE15L_SharedGroup\\test3.md");
        String content = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>(
            Arrays.asList("some-thing.html", "https://google.com"));

        assertEquals(true, links.equals(result));
    }

    @Test
    public void checkTest4() throws IOException {
        // test4.md
        Path file = Path.of("C:\\Users\\Jeffrey Chen\\Documents\\GitHub\\CSE15L_SharedGroup\\test4.md");
        String content = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>(
            Arrays.asList("some-thing.html"));

        assertEquals(true, links.equals(result));
    }

    @Test
    public void checkTest5() throws IOException {
        // Lab 5 Part 2
        Path file = Path.of("C:\\Users\\Jeffrey Chen\\Documents\\GitHub\\CSE15L_SharedGroup\\test1.md");
        String content = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>(
            Arrays.asList("some-thing.html", "https://google.com", "https://google.com"));

        //fixed
        assertEquals(true, links.equals(result));
    }

    @Test
    public void checkTest6() throws IOException {
        // test5.md
        Path file = Path.of("C:\\Users\\Jeffrey Chen\\Documents\\GitHub\\CSE15L_SharedGroup\\test5.md");
        String content = Files.readString(file);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> result = new ArrayList<String>(
            Arrays.asList("some-thing.html", "https://google.com"));

        assertEquals(true, links.equals(result));
    }
}