package com.example.TwoStrings;

import org.junit.jupiter.api.Test;

import static com.example.TwoStrings.TwoStrings.twoStrings;
import static org.junit.jupiter.api.Assertions.*;

class TwoStringsTest {
    @Test
    void andArtTest() {
        assertEquals("YES", twoStrings("and", "art"));
    }

    @Test
    void helloWorldTest() {
        assertEquals("YES", twoStrings("hello", "world"));
    }

    @Test
    void hiWorldTest() {
        assertEquals("NO", twoStrings("hi", "world"));
    }

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
    void compareTest6() { assertEquals("NO!", twoStrings("beetroot", "sandals")); }

}