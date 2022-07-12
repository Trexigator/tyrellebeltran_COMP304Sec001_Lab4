package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName, ePassword;
    private Button eLogin;
    private TextView eRegister;

    private ProgressDialog progressDialog;

    //for initial testing...
    private final String userAdmin = "Admin";
    private final String adminPword = "123456";

    boolean isValid = false;
    private int counter = 5; //5 attempts to login.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.editTxtUserName);
        ePassword = findViewById(R.id.editTextPassword);
        eLogin = findViewById(R.id.btnLogin);
        eRegister = findViewById(R.id.txtRegister);

        progressDialog = new ProgressDialog(this); //because Firebase might take some time to initialize.

        //Login portion
        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty())
                    Toast.makeText(MainActivity.this, "Incomplete details!", Toast.LENGTH_SHORT).show();
                else {
                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect Login. You have " + counter + " attempts left.", Toast.LENGTH_SHORT).show();
                        if (counter == 0) {
                            eLogin.setEnabled(false);
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(MainActivity.this, MainNavigation.class));
                    }
                }
            }
        });

        //Register new user portion
        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegisterCustomer.class));
            }
        });
    }

    private boolean validate(String name, String password) {
        return false;
    }
}

