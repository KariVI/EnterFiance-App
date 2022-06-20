package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Calendar;

public class CreateAccount extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    ImageView imageView;
    Button continueButton;
    Spinner genderSpinner;
    Spinner gradeSpinner;
    Spinner occupationSpinner;
    Button datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createDatePicker();
        datePicker = findViewById(R.id.dateInput);
        datePicker.setText("Fecha de nacimiento");
        datePicker.setOnClickListener(v -> {
            datePickerDialog.show();
        });
        imageView = findViewById(R.id.backButton);
        imageView.setOnClickListener (v -> {
            Intent intent = new Intent(CreateAccount.this, PreCreateAccount.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
        );
        setupSpinners();
    }

    private String getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day + "/" + getMonthFormat(month) + "/" + year;
    }

    private void createDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month+=1;
                String date = makeDateString(dayOfMonth,month,year);
                datePicker.setText(date);
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this,style, dateSetListener, year, month, day );



    }

    private String makeDateString(int day, int month, int year) {
        return day + "/" + getMonthFormat(month) + "/" + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "Enero";
        if(month == 2)
            return "Febrero";
        if(month == 3)
            return "Marzo";
        if(month == 4)
            return "Abril";
        if(month == 5)
            return "Mayo";
        if(month == 6)
            return "Junio";
        if(month == 7)
            return "Julio";
        if(month == 8)
            return "Agosto";
        if(month == 9)
            return "Septiembre";
        if(month == 10)
            return "Octubre";
        if(month == 11)
            return "Noviembre";
        if(month == 12)
            return "Diciembre";

        //default should never happen
        return "JAN";
    }

    private void setupSpinners() {
        genderSpinner = (Spinner) findViewById(R.id.genderSelector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genderSpinner, R.layout.spinner_selected_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);
        gradeSpinner = (Spinner) findViewById(R.id.gradeSelector);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.gradeSpinner, R.layout.spinner_selected_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gradeSpinner.setAdapter(adapter);
        occupationSpinner = (Spinner) findViewById(R.id.occupationSpinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.ocupationSpinner, R.layout.spinner_selected_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        occupationSpinner.setAdapter(adapter);
    }
}