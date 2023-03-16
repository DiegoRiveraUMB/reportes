package com.example.tusreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {

    //Creacion de objetos
    private EditText nombre1;
    private EditText email1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //el metodo R conecta la parte grafica con la parte lógica
        nombre1 = (EditText) findViewById(R.id.PersonName);
        email1 = (EditText) findViewById(R.id.editTEmail);

    }

    //Metodo para el boton enviar
    public void Enviar (View view){
        String name = nombre1.getText().toString();
        String mail = email1.getText().toString();
        if (name.length()==0){
            Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG).show();
        }
        if (mail.length()==0){
            Toast.makeText(this, "Debes ingresar un email", Toast.LENGTH_LONG).show();
        }
        if (name.length() !=0 && mail.length() !=0){
            Intent i = new Intent(this, Conf_Registro.class);
            i.putExtra( "nombre", nombre1.getText().toString());
            i.putExtra( "correo", email1.getText().toString());
            startActivity(i);
        }

    }
    //Metodo para el boton anterior
    public void anterior (View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}