package stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by linnanwei on 2019/9/16
 *
 * @author linnanwei
 */
public class RunStream {
    public static void main(String[] args) {
        Random random = new Random();
        Stream.generate(() -> random.nextInt())
                .limit(500)
                .peek(s -> System.out.println("peek:" + s))
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s > 1000000;
                })
                .count();
    }
}
