package com.example.springclient.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.springclient.R;

public class EmployeeHolder extends RecyclerView.ViewHolder {

    TextView nombre, ubicacion, puesto;

    public EmployeeHolder(@NonNull View itemView) {
        super(itemView);
        nombre = itemView.findViewById(R.id.employeeListItem_nombre);
        ubicacion = itemView.findViewById(R.id.employeeListItem_ubicacion);
        puesto = itemView.findViewById(R.id.employeeListItem_puesto);

    }
}
