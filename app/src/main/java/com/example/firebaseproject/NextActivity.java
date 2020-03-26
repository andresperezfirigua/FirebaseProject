package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView Nombre;
    private TextView Apellido;
    private TextView Edad;
    private TextView Celular;
    private TextView Correo;
    private TextView Cedula;
    private TextView Universidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Nombre = findViewById(R.id.textViewNombre);
        Apellido = findViewById(R.id.textViewApellido);
        Edad = findViewById(R.id.textViewEdad);
        Celular = findViewById(R.id.textViewCelular);
        Correo = findViewById(R.id.textViewCorreo);
        Cedula = findViewById(R.id.textViewCedula);
        Universidad = findViewById(R.id.textViewUniversidad);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("clave_nombre");
        String apellido = intent.getStringExtra("clave_apellido");
        String edad = intent.getStringExtra("clave_edad");
        String celular = intent.getStringExtra("clave_celular");
        String correo = intent.getStringExtra("clave_correo");
        String cedula = intent.getStringExtra("clave_cedula");
        String universidad = intent.getStringExtra("clave_universidad");

        Nombre.setText(nombre);
        Apellido.setText(apellido);
        Edad.setText(edad);
        Celular.setText(celular);
        Correo.setText(correo);
        Cedula.setText(cedula);
        Universidad.setText(universidad);
    }
}
