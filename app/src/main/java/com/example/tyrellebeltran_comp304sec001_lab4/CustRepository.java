package com.example.tyrellebeltran_comp304sec001_lab4;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CustRepository {
    private CustDao custDao;
    private LiveData<List<CustEntity>> allCustomers;

    public CustRepository(Context context) {
        //create a database object
        AppDatabase db = AppDatabase.getFileDatabase(context);
        //create an interface object
        custDao = db.custDao();
        //call interface method
        allCustomers = custDao.getAllCustomers();
    }

    // returns query results as LiveData object
    public LiveData<List<CustEntity>> getAllCustomers() {
        return allCustomers;
    }

    //inserts a person asynchronously
    public void insert(CustEntity custEntity) {
        insertAsync(custEntity);
    }
    //updates a person asynchronously
    //public void update(CustEntity custEntity) { insertAsync(custEntity); }
    //deletes a person asynchronously
    public void delete(CustEntity custEntity) { deleteAsync(custEntity); }

    //Insert and other queries must be done in AsyncTask or IT SHOULD NOT BE DONE ON MAIN UI THREAD
    private void insertAsync(final CustEntity custEntity) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //CustDao.insert(custEntity);
                    //insertResult.postValue(1);
                } catch (Exception e) {
                    //insertResult.postValue(0);
                }
            }
        }).start();
    }

    private void deleteAsync(final CustEntity custEntity) {

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
