// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem?h_r=next-challenge&h_v=zen
package com.example;

import java.util.Arrays;

public class BeautifulDayAtTheMovies {
    /**
     * @param i start of range
     * @param j end of range
     * @param k beautiful number
     * @return count of beautiful days in range
     */
    public static int beautifulDays(int i, int j, int k) {
        var days = 0;
        for (; i <= j; i++) {
            var inverse = inverse(i);
            var day = i - inverse;
            var beautiful = day % k == 0;

            if (beautiful)
                days++;

            //System.out.printf("i %d j %d k %d inverse %d beautiful %s days %d \n", i, j, k, inverse, beautiful, days);
            System.out.printf("inverse:%d day(%d) %% k(%d) == 0 %s\n", inverse, day, k, beautiful);
        }
        return days;
    }

    public static int inverse(int num) {
        // turn 12 into '12'
        // iterate chars 12 in reverse building new string
        // 2, 1 = '21' to int = 21
        // 20 = '20' = '02' = 2

        //how to reverse a string when i dont know the lang:
        //var numString = String.valueOf(num).toCharArray();
        //var reversed = new char[numString.length];
        //for (var x=numString.length; x > 0; x++) {
        //var y = numString.length - 1 - x;
        //reversed[x] = numString[y];
        //reversed.append(numString[x]);
        //}
        //
        //var asStr = Arrays.toString(reversed);
        //System.out.printf("asStr %s \n", asStr);
        //return Integer.parseInt(asStr);

        var numString = String.valueOf(num);
        var reversed = new StringBuilder();
        var max = numString.length() - 1;

        for (var x=max; x >= 0; x--) {
            var sub =  numString.substring(x, x+1);
            reversed.append(sub);
        }

        return Integer.parseInt(reversed.toString());
    }
}
