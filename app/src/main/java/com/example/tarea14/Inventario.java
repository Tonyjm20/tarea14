package com.example.tarea14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class    Inventario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inventario, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.opcion1) {
            Toast.makeText(this,"Puedes hacer la venta",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),Ventas.class);
            startActivity(i);
        }
        if (id==R.id.opcion2) {
            Toast.makeText(this,"Puedes hacer la compra",Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),Compras.class);
            startActivity(i);
        }
        if (id==R.id.opcion3) {
            Toast.makeText(this,"Buscar productos", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),ListaProductos.class);
            startActivity(i);
        }
        if (id==R.id.opcion4) {
            Toast.makeText(this,"Se seleccionó la cuarta opción", Toast.LENGTH_LONG).show();
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}