package com.vocablo.mario.vocablo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InterfazAgendarCita extends AppCompatActivity {
    //Declaración de los botones
    Button Regresar;
    Button Cita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_agendar_cita);

        getSupportActionBar().hide(); //Oculta la barra superior

        Regresar = (Button)findViewById(R.id.btnMenuAlumno2); //Asignación del botón de Regresar
        Cita = (Button)findViewById(R.id.btnMenuAlumno); //Asignación del botón de Agendar Cita

        final AlertDialog.Builder alert= new AlertDialog.Builder(this); //Declaración del tipo de objeto de AlertDialog para mostrar

        Regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de Regresar
                startActivity(new Intent(InterfazAgendarCita.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                finish();//Cierra la activity completamente
            }
        });

        Cita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de cita
                alert.setMessage("Ejemplo de alerta"); //Asignación de lo que se va a desplegar en el mensaje central del AlertDialog
                alert.setCancelable(false);
                alert.setTitle("Cita Agendada"); //asignación del titulo del AlertDialog

                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                        startActivity(new Intent(InterfazAgendarCita.this,InterfazAlumno.class)); //Encargado de lanzar la otra actividad desde aqui
                        finish(); //Cierra la activity completamente
                    }
                });
                alert.show(); //Muestra el AlertDialog
            }
        });
    }
}
