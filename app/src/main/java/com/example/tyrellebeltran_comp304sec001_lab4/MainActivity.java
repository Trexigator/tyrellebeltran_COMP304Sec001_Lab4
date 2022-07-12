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
                        //verify details against DB.
                        CustDatabase custDatabase = CustDatabase.getCustDatabase(getApplicationContext());
                        final CustDao custDao = custDatabase.custDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                CustEntity custEntity = custDao.login(inputName, inputPassword); //run the query in the backend
                                if (custEntity == null){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            counter--;
                                            Toast.makeText(MainActivity.this, "Incorrect Login. You have " + counter + " attempts left.", Toast.LENGTH_SHORT).show();
                                            if (counter == 0) {
                                                eLogin.setEnabled(false);
                                            }
                                        }
                                    });
                                }
                                else{
                                    String name = custEntity.userName;
                                    startActivity(new Intent(MainActivity.this, MainNavigation.class).putExtra("name", name));
                                }
                            }
                        }).start();
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

}

