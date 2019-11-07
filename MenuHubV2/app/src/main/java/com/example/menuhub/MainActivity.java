package com.example.menuhub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title = (TextView) findViewById(R.id.homeTitle1);
        title.setText("Menu Hub");


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        break;
                    case R.id.menu_search:
                        Intent a = new Intent(MainActivity.this,SearchActivity.class);
                        startActivity(a);
                        break;
                    case R.id.menu_add:
                        Intent b = new Intent(MainActivity.this,AddMenuActivity.class);
                        startActivity(b);
                        break;
                    case R.id.menu_setting:
                        Intent c = new Intent(MainActivity.this,SettingsActivity.class);
                        startActivity(c);
                        break;
                    case R.id.menu_map:
                        MapsActivity.getInstance();
                        Intent d = new Intent(MainActivity.this,MapsActivity.class);
                        startActivity(d);
                        break;
                }
                return false;
            }
        });
    }
}