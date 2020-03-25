package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText miNombreCompleto;
    private EditText miApellido;
    private EditText miUniversidad;
    private Button miBotonMostrar;
    private Button miBotonEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miNombreCompleto = findViewById(R.id.Nombre);
        miApellido = findViewById(R.id.Apellido);
        miUniversidad = findViewById(R.id.Universidad);
        miBotonMostrar = findViewById(R.id.Mostrar);
        miBotonEnviar = findViewById(R.id.Enviar);

        miBotonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNombreCompleto = miNombreCompleto.getText().toString();
                String strApellido = miApellido.getText().toString();
                String strUniversidad = miUniversidad.getText().toString();
                Toast miToast = Toast.makeText(getApplicationContext(),strNombreCompleto+" "+strApellido+" "+strUniversidad,Toast.LENGTH_LONG);

                miToast.show();
                /*Estudiante estudiante1 = new Estudiante();
                estudiante1.setNombres(strNombreCompleto);
                estudiante1.setApellido(strApellido);
                estudiante1.setUniversidad(strUniversidad);*/
            }
        });

        miBotonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NextActivity.class);
                String strNombreCompleto = miNombreCompleto.getText().toString();
                String strApellido = miApellido.getText().toString();
                String strUniversidad = miUniversidad.getText().toString();
                intent.putExtra("clave_nombre",strNombreCompleto);
                intent.putExtra("clave_apellido", strApellido);
                intent.putExtra("clave_universidad", strUniversidad);
                startActivity(intent);
            }
        });
    }

}