package com.example.presionarte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class login extends AppCompatActivity {

    //VARIABLES DE NUESTRO USUARIO
    EditText etNombre, etUsuario, etConsulta, etPassword;
    Button btnMostrar, btnGuardar, btnG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //DECLARACIÓN DE NUESTROS CAMPOS DE TEXTO
        etNombre = findViewById(R.id.etNombre);
        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        etConsulta = findViewById(R.id.etConsulta);
        btnMostrar = findViewById(R.id.btnMostrar);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnG = findViewById(R.id.button4);

        //EN ESTO SE ENCUENTRA TODA LA CIENCIA DEL TRABAJO, ALMACENA LA INFORMACIÓN en ROOM

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, grafica.class);
                startActivity(intent);
            }
        });


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(login.this,
                        AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                Usuarios usuarios = new Usuarios(etNombre.getText().toString(), etUsuario.getText().toString(), etPassword.getText().toString());
                Long reg = db.usuariosDao().insert(usuarios);
                Toast.makeText(getApplicationContext(),"Registrado Correctamente",Toast.LENGTH_LONG).show();


            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(login.this,
                        AppDataBase.class, "BaseDeDatosI").allowMainThreadQueries().build();
                List<Usuarios> lista = db.usuariosDao().getAll();
                String  valores = "";

                //MOSTRAR VALORES ALMACENADOS
                for(int i = 0; i<lista.size();i++){

                    valores+=" "+lista.get(i).getId()+": "+lista.get(i).nombreUsuario+" , "+lista.get(i).usuario+" , Presión: "+lista.get(i).password+"\n";

                }
                etConsulta.setText(valores);
            }
        });




    }
}