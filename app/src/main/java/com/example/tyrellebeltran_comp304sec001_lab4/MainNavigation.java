package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainNavigation extends AppCompatActivity {

    //Shared Pref
    Set<String> setUserNow = new HashSet<String>();
    SharedPreferences myPref;
    SharedPreferences.Editor prefEditor;

    //Setup Views
    private Button btnCust, btnCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        //fetch username via Intent
        TextView tName = findViewById(R.id.txtWelcName);
        String name = getIntent().getStringExtra("name");
        tName.setText("You are logged in as  " + name);

        //input username to Shared Pref
        myPref = getSharedPreferences("info", MODE_PRIVATE);
        setUserNow = myPref.getStringSet("user", new HashSet<String>());
        prefEditor = myPref.edit();
        setUserNow.add(name);
        prefEditor.putStringSet("user", setUserNow);
        prefEditor.commit();

        //buttons
        btnCust = findViewById(R.id.btnViewCust);
        btnCar = findViewById(R.id.btnViewCar);

        //Navigate to Customer Activity
        btnCust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainNavigation.this, CustomerActivity.class));
            }
        });
        //Navigate to Car Activity
        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainNavigation.this, CarActivity.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
        switch (item.getItemId()) {
            case R.id.custProfile:
                //Toast.makeText(this, "You selected Customer Profile.", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, CustomerActivity.class));
                break;
            case R.id.logout:
                Toast.makeText(this, "Goodbye", Toast.LENGTH_LONG).show();
                finish();
                myPref.edit().clear().commit();
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}