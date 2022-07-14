package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarsDao {

    @Insert
    void insert(CarsEntity carsEntity);

    //Monitoring Query Result Changes with Live Data
    @Query("select * from Cars order by brandName")
    LiveData<List<CarsEntity>> getAllCars();

    @Delete
    void delete(CarsEntity carsEntity);
}
