// https://www.hackerrank.com/challenges/between-two-sets/
package com.example;

import java.util.List;

public class AlternatingCharacters {
    public static int alternatingCharacters(String s) {
        int deletions = 0;

        char current = s.charAt(0);
        for (var x=1; x < s.length(); x++) {
            var letter = s.charAt(x);
            if (letter == current) {
                deletions++;
            } else {
                current = letter;
            }
        }

        return deletions;
    }
}

/*
AABAAB
current = A
deleted = 0;

current = A
deletions = 0



 */