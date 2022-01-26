package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static com.example.Helpers.asIntList;
import static com.example.TheHurdleRace.hurdleRace;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TheHurdleRaceTest {

    @Test
    void example() {
        var height = Arrays.asList(1, 2, 3, 3, 2);
        var k = 1;
        var res = hurdleRace(k, height);
        assertEquals(2, res);
    }

    @ParameterizedTest
    @CsvSource({"1 2 3 3 2,1,2", "2 5 4 5 2,7,0", "1 6 3 5 2,4,2"})
    void sample1(String input, Integer k, Integer potions) {
        assertEquals(potions, hurdleRace(k, asIntList(input)));
    }

}
