package com.example.menuhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings, new SettingsFragment())
                .commit();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_setting:
                        break;
                    case R.id.menu_search:
                        Intent a = new Intent(SettingsActivity.this,SearchActivity.class);
                        startActivity(a);
                        break;
                    case R.id.menu_add:
                        Intent b = new Intent(SettingsActivity.this,AddMenuActivity.class);
                        startActivity(b);
                        break;
                    case R.id.menu_home:
                        Intent c = new Intent(SettingsActivity.this,MainActivity.class);
                        startActivity(c);
                        break;
                    case R.id.menu_map:
                        MapsActivity.getInstance();
                        Intent d = new Intent(SettingsActivity.this,MapsActivity.class);
                        startActivity(d);
                        break;
                }
                return false;
            }
        });
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }




}