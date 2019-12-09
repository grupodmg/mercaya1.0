package com.example.yisela.mibusnavidrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        getSupportActionBar().setTitle("Gracias por usar Merca Ya"); //Configura el texto del Toolbar del Activity ConfiguraActivity
    }

    public void iralmenu(View view)
    {
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "Gracias", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
