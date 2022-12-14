package com.example.springclient;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.springclient.model.Employee;
import com.example.springclient.retrofit.EmployeeApi;
import com.example.springclient.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmployeeForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText inputEditNombre = findViewById(R.id.form_textFieldNombre);
        TextInputEditText inputEditPuesto = findViewById(R.id.form_textFieldPuesto);
        TextInputEditText inputEditUbicacion = findViewById(R.id.form_textFieldUbicacion);
        MaterialButton buttonGuardar = findViewById(R.id.form_buttonsave);

        RetrofitService retrofitService = new RetrofitService();
        EmployeeApi employeeApi = retrofitService.getRetrofit().create(EmployeeApi.class);

        buttonGuardar.setOnClickListener(view -> {
            String nombre = String.valueOf(inputEditNombre.getText());
            String ubicacion = String.valueOf(inputEditUbicacion.getText());
            String puesto = String.valueOf(inputEditPuesto.getText());

            Employee employee = new Employee();
            employee.setNombre(nombre);
            employee.setPuesto(puesto);
            employee.setUbicacion(ubicacion);

            employeeApi.save(employee)
                    .enqueue(new Callback<Employee>() {
                        @Override
                        public void onResponse(Call<Employee> call, Response<Employee> response) {
                            Toast.makeText(EmployeeForm.this, "Guardo Correctamente", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Employee> call, Throwable t) {
                            Toast.makeText(EmployeeForm.this, "Se Guardo", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, "Error", t);

                        }
                    });
        });

    }
}