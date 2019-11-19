package com.example.menuhub;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPwd;
    private Button btLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle("CREATE ACCOUNT");
        init();
    }

    private void init() {
        etName = findViewById(R.id.et_write_name);
        etPwd = findViewById(R.id.et_write_pwd);
        btLogin = findViewById(R.id.btn_login);
        btLogin.setOnClickListener(this);
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
    public void onToast(String msg) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                // if and else statement to check username and password is empty or not.
                String name=etName.getText().toString().trim();
                String pass=etPwd.getText().toString().trim();
                if (TextUtils.isEmpty(name)){
                    onToast("User Name Cannot Empty");
                    return;
                }
                if (TextUtils.isEmpty(pass)){
                    onToast("Password cannot Empty");
                    return;
                }
                User user=new User();
                user.username = name;
                user.userpwd = pass;
                // this is for registration page to check for success！
                int result= UserDao.getInstance(getApplicationContext()).registerUser(user);
                if (result==1){
                    Toast.makeText(RegisterActivity.this,"Registration Successfully！", Toast.LENGTH_SHORT).show();
                    finish();
                }else  if (result==-1)
                {
                    Toast.makeText(RegisterActivity.this,"User name already exist！！", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Registration failed！", Toast.LENGTH_SHORT).show();
                }

                break;

        }
    }
}
