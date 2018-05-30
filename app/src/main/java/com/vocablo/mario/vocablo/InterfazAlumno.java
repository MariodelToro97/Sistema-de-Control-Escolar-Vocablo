package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazAlumno extends AppCompatActivity {

    Button AgendarCita;
    Button VerProgreso;
    Button RealizarPago;
    Button CerrarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_alumno);

        getSupportActionBar().hide();

        AgendarCita = (Button)findViewById(R.id.btnAgendarCita);
        VerProgreso=(Button)findViewById(R.id.btnVerProgreso);
        RealizarPago=(Button)findViewById(R.id.btnRealizarPago);
        CerrarSesion=(Button)findViewById(R.id.btnLogin);

        AgendarCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAlumno.this,InterfazAgendarCita.class));
                //finish();
            }
        });


        VerProgreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAlumno.this,InterfazProgresoAlumno.class));
                //finish();
            }
        });


        RealizarPago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAlumno.this,InterfazPago.class));
                //finish();
            }
        });


        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAlumno.this,Login.class));
                //finish();
            }
        });



    }
}
