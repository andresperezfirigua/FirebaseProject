package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView Nombre;
    private TextView Apellido;
    private TextView Universidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Nombre = findViewById(R.id.textViewNombre);
        Apellido = findViewById(R.id.textViewApellido);
        Universidad = findViewById(R.id.textViewUniversidad);

        Intent intent = getIntent();
        String nombre = intent.getStringExtra("clave_nombre");
        String apellido = intent.getStringExtra("clave_apellido");
        String universidad = intent.getStringExtra("clave_universidad");

        Nombre.setText(nombre);
        Apellido.setText(apellido);
        Universidad.setText(universidad);
    }
}
