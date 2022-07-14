package com.example.tyrellebeltran_comp304sec001_lab4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CustViewModel extends AndroidViewModel {

    private CustRepository custRepository;
    private LiveData<List<CustEntity>> allCustomers;

    public CustViewModel(@NonNull Application application) {
        super(application);
        custRepository = new CustRepository(application);
        allCustomers = custRepository.getAllCustomers();
    }

    //calls repository to insert a customer
    public void insert(CustEntity custEntity) {
        custRepository.insert(custEntity);
    }

    //calls repository to update a customer
    public void update(CustEntity custEntity) { custRepository.delete(custEntity); }

    //calls repository to delete a customer
    public void delete(CustEntity custEntity) { custRepository.delete(custEntity); }

    //returns query results as live data object
    LiveData<List<CustEntity>> getAllCustomers() { return allCustomers; }
}
