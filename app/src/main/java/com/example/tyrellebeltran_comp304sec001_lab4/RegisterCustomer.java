package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterCustomer extends AppCompatActivity {

    private EditText regUser, regPword, regFN, regLN, regAddress, regCity, regPostalCode;
    private Button regRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_customer);
        setupViews();

        regRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (reqdFields()) //check if required Fields have contents
                {
                    //proceed to create Customer in database
                   CustEntity custEntity = new CustEntity();
                    custEntity.setUserName(regUser.getText().toString());
                    custEntity.setPassword(regPword.getText().toString());
                    custEntity.setFirstName(regFN.getText().toString());
                    custEntity.setLastName(regLN.getText().toString());
                    custEntity.setAddress(regAddress.getText().toString());
                    custEntity.setCity(regCity.getText().toString());
                    custEntity.setPostalCode(regPostalCode.getText().toString());

                    //proceed with insert
                    AppDatabase appDatabase = AppDatabase.getFileDatabase(getApplicationContext());
                    CustDao custDao = appDatabase.custDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //register user
                            custDao.registerCust(custEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(RegisterCustomer.this, "User " + regUser.getText().toString() + " created.", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterCustomer.this, MainNavigation.class));
                                }
                            });
                        }
                    }).start();
                }
            }
        });
    }

    private void setupViews()
    {
        regUser = findViewById(R.id.tvUserName);
        regPword = findViewById(R.id.tvPword);
        regFN = findViewById(R.id.tvFirstName);
        regLN = findViewById(R.id.tvLastName);
        regAddress = findViewById(R.id.tvAddress);
        regCity = findViewById(R.id.tvCity);
        regPostalCode = findViewById(R.id.tvPostalCode);
        regRegister = findViewById(R.id.btnReg);
    }

    private boolean reqdFields()
    {
        boolean result = false;
        //required fields
        String name = regUser.getText().toString();
        String pword = regPword.getText().toString();
        String fName = regFN.getText().toString();
        String lName = regLN.getText().toString();

        if(name.isEmpty() || pword.isEmpty() || fName.isEmpty() || lName.isEmpty()) {
            Toast.makeText(this, "Incomplete details. Check required fields.", Toast.LENGTH_SHORT).show();
        }
        else
            return true;

        return result;
    }

}