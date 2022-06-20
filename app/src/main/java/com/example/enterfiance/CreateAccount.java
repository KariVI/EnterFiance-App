package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class CreateAccount extends AppCompatActivity {

    ImageView imageView;
    Button continueButton;
    Spinner genderSpinner;
    Spinner gradeSpinner;
    Spinner occupationSpinner;
    EditText datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        datePicker = findViewById(R.id.dateInput);

        imageView = findViewById(R.id.backButton);
        imageView.setOnClickListener (v -> {
            Intent intent = new Intent(CreateAccount.this, PreCreateAccount.class);
            startActivity(intent);
        }
        );
        setupSpinners();
    }

    private void setupSpinners() {
        genderSpinner = (Spinner) findViewById(R.id.genderSelector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genderSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);
        gradeSpinner = (Spinner) findViewById(R.id.gradeSelector);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.gradeSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(adapter);
        occupationSpinner = (Spinner) findViewById(R.id.occupationSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.ocupationSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occupationSpinner.setAdapter(adapter);
    }
}