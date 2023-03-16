package com.example.tusreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Metodo para el boton abrir
    public void abrir (View view){
        Intent siguiente = new Intent(this, Registro.class);
        startActivity(siguiente);
    }
}