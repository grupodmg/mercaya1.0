package com.example.yisela.mibusnavidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ListaFrutasActivity extends AppCompatActivity
{
    Spinner cantidadlimon;
    Spinner cantidadpina;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_frutas);

        cantidadlimon = findViewById(R.id.spinnerlimon);
        ArrayAdapter<CharSequence> adapterlimon = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        cantidadlimon.setAdapter(adapterlimon);

        cantidadpina = findViewById(R.id.spinnerpina);
        ArrayAdapter<CharSequence> adapterpina = ArrayAdapter.createFromResource(this, R.array.cantidad, android.R.layout.simple_spinner_item);
        cantidadpina.setAdapter(adapterpina);
    }
    public void añadirlimon(View view)
    {
        Toast.makeText(this, "Añadido 1 libra de limon al carrito", Toast.LENGTH_SHORT).show();
    }

    public void añadirpina(View view)
    {
        Toast.makeText(this, "Ingresa una cantidad", Toast.LENGTH_SHORT).show();
    }

    public void carrito(View view)
    {
        Intent i = new Intent(this, CarritoActivity.class);
        startActivity(i);
    }
}
