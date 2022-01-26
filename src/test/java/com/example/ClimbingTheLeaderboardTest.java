package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.example.ClimbingTheLeaderboard.climbingLeaderboard;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClimbingTheLeaderboardTest {
    @Test
    void example() {
        var ranked = Arrays.asList(100,90,90,80);
        var player = Arrays.asList(70,80,105);
        var res = Arrays.asList(4,3,1);
        assertEquals(res, climbingLeaderboard(ranked, player));
    }

    @Test
    void sample1() {
        var ranked = Arrays.asList(100, 100, 50, 40, 40, 20, 10);
        var player = Arrays.asList(5, 25, 50, 120);
        var res = Arrays.asList(6, 4, 2, 1);
        assertEquals(res, climbingLeaderboard(ranked, player));
    }

    @Test
    void sample2() {
        var ranked = Arrays.asList(100,90,90,80,75,60);
        var player = Arrays.asList(50,65,77,90,102);
        var res = Arrays.asList(6,5,4,2,1);
        assertEquals(res, climbingLeaderboard(ranked, player));
    }

    // @Timeout(value=100, unit = TimeUnit.MILLISECONDS)
    @ParameterizedTest()
    @CsvFileSource(resources = "/climbing-the-leaderboard.csv", numLinesToSkip = 1, maxCharsPerColumn = 2500000)
    void testCase01(String ranked, String player, String result) {
        // answer has 3 4's
        // result has 2 4's.. theres a fencepost issue
        assertEquals(asIntList(result), climbingLeaderboard(asIntList(ranked), asIntList(player)));
    }

    private List<Integer> asIntList(String convert) {
        return Stream.of(convert.split(" "))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
