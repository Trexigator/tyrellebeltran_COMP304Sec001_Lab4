package com.example.tyrellebeltran_comp304sec001_lab4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//@Database(entities = {CustEntity.class, CarsEntity.class, CarSalesEntity.class}, version = 1)
@Database(entities = {CustEntity.class}, version = 1)
public abstract class CustDatabase extends RoomDatabase {
    private static final String dbName = "customer";
    private static CustDatabase custDatabase;

    public static synchronized CustDatabase getCustDatabase(Context context){

        if (custDatabase == null){
            custDatabase = Room.databaseBuilder(context, CustDatabase.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return custDatabase;
    }

    public abstract CustDao custDao();
}
