package com.example.tyrellebeltran_comp304sec001_lab4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CarSalesViewModel extends AndroidViewModel {

    private CarSalesRepository carSalesRepository;
    private LiveData<List<CarSalesEntity>> allCarSales;

    public CarSalesViewModel(@NonNull Application application) {
        super(application);
        carSalesRepository = new CarSalesRepository(application);
        allCarSales = carSalesRepository.getAllCarSales();
    }

    //calls repository to insert a carsales
    public void insert(CarSalesEntity carSalesEntity) { carSalesRepository.insert(carSalesEntity); }

    //calls repository to update a carsales
    public void update(CarSalesEntity carSalesEntity) { carSalesRepository.delete(carSalesEntity); }

    //calls repository to delete a carsales
    public void delete(CarSalesEntity carSalesEntity) { carSalesRepository.delete(carSalesEntity); }

    //returns query results as live data object
    LiveData<List<CarSalesEntity>> getAllCarSales() { return allCarSales; }

}
