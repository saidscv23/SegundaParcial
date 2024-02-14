package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class validacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("nombre");
            String telefono = extras.getString("telefono");
            String carrera = extras.getString("carrera");
            String deporte = extras.getString("deporte");
            String edad = extras.getString("edad");

            EditText txt_nombre = findViewById(R.id.nombre);
            EditText txt_telefono = findViewById(R.id.telefono);
            EditText txt_carrera = findViewById(R.id.carrera);
            EditText txt_deporte = findViewById(R.id.deporte);
            EditText txt_edad = findViewById(R.id.edad);

            txt_nombre.setText(nombre);
            txt_telefono.setText(telefono);
            txt_carrera.setText(carrera);
            txt_deporte.setText(deporte);
            txt_edad.setText(edad);
        }
    }
}