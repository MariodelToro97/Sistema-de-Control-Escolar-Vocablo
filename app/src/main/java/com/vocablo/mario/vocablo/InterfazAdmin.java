package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazAdmin extends AppCompatActivity {

    Button SiguienteProgreso;
    Button RegistrarAlumno;
    Button RegistrarDocente;
    Button RegistrarAdmin;
    Button VerCitasAgendadas;
    Button CerrarSesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_admin);

        getSupportActionBar().hide();
        SiguienteProgreso = (Button)findViewById(R.id.btnProgresoEstudiante);
        RegistrarAlumno=(Button)findViewById(R.id.btnRegistrarAlumno);
        RegistrarDocente=(Button)findViewById(R.id.btnRegistrarDocente);
        RegistrarAdmin=(Button)findViewById(R.id.btnRegistrarAdmin);
        VerCitasAgendadas=(Button)findViewById(R.id.btnVerCitas);
        CerrarSesion=(Button)findViewById(R.id.btnLogin);

        SiguienteProgreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,InterfazProgresoAlumno.class));
            }
        });


        RegistrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,RegistrarAlumno.class));
                finish();
            }
        });


        RegistrarDocente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,RegistrarProfesor.class));
                finish();
            }
        });


        RegistrarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,RegistrarAdministrativo.class));
                finish();
            }
        });


        VerCitasAgendadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,InterfazCitasAgendadas.class));
                finish();
            }
        });

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,Login.class));
                finish();
            }
        });
    }
}
