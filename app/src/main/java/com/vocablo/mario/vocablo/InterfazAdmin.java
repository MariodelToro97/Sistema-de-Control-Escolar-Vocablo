package com.vocablo.mario.vocablo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazAdmin extends AppCompatActivity {

    Button SiguienteProgreso; //Botón de Ver Progreso Estudiantil
    Button RegistrarAlumno; //Botón de Registrar Alumno
    Button RegistrarDocente; //Botón de Registrar Docente
    Button RegistrarAdmin; //Botón de Registrar Administrador
    Button VerCitasAgendadas; //Botón de Ver las Citas
    Button CerrarSesion; //Botón de Cerrar Sesión
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_admin);

        getSupportActionBar().hide(); //Oculta la barra superior

        //Asignación de los botones de la pantalla a las variables
        SiguienteProgreso = (Button)findViewById(R.id.btnProgresoEstudiante);
        RegistrarAlumno=(Button)findViewById(R.id.btnRegistrarAlumno);
        RegistrarDocente=(Button)findViewById(R.id.btnRegistrarDocente);
        RegistrarAdmin=(Button)findViewById(R.id.btnRegistrarAdmin);
        VerCitasAgendadas=(Button)findViewById(R.id.btnVerCitas);
        CerrarSesion=(Button)findViewById(R.id.btnLogin);

        SiguienteProgreso.setOnClickListener(new View.OnClickListener() { //Entra con el botón del progreso del estudiante
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,InterfazProgresoAlumno.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la activity completamente
            }
        });


        RegistrarAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra con el botón de registrar estudiante
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,RegistrarAlumno.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la activity completamente
            }
        });


        RegistrarDocente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra con el botón de registrar docente
                //Intent i = new Intent(Login.this, Examen Diagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,RegistrarProfesor.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la activity completamente
            }
        });


        RegistrarAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra con el botón de registrar administrador
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,RegistrarAdministrativo.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la activity completamente
            }
        });


        VerCitasAgendadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Entra con el botón de ver citas
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,InterfazCitasAgendadas.class)); //Despliegue de la pantalla a mostrar
                finish(); //Cierra la activity completamente
            }
        });

        CerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra con el botón de cerrar sesión
                //Intent i = new Intent(Login.this, ExamenDiagnostico.class);
                startActivity(new Intent(InterfazAdmin.this,Login.class)); //Despliegue de la pantalla a mostrar
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
