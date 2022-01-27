// https://www.hackerrank.com/challenges/designer-pdf-viewer/problem

package com.example;

import java.util.Hashtable;
import java.util.List;

public class DesignerPDFViewer {
    public static int designerPdfViewer(List<Integer> h, String word) {
        /*
        problem:
        h = heights of letters
        index of h is 0-25 which maps to a-z
        h[0] = height of letter a

        word = torn
        t=2, o=1, r=1, n=1
        height = 2; (letter t=2)
        width = 4; (word.size=4)

        result = 2*4=8; (width * height; mm^2)

        idea outline:
        - create a mapping of char -> h index
        - iterate word as char
        - find height for char
        - if height > largest-so-far -> largest-so-far=height

        implementation:
        map = { a: 0, b: 1 } <-- how?
        highest = 0
        for (char : word)
            height = map[char]
            if height > highest
                highest = height
        answer = highest * word.size()
         */

        /*
        attempt 1:
        var map = new Hashtable<Integer, Character>();
        var start = "a".charAt(0);
        var end = "z".charAt(0);
        for (; start < end; start++) {
            System.out.printf("start %s", start);
            //map.put(start, (char)start);
        }
        ^- actually i dont need a map. i can compute the char code using `start`
        */

        var start = "a".charAt(0); // prob 97-122 https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html

        // attempt 2:
        // iterate char in word
        // find height fo char
        //   char = 119 ; w
        //   char - start = h offset ; 119 - 97 = 22
        //     t[22] should have height of character 'w'

        // attempt 3:
        //for (var letter : word) { System.out.printf("letter %c %s\n", letter, letter); }
        // ^- cant iterate chars like this, find another way

        // attempt 4:
        var highest = 0;
        for (var x=0; x < word.length(); x++) {
            var letter = word.charAt(x);
            var heightOffset = letter - start;
            var height = h.get(heightOffset);
            // System.out.printf("letter %c heightoffset %d height %d \n", letter, heightOffset, height);
            if (height > highest)
                highest = height;
        }

        return highest * word.length();
    }
}
