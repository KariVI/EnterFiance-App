package com.example.enterfiance;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.enterfiance.model.UserContract;
import com.example.enterfiance.model.UserDbHelper;
import com.example.enterfiance.tools.Validation;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateAccount extends AppCompatActivity {
    private DatePickerDialog datePickerDialog;
    ImageView imageView;
    Button continueButton;
    Spinner genderSpinner;
    Spinner gradeSpinner;
    Spinner occupationSpinner;
    Button datePicker;
    TextInputEditText userInput;
    TextInputEditText nameInput;
    TextInputEditText phoneInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        userInput = findViewById(R.id.usernameInput);
        nameInput = findViewById(R.id.nameInput);
        phoneInput = findViewById(R.id.phoneInput);
        continueButton = findViewById(R.id.buttonContinue);
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

        continueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checkData()) {
                    saveData();
                    Intent intent = new Intent(CreateAccount.this, MainActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                }
            }
        });
        setupSpinners();
    }

    private boolean checkData(){
        boolean value = true;
        if (Validation.isEmpty(nameInput.getEditableText().toString())) {
            Toast toast = Toast.makeText(this, "Escribe tu nombre por favor", Toast.LENGTH_SHORT);
            toast.show();
            value = false;
        }

        if (Validation.isEmpty(userInput.getEditableText().toString())) {
            Toast toast = Toast.makeText(this, "Escribe tu usuario por favor", Toast.LENGTH_SHORT);
            toast.show();
            value = false;
        }
       if (genderSpinner.getSelectedItemPosition()==0){
            Toast.makeText(getApplicationContext(), "Por favor selecciona en el apartado de Género", Toast.LENGTH_LONG).show();
            value= false;
        }

        if (gradeSpinner.getSelectedItemPosition()==0){
            Toast.makeText(getApplicationContext(), "Por favor selecciona un de Grado de estudios", Toast.LENGTH_LONG).show();
            value= false;
        }

        if (occupationSpinner.getSelectedItemPosition()==0){
            Toast.makeText(getApplicationContext(), "Por favor selecciona una ocupación", Toast.LENGTH_LONG).show();
            value= false;
        }

        return value;
    }

    private void saveData(){


            try{
                UserDbHelper dbHelper = new UserDbHelper(getBaseContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("fullname", nameInput.getEditableText().toString());
                values.put("username", userInput.getEditableText().toString());
                values.put("phonenumber", phoneInput.getEditableText().toString());
                values.put("phonenumber", getDate());
                values.put("sex", (String) genderSpinner.getSelectedItem());
                values.put("levelstudies", (String) gradeSpinner.getSelectedItem());
                values.put("job", (String) occupationSpinner.getSelectedItem());
                long newRowId = db.insert(UserContract.UserEntry.TABLE_NAME, null, values);
                if(newRowId != -1) {
                    Toast.makeText(getApplicationContext(), "Usuario registrado", Toast.LENGTH_LONG).show();
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }

    }
    private String getTodayDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return day + "/" + getMonthFormat(month) + "/" + year;
    }

    private String getDate(){
        DatePicker datePicker = datePickerDialog.getDatePicker();
        int   day  = datePicker.getDayOfMonth();
        int   month= datePicker.getMonth();
        int   year = datePicker.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String formatedDate = sdf.format(calendar.getTime());
        return formatedDate;
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