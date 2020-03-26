package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private EditText miNombre;
    private EditText miApellido;
    private EditText miEdad;
    private EditText miCelular;
    private EditText miCorreo;
    private EditText miCedula;
    private EditText miUniversidad;
    private Button miBotonMostrar;
    private Button miBotonEnviar;
    private Button miBotonEnviarFirebase;
    private DatabaseReference fireaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miNombre = findViewById(R.id.Nombre);
        miApellido = findViewById(R.id.Apellido);
        miEdad = findViewById(R.id.Edad);
        miCelular = findViewById(R.id.Celular);
        miCorreo = findViewById(R.id.Correo);
        miCedula = findViewById(R.id.Cedula);
        miUniversidad = findViewById(R.id.Universidad);
        miBotonMostrar = findViewById(R.id.Mostrar);
        miBotonEnviar = findViewById(R.id.Enviar);
        miBotonEnviarFirebase = findViewById(R.id.EnviarFirebase);

        miBotonMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNombre = miNombre.getText().toString();
                String strApellido = miApellido.getText().toString();
                String strEdad = miEdad.getText().toString();
                String strCelular = miCelular.getText().toString();
                String strCorreo = miCorreo.getText().toString();
                String strCedula = miCedula.getText().toString();
                String strUniversidad = miUniversidad.getText().toString();
                Toast miToast = Toast.makeText(getApplicationContext(),strNombre+" "+strApellido+" "+strEdad+""+strCelular+""+strCorreo+""+strCedula+""+strUniversidad,Toast.LENGTH_LONG);

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
                String strNombre = miNombre.getText().toString();
                String strApellido = miApellido.getText().toString();
                String strEdad = miEdad.getText().toString();
                String strCelular = miCelular.getText().toString();
                String strCorreo = miCorreo.getText().toString();
                String strCedula = miCedula.getText().toString();
                String strUniversidad = miUniversidad.getText().toString();
                intent.putExtra("clave_nombre",strNombre);
                intent.putExtra("clave_apellido", strApellido);
                intent.putExtra("clave_edad", strEdad);
                intent.putExtra("clave_celular", strCelular);
                intent.putExtra("clave_correo", strCorreo);
                intent.putExtra("clave_cedula", strCedula);
                intent.putExtra("clave_universidad", strUniversidad);
                startActivity(intent);
            }
        });

        miBotonEnviarFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNombre = miNombre.getText().toString();
                String strApellido = miApellido.getText().toString();
                String strEdad = miEdad.getText().toString();
                String strCelular = miCelular.getText().toString();
                String strCorreo = miCorreo.getText().toString();
                String strCedula = miCedula.getText().toString();
                String strUniversidad = miUniversidad.getText().toString();

                Toast miToast = Toast.makeText(getApplicationContext(),"Datos Registrados",Toast.LENGTH_LONG);

                Estudiante datosEstudiante = new Estudiante();

                datosEstudiante.setNombres(strNombre);
                datosEstudiante.setApellido(strApellido);
                datosEstudiante.setEdad(strEdad);
                datosEstudiante.setCelular(strCelular);
                datosEstudiante.setCorreo(strCorreo);
                datosEstudiante.setCedula(strCedula);
                datosEstudiante.setUniversidad(strUniversidad);


                String key = fireaseDatabase.push().getKey();
                fireaseDatabase.child(key).setValue(datosEstudiante);

                miToast.show();

            }
        });

        fireaseDatabase = FirebaseDatabase.getInstance().getReference("DataBaseUsers");
    }

}