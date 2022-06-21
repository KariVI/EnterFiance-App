package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class CreateAccountOptional extends AppCompatActivity {

    Button createBusiness;
    ImageView backButton;
    Button completeLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_optional);
        createBusiness = findViewById(R.id.buttonCompleteData);
        createBusiness.setOnClickListener(v -> {
            Intent intent = new Intent(CreateAccountOptional.this, CreateAccountBusiness.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        });
        completeLater = findViewById(R.id.buttonCompleteLater);
        completeLater.setOnClickListener(v -> {
            Intent intent = new Intent(CreateAccountOptional.this, Menu.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        });
        backButton = findViewById(R.id.backButtonOptional);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(CreateAccountOptional.this, CreateAccount.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }


}