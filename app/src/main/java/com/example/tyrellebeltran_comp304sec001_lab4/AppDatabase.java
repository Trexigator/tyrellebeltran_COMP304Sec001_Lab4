package com.example.tyrellebeltran_comp304sec001_lab4;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CustEntity.class, CarsEntity.class, CarSalesEntity.class}, version = 1)
//@Database(entities = {CustEntity.class, }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    //private static final String dbName = "customer";
    private static AppDatabase appDatabase;

    public static synchronized AppDatabase getFileDatabase(Context context){

        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "database_filename")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return appDatabase;
    }

    public abstract CustDao custDao();
    public abstract CarsDao carsDao();
    public abstract CarSalesDao carSalesDao();
}
