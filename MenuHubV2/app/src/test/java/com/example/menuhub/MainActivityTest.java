package com.example.menuhub;

import android.content.Intent;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    @Test
    public void onCreate() {
    }

    @Test
    public void openReport() {
        Intent intent = new Intent(this, Reporting.class);
        assertNotNull(intent);
    }

    @Test
    public void openMaps() {
        Intent intent = new Intent(this, Reporting.class);
        assertNotNull(intent);
    }
}