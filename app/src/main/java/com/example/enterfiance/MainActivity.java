package com.example.enterfiance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.enterfiance.model.User;
import com.example.enterfiance.model.UserContract;
import com.example.enterfiance.model.UserDbHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btStart = (Button) findViewById(R.id.btStart);
        btStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PreCreateAccount.class);
                if(isRegistered()){
                 intent = new Intent(MainActivity.this, Menu.class);
                }
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        }
        );
    }

        private boolean isRegistered(){
            boolean value =false;
            UserDbHelper dbHelper = new UserDbHelper(getBaseContext());
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            Cursor cursor = null;
            cursor = db.rawQuery("SELECT *  FROM " + UserContract.UserEntry.TABLE_NAME, null);
            if(cursor.moveToFirst()){
               value = true;
            }
            return value;
        }
    }

