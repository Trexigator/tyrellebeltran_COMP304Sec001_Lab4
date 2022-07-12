package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "CarSales")
public class CarSalesEntity {
    @PrimaryKey(autoGenerate = true)
    Integer custId;

    @ColumnInfo(name = "carId")
    String carId;

    @ColumnInfo(name = "paymentDate")
    String paymentDate;

    @ColumnInfo(name = "orderStatus")
    String orderStatus;

    @ColumnInfo(name = "amountPaid")
    Double amountPaid;

//(You may include credit card payment details)

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
