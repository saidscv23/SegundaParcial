package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText txt_nombre, txt_telefono, txt_carrrera, txt_deporte, txt_edad;
    private Button btn_fecha_nacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_telefono = findViewById(R.id.txt_telefono);
        txt_carrrera = findViewById(R.id.txt_carrrera);
        txt_deporte = findViewById(R.id.txt_deporte);
        txt_edad = findViewById(R.id.txt_edad);
        btn_fecha_nacimiento = findViewById(R.id.btn_fecha_nacimiento);


        Button btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados
                String nombre = txt_nombre.getText().toString();
                String telefono = txt_telefono.getText().toString();
                String carrera = txt_carrrera.getText().toString();
                String deporte = txt_deporte.getText().toString();
                String edad = txt_edad.getText().toString();

                Intent intent = new Intent(MainActivity.this, validacion.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("telefono", telefono);
                intent.putExtra("carrera", carrera);
                intent.putExtra("deporte", deporte);
                intent.putExtra("edad", edad);

                startActivity(intent);
            }
        });




        btn_fecha_nacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarCalendario();
            }
        });
    }

    private void mostrarCalendario() {
        final Calendar calendario = Calendar.getInstance();
        int anio = calendario.get(Calendar.YEAR);
        int mes = calendario.get(Calendar.MONTH);
        int dia = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // Se establece la fecha seleccionada en el EditText
                        String fechaNacimiento = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                        txt_edad.setText(fechaNacimiento);

                        // Se calcula la edad
                        int edad = calcularEdad(year, monthOfYear, dayOfMonth);
                        txt_edad.setText(String.valueOf(edad));
                    }
                }, anio, mes, dia);
        datePickerDialog.show();
    }

    private int calcularEdad(int year, int month, int day) {
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();

        fechaNacimiento.set(year, month, day);

        int edad = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);

        if (fechaActual.get(Calendar.DAY_OF_YEAR) < fechaNacimiento.get(Calendar.DAY_OF_YEAR)) {
            edad--;
        }

        return edad;
    }
}
