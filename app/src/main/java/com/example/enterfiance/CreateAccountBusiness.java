package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.Calendar;

public class CreateAccountBusiness extends AppCompatActivity {

    Spinner giroSpinner;
    ImageView information;
    Button buttonConsumo;
    Button buttonServicio;
    Button buttonEmpresario;
    Button buttonEmprendedor;
    ImageView buttonBack;
    Button buttonSave;
    Button activeTimeInput;
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account_business);
        giroSpinner = findViewById(R.id.giroNegocioSpinner);
        createSpinner();
        activeTimeInput = findViewById(R.id.activeTimeInput);
        createDatePicker();
        activeTimeInput.setText("Tiempo activo");
        activeTimeInput.setOnClickListener(v -> {
            datePickerDialog.show();
        });
        information = findViewById(R.id.buttonInformation);
        information.setOnClickListener(v -> {
            openDialog();
        });
        buttonSave = findViewById(R.id.buttonSaveBusiness);
        buttonSave.setOnClickListener(v -> {
            Intent intent = new Intent(CreateAccountBusiness.this, Menu.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(CreateAccountBusiness.this, CreateAccountOptional.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
        buttonConsumo = findViewById(R.id.buttonConsumo);
        buttonConsumo.setOnClickListener(v -> {
            buttonConsumo.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_200));
            buttonServicio.setBackgroundTintList(this.getResources().getColorStateList(R.color.black));
        });
        buttonServicio = findViewById(R.id.buttonService);
        buttonServicio.setOnClickListener(v -> {
            buttonServicio.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_200));
            buttonConsumo.setBackgroundTintList(this.getResources().getColorStateList(R.color.black));
        });
        buttonEmpresario = findViewById(R.id.buttonEmpresario);
        buttonEmpresario.setOnClickListener(v -> {
            buttonEmpresario.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_200));
            buttonEmprendedor.setBackgroundTintList(this.getResources().getColorStateList(R.color.black));
        });
        buttonEmprendedor = findViewById(R.id.buttonEmprendedor);
        buttonEmprendedor.setOnClickListener(v -> {
            buttonEmprendedor.setBackgroundTintList(this.getResources().getColorStateList(R.color.purple_200));
            buttonEmpresario.setBackgroundTintList(this.getResources().getColorStateList(R.color.black));
        });
    }

    private void openDialog() {
        DialogInformationService dialog = new DialogInformationService();
        dialog.show(getSupportFragmentManager(), "InformationDialog ");
    }

    private void createSpinner() {
        giroSpinner = (Spinner) findViewById(R.id.giroNegocioSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.giroNegocioSpinner, R.layout.spinner_selected_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        giroSpinner.setAdapter(adapter);
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
                activeTimeInput.setText(date);
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
}