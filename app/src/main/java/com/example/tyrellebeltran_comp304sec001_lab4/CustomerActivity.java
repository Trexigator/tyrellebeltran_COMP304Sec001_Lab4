package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

//public class CustomerActivity extends AppCompatActivity {
public class CustomerActivity extends MainNavigation {

    SharedPreferences myPref;
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        myPref = getSharedPreferences("info", MODE_PRIVATE);
        setUserNow = myPref.getStringSet("user",new HashSet<String>());

        TextView tName = findViewById(R.id.txtUserNow);
        tName.setText("You are logged in as  " + setUserNow);

    }

}