package com.example.tyrellebeltran_comp304sec001_lab4;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CarsRepository {
    private CarsDao carsDao;
    private LiveData<List<CarsEntity>> allCars;

    public CarsRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getFileDatabase(context);
        //create an interface object
        carsDao = db.carsDao();
        //call interface method
        allCars = carsDao.getAllCars();
    }

    // returns query results as LiveData object
    public LiveData<List<CarsEntity>> getAllCars() {
        return allCars;
    }

    //inserts a car asynchronously
    public void insert(CarsEntity carsEntity) {
        insertAsync(carsEntity);
    }
    //updates a car asynchronously
    //public void update(CarsEntity carsEntity) { insertAsync(carsEntity); }
    //deletes a car asynchronously
    public void delete(CarsEntity carsEntity) { deleteAsync(carsEntity); }

    //Insert and other queries must be done in AsyncTask or IT SHOULD NOT BE DONE ON MAIN UI THREAD
    private void insertAsync(final CarsEntity carsEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //CarsDao.insert(carsEntity);
                    //insertResult.postValue(1);
                } catch (Exception e) {
                    //insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAsync(final CarsEntity carsEntity) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // CarsDao.delete(carsEntity);
                    //deleteResult.postValue(1);
                } catch (Exception e) {
                    //deleteResult.postValue(0);
                }
            }
        }).start();
    }
}
