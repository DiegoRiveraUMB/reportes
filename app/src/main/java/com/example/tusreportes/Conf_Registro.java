package com.example.tusreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Conf_Registro extends AppCompatActivity {

    private TextView txv1;
    private TextView txv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conf_registro);

        txv1 =(TextView) findViewById(R.id.recNombre);
        String name = getIntent().getStringExtra( "nombre");
        txv1.setText("Hola "+name+" tus datos son:");

        txv2 =(TextView) findViewById(R.id.recEmail);
        String email = getIntent().getStringExtra("correo");
        txv2.setText(email);
    }
    //Metodo para el boton anterior
    public void anterior (View view){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
    }
    //Metodo para el boton aceptar
    public void aceptar (View view){
        Intent i = new Intent(this, datos.class);
        startActivity(i);
    }
}