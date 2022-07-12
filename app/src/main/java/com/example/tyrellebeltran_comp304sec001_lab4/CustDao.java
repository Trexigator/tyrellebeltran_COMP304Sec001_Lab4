package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface CustDao {
    @Insert
    void registerCust(CustEntity custEntity);

}
