package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    private CustViewModel custViewModel;
    private CustEntity custEntity;
    TextView txtOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer2);

        txtOutput = findViewById(R.id.txtCustData);
        custViewModel = new ViewModelProvider(this).get(CustViewModel.class);
        custEntity = new CustEntity();

        //if the LiveData already has data it will delivered to the observer
        custViewModel.getAllCustomers().observe(this, new Observer<List<CustEntity>>() {
            @Override
            public void onChanged(@Nullable List<CustEntity> result) {
                String output = "";
                for (CustEntity custEntity : result) {
                    output += custEntity.getFirstName() + " " + custEntity.getLastName() + "\n";
                }
                txtOutput.setText(output);
            }
        });
    }
}