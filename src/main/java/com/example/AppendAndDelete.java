// https://www.hackerrank.com/challenges/append-and-delete/problem?isFullScreen=false
package com.example;

/*
Notes: so many edge cases!

s = abc
t = def
k = 6
6 ab
5 a
4 ''
3 a
2 ab
1 abc

s=aba
t=aba
k=7
7 ab
6 a
5 ''
4 ''
3 a
2 b
1 a

s=hackerhappy
t=hackerrank
k=9
9 hackerhappy
8 hackerhapp
7 hackerhap
6 hackerha
5 hackerh
4 hacker
3 hackerr
2 hackerra
1 hackerran
0 hackerrank

1 abcd      destination string is continuation, there will be leftover moves, to use 3 moves delete "bcd"
2 abc
3 ab
4 a
5 ab
6 abc
7 abcd
8 abcde
9 abcder
10 abcdert
 */

public class AppendAndDelete {
    public enum Operations {
        APPEND,
        DELETE
    }

    /**
     *
     * @param s initial string
     * @param t desired string
     * @param k Number of moves
     * @return String
     */
    public static String appendAndDeleteValue(String s, String t, int k) {
        /*
        modify s, using the following operations k times:
        1) Append a lowercase English letter to the end of the string.
        2) Delete the last character of the string. Performing this operation on an empty string results in an empty string.

        GOAL: s.equals(t) after k operations
         */

        int t_length = t.length();
        Operations op;

        var substring = findSharedIndex(s, t);
        var extraMoves = extraMoves(t_length, substring, k);

        for (var x = 1; x <= k; x++) {
            var s_length = s.length();

            // TODO combine like expressions
            // retain individual expressions though, as reqs change this could become _more_ difficult to understand
            if (substring == 0 && s_length > 0) {
                // no matching chars, must delete everything
                op = Operations.DELETE;
            } else if (s_length > substring) {
                // original string contains chars not in desired string
                op = Operations.DELETE;
            } else if (extraMoves > 0) {
                op = Operations.DELETE;
            } else if (substring > 0 && substring < t_length) {
                // shared substring less than desired string; append until s == t
                op = Operations.APPEND;
            } else if (s_length == 0) {
                // s cleared, start appending
                op = Operations.APPEND;
            } else {
                // noop?
                op = Operations.DELETE;
            }

            if (op == Operations.APPEND) {
                s = s + t.charAt(substring);
            } else {
                extraMoves--;
                var deleteIndex = Math.max(s_length - 1, 0); // index bounds safety
                s = s.substring(0, deleteIndex);
            }

            substring = findSharedIndex(s, t);
        }

        return s;
    }

    public static String appendAndDelete(String s, String t, int k) {
        var res = appendAndDeleteValue(s, t, k);
        return res.equals(t) ? "Yes" : "No";
    }

    /**
     * Find the common substring offset between two strings.
     *
     * hackerhappy, hackerrank both share `hacker`, therefore the shared offset is 6
     *
     * @param s original string
     * @param t desired string
     * @return int
     */
    public static int findSharedIndex(String s, String t) {
        // constraints say input strings are 1 to 100 chars
        var schars = s.toCharArray();
        var tchars = t.toCharArray();

        var max = Math.min(schars.length, tchars.length);
        var offset = 0;  // contains the shared substring offset between s and t

        for (; offset < max; offset++) {
            if (schars[offset] != tchars[offset])
                break;
        }

        return offset;
    }

    /**
     * How many moves need to be "erased" by deleting against an empty string?
     * @param t_length desired string length
     * @param substring shared substring of s & t
     * @param k Total moves
     * @return int
     */
    private static int extraMoves(int t_length, int substring, int k) {
        int t_needed = Math.max(0, t_length - substring);

        var moves = k - substring;
        moves -= t_needed; // don't erase more moves than needed

        return moves;
    }
}
