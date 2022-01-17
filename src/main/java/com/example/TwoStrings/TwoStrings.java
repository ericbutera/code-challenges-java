// https://www.hackerrank.com/challenges/two-strings/problem
package com.example.TwoStrings;

public class TwoStrings {
    public static String twoStrings(String s1, String s2) {
        for (var x=0; x < s1.length(); x++) {
            for (var y=0; y < s2.length(); y++) {
                char first = s1.charAt(x);
                char second = s2.charAt(y);

                if (first == second)
                    return "YES";
            }
        }

        return "NO";
    }
}