package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface CustDao {
    @Insert
    void registerCust(CustEntity custEntity);

    @Query("SELECT * from customers where userName=(:userName) and password = (:password)")
    CustEntity login(String userName, String password);
}
