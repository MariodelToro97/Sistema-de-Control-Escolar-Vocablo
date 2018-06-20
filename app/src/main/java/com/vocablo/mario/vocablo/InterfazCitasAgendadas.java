package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazCitasAgendadas extends AppCompatActivity {
    Button InterfazAlumno; //Declaración de la variable para regresar de pantalla
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_citas_agendadas);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        InterfazAlumno = (Button)findViewById(R.id.btnMenuAlumno); //Asginación de la variable al botón
        InterfazAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra cuando se presiona la tecla de Regresar
                startActivity(new Intent(InterfazCitasAgendadas.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
