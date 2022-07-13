package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustDao {
    @Insert
    void registerCust(CustEntity custEntity);

    @Query("SELECT * from customers where userName=(:userName) and password = (:password)")
    CustEntity login(String userName, String password);

    @Query("SELECT * from customers where userName=(:userName)")
    LiveData<List<CustEntity>> getCustDetails(String userName);
}
