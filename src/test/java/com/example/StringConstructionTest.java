package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.example.StringConstruction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConstructionTest {
    @ParameterizedTest
    @CsvSource({"abcd,4", "abab,2"})
    void input00(String string, Integer cost) {
        assertEquals(cost, stringConstructionCached(string));
        assertEquals(cost, stringConstructionNoCache(string));
    }

    @ParameterizedTest
    @CsvSource({"scfg,4", "bccb,2"}) // https://www.baeldung.com/parameterized-tests-junit-5
    void input12(String string, Integer cost) {
        assertEquals(cost, stringConstructionCached(string));
        assertEquals(cost, stringConstructionNoCache(string));
    }
}

