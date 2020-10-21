package com.example.tarea14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import modelo.Persona1;

public class Persona extends AppCompatActivity {
    private Spinner spinner1;
    private EditText et1,et2,et3,et4;
    private RadioButton masculino,femenino;
    private Button btnActualizar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persona);
        inicializarFirebase();
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        String[] opciones = {"Ecuador", "Colombia", "Venezuela", "Peru"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);
        spinner1.setAdapter(adapter);
        et1 = (EditText) findViewById(R.id.etCedula);
        et2 = (EditText) findViewById(R.id.etNombre);
        et3 = (EditText) findViewById(R.id.etProvincia);
        et4 = (EditText) findViewById(R.id.etCorreo);
        masculino = (RadioButton) findViewById(R.id.rb1);
        femenino = (RadioButton) findViewById(R.id.rb2);

        btnActualizar = (Button) findViewById(R.id.btnActualizar);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cedula = et1.getText().toString();
                String Nombre = et2.getText().toString();
                String Provincia = et3.getText().toString();
                String Correo = et4.getText().toString();
                Persona1 p = new Persona1();
                //p.setUid(UUID.randomUUID().toString());
                p.setCedula(Cedula);
                p.setNombre(Nombre);
                p.setSexo(sexo());
                p.setPais(String.valueOf(spinner1.getSelectedItemPosition()));
                p.setProvincia(Provincia);
                p.setCorreo(Correo);
                databaseReference.child("Persona").child(p.getCedula()).setValue(p);
                Toast.makeText(getApplicationContext(), "Actualización exitosa", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public String sexo() {
        String sexo="";
        if (masculino.isChecked() == true) {
            sexo = "Masculino";
        } else if (femenino.isChecked() == true) {
            sexo = "Femenino";
        }
        return sexo;
    }
    public void regresar(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}