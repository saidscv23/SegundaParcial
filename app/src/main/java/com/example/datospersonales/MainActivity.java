package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt_nombre, txt_telefono, txt_carrrera, txt_deporte, txt_edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_telefono = findViewById(R.id.txt_telefono);
        txt_carrrera = findViewById(R.id.txt_carrrera);
        txt_deporte = findViewById(R.id.txt_deporte);
        txt_edad = findViewById(R.id.txt_edad);

        Button btn_ingresar = findViewById(R.id.btn_ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }
}