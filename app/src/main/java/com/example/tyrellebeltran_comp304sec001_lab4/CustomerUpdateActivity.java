package com.example.tyrellebeltran_comp304sec001_lab4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

//public class CustomerUpdateActivity extends AppCompatActivity {
public class CustomerUpdateActivity extends MainNavigation {

    SharedPreferences myPref;
    String dispFName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        myPref = getSharedPreferences("info", MODE_PRIVATE);
        setUserNow = myPref.getStringSet("user",new HashSet<String>());

        TextView tFName = findViewById(R.id.cpFirstName);
        TextView tName = findViewById(R.id.lblUserNow);
        for(String userNow : setUserNow ) {
            tName.setText("You are logged in as  " + userNow);
            dispFName = userNow;
        }
        //Display customer info
        AppDatabase appDatabase = AppDatabase.getFileDatabase(getApplicationContext());
        final CustDao custDao = appDatabase.custDao();
        Toast.makeText(CustomerUpdateActivity.this, "dispFName = " + dispFName, Toast.LENGTH_SHORT).show();
        /*
        new Thread(new Runnable() {
            @Override
            public void run() {

              //  CustEntity custDisplay = custDao.selectCustInfo(dispFName); //run the query in the backend
            /*    if (custDisplay == null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(CustomerUpdateActivity.this, "Error retrieving first name", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{//if (custDisplay != null)
                    tFName.setText(custDisplay.firstName);
                }
            }
        }).start();*/
//----------------
    }
}