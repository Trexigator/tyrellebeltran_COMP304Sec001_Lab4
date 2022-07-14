package com.example.tyrellebeltran_comp304sec001_lab4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CarsViewModel extends AndroidViewModel {

    private CarsRepository carsRepository;
    private LiveData<List<CarsEntity>> allCars;

    public CarsViewModel(@NonNull Application application) {
        super(application);
        carsRepository = new CarsRepository(application);
        allCars = carsRepository.getAllCars();
    }

    //calls repository to insert a customer
    public void insert(CarsEntity carsEntity) {
        carsRepository.insert(carsEntity);
    }

    //calls repository to update a customer
    public void update(CarsEntity carsEntity) { carsRepository.delete(carsEntity); }

    //calls repository to delete a customer
    public void delete(CarsEntity carsEntity) { carsRepository.delete(carsEntity); }

    //returns query results as live data object
    LiveData<List<CarsEntity>> getAllCustomers() { return allCars; }

}
