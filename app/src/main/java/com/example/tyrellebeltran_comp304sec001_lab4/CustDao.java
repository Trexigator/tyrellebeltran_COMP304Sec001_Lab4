package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CustDao {
    @Insert
    void insert(CustEntity custEntity);

    @Query("SELECT * from customers where userName=(:userName) and password = (:password)")
    CustEntity login(String userName, String password);

    @Query("SELECT * from customers order by firstName")
    LiveData<List<CustEntity>> getAllCustomers();

    @Delete
    void delete(CustEntity custEntity);
}
