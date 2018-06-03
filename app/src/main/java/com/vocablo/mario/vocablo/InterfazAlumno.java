package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class InterfazAlumno extends AppCompatActivity {

    //Asignación de las variables de los tipos botones
    Button AgendarCita;
    Button VerProgreso;
    Button RealizarPago;
    Button CerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_alumno);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        //Asignación de las variables con los botones
        AgendarCita = (Button)findViewById(R.id.btnAgendarCita);
        VerProgreso=(Button)findViewById(R.id.btnVerProgreso);
        RealizarPago=(Button)findViewById(R.id.btnRealizarPago);
        CerrarSesion=(Button)findViewById(R.id.btnLogin);

        AgendarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra cuando se presiona el botón de agendar cita
                startActivity(new Intent(InterfazAlumno.this,InterfazAgendarCita.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });

        VerProgreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de ver progreso
                startActivity(new Intent(InterfazAlumno.this,InterfazProgresoAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        RealizarPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de realizar pago
                startActivity(new Intent(InterfazAlumno.this,InterfazPago.class)); //Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de cerrar sesión
                startActivity(new Intent(InterfazAlumno.this,Login.class)); //Encargado de lanzar la otra actividad desde aqui
                finish(); //Cierra la activity completamente
            }
        });



    }
}
