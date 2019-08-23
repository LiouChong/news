package servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author liuchong
 */
public class StreamTest {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("C:\\Users\\Antiy\\Desktop\\type.txt")), StandardCharsets.UTF_8);
        String[] split = contents.split("\r\n");
        List<String> strings = Arrays.asList(split);
        List<String> collect = strings.stream().filter(w -> !w.equals("SQL注入 ") && !w.equals("信息泄露 ")).collect(Collectors.toList());
        collect.remove(0);
        for (int i = 3; i < collect.size() + 3; i++) {
            System.out.println("('" + i + "','" + collect.get(i -3).substring(0,collect.get(i-3).length()-1) + "',1,1),");
        }
//        List<String> longWord = Arrays.stream(split).filter(w -> w.length() > 12).collect(Collectors.toList());
       /* List<String> lowercaseWords = Arrays.stream(split).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(lowercaseWords);
        List<String> firstLetters = Arrays.stream(split).map(s-> s.substring(0,1)).collect(Collectors.toList());
        System.out.println(firstLetters);
        // 可以看到流的筛选改变对原值并无影响。
        Stream<String> combined = Stream.concat(letters("hello"), letters("world"));
        System.out.println(combined.collect(Collectors.toList()));

        List<String> distinct = new LinkedList<>();
        distinct.add("liuchong");
        distinct.add("aa");
        distinct.add("bb");
        distinct.add("cc");
        distinct.add("liuchong");
        distinct.add("cc");
        Stream<String> distinctResult = distinct.stream().distinct();
        System.out.println(distinctResult.collect(Collectors.toList()));*/
    }

    public static <T> void showList(String title, Stream<T> stream) {
        List<T> firstElements = stream.collect(Collectors.toList());
        System.out.println(title + " : ");
        for (int i = 0; i < firstElements.size(); i++) {
            if (firstElements.get(i) instanceof Stream) {
                showList(title + i, (Stream<T>)firstElements.get(i));
            } else {
                System.out.print(firstElements.get(i));
            }
        }
        System.out.println();
    }

    public static Stream<String> letters(String s) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            result.add(s.substring(i, i + 1));
        }
        return result.stream();
    }
}
