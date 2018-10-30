package streams.part2.exercise;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SuppressWarnings({"unused", "ConstantConditions"})
class Exercise3 {

    @Test
    void createLimitedStringWithOddNumbersSeparatedBySpaces() {
        int countNumbers = 10;

        String result = IntStream.iterate(1, i -> i+2)
                .limit(countNumbers)
                .mapToObj(String::valueOf)
                .collect(joining(" "));

        assertThat(result, is("1 3 5 7 9 11 13 15 17 19"));
    }

    @Test
    void extractEvenNumberedCharactersToNewString() {
        String source = "abcdefghijklm";

        String result = IntStream.range(0, source.length())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> String.valueOf(source.charAt(i)))
                .collect(joining());

        assertThat(result, is("acegikm"));
    }
}
