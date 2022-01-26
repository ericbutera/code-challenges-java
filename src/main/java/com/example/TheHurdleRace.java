// https://www.hackerrank.com/challenges/the-hurdle-race
package com.example;

import java.util.List;

public class TheHurdleRace {
    public static int hurdleRace(int k, List<Integer> height) {
        var highest = 0;
        for (var hurdle : height) {
            if (hurdle > highest) {
                highest = hurdle;
            }
        }

        return Math.max((highest - k), 0); // prevent -
    }
}
