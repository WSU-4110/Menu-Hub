package com.example.menuhub;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.Serializable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ImageActivity extends AppCompatActivity {
    private MenuHub menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);


        menu = (MenuHub) getIntent().getSerializableExtra("data");
        setTitle(menu.name);
        ImageView ivImg = findViewById(R.id.iv_img);
        ivImg.setImageBitmap(Utils.getLoacalBitmap(menu.img));
    }
    public void setTitle(String title) {
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
