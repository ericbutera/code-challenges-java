// https://www.hackerrank.com/challenges/camelcase/problem?isFullScreen=true
package com.example;

public class CamelCase {
    public static int camelcase(String s) {
        // latin1 chars only
        var start = "A".codePointAt(0);
        var end = "Z".codePointAt(0);
        int count = 1;

        for (var x=0; x < s.length(); x++) {
            var code = s.codePointAt(x);
            if (code >= start && code <= end)
                count++;
        }

        return count;
    }
}
