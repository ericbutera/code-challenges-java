package com.example.Hello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTest {
    @Test
    void helloWorldTest() {
        var hello = new Hello();
        assertEquals("hello world", hello.world());
    }
}