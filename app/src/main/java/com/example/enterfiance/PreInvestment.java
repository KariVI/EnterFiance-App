package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class PreInvestment extends AppCompatActivity {

    ImageView backButton;
    Button buttonLearnInvestment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_investment);
        backButton = findViewById(R.id.buttonBackToMenu);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(PreInvestment.this, Menu.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        buttonLearnInvestment = findViewById(R.id.buttonLearnInvestment);
        buttonLearnInvestment.setOnClickListener(v -> {
            Intent intent = new Intent(PreInvestment.this, Investment.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }
}