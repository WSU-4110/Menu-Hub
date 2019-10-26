package com.example.menuhub;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.io.FileNotFoundException;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddMenuActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etName;
    ImageView mIvImg;
    private String img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("Add Restaurant");
        etName = findViewById(R.id.et_name);
        mIvImg = findViewById(R.id.iv_img);
      findViewById(R.id.btn_add).setOnClickListener(this);
        mIvImg.setOnClickListener(this);
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

    private void getPhoto() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
        intent.setType("image/*");
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 100);
    }

    @SuppressLint("SdCardPath")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 100:
                    if (data != null) {
                        Uri uri_ = data.getData();
                        if (uri_ != null) {
                            try {
                                img = Utils.getPath(AddMenuActivity.this, uri_);
                                Bitmap photo = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri_));
                                mIvImg.setImageBitmap(photo);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    break;


                default:
                    break;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void showToast(String msg) {
        Toast.makeText(AddMenuActivity.this, msg, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_img:
                getPhoto();
                break;

            case R.id.btn_add:
                String name = etName.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    showToast("Please Input Restaurant");
                    return;
                }

                if (TextUtils.isEmpty(img)) {
                    showToast("Please Upload Menu Picture");
                    return;
                }
                MenuHub menuHub = new MenuHub();
                menuHub.name = name;
                menuHub.img = img;
                boolean flag = menuHub.save();
                if (flag) {
                    showToast("Successfully Added");
                    finish();
                } else {
                    showToast("Failed to add, please check if it has been added");
                }
                break;
        }
    }
}
