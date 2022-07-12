package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);

        TextView tName = findViewById(R.id.txtWelcName);
        String name = getIntent().getStringExtra("name");
        tName.setText("WELCOME " + name);
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
                Toast.makeText(this, "You selected Customer Profile.", Toast.LENGTH_LONG).show();
                break;
            case R.id.logout:
                Toast.makeText(this, "You selected Logout!", Toast.LENGTH_LONG).show();
                finish();
                //sharedpreferences destroy data
                startActivity(new Intent(this, MainActivity.class));
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}