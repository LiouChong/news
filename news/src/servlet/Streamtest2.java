package servlet;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 描述:
 *
 * @author liuchong
 */
public class Streamtest2 {
    public static void main(String[] args) {
        Object[] powers = Stream.iterate(1,p -> p * 2).peek( e -> System.out.println("Fetching " + e)).limit(20).toArray();
        System.out.println(Arrays.toString(powers));
    }
}
