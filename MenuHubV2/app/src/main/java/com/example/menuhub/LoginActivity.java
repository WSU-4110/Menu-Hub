package com.example.menuhub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName;
    private EditText etPwd;
    private TextView btLogin;
    private TextView tv_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        etName = (EditText)findViewById(R.id.et_name);
        etPwd = (EditText)findViewById(R.id.et_pwd);
        btLogin = (TextView)findViewById(R.id.bt_login);
        tv_register = (TextView)findViewById(R.id.tv_register);
        btLogin.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                String name=etName.getText().toString().trim();
                String pass=etPwd.getText().toString().trim();
                // if else statement for check username and password
                int result= UserDao.getInstance(getApplicationContext()).login(pass,name);
                if (result==-2){
                    Toast.makeText(LoginActivity.this,"User Name is not Exist！", Toast.LENGTH_SHORT).show();
                }else if(result==-1){
                    Toast.makeText(LoginActivity.this,"Error Password！", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this,"Login Successful！", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }
                break;
            case R.id.tv_register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
        }
    }
}