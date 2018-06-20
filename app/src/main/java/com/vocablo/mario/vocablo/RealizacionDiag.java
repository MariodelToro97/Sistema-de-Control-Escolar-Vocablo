package com.vocablo.mario.vocablo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RealizacionDiag extends AppCompatActivity {

    Button Siguiente; //Asignación de la variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realizacion_diag);

        getSupportActionBar().hide(); //Oculta la barra superior de la pantalla

        Siguiente = (Button)findViewById(R.id.btnLogin); //Asignación del botón de finalizar examen a la variable
        final AlertDialog.Builder alert= new AlertDialog.Builder(this);  //Declaración del tipo de objeto de AlertDialog para mostrar

        Siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //Entra si se presiona el botón de Finalizar Examen
                alert.setMessage("Ejemplo de alerta"); //Asignación de lo que se va a desplegar en el mensaje central del AlertDialog
                alert.setCancelable(false);
                alert.setTitle("Examen Concluido"); //asignación del titulo del AlertDialog

                alert.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {//Entra cuando se presiona la tecla de Aceptar en el AlertDialog
                        startActivity(new Intent(RealizacionDiag.this,Login.class)); //Encargado de lanzar la otra actividad desde aqui
                        finish(); //Cierra la activity completamente
                    }
                });
                alert.show();
                alert.show(); //Muestra el AlertDialog
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
