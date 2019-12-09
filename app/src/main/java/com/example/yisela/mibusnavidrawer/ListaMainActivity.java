package com.example.yisela.mibusnavidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ListaMainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_main);
    }

    public void ir_carnes(View view)
    {
        Intent i = new Intent(this, ListaCarneActivity.class);
        startActivity(i);
    }

    public void ir_frutas(View view)
    {
        Intent i = new Intent(this, ListaFrutasActivity.class);
        startActivity(i);
    }
}
