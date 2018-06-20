package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazProgresoAlumno extends AppCompatActivity {

    Button Regresar; //Declaración del botón de Regresar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_progreso_alumno);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        Regresar = (Button)findViewById(R.id.button); //Asignación del botón a la variable

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Se ejecuta al presionar la tecla de Regresar
                startActivity(new Intent(InterfazProgresoAlumno.this, InterfazAdmin.class));//Encargado de lanzar la otra actividad desde aqui
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
