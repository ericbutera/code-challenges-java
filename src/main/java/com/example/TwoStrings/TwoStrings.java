// https://www.hackerrank.com/challenges/two-strings/problem
package com.example.TwoStrings;

import java.util.ArrayList;

public class TwoStrings {
    public static String twoStrings(String s1, String s2) {
        // cache prevents retrying characters
        var cache = new ArrayList<Character>();

        for (var x=0; x < s1.length(); x++) {
            char first = s1.charAt(x);

            if (cache.contains(first))
                continue;

            for (var y=0; y < s2.length(); y++) {
                char second = s2.charAt(y);

                if (first == second)
                    return "YES";
            }

            cache.add(first);
        }

        return "NO";
    }
}