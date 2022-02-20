package com.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static com.example.AlternatingCharacters.alternatingCharacters;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlternatingCharactersTest {
    @Test
    void example() {
        assertEquals(2, alternatingCharacters("AABAAB"));
    }

    @Test
    void sample() {
        assertEquals(3, alternatingCharacters("AAAA"));
        assertEquals(4, alternatingCharacters("BBBBB"));
        assertEquals(0, alternatingCharacters("ABABABAB"));
        assertEquals(0, alternatingCharacters("BABABA"));
        assertEquals(4, alternatingCharacters("AAABBB"));
    }
}
