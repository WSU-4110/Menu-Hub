package com.example.menu;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SettingsActivityTest {


    @Before
    public void setUp() throws Exception {
        SettingsActivity setting  = new SettingsActivity();
        Bundle savedInstanceState = new Bundle();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onCreateTest() {
        assertEquals("active", null, setting.onCreate(savedInstanceState));
    }




    @Test
    public void onCreatePreferencesTest() {
        SettingsFragment settingsFragment = new SettingsFragment();
        assertNull(Null, settingsFragment.onCreatePreferences(savedInstanceState, rootKey));
    }



}