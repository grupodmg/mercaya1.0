package com.example.yisela.mibusnavidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class ListaCarneActivity extends AppCompatActivity
{
    Spinner cantidadchuleta;
    Spinner cantidadcostilla;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_carne);

        cantidadchuleta = findViewById(R.id.spinnerchuleta);
        ArrayAdapter<CharSequence> adapterchuleta = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        cantidadchuleta.setAdapter(adapterchuleta);

        cantidadcostilla = findViewById(R.id.spinnercostilla);
        ArrayAdapter<CharSequence> adaptercostilla = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        cantidadcostilla.setAdapter(adaptercostilla);
    }

    public void añadirchuleta(View view)
    {
        Toast.makeText(this, "Añadido 3 libras de chuleta al carrito", Toast.LENGTH_SHORT).show();
    }

    public void añadircostilla(View view)
    {
        Toast.makeText(this, "Ingresa una cantidad", Toast.LENGTH_SHORT).show();
    }

    public void carrito(View view)
    {
        Intent i = new Intent(this, CarritoActivity.class);
        startActivity(i);
    }
}
