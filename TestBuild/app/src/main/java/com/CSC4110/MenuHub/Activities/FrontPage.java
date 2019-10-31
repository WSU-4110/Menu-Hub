package com.CSC4110.MenuHub.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import com.CSC4110.MenuHub.R;

public class FrontPage extends AppCompatActivity {

    // Button variables
    private ImageButton Settings, Favorites, Map;

    @Override
    // Create function
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        // Settings activity implementation
        Settings = findViewById(R.id.ToSettings);
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySettings();
            }
        });

        // Favorites activity implementation
        Settings = findViewById(R.id.ToSettings);
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivitySettings();
            }
        });

        // Favorites activity implementation
        Favorites = findViewById(R.id.ToFavorites);
        Favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityFavorites();
            }
        });

        // MapAct activity implementation
        Map = findViewById(R.id.ToMap);
        Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityMap();
            }
        });
    }

    // Functions for opening activities
    public void openActivitySettings() {
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);
    }
    public void openActivityFavorites() {
        Intent intent = new Intent(this, Favorites.class);
        startActivity(intent);
    }
    public void openActivityMap() {
        Intent intent = new Intent(this, MapAct.class);
        startActivity(intent);
    }
}
