package com.example.retrofitpractisefrommedium.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitpractisefrommedium.R;
import com.example.retrofitpractisefrommedium.model.Employee;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> dataList;

    public EmployeeAdapter(ArrayList<Employee> dataList){
        this.dataList=dataList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View v=layoutInflater.inflate(R.layout.row_employee,parent,false);
        return new EmployeeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        holder.txtEmpName.setText(dataList.get(position).getName());
        holder.txtEmpEmail.setText(dataList.get(position).getEmail());
        holder.txtEmpPhone.setText(dataList.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtEmpName, txtEmpEmail, txtEmpPhone;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            txtEmpName = (TextView) itemView.findViewById(R.id.txt_employee_name);
            txtEmpEmail = (TextView) itemView.findViewById(R.id.txt_employee_email);
            txtEmpPhone = (TextView) itemView.findViewById(R.id.txt_employee_phone);
        }
    }
}
