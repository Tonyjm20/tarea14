package com.example.tarea14;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Ventas extends AppCompatActivity {
    EditText Gigante,Primera,Segunda,Tercera,Bola,Dañado,tfecha,thora;
    Button bfecha,bhora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
    }
}