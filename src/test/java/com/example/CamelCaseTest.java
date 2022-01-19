package com.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.example.CamelCase.camelcase;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CamelCaseTest {
    @ParameterizedTest
    @CsvSource({"oneTwoThree,3"})
    void example(String string, Integer words) {
        assertEquals(words, camelcase(string));
    }
}
