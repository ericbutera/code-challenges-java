package com.example.TwoStrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.concurrent.TimeUnit;

import static com.example.TwoStrings.TwoStrings.twoStrings;

class TwoStringsTest {
    @Test
    void andArtTest() { assertEquals("YES", twoStrings("and", "art")); }

    @Test
    void helloWorldTest() { assertEquals("YES", twoStrings("hello", "world")); }

    @Test
    void hiWorldTest() { assertEquals("NO", twoStrings("hi", "world")); }

    @Test
    void compareTest1() { assertEquals("NO", twoStrings("wouldyoulikefrie", "abcabcabcabcabcabc")); }

    @Test
    void compareTest2() { assertEquals("YES", twoStrings("hackerrankcommunity","cdecdecdecde")); }

    @Test
    void compareTest3() { assertEquals("YES", twoStrings("jackandjill", "wentupthehill")); }

    @Test
    void compareTest4() { assertEquals("NO", twoStrings("writetoyourparents", "fghmqzldbc")); }

    @Test
    void compareTest5() { assertEquals("YES", twoStrings("aardvark", "apple")); }

    @Test
    void compareTest6() { assertEquals("NO", twoStrings("beetroot", "sandals")); }

    @Timeout(value=100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest()
    @CsvFileSource(resources = "/input04.csv", numLinesToSkip = 1, maxCharsPerColumn = 100000)
    void testCase04(String s1, String s2, String result) {
        assertEquals(result, twoStrings(s1, s2));
    }
}