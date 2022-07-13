package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CarSalesDao {
    @Insert
    void registerCarSales(CarSalesEntity carSalesEntity);

    //Monitoring Query Result Changes with Live Data
    @Query("select * from CarSales order by carId")
    LiveData<List<CarSalesEntity>> getAllCarSales();

    @Delete
    void delete(CarSalesEntity carSalesEntity);

}
