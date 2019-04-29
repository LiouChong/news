package servlet;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:
 *
 * @author liuchong
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\Antiy\\Desktop\\streamTest.txt")), StandardCharsets.UTF_8);
        String[] split = contents.split("/n");
        System.out.println(Arrays.toString(split));
        List<String> words = Arrays.asList(split);
        System.out.println(words.size());
        int count = 0;
        for (String word : words) {
            if (word.length() > 7) {
                count ++;
            }
        }
        System.out.println(words);
        System.out.println(count);
    }
}
