package com.example.tyrellebeltran_comp304sec001_lab4;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CarSalesRepository {
    private CarSalesDao carSalesDao;
    private LiveData<List<CarSalesEntity>> allCarSales;

    public CarSalesRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getFileDatabase(context);
        //create an interface object
        carSalesDao = db.carSalesDao();
        //call interface method
        allCarSales = carSalesDao.getAllCarSales();
    }

    // returns query results as LiveData object
    public LiveData<List<CarSalesEntity>> getAllCarSales() {
        return allCarSales;
    }

    //inserts a person asynchronously
    public void insert(CarSalesEntity carSalesEntity) {
        insertAsync(carSalesEntity);
    }
    //updates a person asynchronously
    //public void update(CarSalesEntity carSalesEntity) { insertAsync(carSalesEntity); }
    //deletes a person asynchronously
    public void delete(CarSalesEntity carSalesEntity) { deleteAsync(carSalesEntity); }

    //Insert and other queries must be done in AsyncTask or IT SHOULD NOT BE DONE ON MAIN UI THREAD
    private void insertAsync(final CarSalesEntity carSalesEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //CarSalesDao.insert(carSalesEntity);
                    //insertResult.postValue(1);
                } catch (Exception e) {
                    //insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAsync(final CarSalesEntity carSalesEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // CustDao.delete(custEntity);
                    //deleteResult.postValue(1);
                } catch (Exception e) {
                    //deleteResult.postValue(0);
                }
            }
        }).start();
    }
}
