package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrarAlumno extends AppCompatActivity {
    //Creación de las variables locales a usar detipo botón durante esta activity
    Button cancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_alumno);

        //Asignación de los botones a las variables
        cancelar = (Button)findViewById(R.id.button2); //Botón Cacelar

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                startActivity(new Intent(RegistrarAlumno.this, InterfazAdmin.class));//Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla
    }
}
