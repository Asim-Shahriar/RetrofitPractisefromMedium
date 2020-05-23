package com.example.retrofitpractisefrommedium.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.retrofitpractisefrommedium.R;
import com.example.retrofitpractisefrommedium.adapter.EmployeeAdapter;
import com.example.retrofitpractisefrommedium.model.Employee;
import com.example.retrofitpractisefrommedium.model.EmployeeList;
import com.example.retrofitpractisefrommedium.network.GetEmployeeDataService;
import com.example.retrofitpractisefrommedium.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EmployeeAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetEmployeeDataService service= RetrofitInstance.getRetrofitInstance().create(GetEmployeeDataService.class);
        Call<EmployeeList> call=service.getEmployeeData(100);

        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<EmployeeList>() {
            @Override
            public void onResponse(Call<EmployeeList> call, Response<EmployeeList> response) {
                generateEmployeeList(response.body().getEmployeeList());
            }

            @Override
            public void onFailure(Call<EmployeeList> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateEmployeeList(ArrayList<Employee> employeeList) {
      recyclerView=findViewById(R.id.recycler_view_employee_list);
      adapter=new EmployeeAdapter( employeeList);
      RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
      recyclerView.setLayoutManager(layoutManager);
      recyclerView.setAdapter(adapter);

    }
}
