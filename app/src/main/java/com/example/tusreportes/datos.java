package com.example.tusreportes;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class datos extends AppCompatActivity {
    TextView fecha;
    private TextView tvDN, tvp1, tvp2;
    private Spinner spinner1, spinner2;
    Button btnCamara;
    ImageView imgView;
    static final int REQUEST_IMAGE_CAPTURE = 1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        //el metodo R conecta la parte grafica con la parte lógica

        btnCamara = findViewById(R.id.buttonCamara);
        imgView = findViewById(R.id.imageViewC);
        tvDN = (TextView)findViewById(R.id.textViewM);
        spinner1 = (Spinner) findViewById(R.id.spinnerM);
        spinner2 = (Spinner) findViewById(R.id.spinnerD);

        //recibir y colocar fecha
        Date date = new Date();
        fecha = (TextView) findViewById(R.id.textViewF);
        SimpleDateFormat fech = new SimpleDateFormat("d 'de' MMMM 'de' YYYY");
        String sFecha = fech.format(date);
        fecha.setText(sFecha);

        String [] opcionesM = {"Asbesto","Concreto","Gres","Hierro Dúctil","Polietileno AD",
        "Policloruro de Vinilo"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesM);
        spinner1.setAdapter(adapter);

        String [] opcionesD = {"4 - 110mm","6 - 160mm","8 - 200mm","10 - 250mm","12 - 315mm","14 - 350mm",
        "16 - 400mm","20 - 500mm"};
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesD);
        spinner2.setAdapter(adapter2);

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });
    }
    //Metodo para abrir la camara del dispositivo
    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if (intent.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(intent, 1);
            //int requestCode=1;

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgView.setImageBitmap(imageBitmap);
        }
    }
    public void aceptarOK (View view){
        Intent i = new Intent(this, Final.class);
        Toast.makeText(this, "Su registro fué enviado satisfactoriamente", Toast.LENGTH_LONG).show();
        startActivity(i);
    }




}