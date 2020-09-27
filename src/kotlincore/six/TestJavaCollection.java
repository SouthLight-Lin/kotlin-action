package kotlincore.six;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author linnanwei
 * @since 1.0.0
 */
public class TestJavaCollection {
    public void testLazyEvaluation(final List<String> strings) {
        final List<String> newStrings = strings.stream()
                .filter("aaaa"::equals)
                .map(it -> it + "bbbbb")
                .collect(Collectors.toList());
        System.out.println(newStrings);
    }

    public static void main(String[] args) {
        final List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("a");
        final Stream<String> stringStream = strings.stream();
        stringStream.filter("m"::equals).collect(Collectors.toList());
        // will happend exception
        stringStream.filter("m"::equals).collect(Collectors.toList());
    }
}
