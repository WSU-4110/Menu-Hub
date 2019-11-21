package com.example.menuhub;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.FileOutputStream;
import java.io.IOException;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.Serializable;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ImageActivity extends AppCompatActivity {
    private MenuHub menu;
    ImageView imageview;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);


        menu = (MenuHub) getIntent().getSerializableExtra("data");
        setTitle(menu.name);

        ImageView ivImg = findViewById(R.id.iv_img);
        ivImg.setImageBitmap(Utils.getLoacalBitmap(menu.img));

        button = (Button)findViewById(R.id.save);
        imageview = (ImageView)findViewById(R.id.iv_img);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Bitmap bmp = Bitmap.createBitmap(Utils.getLoacalBitmap(menu.img));

                try (FileOutputStream fos = new FileOutputStream(menu.img)) {
                    bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(ImageActivity.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });
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
