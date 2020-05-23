package com.example.retrofitpractisefrommedium.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class EmployeeList {
    @SerializedName("employeeList")
    @Expose
    private ArrayList<Employee> employeeList = null;

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
