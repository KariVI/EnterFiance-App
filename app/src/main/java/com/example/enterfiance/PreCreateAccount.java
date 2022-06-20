package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class PreCreateAccount extends AppCompatActivity {

    ImageView imageView;
    Button btContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_create_account);
        imageView = findViewById(R.id.imageBack);
        imageView.setOnClickListener (v -> {
            Intent intent = new Intent(PreCreateAccount.this, MainActivity.class);
            startActivity(intent);
        }
        );
        btContinue = findViewById(R.id.btContinue);
        btContinue.setOnClickListener(v -> {
            Intent intent = new Intent(PreCreateAccount.this, CreateAccount.class);
            startActivity(intent);
        });
    }
}