package com.example.menuhub;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtlTest {

    @Test
    public void filter_true() {
        assertEquals("nameemailcom", StringUtl.filter("name@email.com"));
    }

    @Test
    public void filter_false() {
        assertEquals("nameemailcoj", StringUtl.filter("name@email.com"));
    }

    @Test
    public void notNull_false() {
        assertTrue(StringUtl.notNull(""));
    }

    @Test
    public void notNull_true() {
        assertTrue(StringUtl.notNull("should pass"));
    }
}