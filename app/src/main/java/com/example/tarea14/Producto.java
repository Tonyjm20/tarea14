package com.example.tarea14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import modelo.Producto1;

public class Producto extends AppCompatActivity {
    private EditText Codigo,Producto,Stock,Costo,Venta;
    private Button btnActualizar,btnGuardar,btnBuscar,btnBorrar;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        Codigo = (EditText) findViewById(R.id.etCodigo);
        Producto = (EditText) findViewById(R.id.etProducto);
        Stock = (EditText) findViewById(R.id.etStock);
        Costo = (EditText) findViewById(R.id.etCosto);
        Venta = (EditText) findViewById(R.id.etVenta);
        btnGuardar = (Button) findViewById(R.id.btnGuardar2);
        inicializarFirebase();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = Codigo.getText().toString();
                String producto = Producto.getText().toString();
                String stock = Stock.getText().toString();
                String costo = Costo.getText().toString();
                String venta = Venta.getText().toString();
                Producto1 p = new Producto1();
                //p.setUid(UUID.randomUUID().toString());
                p.setCodigo(codigo);
                p.setProducto(producto);
                p.setStock(stock);
                p.setCosto(costo);
                p.setVenta(venta);
                databaseReference.child("Producto").child(p.getCodigo()).setValue(p);
                Toast.makeText(getApplicationContext(), "Guardado con éxito", Toast.LENGTH_SHORT).show();
                limpiar();
            }
        });
        btnActualizar = (Button) findViewById(R.id.btnActualizar2);
        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = Codigo.getText().toString();
                String producto = Producto.getText().toString();
                String stock = Stock.getText().toString();
                String costo = Costo.getText().toString();
                String venta = Venta.getText().toString();
                Producto1 p = new Producto1();
                //p.setUid(personaSelected.getUid());
                p.setCodigo(codigo);
                p.setProducto(producto.trim());
                p.setStock(stock.trim());
                p.setCosto(costo.trim());
                p.setVenta(venta.trim());
                databaseReference.child("Producto").child(p.getCodigo()).setValue(p);
                Toast.makeText(getApplicationContext(), "Actualizado con éxito", Toast.LENGTH_SHORT).show();
                limpiar();
            }
        });
        btnBorrar = (Button) findViewById(R.id.btnBorrar2);
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String codigo = Codigo.getText().toString();
                Producto1 p = new Producto1();
                p.setCodigo(codigo);
                databaseReference.child("Producto").child(p.getCodigo()).removeValue();
                Toast.makeText(getApplicationContext(), "Eliminado con éxito", Toast.LENGTH_SHORT).show();
                limpiar();
            }
        });
    }
    private void inicializarFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    private void limpiar(){
        Codigo.setText("");
        Producto.setText("");
        Stock.setText("");
        Costo.setText("");
        Venta.setText("");
    }
    public void regresar(View view) {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}