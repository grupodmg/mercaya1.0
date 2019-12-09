package com.example.yisela.mibusnavidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CarritoActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
    }

    public void ir_domicilio(View view)
    {
        Toast.makeText(this, "Tu domicilio va en camino", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, UbicaActivity.class);
        startActivity(i);
    }
}
