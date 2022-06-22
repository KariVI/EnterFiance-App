package com.example.enterfiance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Investment extends AppCompatActivity {
    Button btCalculate;
    ImageView btBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment);
        btCalculate = (Button) findViewById(R.id.btCalculate);
        btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v != null) {

                    // now assign the system
                    // service to InputMethodManager
                    InputMethodManager manager
                            = (InputMethodManager)
                            getSystemService(
                                    Context.INPUT_METHOD_SERVICE);
                    manager
                            .hideSoftInputFromWindow(
                                    v.getWindowToken(), 0);
                }
                EditText benefit =  (EditText) findViewById(R.id.benefitInput);
                EditText investment =  (EditText) findViewById(R.id.investmentInput);
                float benefitValue =  Integer.parseInt(String.valueOf(benefit.getText()));
                float investmentValue =  Integer.parseInt(String.valueOf(investment.getText()));
                float ROI = (benefitValue - investmentValue) / investmentValue;
                TextView ROIValue =  (TextView) findViewById(R.id.tvRoi);
                ROIValue.setText(String. valueOf(ROI*100)+" %");
            }
        }
        );

        btBack = findViewById(R.id.buttonBackMenu);
        btBack.setOnClickListener(v -> {
            Intent intent = new Intent(Investment.this, Menu.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);        });
    }
}