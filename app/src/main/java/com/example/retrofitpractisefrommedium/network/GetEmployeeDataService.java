package com.example.retrofitpractisefrommedium.network;

import com.example.retrofitpractisefrommedium.model.EmployeeList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetEmployeeDataService {
    @GET("retrofit-demo.php")
    Call<EmployeeList> getEmployeeData(@Query("company_no")int companyNo);
}
