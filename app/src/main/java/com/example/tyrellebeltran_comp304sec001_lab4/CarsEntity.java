package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Cars")
public class CarsEntity {
    @PrimaryKey(autoGenerate = true)
    String carId;

    @ColumnInfo(name = "brandName")
    String brandName;

    @ColumnInfo(name = "modelName")
    String modelName;

    @ColumnInfo(name = "price")
    Double price;

    @ColumnInfo(name = "color")
    String color;

    //(Any other two features of cars)
    @ColumnInfo(name = "hybrid")
    Boolean hybrid;

    @ColumnInfo(name = "freeFoilWrap")
    Boolean freeFoilWrap;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getHybrid() {
        return hybrid;
    }

    public void setHybrid(Boolean hybrid) {
        this.hybrid = hybrid;
    }

    public Boolean getFreeFoilWrap() {
        return freeFoilWrap;
    }

    public void setFreeFoilWrap(Boolean freeFoilWrap) {
        this.freeFoilWrap = freeFoilWrap;
    }
}
