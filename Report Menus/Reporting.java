package com.example.test;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Reporting extends AppCompatActivity {

    Button button;

    String name;
    String email;
    String description;

    EditText Name;
    EditText Email;
    EditText Description;

    private static final String FILE_NAME = "example.txt";

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporting);

        Name = (EditText) findViewById(R.id.Name);
        Email = (EditText) findViewById(R.id.Email);
        Description = (EditText) findViewById(R.id.Description);

        button = (Button) findViewById(R.id.submitButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               name = Name.getText().toString();
               email = Email.getText().toString();
               description = Description.getText().toString();
            }
        });
    }
}
