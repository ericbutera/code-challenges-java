// https://www.hackerrank.com/challenges/utopian-tree/problem?h_r=next-challenge&h_v=zen
package com.example;

/*
tree has 2 growth cycles per year
- each spring height * 2
- each summer hight + 1 meter

period  height
0       1
1       2
2       3
3       6
4       7
5       14

input
3       # t = number of tests
0       # n = first test
2       # second ...
4       # ...

output
1       # result of first test
2       # ... second test
7       # ...

H = 1 (tree starts at 1 height)
n = 0 => 1
n = 1 => 2 (after spring) [spring is odd]

n=0 h=1 (initial height)
n=1 h=2
    resume n=1
n=4 h=7
    n=1 h=2 (1 * 2 = 2)
    n=2 h=3 (2 + 1 = 3)
    n=3 h=6 (3 * 2 = 6)
    n=4 h=7 (6 + 1 = 7)
n=5
    n=5 h=14 (resume h=7; 7 * 2 = 14; h=14)
n=6
    n=6 h=15 (resume h=14; 14 + 1 = 15; h=15)
n=7
    n=7 h=30 (resume h=15; 15 * 2 = 30; h=30)

 */

import java.util.Hashtable;

public class UtopianTree {
    /**
     *
     * @param n cycles to simulate
     * @return height of tree after n cycles
     */
    public static int utopianTree(int n) {
        var h = 1;

        for (var x=0; x < n; x++) {
            if (x % 2 == 0) {
                h = h * 2;
            } else {
                h = h + 1;
            }
        }

        return h;
    }
}
