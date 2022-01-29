package com.example;

import org.junit.jupiter.api.Test;

import static com.example.BeautifulDayAtTheMovies.beautifulDays;
import static com.example.BeautifulDayAtTheMovies.inverse;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BeautifulDayAtTheMoviesTest {
    @Test
    void example() {
        assertEquals(2, beautifulDays(20, 23, 6));
    }

    @Test
    void inverseTest() {
        assertEquals(2, inverse(20));
    }
}
