package com.example.presionarte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnI,btnA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CAMBIO DE PANTALLA
        btnI = (Button)findViewById(R.id.button);
        btnA = (Button)findViewById(R.id.button3);


        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, login.class); //ABRIR VENTANA DE REGISTRO
                startActivity(intent);
            }
        });

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, info.class); //ABRIR VENTANA DE INFORMACIÓN
                startActivity(a);
            }
        });


    }
}