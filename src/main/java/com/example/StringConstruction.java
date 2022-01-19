// https://www.hackerrank.com/challenges/string-construction/problem
package com.example;

/*
GOAL lowest possible cost
SECONDARY maximize the substrings

scfg = $4, no substrings
bccb = $2
    b unique
    c unique
    c used
    b used
 */

public class StringConstruction {
    public static int stringConstruction(String s) {
        return stringConstructionCached(s);
    }

    public static int stringConstructionCached(String s) {
        var max = s.length();
        var out = new char[max];
        var cache = new char[max];

        int cacheIndex = 0;
        int cost = 0;

        for (var x=0; x < max; x++) {
            var cacheHit = false;
            var current = s.charAt(x);

            for (var y=0; y < cacheIndex; y++) {
                // there must be a faster way to do this?
                // maybe a hash/dictionary of {char code => char}
                //
                // start in the middle of cache (cache[ceil(cacheIndex / 2)])
                // is value > than current, then try to the right (range of middle to end / 2)
                // else try to the left
                if (cache[y] == current) {
                    cacheHit = true;
                    break;
                }
            }

            if (!cacheHit) {
                cache[cacheIndex] = current;
                cacheIndex++; // how curious cache index & cost are the same
                cost++;
            }

            out[x] = current;
        }

        return cost;
    }

    public static int stringConstructionNoCache(String s) {
        var max = s.length();
        var out = new char[max];
        int cost = 0;

        for (var x=0; x < max; x++) {
            boolean addCost = true;

            char current = s.charAt(x);

            for (var y=0; y < max; y++) {
                if (out[y] == current) {
                    addCost = false;
                    break;
                }
            }

            if (addCost)
                cost++;

            out[x] = current;
        }

        return cost;
    }
}
