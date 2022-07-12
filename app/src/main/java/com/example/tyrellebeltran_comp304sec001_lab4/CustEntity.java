package com.example.tyrellebeltran_comp304sec001_lab4;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Customers")

public class CustEntity {
    @PrimaryKey(autoGenerate = true)
        Integer custId;

    @ColumnInfo(name = "userName")
        String userName;

    @ColumnInfo(name = "password")
        String password;

    @ColumnInfo(name = "firstName")
        String firstName;

    @ColumnInfo(name = "lastName")
    String lastName;

    @ColumnInfo(name = "address")
    String address;

    @ColumnInfo(name = "city")
    String city;

    @ColumnInfo(name = "postalCode")
    String postalCode;

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
