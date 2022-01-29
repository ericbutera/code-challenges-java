package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static com.example.UtopianTree.utopianTree;

public class UtopianTreeTest {
    @Test
    void sample() {
        assertEquals(1, utopianTree(0));
        assertEquals(2, utopianTree(1));
        assertEquals(7, utopianTree(4));
    }
}
