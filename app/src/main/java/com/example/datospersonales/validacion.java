package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class validacion extends AppCompatActivity {
    private EditText txt_nombre,txt_edad, txt_telefono, txt_carrrera, txt_deporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validacion);

        txt_nombre = findViewById(R.id.nombre);
        txt_edad = findViewById(R.id.edad);
        txt_telefono = findViewById(R.id.telefono);
        txt_carrrera = findViewById(R.id.carrera);
        txt_deporte = findViewById(R.id.deporte);




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


        Button btnRegresar = findViewById(R.id.regresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(validacion.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }



    public void crearTablaDatos(View view) {

        MySQLConnection admin = new MySQLConnection(this, "FichaDatos2.db", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        String nombre = txt_nombre.getText().toString();
        String edad = txt_edad.getText().toString();
        String telefono = txt_telefono.getText().toString();
        String carrera = txt_carrrera.getText().toString();
        String deporte = txt_deporte.getText().toString();



        if (!nombre.isEmpty() && !edad.isEmpty() && !telefono.isEmpty() && !carrera.isEmpty() && !deporte.isEmpty() ) {
            ;

            ContentValues datosRegistrar = new ContentValues();
            datosRegistrar.put("nombre", nombre);
            datosRegistrar.put("edad", edad);
            datosRegistrar.put("telefono", telefono);
            datosRegistrar.put("carrera", carrera);
            datosRegistrar.put("deporte", deporte);






            bd.insert("tbldatos", null, datosRegistrar);
            Toast.makeText(this, "Datos enviados correctamente", Toast.LENGTH_SHORT).show();
        } else {

            Toast.makeText(this, "INGRESE LA FORMACIÓN DE MANERA CORRECTA", Toast.LENGTH_LONG).show();


        }
    }



}