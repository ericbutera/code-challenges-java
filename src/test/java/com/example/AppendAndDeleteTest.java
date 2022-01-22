package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.example.AppendAndDelete.appendAndDelete;
import static com.example.AppendAndDelete.appendAndDeleteValue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppendAndDeleteTest {
    @Test
    void example0() { assertEquals("No", appendAndDelete("ashley", "ash", 2)); }

    @Test
    void example1() { assertEquals("Yes", appendAndDelete("aba", "aba", 7)); }

    @Test
    void example2() { assertEquals("Yes", appendAndDelete("hackerhappy", "hackerrank", 9)); }

    @Test
    void fencepost() { assertEquals("Yes", appendAndDelete("hacker", "h4cker", 10)); }

    @Test
    void fencepost1() { assertEquals("No", appendAndDelete("hacker", "h4cker", 9)); }

    @Test
    void input10() {
        /*
        s = abcd
        t = abcdert
        k = 10
        1 abcde
        2 abcder
        3 abcdert
        4 abcder
        5 abcdert
        6 abcder
        7 abcdert
        8 abcder
        9 abcdert
        10 abcder <-- no

        10 abc
        9 ab
        8 a
        7 ''
        6 a
        5 ab
        4 abc
        3 abcd
        2 abcde
        1 abcder
         */
        assertEquals("abcder", appendAndDeleteValue("abcd", "abcdert", 10));
        assertEquals("No", appendAndDelete("abcd", "abcdert", 10));
    }

    @ParameterizedTest
    @CsvSource({ "hackerhappy,hackerrank,6", "abc,abc,3", "ashley,ashleigh,5", "abc,def,0" })
    void findSharedIndex(String source, String dest, int expected) {
        assertEquals(expected, AppendAndDelete.findSharedIndex(source, dest));
    }

}
