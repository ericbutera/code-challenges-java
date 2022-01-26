package com.example;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Helpers {
    public static List<Integer> asIntList(String input) {
        return asIntList(input, " ");
    }

    public static List<Integer> asIntList(String input, String separator) {
        // TODO generic version
        return Stream.of(input.split(separator))
                // .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
    }
}
